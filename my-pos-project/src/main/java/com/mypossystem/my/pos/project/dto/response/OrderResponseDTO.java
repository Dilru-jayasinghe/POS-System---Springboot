package com.mypossystem.my.pos.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderResponseDTO {
    private Long id;
    private Long customerId;
    private LocalDateTime orderDate;
    private String status;
    private Double totalAmount;
    private List<OrderItemResponseDTO> items;
}
