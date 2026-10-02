package com.fpelli.finanzas_personal.mapper;

import com.fpelli.finanzas_personal.dto.ExpenseTypeDTO;
import com.fpelli.finanzas_personal.entity.ExpenseType;

public class ExpenseTypeMapper {
    public static ExpenseTypeDTO toDTO(ExpenseType expenseType) {
        return new ExpenseTypeDTO(expenseType.getId(), expenseType.getName(),expenseType.getVersion());
    }
    public static ExpenseType toEntity(ExpenseTypeDTO dto) {
        ExpenseType expenseType = new ExpenseType();
        expenseType.setId(dto.id());
        expenseType.setName(dto.name());
        expenseType.setVersion(dto.version());
        return expenseType;
    }
}
