package com.thoughtworks.step.bank;

public class Account {
  private final String name;
  private final int number;
  private int balance;

  public Account(String name, int number, int balance) {
    this.name = name;
    this.number = number;
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }
}
