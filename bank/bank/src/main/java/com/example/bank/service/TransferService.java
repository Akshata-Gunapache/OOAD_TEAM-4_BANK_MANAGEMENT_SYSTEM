package com.example.bank.service;

import com.example.bank.model.TransferReq;
import org.springframework.http.ResponseEntity;

public interface TransferService {
    public ResponseEntity sendMoney(TransferReq req);
}

