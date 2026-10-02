package com.fpelli.finanzas_personal.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

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
@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final ExpenseTypeRepository expenseTypeRepository;

    public ExpenseDTO createExpense(ExpenseDTO dto) {
        validateAmounts(dto);
        ExpenseType expenseTypeRef = expenseTypeRepository.getReferenceById(dto.expenseTypeId());
        Expense entity = ExpenseMapper.toEntity(dto, expenseTypeRef);
        if (entity.getDateTime() == null) entity.setDateTime(LocalDateTime.now());
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

    public List<ExpenseDTO> listByDate(Integer month, Integer year) {
        if (year != null && month == null) {
            return listByYear(Year.of(year));
        }
        YearMonth period = YearMonth.of(
                year != null ? year : Year.now().getValue(),
                month != null ? month : YearMonth.now().getMonthValue());
        return listByPeriod(period);
    }

    private List<ExpenseDTO> listByPeriod(YearMonth period) {
        return listBetween(start(period), end(period));
    }

    private List<ExpenseDTO> listByYear(Year year) {
        LocalDateTime start = year.atDay(1).atStartOfDay();
        return listBetween(start, start.plusYears(1));
    }

    private List<ExpenseDTO> listBetween(LocalDateTime start, LocalDateTime end) {
        return expenseRepository
                .findByDateTimeGreaterThanEqualAndDateTimeLessThan(start, end)
                .stream()
                .map(ExpenseMapper::toDTO)
                .toList();
    }

    public Map<Integer, Long> countExpensePerHour(YearMonth period) {
        return expenseRepository.countPerHour(start(period), end(period))
                .stream()
                .collect(Collectors.toMap(
                        ExpenseRepository.HourlyCount::getHour,
                        ExpenseRepository.HourlyCount::getTotal));
    }

    private LocalDateTime start(YearMonth period) {
        return period.atDay(1).atStartOfDay();
    }

    private LocalDateTime end(YearMonth period) {
        return period.plusMonths(1).atDay(1).atStartOfDay();
    }

    private void validateAmounts(ExpenseDTO dto) {
        if (dto.amount() == null && dto.amountUSD() == null) {
            throw new ValidationException("At least one of amount or amountUSD must be provided");
        }
        if(dto.amount() != null && dto.amount().equals(BigDecimal.ZERO)){
            throw new ValidationException("Amount cannot be zero");
        }
        if(dto.amountUSD() != null && dto.amountUSD().equals(BigDecimal.ZERO)){
            throw new ValidationException("AmountUSD cannot be zero");
        }
    }
}
