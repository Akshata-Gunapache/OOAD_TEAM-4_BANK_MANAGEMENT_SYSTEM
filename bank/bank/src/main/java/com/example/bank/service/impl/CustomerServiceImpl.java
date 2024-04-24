package com.example.bank.service.impl;

import com.example.bank.model.BankUserReq;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Implementing the proxy design pattern to utilize the functionalities of the UserServiceImpl
 * but still validation and particular business logic to create the Customer
 */
@Service
public class CustomerServiceImpl extends UserServiceImpl{
    public CustomerServiceImpl(){
        super();
    }

    public ResponseEntity createCusomter(BankUserReq req){
        return this.createUser(req);
    }
}
