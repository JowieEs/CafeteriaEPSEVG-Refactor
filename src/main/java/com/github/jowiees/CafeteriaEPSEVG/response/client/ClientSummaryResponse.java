package com.github.jowiees.CafeteriaEPSEVG.response.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jowiees.CafeteriaEPSEVG.entity.client.Client;

public record ClientSummaryResponse(
        Long id,
        String name,
        @JsonProperty("client_type") String clientType
) {
}
