package com.github.jowiees.CafeteriaEPSEVG.dto.response.client;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
public abstract class ClientDetailResponse {
    private final Long id;
    private final String universityCardCode;
    private final String name;
    private final String clientType;
    private final LocalDateTime createdAt;
}

