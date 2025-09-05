package com.mypossystem.my.pos.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class InvoiceItemResponseDTO {
    private String itemName;
    private Integer quantity;
    private Double price;
    private Double total;
}
