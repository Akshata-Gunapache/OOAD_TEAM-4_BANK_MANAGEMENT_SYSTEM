package com.example.bank.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "transactionType")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String transferType;

    @OneToMany(mappedBy = "id")
    @ToString.Exclude
    private Set<TransactionDetails> transactionDetailsSet;

    public TransactionType(String upi) {
        this.setTransferType("upi");
    }
}
