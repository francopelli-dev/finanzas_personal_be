package com.fpelli.finanzas_personal.entity;

import org.hibernate.annotations.SoftDelete;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@SoftDelete 
public abstract class GenericEntity {
    
    @Id @GeneratedValue 
    private Long id;
    @Version 
    private Integer version;


}
