package com.github.jowiees.CafeteriaEPSEVG.entity.client;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "professorat")
@DiscriminatorValue("Professorat")
public class Professor extends Client{
    private String email;

    public String getEmail() {

        return email;
    }
}
