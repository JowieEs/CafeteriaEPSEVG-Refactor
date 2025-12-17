package com.github.jowiees.CafeteriaEPSEVG.entity.item;

import com.github.jowiees.CafeteriaEPSEVG.entity.MenuProduct;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.Set;

@Entity
@Table(name = "menus")
@DiscriminatorValue("MENU")
public class Menu extends Item{

    private String description;

    @Column(nullable = false)
    @ColumnDefault("false")
    private Boolean isSpecial;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<MenuProduct> menuProducts;

    public String getDescription() {
        return description;
    }

    public Boolean getSpecial() {
        return isSpecial;
    }

    public Set<MenuProduct> getMenuProducts() {
        return menuProducts;
    }
}
