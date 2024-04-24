package com.example.bank.service.impl;

import com.example.bank.entity.Account;
import com.example.bank.entity.BankUser;
import com.example.bank.entity.TransactionDetails;
import com.example.bank.entity.TransactionType;
import com.example.bank.model.TransferReq;
import com.example.bank.repo.AccountRepo1;
import com.example.bank.repo.BankUserRepo;
import com.example.bank.repo.TransactionDetailsRepo;
import com.example.bank.repo.TransactionTypeRepo;
import com.example.bank.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Primary
public class RegularTransferImpl implements TransferService {

    @Autowired
    private  AccountRepo1 accountRepo;
    @Autowired
    private  BankUserRepo bankUserRepo;
    @Autowired
    private TransactionDetailsRepo transactionDetailsRepo;

    @Autowired
    private TransactionTypeRepo transactionTypeRepo;

    @Transactional
    @Override
    public ResponseEntity sendMoney(TransferReq req) {

        Optional<Account> recAccountOptional = accountRepo.findByAccNo(req.getAccNo());
        Optional<Account> sendAccountOptional = accountRepo.findByAccNo(req.getSenderAccNo());

        if(sendAccountOptional.get().getUser().getId() == Long.parseLong(req.getSenderId())){
          String senderBalance =   sendAccountOptional.get().getBalance();
          String receiverBalance = recAccountOptional.get().getBalance();
          long result = Long.parseLong(senderBalance) - Long.parseLong(req.getAmount());
          if(result >= 0){
                sendAccountOptional.get().setBalance(String.valueOf(result));
                recAccountOptional.get().setBalance(String.valueOf(Long.valueOf(recAccountOptional.get().getBalance()) + result));
                transactionDetailsRepo.save(createTransaction(sendAccountOptional.get().getUser(), recAccountOptional.get().getUser()));
          }
        }
        return ResponseEntity.ok().body("Transfer Successful");
    }
    private TransactionDetails createTransaction(BankUser sender, BankUser receiver){
        return TransactionDetails.builder()
                .sender(sender)
                .receiver(receiver)
                .utrNo(String.valueOf(UUID.randomUUID()))
                .transactionType(transactionTypeRepo.findBytransferType("UPI").get())
                .build();
    }
}
