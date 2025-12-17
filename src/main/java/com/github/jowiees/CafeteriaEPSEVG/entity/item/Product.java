package com.github.jowiees.CafeteriaEPSEVG.entity.item;

import com.github.jowiees.CafeteriaEPSEVG.entity.Category;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
@DiscriminatorValue("PRODUCT")
public class Product extends Item {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Category getCategory() {
        return category;
    }
}
