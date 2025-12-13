package com.github.jowiees.CafeteriaEPSEVG.entity.client;

import jakarta.persistence.*;

@Entity
@Table(name = "professors")
@DiscriminatorValue("PROFESSOR")
public class Professor extends Client{
    @Column(length = 100)
    private String department;

    public String getDepartment() {
        return department;
    }
}
