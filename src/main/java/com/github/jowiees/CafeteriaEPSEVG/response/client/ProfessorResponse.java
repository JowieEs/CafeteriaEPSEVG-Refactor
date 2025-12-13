package com.github.jowiees.CafeteriaEPSEVG.response.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record ProfessorResponse(
        Long id,
        @JsonProperty("university_card_code") String universityCardCode,
        String name,
        @JsonProperty("client_type") String clientType,
        @JsonProperty("created_at") LocalDateTime createdAt,
        String department
) implements ClientResponse {}
