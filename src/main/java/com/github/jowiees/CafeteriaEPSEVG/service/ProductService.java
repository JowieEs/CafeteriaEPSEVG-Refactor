package com.github.jowiees.CafeteriaEPSEVG.service;

import com.github.jowiees.CafeteriaEPSEVG.repository.ProductRepository;
import com.github.jowiees.CafeteriaEPSEVG.response.product.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> getAll() {
        return productRepository.findAll().stream().map(
                product -> new ProductResponse(
                        product.getId(),
                        product.getPrice(),
                        product.getName(),
                        product.getBarCode()
                )
        ).toList();
    }

}
