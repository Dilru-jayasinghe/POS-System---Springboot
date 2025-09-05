package com.mypossystem.my.pos.project.dto.request;

import com.mypossystem.my.pos.project.dto.OrderItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrderRequestDTO {
    private Long customerId;
    private List<OrderItemDTO> items;
}
