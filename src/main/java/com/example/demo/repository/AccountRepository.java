package com.example.demo.repository;

import com.example.demo.domain.Account;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>, AccountRepositoryCustom {

  Account findByName(String name);

  List<Account> findByAccountType(String accountType);

  Account findByAccountNumber(String accountNumber);

  boolean updateAccount(Long id, String money);
}
