package com.example.bank.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "account")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ifscCOde;
    private String branhName;
    private String bankName;
    private String accNo;
    private String accountType;
    private String balance;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private BankUser user;

}
