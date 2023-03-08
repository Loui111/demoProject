package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountType {

  CREDIT("CREDIT_CARD", "1"),
  DEBIT("DEBIT_CARD", "2")
  ;

  private final String desc;
  private final String code;
}
