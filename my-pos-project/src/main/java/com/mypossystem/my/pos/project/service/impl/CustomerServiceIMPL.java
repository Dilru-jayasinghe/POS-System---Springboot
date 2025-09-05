package com.mypossystem.my.pos.project.service.impl;

import com.mypossystem.my.pos.project.dto.CustomerDTO;
import com.mypossystem.my.pos.project.dto.request.CustomerUpdateDTO;
import com.mypossystem.my.pos.project.entity.Customer;
import com.mypossystem.my.pos.project.repo.CustomerRepo;
import com.mypossystem.my.pos.project.service.CustomerService;
import com.mypossystem.my.pos.project.util.mappers.CustomerMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO,Customer.class);
        if (!customerRepo.existsById(customer.getCustomerId())){
            customerRepo.save(customer);
            return customer.getCustomerId()+"Save Successfully";
        }else {
            throw new DuplicateKeyException("Already Added");
        }
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());
            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName() + " Updated Successfully";
        } else {
            throw new RuntimeException("No data found that ID");
        }
    }

    @Override
    public CustomerDTO getCustomerId(long customerId) {
        if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = customerMapper.entityToDTO(customer);
            return customerDTO;
        } else {
            throw new RuntimeException("No Customer found with ID: " + customerId);
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer>customers=customerRepo.findAll();
        return customerMapper.entityToDTOList(customers);
    }

    @Override
    public String deleteCustomer(long customerId) {
        if (customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return "Delete Successfully " + customerId;
        }else {
            throw new RuntimeException("No Data in That Id");
        }
    }

}






