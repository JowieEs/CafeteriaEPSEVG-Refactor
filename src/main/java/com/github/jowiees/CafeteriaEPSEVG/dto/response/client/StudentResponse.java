package com.github.jowiees.CafeteriaEPSEVG.dto.response.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record StudentResponse(
        Long id,
        @JsonProperty("university_card_code") String universityCardCode,
        String name,
        @JsonProperty("client_type") String clientType,
        @JsonProperty("created_at") LocalDateTime createdAt,
        String degree
) implements ClientDetailResponse {}
