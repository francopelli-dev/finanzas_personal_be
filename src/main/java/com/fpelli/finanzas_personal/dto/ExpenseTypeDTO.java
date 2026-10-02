package com.fpelli.finanzas_personal.dto;

import jakarta.validation.constraints.NotBlank;

public record ExpenseTypeDTO(Long id,
        @NotBlank String name,
        Integer version) {

}
