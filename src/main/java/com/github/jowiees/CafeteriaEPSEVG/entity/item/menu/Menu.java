package com.github.jowiees.CafeteriaEPSEVG.entity.item.menu;

import com.github.jowiees.CafeteriaEPSEVG.entity.item.Item;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import java.util.Set;

@Getter
@Entity
@Table(name = "menus")
@DiscriminatorValue("MENU")
public class Menu extends Item {

    private String description;

    @Column(nullable = false)
    @ColumnDefault("false")
    private Boolean isSpecial;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<MenuProduct> menuProducts;
}
