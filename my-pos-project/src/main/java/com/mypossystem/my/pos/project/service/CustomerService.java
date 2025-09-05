package com.mypossystem.my.pos.project.service;

import com.mypossystem.my.pos.project.dto.CustomerDTO;
import com.mypossystem.my.pos.project.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerId(long customerId);

    List<CustomerDTO> getAllCustomer();

    String deleteCustomer(long customerId0);
}
