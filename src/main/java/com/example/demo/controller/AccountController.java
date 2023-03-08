package com.example.demo.controller;

import com.example.demo.domain.Account;
import com.example.demo.domain.AccountDto;
import com.example.demo.service.AccountService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/account")
@Slf4j
public class AccountController {

  private final AccountService accountService;

  @GetMapping("")
  public List<Account> getAllAccount(){
    return accountService.getAllAccount();
  }

  @GetMapping("/{id}")
  public AccountDto getAccount(@PathVariable Long id){
    return accountService.getAccount(id);
  }

  @GetMapping("/search")
//  public AccountDto getAccountByName(@ModelAttribute SearchParam searchParam){
  public AccountDto getAccountByName(
      @RequestParam(value="cardName", defaultValue="hanaCard") String cardName){

    return accountService.getAccountByName(cardName);
  }

  @GetMapping("/search/accountType")
//  public AccountDto getAccountByName(@ModelAttribute SearchParam searchParam){
  public List<AccountDto> getAccountByAccountType(
      @RequestParam(value="accountType", defaultValue="CREDIT_CARD") String accountType){

    //TODO: ENUM쓰려고 했으나 뭔가 잘 안됨. 일단 보류
    String type="2";
    if(accountType.equals("CREDIT_CARD")) {
      type = "1";
    }

    return accountService.getAccountByAccountType(type);
  }

  @PostMapping("withdraw")
  public AccountDto setWithdrawAccount( //원래는 requestBody json 타입 쓰는게 맞지만,
                                        //url 공유를 위해서 우선 requestParam으로 진행.
      @RequestParam(value="account_number", defaultValue="344565667") String accountNumber,
      @RequestParam(value="money", defaultValue="3845") String money) throws Exception {

    return accountService.setWithdrawAccount(accountNumber, money);
  }


}
