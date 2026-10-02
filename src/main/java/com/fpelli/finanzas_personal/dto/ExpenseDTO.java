package com.fpelli.finanzas_personal.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record ExpenseDTO(
        Long id,
        @NotBlank String description,
        BigDecimal amount,
        BigDecimal amountUSD,
        @NotBlank Long expenseTypeId,
        String expenseTypeName,
        LocalDateTime date) {
}
