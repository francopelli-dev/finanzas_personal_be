package com.fpelli.finanzas_personal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpelli.finanzas_personal.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
