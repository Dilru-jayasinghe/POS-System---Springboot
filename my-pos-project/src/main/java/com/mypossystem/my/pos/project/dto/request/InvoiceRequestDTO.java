package com.mypossystem.my.pos.project.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvoiceRequestDTO {
    private Long customerId;
    private List<InvoiceItemRequestDTO> items;
}
