package com.mypossystem.my.pos.project.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvoiceItemRequestDTO {
    private Long itemId;
    private Integer quantity;
}
