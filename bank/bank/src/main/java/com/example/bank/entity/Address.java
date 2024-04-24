package com.example.bank.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String pinCode;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String country;
    private String state;
    @ManyToOne
    @ToString.Exclude
    private BankUser user;
}
