package com.github.jowiees.CafeteriaEPSEVG.controller;

import com.github.jowiees.CafeteriaEPSEVG.dto.request.item.ItemFilter;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.ItemResponse;
import com.github.jowiees.CafeteriaEPSEVG.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @SuppressWarnings("NullableProblems")
    @GetMapping
    public Page<ItemResponse> getAll(@ModelAttribute ItemFilter filter, Pageable pageable) {
        return itemService.getAll(filter,pageable);
    }

    @GetMapping("{id}")
    public ItemResponse getById(@PathVariable Long id) {
        return itemService.getById(id);
    }

}
