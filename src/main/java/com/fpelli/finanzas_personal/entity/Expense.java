package com.fpelli.finanzas_personal.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter 
public class Expense extends GenericEntity {
    @Column(nullable = false, length = 50)
    private String description;
    private BigDecimal amount;
    private BigDecimal amountUSD;
    @Column(nullable = false)
    private LocalDateTime dateTime;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="expense_type_id", nullable = false)
    private ExpenseType expenseType;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="payment_method_id", nullable = false)
    private PaymentMethod paymentMethod;
    
    
    


}
