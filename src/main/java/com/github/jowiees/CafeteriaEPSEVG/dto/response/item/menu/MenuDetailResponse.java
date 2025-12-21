package com.github.jowiees.CafeteriaEPSEVG.dto.response.item.menu;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.ItemResponse;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Getter
@SuperBuilder
public class MenuDetailResponse extends ItemResponse {
    private final String description;
    private final Boolean isSpecial;
    private final List<MenuProductResponse> products;
}
