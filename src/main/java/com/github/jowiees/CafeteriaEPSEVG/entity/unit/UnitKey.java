package com.github.jowiees.CafeteriaEPSEVG.entity.unit;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class UnitKey implements Serializable {
    private String name;
    private String brand;

    public UnitKey(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }
}
