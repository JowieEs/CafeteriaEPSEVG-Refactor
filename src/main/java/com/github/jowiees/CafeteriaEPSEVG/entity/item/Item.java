package com.github.jowiees.CafeteriaEPSEVG.entity.item;

import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "item_type")
public abstract class Item {
    @Id
    @GeneratedValue
    private Long id;
    private double price;
    @Column(name = "item_type", insertable = false, updatable = false)
    private String itemType;

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getItemType() {
        return itemType;
    }
}
