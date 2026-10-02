package com.fpelli.finanzas_personal.repository;



import org.springframework.data.jpa.repository.JpaRepository;




import com.fpelli.finanzas_personal.entity.ExpenseType;

public interface ExpenseTypeRepository extends JpaRepository<ExpenseType,Long> {

}
