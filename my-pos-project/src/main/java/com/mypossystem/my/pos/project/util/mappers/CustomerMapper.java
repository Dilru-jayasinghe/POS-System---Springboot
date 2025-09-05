package com.mypossystem.my.pos.project.util.mappers;

import com.mypossystem.my.pos.project.dto.CustomerDTO;
import com.mypossystem.my.pos.project.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface CustomerMapper {

    List<CustomerDTO>entityToDTOList(List<Customer>customers);
    CustomerDTO entityToDTO(Customer customer);

}
