package com.github.jowiees.CafeteriaEPSEVG.entity.item;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "menu")
@DiscriminatorValue("Menu")
public class Menu extends Item{
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "menu_producte_rel",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "producte_id")
    )
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }
}
