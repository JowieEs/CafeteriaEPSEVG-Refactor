package com.github.jowiees.CafeteriaEPSEVG.dto.response.client;

import java.time.LocalDateTime;

public sealed interface ClientDetailResponse permits StudentResponse, ProfessorResponse {
    Long id();
    String universityCardCode();
    String name();
    String clientType();
    LocalDateTime createdAt();
}

