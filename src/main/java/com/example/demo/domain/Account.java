package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {

  @Id
  @GeneratedValue
  private Long id;
  private String cardName;
  private String pinNumber;
  private String accountNumber;
  private String money;
//  private AccountType accountType;
  private String accountType;

  @Builder
  public Account(String cardName, String pinNumber, String accountNumber, String money,
      String accountType) {
    this.cardName = cardName;
    this.pinNumber = pinNumber;
    this.accountNumber = accountNumber;
    this.money = money;
    this.accountType = accountType;
  }

  public Long getId() {
    return id;
  }

}

