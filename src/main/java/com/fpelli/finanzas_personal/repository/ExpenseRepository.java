package com.fpelli.finanzas_personal.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fpelli.finanzas_personal.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByDateTimeGreaterThanEqualAndDateTimeLessThan(
            LocalDateTime start,
            LocalDateTime end);

    @Query("""
            select extract(hour from e.dateTime) as hour, count(e) as total
            from Expense e
            where e.dateTime >= :start and e.dateTime < :end
            group by extract(hour from e.dateTime)
            order by extract(hour from e.dateTime)
            """)
    List<HourlyCount> countPerHour(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end);

    interface HourlyCount {
        Integer getHour();
        Long getTotal();
    }
}
