package com.example.bank.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "bank_user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BankUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String mobile;
    @OneToOne
    @JoinColumn(name = "self_address_id")
    @ToString.Exclude
    private Address selfAddress;
    @ManyToOne
    @JoinColumn(name = "user_type_id")
    @ToString.Exclude
    private UserType userType;
    @ToString.Exclude
    @OneToMany(mappedBy = "id")
    private Set<Account> accounts;
}
