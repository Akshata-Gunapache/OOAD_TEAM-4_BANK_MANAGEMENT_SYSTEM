package com.example.bank.service.impl;
import com.example.bank.mapper.BankUserMapper;
import com.example.bank.model.BankUserReq;
import com.example.bank.repo.BankUserRepo;
import com.example.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserServiceImpl implements UserService {

    @Autowired
    private BankUserMapper bankUserMapper;
    @Autowired
    private BankUserRepo bankUserRepo;
    @Override
    public ResponseEntity createUser(BankUserReq user) {
        bankUserRepo.save(bankUserMapper.createBankUser(user));
        return ResponseEntity.ok().body("User Created Successfully");
    }
}
