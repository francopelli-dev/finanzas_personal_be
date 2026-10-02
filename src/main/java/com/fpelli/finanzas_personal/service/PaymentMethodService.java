package com.fpelli.finanzas_personal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fpelli.finanzas_personal.dto.PaymentMethodDTO;
import com.fpelli.finanzas_personal.entity.PaymentMethod;
import com.fpelli.finanzas_personal.mapper.PaymentMethodMapper;
import com.fpelli.finanzas_personal.repository.PaymentMethodRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;

    public List<PaymentMethodDTO> listPaymentMethods() {
        return paymentMethodRepository.findAll().stream().map(PaymentMethodMapper::toDTO).toList();
    }

    public PaymentMethodDTO createPaymentMethod(PaymentMethodDTO dto) {
        PaymentMethod created = this.paymentMethodRepository.save(PaymentMethodMapper.toEntity(dto));
        return PaymentMethodMapper.toDTO(created);
    }

    public PaymentMethodDTO updatePaymentMethod(PaymentMethodDTO dto, Long id) {
        PaymentMethod entity = PaymentMethodMapper.toEntity(dto);
        entity.setId(id);
        PaymentMethod updated = this.paymentMethodRepository.save(entity);
        return PaymentMethodMapper.toDTO(updated);
    }
    public void deletePaymentMethod(Long id){
        paymentMethodRepository.deleteById(id);
    }
}
