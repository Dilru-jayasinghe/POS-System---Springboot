package com.mypossystem.my.pos.project.controller;

import com.mypossystem.my.pos.project.dto.CustomerDTO;
import com.mypossystem.my.pos.project.dto.request.CustomerUpdateDTO;
import com.mypossystem.my.pos.project.service.CustomerService;
import com.mypossystem.my.pos.project.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        String message = customerService.saveCustomer(customerDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        201,
                        "success",
                        message),
                HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<StandardResponse>updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        String message = customerService.updateCustomer(customerUpdateDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        201,
                        "Updated",
                        message),
                HttpStatus.CREATED);
    }
    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )

    public CustomerDTO getCustomerById(@RequestParam(value = "id")long customerId){
        CustomerDTO customerDTO=customerService.getCustomerId((int) customerId);
        return customerDTO;
    }
    @GetMapping(
            path = "/get-all-customer"
    )

    public List<CustomerDTO>getAllCustomers(){
        List<CustomerDTO>allCustomer=customerService.getAllCustomer();
        return allCustomer;
    }

    @DeleteMapping(
            path="delete-customer/{id}"
    )
    public String deleteCustomer(@PathVariable(value = "id")long customerId0){
        String delete = customerService.deleteCustomer(customerId0);
        return delete;
    }
}
