package com.github.jowiees.CafeteriaEPSEVG.entity.client;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "students")
@DiscriminatorValue("STUDENT")
public class Student extends Client{
    @Column(length = 100)
    private String degree;

}
