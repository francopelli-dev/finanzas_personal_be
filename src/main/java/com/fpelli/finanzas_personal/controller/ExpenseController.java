package com.fpelli.finanzas_personal.controller;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fpelli.finanzas_personal.dto.ExpenseDTO;
import com.fpelli.finanzas_personal.dto.ExpenseTypeDTO;
import com.fpelli.finanzas_personal.service.ExpenseService;
import com.fpelli.finanzas_personal.service.ExpenseTypeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseTypeService expenseTypeService;
    private final ExpenseService expenseService;
    


    @PostMapping("/expense")
    public ResponseEntity<ExpenseDTO> createExpense(@RequestBody @Valid ExpenseDTO entity) {
        ExpenseDTO createdExpense = this.expenseService.createExpense(entity);
        return ResponseEntity.created(null).body(createdExpense);
    }
    



    @PostMapping("/expense-type")
    public ResponseEntity<ExpenseTypeDTO> createExpenseType(@RequestBody @Valid ExpenseTypeDTO dto) {;       
        return ResponseEntity.created(null).body(this.expenseTypeService.createExpenseType(dto));
    }
    @PutMapping("/expense-type/{id}")
    public ResponseEntity<ExpenseTypeDTO> updateExpenseType(@PathVariable Long id, @RequestBody @Valid ExpenseTypeDTO dto) {       

        return ResponseEntity.ok(this.expenseTypeService.updateExpenseType(dto,id));
    }
    @GetMapping("/expense-type/{id}")
    public ResponseEntity<ExpenseTypeDTO> getExpenseById(@PathVariable Long id) {
        return ResponseEntity.ok(this.expenseTypeService.getExpenseTypeById(id));
    }
    @GetMapping("/expense-type")
    public ResponseEntity<List<ExpenseTypeDTO>> getAllExpenseTypes() {
        return ResponseEntity.ok(this.expenseTypeService.getAllExpenseTypes());
    }
    @DeleteMapping("/expense-type/{id}")
    public ResponseEntity<Void> deleteExpenseTypeById(@PathVariable Long id) {
        this.expenseTypeService.deleteExpenseTypeById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/expense/by-date")
    public ResponseEntity<List<ExpenseDTO>> listByDate(@RequestParam(required = false) Integer year, @RequestParam(required = false) Integer month) {
        return ResponseEntity.ok(this.expenseService.listByDate(month, year));
    }
    @GetMapping("/expense/count-per-hour")
    public ResponseEntity<Map<Integer,Long>> countPerHour(@RequestParam(required = false) Integer year, @RequestParam(required = false) Integer month){
        YearMonth period = YearMonth.of(
            year != null ? year : LocalDate.now().getYear(),
            month != null ? month : LocalDate.now().getMonthValue());
        return ResponseEntity.ok(expenseService.countExpensePerHour(period));
    }
}
