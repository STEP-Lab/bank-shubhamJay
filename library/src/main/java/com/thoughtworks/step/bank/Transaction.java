package com.thoughtworks.step.bank;

import java.util.Date;
import java.util.Objects;

abstract public class Transaction {
  private final int amount;
  private final Date date;

  public Transaction(int amount, Date date) {
    this.amount = amount;
    this.date = date;
  }

  public int getAmount() {
    return amount;
  }

  public Date getDate() {
    return date;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Transaction that = (Transaction) o;
    return amount == that.amount &&
            Objects.equals(date.toString(), that.date.toString());
  }

  @Override
  public String toString() {
    return "Transaction{" +
            "amount=" + amount +
            ", date=" + date +
            '}';
  }
}
