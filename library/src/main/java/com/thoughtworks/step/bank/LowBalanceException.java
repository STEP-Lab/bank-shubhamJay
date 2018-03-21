package com.thoughtworks.step.bank;

public class LowBalanceException extends Exception{
  public LowBalanceException(int amount) {
    super("Not sufficient balance for "+amount);
  }
}
