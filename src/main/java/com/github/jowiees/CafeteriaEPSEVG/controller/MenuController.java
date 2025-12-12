package com.github.jowiees.CafeteriaEPSEVG.controller;

import com.github.jowiees.CafeteriaEPSEVG.response.menu.MenuDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.menu.MenuResponse;
import com.github.jowiees.CafeteriaEPSEVG.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public List<MenuResponse> getAll() {
        return menuService.getAll();
    }

    @GetMapping("{id}")
    public MenuDetailResponse getById(@PathVariable Long id) {
        return menuService.getById(id);
    }
}
