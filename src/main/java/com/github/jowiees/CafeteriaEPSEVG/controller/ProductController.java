package com.github.jowiees.CafeteriaEPSEVG.controller;

import com.github.jowiees.CafeteriaEPSEVG.response.product.ProductDetailResponse;
import com.github.jowiees.CafeteriaEPSEVG.response.product.ProductResponse;
import com.github.jowiees.CafeteriaEPSEVG.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductResponse> getAll() {
        return productService.getAll();
    }

    @GetMapping("{id}")
    public ProductDetailResponse findById(@PathVariable Long id) {
        return productService.getById(id);
    }

}
