package com.example.bank.model;

import lombok.Data;

@Data
public class BankUserReq {
    private long id;
    private String name;
    private String email;
    private String mobile;
    private String userType;
}
