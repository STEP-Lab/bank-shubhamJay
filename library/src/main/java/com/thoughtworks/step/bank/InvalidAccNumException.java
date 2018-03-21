package com.thoughtworks.step.bank;

public class InvalidAccNumException extends Exception {
  public InvalidAccNumException (String accNum){
    super("Invalid Account Number "+ accNum + ", valid account number format is 1111-1111");
  }
}
