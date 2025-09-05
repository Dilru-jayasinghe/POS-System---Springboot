package com.mypossystem.my.pos.project.util.mappers;

import com.mypossystem.my.pos.project.dto.response.InvoiceItemResponseDTO;
import com.mypossystem.my.pos.project.dto.response.InvoiceResponseDTO;
import com.mypossystem.my.pos.project.entity.Invoice;
import com.mypossystem.my.pos.project.entity.InvoiceItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {


    InvoiceResponseDTO toDTO(Invoice invoice);

    List<InvoiceItemResponseDTO> toItemDTOList(List<InvoiceItem> items);
}
