package com.example.demo.service;

import com.example.demo.domain.Account;
import com.example.demo.domain.AccountDto;
import com.example.demo.repository.AccountRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@RequiredArgsConstructor
@ResponseBody
@Slf4j
public class AccountService {

  private final AccountRepository accountRepository;

  public List<Account> getAllAccount(){
    return accountRepository.findAll();
  }

  public AccountDto getAccount(Long id) {
//    Optional<Account> account = accountRepository.findById(id);
    Account account = accountRepository.findById(id).orElseThrow();
    return AccountDto.of(account);
}

  public AccountDto getAccountByName(String name) {
    Account account = accountRepository.findByName(name);

    return AccountDto.of(account);
  }

  public List<AccountDto> getAccountByAccountType(String accountType) {
    List<Account> accounts = accountRepository.findByAccountType(accountType);

    List<AccountDto> accountDtos = new ArrayList<>();

    for(Account account : accounts){
      AccountDto accountDto = new AccountDto();
      AccountDto of = accountDto.of(account);

      accountDtos.add(of);
    }
    return accountDtos;


//    return byAccountNumber;
  }

  public AccountDto setWithdrawAccount(String accountNumber, String money) throws Exception{

    int newMoney=0;

    //check current money
    Account beforeAccountByAccountNumber = this.getAccountByAccountNumber(accountNumber);
    log.info("originMoney:: "+beforeAccountByAccountNumber.getMoney());

    //validation & throw exception
    newMoney = calcMoney(beforeAccountByAccountNumber.getMoney(), money);

    boolean b = accountRepository.updateAccount(beforeAccountByAccountNumber.getId(), String.valueOf(newMoney));

    //check after money
    Account afterAccountByAccountNumber = this.getAccountByAccountNumber(accountNumber);
    log.info("updatedMoney:: "+afterAccountByAccountNumber.getMoney());

    return AccountDto.of(afterAccountByAccountNumber);
  }

  private int calcMoney(String originMoney, String withralMoney) throws Exception {

    int result = Integer.parseInt(originMoney) - Integer.parseInt(withralMoney);

    if( result < 0) {
      throw new Exception("No Money!!!");
    }

    return result;
  }

  public Account getAccountByAccountNumber(String accountNumber) {
    return accountRepository.findByAccountNumber(accountNumber);
  }
}
