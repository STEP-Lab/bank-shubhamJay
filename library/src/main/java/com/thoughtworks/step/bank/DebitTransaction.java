package com.thoughtworks.step.bank;

import java.util.Date;

public class DebitTransaction extends Transaction {

  protected DebitTransaction(int amount, Date date) {
    super(amount, date);
  }

  public DebitTransaction(int amount) {
    this(amount, new Date());
  }
}
