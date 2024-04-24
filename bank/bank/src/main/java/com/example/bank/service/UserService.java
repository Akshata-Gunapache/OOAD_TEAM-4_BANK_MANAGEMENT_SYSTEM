package com.example.bank.service;

import com.example.bank.model.BankUserReq;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity createUser(BankUserReq user);
}
