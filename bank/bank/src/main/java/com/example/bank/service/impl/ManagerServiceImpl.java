package com.example.bank.service.impl;

import com.example.bank.entity.BankUser;
import com.example.bank.model.BankUserReq;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Implementing the proxy design pattern to utilize the functionalities of the UserServiceImpl
 * but still validation and particular business logic to create the Manager
 */
@Service
public class ManagerServiceImpl extends UserServiceImpl{

    public ManagerServiceImpl(){
        super();
    }

    public ResponseEntity createManger(BankUserReq user){
        // Additional Business logic for manager Creation
        return this.createUser(user);
    }
}
