package com.mypossystem.my.pos.project.controller;

import com.mypossystem.my.pos.project.dto.CustomerDTO;
import com.mypossystem.my.pos.project.dto.request.ItemSaveRequestDTO;
import com.mypossystem.my.pos.project.dto.response.ItemGetResponseDTO;
import com.mypossystem.my.pos.project.service.ItemService;
import com.mypossystem.my.pos.project.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin

public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String message = itemService.saveItem(itemSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        201,
                        "Success",
                        message),
                HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public List<ItemGetResponseDTO> getItemByNameAndStatus(@RequestParam(value = "name") String itemName) {
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatus(itemName);
        return itemDTOS;
    }
    @GetMapping(
            path = "/get-all-item"
    )

    public List<ItemGetResponseDTO>getAllItems(){
        List<ItemGetResponseDTO>allItems=itemService.getAllItems();
        return allItems;
    }
    @DeleteMapping(
            path = "/delete-item/{id}"
    )
    public String deleteItem(@PathVariable(value = "id")int itemId){
        String delete = itemService.DeleteItem(itemId);
        return delete;
    }


}
