package com.fpelli.finanzas_personal.entity;

import com.fpelli.finanzas_personal.dto.ExpenseTypeDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter
public class ExpenseType extends GenericEntity {
    @Column(name="name", unique=true) 
    private String name;

    @Override
    public ExpenseTypeDTO toDTO() {
        return new ExpenseTypeDTO(getId(), name, getVersion());
    }
}
