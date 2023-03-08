package com.example.demo.repository;

import com.example.demo.domain.Account;
import com.example.demo.domain.AccountType;
import com.example.demo.domain.QAccount;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepositoryCustom{

  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public Account findByName(String name) {
    Account account = jpaQueryFactory.selectFrom(QAccount.account)
        .where(QAccount.account.cardName.eq(name))
        .fetchOne();

    return account;
  }

  @Override
  public List<Account> findByAccountType(String accountType){
    List<Account> accounts = jpaQueryFactory.selectFrom(QAccount.account)
        .where(QAccount.account.accountType.eq(accountType))
        .fetch();

//    List<Account> accounts = jpaQueryFactory.selectFrom(QAccount.account)
//        .fetch();
    return accounts;
  }

  @Override
  public Account findByAccountNumber(String accountNumber) {
    return jpaQueryFactory.selectFrom(QAccount.account)
        .where(QAccount.account.accountNumber.eq(accountNumber))
        .fetchOne();
  }

  @Override
  @Transactional
  public boolean updateAccount(Long id, String money) {

    long execute = jpaQueryFactory.update(QAccount.account)
        .where(QAccount.account.id.eq(id))
        .set(QAccount.account.money, money)
        .execute();

    if(execute > 0){
      return true;
    }
    return false;
  }
}
