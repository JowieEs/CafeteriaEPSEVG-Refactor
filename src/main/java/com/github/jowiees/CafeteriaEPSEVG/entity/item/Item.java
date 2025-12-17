package com.github.jowiees.CafeteriaEPSEVG.entity.item;

import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
@Table(name = "items")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "item_type")
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal sellingPrice;

    @Column(name = "item_type", insertable = false, updatable = false)
    private String itemType;

    @Column(name = "is_active")
    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getItemType() {
        return itemType;
    }

    public Boolean getActive() {
        return isActive;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }
}
