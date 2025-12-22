package com.github.jowiees.CafeteriaEPSEVG.dto.response.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class ClientSummaryResponse{
    Long id;
    String name;
    String clientType;
}
