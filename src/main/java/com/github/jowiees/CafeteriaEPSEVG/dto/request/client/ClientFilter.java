package com.github.jowiees.CafeteriaEPSEVG.dto.request.client;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClientFilter {
    private String clientType;
    private LocalDateTime createdAt;
}
