package com.github.jowiees.CafeteriaEPSEVG.response.product;

public record ProductResponse(
        Long id,
        Double price,
        String name,
        Integer barcode
) {
}
