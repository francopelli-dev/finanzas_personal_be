package com.fpelli.finanzas_personal.controller;

import com.fpelli.finanzas_personal.entity.ExpenseType;
import com.fpelli.finanzas_personal.repository.ExpenseTypeRepository;
import com.fpelli.finanzas_personal.service.ExpenseService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;
    private final ExpenseTypeRepository expenseTypeRepository;



    @PostMapping("/expense-type/{name}")
    public String postMethodName(@PathVariable String name) {
        ExpenseType entity = new ExpenseType();
        entity.setName(name);
        entity.setVersion(1);
        this.expenseTypeRepository.save(entity);
        
        return HttpStatus.OK.toString();
    }
    @GetMapping("/expense-type/{id}")
    public String getExpenseById(@PathVariable Long id) {
        return this.expenseTypeRepository.getById(id)
                .map(ExpenseType::getName)
                .orElse("N/A");
    }
    
    
}
