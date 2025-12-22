package com.github.jowiees.CafeteriaEPSEVG.dto.response.client;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ProfessorResponse extends ClientDetailResponse{
    private final String department;
}
