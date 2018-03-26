package com.thoughtworks.step.bank;

import java.util.ArrayList;

public class Account {
  private final String name;
  private final AccountNumber accountNumber;
  private int balance;
  private Transactions transactions = new Transactions();

  public Account(String name, AccountNumber accountNumber, int balance) {
    this.name = name;
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  public String getAccountNumber() {
    return accountNumber.getAccountNumber();
  }

  public String getName() {
    return name;
  }

  public int debit(int amount) throws LowBalanceException {
    if (!canDebit(amount)) {
      throw new LowBalanceException(amount);
    }
    transactions.addDebitTransaction(amount);
    balance -= amount;
    return balance;
  }

  private boolean canDebit(int amount) {
    return amount <= balance;
  }

  public int credit(int amount) {
    balance += amount;
    transactions.addCreditTransaction(amount);
    return balance;
  }

  public ArrayList<Transaction> getTransactions() {
    return transactions.getTransactions();
  }
}
