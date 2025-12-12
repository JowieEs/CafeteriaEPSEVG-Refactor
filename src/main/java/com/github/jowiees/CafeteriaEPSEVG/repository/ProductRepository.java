package com.github.jowiees.CafeteriaEPSEVG.repository;

import com.github.jowiees.CafeteriaEPSEVG.entity.item.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
