package com.github.jowiees.CafeteriaEPSEVG.entity.item.product;

import com.github.jowiees.CafeteriaEPSEVG.entity.Unit;
import com.github.jowiees.CafeteriaEPSEVG.entity.item.Item;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;

@Getter
@Entity
@Table(name = "products")
@DiscriminatorValue("PRODUCT")
public class Product extends Item {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ProductUnit> productUnits;
}
