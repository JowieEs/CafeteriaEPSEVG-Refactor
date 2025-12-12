package com.github.jowiees.CafeteriaEPSEVG.entity.unit;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "aliment")
public class Unit {

    @EmbeddedId
    private UnitKey unitKey;

    private String nutritionInfo;
    private Double price;
    private Integer stock;

    public UnitKey getUnitKey() {
        return unitKey;
    }

    public String getNutritionInfo() {
        return nutritionInfo;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }
}
