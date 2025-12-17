package com.github.jowiees.CafeteriaEPSEVG.response.item;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ItemBaseResponse(
        Long id,
        Double price,
        @JsonProperty("item_type") String itemType
) {}
