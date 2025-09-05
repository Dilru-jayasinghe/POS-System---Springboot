package com.mypossystem.my.pos.project.controller;

import com.mypossystem.my.pos.project.dto.request.InvoiceRequestDTO;
import com.mypossystem.my.pos.project.dto.request.OrderRequestDTO;
import com.mypossystem.my.pos.project.dto.response.InvoiceResponseDTO;
import com.mypossystem.my.pos.project.dto.response.OrderResponseDTO;
import com.mypossystem.my.pos.project.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/invoice")
@CrossOrigin
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/create")
    public ResponseEntity<InvoiceResponseDTO> createInvoice(@RequestBody InvoiceRequestDTO dto) {
        InvoiceResponseDTO response = invoiceService.createInvoice(dto);
        return ResponseEntity.ok(response);
    }
}


