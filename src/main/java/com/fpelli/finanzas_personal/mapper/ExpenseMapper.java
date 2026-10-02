package com.fpelli.finanzas_personal.mapper;

import com.fpelli.finanzas_personal.dto.ExpenseDTO;
import com.fpelli.finanzas_personal.entity.Expense;
import com.fpelli.finanzas_personal.entity.ExpenseType;

public class ExpenseMapper {
    public static ExpenseDTO toDTO(Expense entity) {
        return new ExpenseDTO(
            entity.getId(),
            entity.getDescription(),
            entity.getAmount(),
            entity.getAmountUSD(),
            entity.getExpenseType().getId(),
            entity.getExpenseType().getName()
        );
    }

    public static Expense toEntity(ExpenseDTO dto,ExpenseType expenseType) {
        Expense expense = new Expense();
        expense.setId(dto.id());
        expense.setDescription(dto.description());
        expense.setAmount(dto.amount());
        expense.setAmountUSD(dto.amountUSD());
        expense.setExpenseType(expenseType);
        return expense;
    }
}
