package com.fpelli.finanzas_personal.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fpelli.finanzas_personal.dto.PaymentMethodDTO;
import com.fpelli.finanzas_personal.service.PaymentMethodService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PaymentController {
    private final PaymentMethodService paymentMethodService;

    @GetMapping("payment-method")
    public ResponseEntity<List<PaymentMethodDTO>> listPaymentMethod() {
        List<PaymentMethodDTO> list = this.paymentMethodService.listPaymentMethods();
        return ResponseEntity.ok(list);
    }

    @PostMapping("payment-method")
    public ResponseEntity<PaymentMethodDTO> createPaymentMethod(@RequestBody @Valid PaymentMethodDTO dto) {
        return ResponseEntity.created(null).body(this.paymentMethodService.createPaymentMethod(dto));
    }

    @PutMapping("payment-method/{id}")
    public ResponseEntity<PaymentMethodDTO> updatePaymentMethod(@PathVariable(name = "id") Long id,
            @RequestBody @Valid PaymentMethodDTO dto) {
        return ResponseEntity.created(null).body(this.paymentMethodService.updatePaymentMethod(dto, id));
    }

    @DeleteMapping("payment-method/{id}")
    public ResponseEntity<Void> deletePaymentMethod(@PathVariable(name = "id") Long id) {
        this.paymentMethodService.deletePaymentMethod(id);
        return ResponseEntity.noContent().build();
    }

}
