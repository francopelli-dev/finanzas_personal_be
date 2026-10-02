package com.fpelli.finanzas_personal.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import com.fpelli.finanzas_personal.dto.ExpenseTypeDTO;
import com.fpelli.finanzas_personal.entity.ExpenseType;
import com.fpelli.finanzas_personal.mapper.ExpenseTypeMapper;
import com.fpelli.finanzas_personal.repository.ExpenseTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseTypeService {
    private final ExpenseTypeRepository expenseTypeRepository;
    public ExpenseTypeDTO createExpenseType(ExpenseTypeDTO dto) {
        return ExpenseTypeMapper.toDTO(expenseTypeRepository.save(ExpenseTypeMapper.toEntity(dto)));
    }
    public ExpenseTypeDTO updateExpenseType(ExpenseTypeDTO dto, Long id) {
        ExpenseType entity = ExpenseTypeMapper.toEntity(dto);
        entity.setId(id);
        return ExpenseTypeMapper.toDTO(expenseTypeRepository.save(entity));
    }

    public ExpenseTypeDTO getExpenseTypeById(Long id) {
        return expenseTypeRepository.findById(id)
                                    .map(ExpenseTypeMapper::toDTO)
                                    .orElseThrow(() -> new ServiceException("Expense type not found"));
    }

    public List<ExpenseTypeDTO> getAllExpenseTypes() {
        return expenseTypeRepository.findAll()
                                    .stream()
                                    .map(ExpenseTypeMapper::toDTO)
                                    .toList();
    }


    public void deleteExpenseTypeById(Long id) {
        expenseTypeRepository.deleteById(id);
    }
}
