package com.mypossystem.my.pos.project.util.mappers;

import com.mypossystem.my.pos.project.dto.response.OrderItemResponseDTO;
import com.mypossystem.my.pos.project.dto.response.OrderResponseDTO;
import com.mypossystem.my.pos.project.entity.Order;
import com.mypossystem.my.pos.project.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderResponseDTO orderToOrderResponseDTO(Order order);
    OrderResponseDTO toOrderResponseDTO(Order order);
}

