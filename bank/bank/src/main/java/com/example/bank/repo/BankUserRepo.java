package com.example.bank.repo;

import com.example.bank.entity.BankUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankUserRepo extends JpaRepository<BankUser,String> {
}
