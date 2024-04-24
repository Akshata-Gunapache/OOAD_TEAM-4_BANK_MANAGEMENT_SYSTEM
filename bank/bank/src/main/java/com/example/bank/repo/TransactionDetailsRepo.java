package com.example.bank.repo;

import com.example.bank.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailsRepo extends JpaRepository<TransactionDetails,String> {
}

