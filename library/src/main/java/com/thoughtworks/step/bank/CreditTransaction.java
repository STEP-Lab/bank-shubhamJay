package com.thoughtworks.step.bank;

import java.util.Date;

public class CreditTransaction extends Transaction {

  public CreditTransaction(int amount) {
    super(amount, new Date());
  }
}
