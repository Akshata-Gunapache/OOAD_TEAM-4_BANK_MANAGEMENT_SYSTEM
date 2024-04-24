package com.example.bank.repo;

import com.example.bank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo1 extends JpaRepository<Account,String> {



    Optional<Account> findByAccNo(String id);

}
