package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
public class AccountDto {

  private Long id;
  private String cardName;
  private String pinNumber;
  private String accountNumber;
  private String money;
  private String accountType;

  @Builder
  public AccountDto(Long id, String cardName, String pinNumber, String accountNumber, String money,
      String accountType) {
    this.id = id;
    this.cardName = cardName;
    this.pinNumber = pinNumber;
    this.accountNumber = accountNumber;
    this.money = money;
    this.accountType = accountType;
  }


  public static AccountDto of(Account account) {
    return
        AccountDto.builder()
        .id(account.getId())
        .cardName(account.getCardName())
        .pinNumber(account.getPinNumber())
        .accountNumber(account.getAccountNumber())
        .money(account.getMoney())
        .accountType(account.getAccountType())
        .build();
  }
}

