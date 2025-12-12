package com.github.jowiees.CafeteriaEPSEVG.response.product;

public record ProductDetailResponse(
        Long id,
        Double price,
        String name,
        Integer barcode
) {

}
