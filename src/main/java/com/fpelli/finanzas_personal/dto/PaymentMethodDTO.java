package com.fpelli.finanzas_personal.dto;

import jakarta.validation.constraints.NotBlank;

public record PaymentMethodDTO(Long id,Integer version,@NotBlank  String name, Integer creditLastFour, boolean isCredit) {

}
