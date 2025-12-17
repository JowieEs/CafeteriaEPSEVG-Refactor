package com.github.jowiees.CafeteriaEPSEVG.response.client;

import java.time.LocalDateTime;

public sealed interface ClientBaseResponse permits StudentResponse, ProfessorResponse {
    Long id();
    String universityCardCode();
    String name();
    String clientType();
    LocalDateTime createdAt();
}

