package com.github.jowiees.CafeteriaEPSEVG.controller;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.ItemResponse;
import com.github.jowiees.CafeteriaEPSEVG.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @SuppressWarnings("NullableProblems")
    @GetMapping
    public Page<ItemResponse> getAll(Pageable pageable) {
        return itemService.getAll(pageable);
    }

}
