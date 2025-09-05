package com.mypossystem.my.pos.project.service;

import com.mypossystem.my.pos.project.dto.request.InvoiceRequestDTO;
import com.mypossystem.my.pos.project.dto.response.InvoiceResponseDTO;

public interface InvoiceService {
    InvoiceResponseDTO createInvoice(InvoiceRequestDTO dto);
}
