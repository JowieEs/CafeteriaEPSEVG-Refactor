package com.github.jowiees.CafeteriaEPSEVG.mapper.item;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.*;
import com.github.jowiees.CafeteriaEPSEVG.entity.item.Item;
import com.github.jowiees.CafeteriaEPSEVG.entity.item.menu.Menu;
import com.github.jowiees.CafeteriaEPSEVG.entity.item.product.Product;
import com.github.jowiees.CafeteriaEPSEVG.mapper.item.menu.MenuMapper;
import com.github.jowiees.CafeteriaEPSEVG.mapper.item.product.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemMapper {

    private final ProductMapper productMapper;
    private final MenuMapper menuMapper;

    public ItemResponse toSummaryResponse(Item item) {
        return switch (item) {
            case Menu m -> menuMapper.toSummaryResponse(m);

            case Product p -> productMapper.toSummaryResponse(p);

            default -> throw new IllegalStateException("Unexpected value: " + item);
        };
    }

    public ItemResponse toDetailResponse(Item item) {
        return switch (item) {
            case Menu m -> menuMapper.toDetailResponse(m);

            case Product p -> productMapper.toDetailResponse(p);

            default -> throw new IllegalStateException("Unexpected value: " + item);
        };
    }
}
