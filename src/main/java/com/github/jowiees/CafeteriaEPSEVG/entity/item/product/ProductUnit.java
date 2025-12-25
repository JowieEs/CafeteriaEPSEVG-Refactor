package com.github.jowiees.CafeteriaEPSEVG.entity.item.product;

import com.github.jowiees.CafeteriaEPSEVG.entity.Unit;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "product_units")
public class ProductUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id",nullable = false)
    private Unit unit;

    @Column(nullable = false)
    private Integer quantity;
}
