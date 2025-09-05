package com.mypossystem.my.pos.project.controller;

import com.mypossystem.my.pos.project.dto.request.OrderRequestDTO;
import com.mypossystem.my.pos.project.dto.response.OrderResponseDTO;
import com.mypossystem.my.pos.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
@CrossOrigin

public class OrderController {
    @Autowired
    private OrderService orderService;


    @PostMapping("/create")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO request) {
        OrderResponseDTO response = orderService.createOrder(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping("/get_by_id/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable("id") Long orderId) {
        OrderResponseDTO response = orderService.getOrderById(orderId);
        return ResponseEntity.ok(response);

    }
}