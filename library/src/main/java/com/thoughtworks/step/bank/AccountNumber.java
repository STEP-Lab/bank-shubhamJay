package com.thoughtworks.step.bank;

public class AccountNumber {
  private final String accountNumber;

  public AccountNumber(String accountNumber) throws InvalidAccNumException {
    if (!accountNumber.matches("^\\d{4}-\\d{4}$")){
      throw new InvalidAccNumException(accountNumber);
    }
    this.accountNumber = accountNumber;
  }

  public String getAccountNumber() {
    return accountNumber;
  }
}
