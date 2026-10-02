package com.fpelli.finanzas_personal.service;

import java.time.LocalDateTime;
import java.util.List;

import com.fpelli.finanzas_personal.dto.ExpenseDTO;
import com.fpelli.finanzas_personal.entity.Expense;
import com.fpelli.finanzas_personal.entity.ExpenseType;
import com.fpelli.finanzas_personal.exception.ResourceNotFoundException;
import com.fpelli.finanzas_personal.exception.ValidationException;
import com.fpelli.finanzas_personal.mapper.ExpenseMapper;
import com.fpelli.finanzas_personal.repository.ExpenseRepository;
import com.fpelli.finanzas_personal.repository.ExpenseTypeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final ExpenseTypeRepository expenseTypeRepository;

    public ExpenseDTO createExpense(ExpenseDTO dto) {
        validateAmounts(dto);
        ExpenseType expenseTypeRef = expenseTypeRepository.getReferenceById(dto.expenseTypeId());
        Expense entity = ExpenseMapper.toEntity(dto, expenseTypeRef);
        entity.setDate(LocalDateTime.now());
        return ExpenseMapper.toDTO(expenseRepository.save(entity));
    }

    public ExpenseDTO updateExpense(ExpenseDTO dto, Long id) {
        validateAmounts(dto);
        ExpenseType expenseTypeRef = expenseTypeRepository.getReferenceById(dto.expenseTypeId());
        Expense entity = ExpenseMapper.toEntity(dto, expenseTypeRef);
        entity.setId(id);
        return ExpenseMapper.toDTO(expenseRepository.save(entity));
    }

    public ExpenseDTO getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .map(ExpenseMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found"));
    }

    public List<ExpenseDTO> getAllExpenses() {
        return expenseRepository.findAll()
                .stream()
                .map(ExpenseMapper::toDTO)
                .toList();
    }

    public void deleteExpenseById(Long id) {
        expenseRepository.deleteById(id);
    }

    private void validateAmounts(ExpenseDTO dto) {
        if (dto.amount() == null && dto.amountUSD() == null) {
            throw new ValidationException("At least one of amount or amountUSD must be provided");
        }
    }
}
