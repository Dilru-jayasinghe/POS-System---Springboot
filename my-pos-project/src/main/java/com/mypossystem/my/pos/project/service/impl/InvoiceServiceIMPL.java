package com.mypossystem.my.pos.project.service.impl;

import com.mypossystem.my.pos.project.dto.request.InvoiceItemRequestDTO;
import com.mypossystem.my.pos.project.dto.request.InvoiceRequestDTO;
import com.mypossystem.my.pos.project.dto.response.InvoiceResponseDTO;
import com.mypossystem.my.pos.project.entity.Customer;
import com.mypossystem.my.pos.project.entity.Invoice;
import com.mypossystem.my.pos.project.entity.InvoiceItem;
import com.mypossystem.my.pos.project.entity.Item;
import com.mypossystem.my.pos.project.repo.CustomerRepo;
import com.mypossystem.my.pos.project.repo.InvoiceRepo;
import com.mypossystem.my.pos.project.repo.ItemRepo;
import com.mypossystem.my.pos.project.service.InvoiceService;
import com.mypossystem.my.pos.project.util.mappers.InvoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InvoiceServiceIMPL implements InvoiceService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private InvoiceRepo invoiceRepo;
    @Autowired
    private InvoiceMapper invoiceMapper;

    @Override
    public InvoiceResponseDTO createInvoice(InvoiceRequestDTO dto) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceDate(LocalDateTime.now());

        Customer customer = customerRepo.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        invoice.setCustomer(customer);

        double totalAmount = 0.0;

        for (InvoiceItemRequestDTO itemDto : dto.getItems()) {
            Item item = itemRepo.findById(itemDto.getItemId())
                    .orElseThrow(() -> new RuntimeException("Item not found"));

            InvoiceItem invoiceItem = new InvoiceItem();
            invoiceItem.setItem(item);
            invoiceItem.setQuantity(itemDto.getQuantity());
            invoiceItem.setPrice(item.getPrice());

            double total = item.getPrice() * itemDto.getQuantity();
            invoiceItem.setTotal(total);

            totalAmount += total;

            invoice.addInvoiceItem(invoiceItem);
        }

        invoice.setTotalAmount(totalAmount);
        invoiceRepo.save(invoice);

        return invoiceMapper.toDTO(invoice);
    }
}
