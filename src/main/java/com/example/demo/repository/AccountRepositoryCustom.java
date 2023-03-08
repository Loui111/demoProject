package com.example.demo.repository;

import com.example.demo.domain.Account;
import java.util.List;

public interface AccountRepositoryCustom {

  Account findByName(String name);

  List<Account> findByAccountType(String accountType);

  Account findByAccountNumber(String accountNumber);

  boolean updateAccount(Long id, String money);
}
