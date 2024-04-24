package com.example.bank.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "userType")
@Data
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userType;
    @OneToMany(mappedBy = "id")
    @ToString.Exclude
    private Set<BankUser> users;
}
