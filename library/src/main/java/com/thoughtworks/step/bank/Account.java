package com.thoughtworks.step.bank;

public class Account {
  private final String name;
  private final String accountNumber;
  private int balance;

  public Account(String name, String accountNumber, int balance) throws InvalidAccNumException{
    if (!accountNumber.matches("^\\d{4}-\\d{4}$")){
      throw new InvalidAccNumException(accountNumber);
    }
    this.name = name;
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public String getName() {
    return name;
  }

  public int withdraw(int amount) throws LowBalanceException {
    if (canDebit(amount)) {
      throw new LowBalanceException(amount);
    }
    balance -= amount;
    return balance;
  }

  public boolean canDebit(int amount) {
    return amount <= balance;
  }

}
