package com.fpelli.finanzas_personal.service;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import com.fpelli.finanzas_personal.dto.ExpenseTypeDTO;
import com.fpelli.finanzas_personal.entity.ExpenseType;
import com.fpelli.finanzas_personal.repository.ExpenseTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseTypeRepository expenseTypeRepository;
    public ExpenseTypeDTO saveExpenseType(ExpenseTypeDTO dto) {
        return expenseTypeRepository.save(dto.toEntity()).toDTO();
    }

    public ExpenseTypeDTO getExpenseTypeById(Long id) {
        return expenseTypeRepository.findById(id)
                                    .map(ExpenseType::toDTO)
                                    .orElseThrow(() -> new ServiceException("Expense type not found"));
    }
}
