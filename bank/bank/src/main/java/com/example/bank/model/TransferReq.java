package com.example.bank.model;

import lombok.Data;

@Data
public class TransferReq {
    private String senderId;
    private String ifscCode;
    private String accNo;
    private String amount;
    private String transerType;
    private String senderAccNo;
}
