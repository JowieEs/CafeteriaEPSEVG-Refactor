package com.github.jowiees.CafeteriaEPSEVG.service;

import com.github.jowiees.CafeteriaEPSEVG.exception.MenuNotFoundException;
import com.github.jowiees.CafeteriaEPSEVG.repository.MenuRepository;
import com.github.jowiees.CafeteriaEPSEVG.response.product.ProductResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.menu.MenuDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.menu.MenuResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<MenuResponse> getAll() {
        return menuRepository.findAll().stream().map(
                menu -> new MenuResponse(
                        menu.getId(),
                        menu.getPrice()
                )
        ).toList();
    }

    public MenuDetailResponse getById(Long id) {
        return menuRepository.findById(id).map(
                menu -> new MenuDetailResponse(
                        menu.getId(),
                        menu.getPrice(),
                        menu.getProducts().stream().map(
                                product -> new ProductResponse(
                                        product.getId(),
                                        product.getPrice(),
                                        product.getName(),
                                        product.getBarCode()
                                )
                        ).toList()
                )
        ).orElseThrow(
                () -> new MenuNotFoundException(id)
        );
    }
}
