package com.example.bank.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@Table(name = "transaction_details")
@Entity
@Builder
public class TransactionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String utrNo;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "recevier_id")
    @ToString.Exclude
    private BankUser receiver;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    @ToString.Exclude
    private BankUser sender;

    @ManyToOne
    @JoinColumn(name = "transaction_type_id")
    @ToString.Exclude
    private TransactionType transactionType;
}
