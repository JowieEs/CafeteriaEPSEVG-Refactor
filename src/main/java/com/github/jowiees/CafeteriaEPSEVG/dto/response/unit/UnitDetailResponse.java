package com.github.jowiees.CafeteriaEPSEVG.dto.response.unit;

import lombok.Value;

@Value
public class UnitDetailResponse {
    Long id;
    String name;
    String description;
    Integer stock;
}
