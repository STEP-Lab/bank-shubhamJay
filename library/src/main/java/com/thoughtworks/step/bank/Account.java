package com.thoughtworks.step.bank;

public class Account {
  private final String name;
  private final int accountNumber;
  private int balance;

  public Account(String name, int accountNumber, int balance) {
    this.name = name;
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  public int getAccountNumber() {
    return accountNumber;
  }

  public String getName() {
    return name;
  }
}
