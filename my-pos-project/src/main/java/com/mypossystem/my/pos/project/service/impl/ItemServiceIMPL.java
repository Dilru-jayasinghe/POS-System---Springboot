package com.mypossystem.my.pos.project.service.impl;

import com.mypossystem.my.pos.project.dto.CustomerDTO;
import com.mypossystem.my.pos.project.dto.request.ItemSaveRequestDTO;
import com.mypossystem.my.pos.project.dto.response.ItemGetResponseDTO;
import com.mypossystem.my.pos.project.entity.Customer;
import com.mypossystem.my.pos.project.entity.Item;
import com.mypossystem.my.pos.project.repo.ItemRepo;
import com.mypossystem.my.pos.project.service.ItemService;
import com.mypossystem.my.pos.project.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ItemMapper itemMapper;



    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        Item item=modelMapper.map(itemSaveRequestDTO,Item.class);
        if (!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return item.getItemId()+"Sve Successfully";
        }else
            throw new DuplicateKeyException("Already added");
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {
        boolean b=true;
        List<Item>items=itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName,b);
        if (items.size()>0){
            List<ItemGetResponseDTO>itemGetResponseDTOS=itemMapper.toItemGetResponseDTOs(items);
            return itemGetResponseDTOS;
        }else
            throw new RuntimeException("Item is not active");
    }



    @Override
    public List<ItemGetResponseDTO> getAllItems() {
        List<Item>item=itemRepo.findAll();
        return itemMapper.entityToDTO(item);
    }

    @Override
    public String DeleteItem(long itemId) {
        if (itemRepo.existsById(itemId)){
            itemRepo.deleteById(itemId);
            return "Delete Successfully " + itemId;
        }else {
            throw new RuntimeException("No Data in That Id");
        }
    }

}


