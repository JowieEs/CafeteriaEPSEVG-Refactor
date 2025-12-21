package com.github.jowiees.CafeteriaEPSEVG.dto.response.item.menu;

import com.github.jowiees.CafeteriaEPSEVG.dto.response.item.ItemResponse;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class MenuSummaryResponse extends ItemResponse {
    private final boolean isSpecial;
}
