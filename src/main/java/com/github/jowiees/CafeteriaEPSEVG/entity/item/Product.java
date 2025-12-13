package com.github.jowiees.CafeteriaEPSEVG.entity.item;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "producte")
@DiscriminatorValue("Producte")
public class Product extends Item {
    private String name;
    @Column(name = "barcode")
    private Integer barCode;


    public String getName() {
        return name;
    }

    public Integer getBarCode() {
        return barCode;
    }
}
