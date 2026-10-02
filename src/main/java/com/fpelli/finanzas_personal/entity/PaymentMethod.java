package com.fpelli.finanzas_personal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PaymentMethod extends GenericEntity{
    @Column(length=25,nullable = false,unique = true)
    private String name;
    @Column(length=4)
    private Integer creditLastFour;
    private boolean isCredit = false;
}
