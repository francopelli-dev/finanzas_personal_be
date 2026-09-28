package com.fpelli.finanzas_personal.controller;

import com.fpelli.finanzas_personal.dto.ExpenseTypeDTO;
import com.fpelli.finanzas_personal.entity.ExpenseType;
import com.fpelli.finanzas_personal.repository.ExpenseTypeRepository;
import com.fpelli.finanzas_personal.service.ExpenseService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;



    @PostMapping("/expense-type")
    public ResponseEntity<ExpenseTypeDTO> createExpenseType(@RequestBody ExpenseTypeDTO dto) {;       
        return ResponseEntity.ok(this.expenseService.saveExpenseType(dto));
    }
    @PutMapping("/expense-type")
    public ResponseEntity<ExpenseTypeDTO> updateExpenseType(@RequestBody ExpenseTypeDTO dto) {;       
        return ResponseEntity.ok(this.expenseService.saveExpenseType(dto));
    }
    @GetMapping("/expense-type/{id}")
    public ResponseEntity<ExpenseTypeDTO> getExpenseById(@PathVariable Long id) {
        return ResponseEntity.ok(this.expenseService.getExpenseTypeById(id));
    }
    
    
}
