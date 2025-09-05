package com.mypossystem.my.pos.project.util.mappers;

import com.mypossystem.my.pos.project.dto.response.ItemGetResponseDTO;
import com.mypossystem.my.pos.project.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.data.domain.Page;

import javax.swing.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponseDTO> toItemGetResponseDTOs(List<Item> items);
    List<ItemGetResponseDTO> entityToDTO(List<Item> item);
}
