package com.github.jowiees.CafeteriaEPSEVG.entity;

import com.github.jowiees.CafeteriaEPSEVG.entity.item.Menu;
import com.github.jowiees.CafeteriaEPSEVG.entity.item.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "menu_products")
public class MenuProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public Long getId() {
        return id;
    }

    public Menu getMenu() {
        return menu;
    }

    public Product getProduct() {
        return product;
    }
}
