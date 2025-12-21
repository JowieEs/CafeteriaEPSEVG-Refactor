package com.github.jowiees.CafeteriaEPSEVG.entity.item;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "products")
@DiscriminatorValue("PRODUCT")
public class Product extends Item {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}
