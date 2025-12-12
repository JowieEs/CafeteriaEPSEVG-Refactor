package com.github.jowiees.CafeteriaEPSEVG.service;

import com.github.jowiees.CafeteriaEPSEVG.repository.ItemRepository;
import com.github.jowiees.CafeteriaEPSEVG.response.item.ItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemResponse> getAll() {
        return itemRepository.findAll().stream().map(
                item -> new ItemResponse(
                        item.getId(),
                        item.getPrice(),
                        item.getItemType()
                )
        ).toList();
    }
}
