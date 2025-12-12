package com.github.jowiees.CafeteriaEPSEVG.response.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StudentResponse(
        @JsonProperty("member_id") Integer memberId,
        @JsonProperty("client_type") String clientType
) implements ClientResponse {}
