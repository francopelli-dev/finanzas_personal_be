package com.fpelli.finanzas_personal.dto;

import com.fpelli.finanzas_personal.entity.ExpenseType;

public record ExpenseTypeDTO(Long id, String name, Integer version) {
    public ExpenseType toEntity() {
        ExpenseType expenseType = new ExpenseType();
        expenseType.setId(id());
        expenseType.setName(name());
        expenseType.setVersion(version());
        return expenseType;
    }
}
