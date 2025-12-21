package com.github.jowiees.CafeteriaEPSEVG.mapper.item;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.menu.MenuDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.menu.MenuProductResponse;
import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.menu.MenuSummaryResponse;
import com.github.jowiees.CafeteriaEPSEVG.entity.item.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MenuMapper {

    private final ProductMapper productMapper;

    public MenuDetailResponse toDetailResponse(Menu menu) {
        return MenuDetailResponse.builder()
                .id(menu.getId())
                .name(menu.getName())
                .sellingPrice(menu.getSellingPrice())
                .itemType(menu.getItemType())
                .isActive(menu.getIsActive())
                .description(menu.getDescription())
                .isSpecial(menu.getIsSpecial())
                .products(menu.getMenuProducts().stream()
                        .map(
                            menuProduct -> new MenuProductResponse(
                                    menuProduct.getQuantity(),
                                    productMapper.toSummaryResponse(menuProduct.getProduct())
                            )
                        )
                        .toList()
                )
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
