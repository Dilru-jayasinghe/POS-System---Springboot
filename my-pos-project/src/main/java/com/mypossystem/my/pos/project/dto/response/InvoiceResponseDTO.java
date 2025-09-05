package com.mypossystem.my.pos.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvoiceResponseDTO {
    private Long id;
    private String customerName;
    private LocalDateTime invoiceDate;
    private Double totalAmount;
    private List<InvoiceItemResponseDTO> items;
}
