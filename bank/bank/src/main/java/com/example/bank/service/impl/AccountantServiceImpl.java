package com.example.bank.service.impl;

import com.example.bank.model.BankUserReq;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Implementing the proxy design pattern to utilize the functionalities of the UserServiceImpl
 * but still validation and particular business logic to create the Accountant
 */
@Service
public class AccountantServiceImpl extends UserServiceImpl{
    public AccountantServiceImpl(){
        super();
    }
    public ResponseEntity createAccount(BankUserReq req){
        // additional bussiness logic for accountant
        return this.createUser(req);
    }
}
