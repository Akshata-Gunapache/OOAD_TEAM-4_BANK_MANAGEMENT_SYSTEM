package com.example.bank.mapper;

import com.example.bank.entity.BankUser;
import com.example.bank.entity.UserType;
import com.example.bank.model.BankUserReq;
import com.example.bank.repo.UserTypeRepo;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Builder
public class BankUserMapper {

    @Autowired
    private UserTypeRepo userTypeRepo;
    public BankUser createBankUser(BankUserReq req){
        /**
         * Implemented the Builder pattern to map the request
         * object to entity. This is basically used instead of creating
         * multiple constructors for multiple optional parameters
         *
         */
        return  BankUser.builder()
                .email(req.getEmail())
                .userType(getUserType(req.getUserType()))
                .name(req.getName())
                .mobile(req.getMobile())
                .build();
    }

    private UserType getUserType(String userTypeId){
        Optional<UserType> userTypeOptional = userTypeRepo.findById(userTypeId);
        return userTypeOptional.isPresent() ? userTypeOptional.get() : null;
    }

}
