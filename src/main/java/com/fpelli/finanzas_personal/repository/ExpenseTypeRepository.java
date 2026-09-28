package com.fpelli.finanzas_personal.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;


import com.fpelli.finanzas_personal.entity.ExpenseType;

public interface ExpenseTypeRepository extends CrudRepository<ExpenseType,Long> {

}
