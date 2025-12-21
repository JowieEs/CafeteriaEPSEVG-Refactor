package com.github.jowiees.CafeteriaEPSEVG.dto.response.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClientSummaryResponse(
        Long id,
        String name,
        @JsonProperty("client_type") String clientType
) {
}
