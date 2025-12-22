package com.github.jowiees.CafeteriaEPSEVG.dto.response.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
public class StudentResponse extends ClientDetailResponse {
    private final String degree;
}
