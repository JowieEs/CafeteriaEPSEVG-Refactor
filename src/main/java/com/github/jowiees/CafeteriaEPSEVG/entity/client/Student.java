package com.github.jowiees.CafeteriaEPSEVG.entity.client;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiant")
@DiscriminatorValue("Estudiant")
public class Student extends Client{
}
