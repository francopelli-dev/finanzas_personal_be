package com.fpelli.finanzas_personal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter
public class ExpenseType extends GenericEntity{
    @Column(name="name", unique=true) 
    private String name;
}
