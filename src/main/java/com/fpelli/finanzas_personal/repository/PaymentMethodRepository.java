package com.fpelli.finanzas_personal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpelli.finanzas_personal.entity.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long>{

}
