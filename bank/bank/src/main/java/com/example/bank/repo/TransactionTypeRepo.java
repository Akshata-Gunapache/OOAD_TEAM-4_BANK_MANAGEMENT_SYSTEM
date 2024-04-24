package com.example.bank.repo;

import com.example.bank.entity.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionTypeRepo extends JpaRepository<TransactionType,String> {

    Optional<TransactionType> findBytransferType(String transfer);
}
