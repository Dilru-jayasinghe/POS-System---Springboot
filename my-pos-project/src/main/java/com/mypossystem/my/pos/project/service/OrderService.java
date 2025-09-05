package com.mypossystem.my.pos.project.service;

import com.mypossystem.my.pos.project.dto.request.OrderRequestDTO;
import com.mypossystem.my.pos.project.dto.response.OrderResponseDTO;

public interface OrderService {
    OrderResponseDTO createOrder(OrderRequestDTO request);

    OrderResponseDTO getOrderById(Long orderId);
}
