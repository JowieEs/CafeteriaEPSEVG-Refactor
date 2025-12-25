package com.github.jowiees.CafeteriaEPSEVG.mapper.item.menu;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.menu.MenuDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.menu.MenuSummaryResponse;
import com.github.jowiees.CafeteriaEPSEVG.entity.item.menu.Menu;
import com.github.jowiees.CafeteriaEPSEVG.mapper.item.product.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MenuMapper {

    private final ProductMapper productMapper;
    private final MenuProductMapper menuProductMapper;

    public MenuDetailResponse toDetailResponse(Menu menu) {
        return MenuDetailResponse.builder()
                .id(menu.getId())
                .name(menu.getName())
                .sellingPrice(menu.getSellingPrice())
                .itemType(menu.getItemType())
                .isActive(menu.getIsActive())
                .description(menu.getDescription())
                .isSpecial(menu.getIsSpecial())
                .products(menu.getMenuProducts().stream().map(menuProductMapper::toResponse).toList())
                .build();
    }

    public MenuSummaryResponse toSummaryResponse(Menu menu) {
        return MenuSummaryResponse.builder()
                .id(menu.getId())
                .name(menu.getName())
                .sellingPrice(menu.getSellingPrice())
                .itemType(menu.getItemType())
                .isActive(menu.getIsActive())
                .isSpecial(menu.getIsSpecial())
                .build();
    }
}
