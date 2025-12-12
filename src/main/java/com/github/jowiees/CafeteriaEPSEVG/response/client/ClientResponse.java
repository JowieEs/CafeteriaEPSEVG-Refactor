package com.github.jowiees.CafeteriaEPSEVG.response.client;

public sealed interface ClientResponse permits StudentResponse, ProfessorResponse {
    Integer memberId();
    String clientType();
}

