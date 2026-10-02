package com.fpelli.finanzas_personal.mapper;

import com.fpelli.finanzas_personal.dto.PaymentMethodDTO;
import com.fpelli.finanzas_personal.entity.PaymentMethod;

public class PaymentMethodMapper {
    public static PaymentMethodDTO toDTO(PaymentMethod paymentMethod) {
        if (paymentMethod == null) {
            return null;
        }
        return new PaymentMethodDTO(
            paymentMethod.getId(),
            paymentMethod.getVersion(),
            paymentMethod.getName(),
            paymentMethod.getCreditLastFour(),
            paymentMethod.isCredit()
        );
    }

    public static PaymentMethod toEntity(PaymentMethodDTO paymentMethodDTO) {
        PaymentMethod entity = new PaymentMethod();
        entity.setId(paymentMethodDTO.id());
        entity.setVersion(paymentMethodDTO.version());
        entity.setCredit(paymentMethodDTO.isCredit());  
        entity.setName(paymentMethodDTO.name());
        entity.setCreditLastFour(paymentMethodDTO.creditLastFour());
        return entity;
    }
}
