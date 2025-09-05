package com.mypossystem.my.pos.project.service;

import com.mypossystem.my.pos.project.dto.request.ItemSaveRequestDTO;
import com.mypossystem.my.pos.project.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {

    List<ItemGetResponseDTO> getAllItems();

    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);


    String DeleteItem(long itemId);
}
