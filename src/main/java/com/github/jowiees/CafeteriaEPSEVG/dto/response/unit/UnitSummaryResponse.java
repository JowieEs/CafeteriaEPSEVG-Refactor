package com.github.jowiees.CafeteriaEPSEVG.dto.response.unit;

import lombok.Value;

@Value
public class UnitSummaryResponse {
    Long id;
    String name;
    Integer stock;
}
