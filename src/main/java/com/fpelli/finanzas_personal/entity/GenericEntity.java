package com.fpelli.finanzas_personal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass 
public abstract class GenericEntity {
    
    @Id @GeneratedValue 
    private Long id;
    private int version;
    @Column(name="deleted_") 
    private boolean deleted = false;

}
