package com.github.jowiees.CafeteriaEPSEVG.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record QuantityItemResponse(
        @JsonProperty("item_id") Long itemId,
        Integer quantity,
        @JsonProperty("item_type") String itemType
) { }
