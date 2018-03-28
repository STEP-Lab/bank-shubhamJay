package com.thoughtworks.step.bank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountNumberTest {

  @Test
  public void checkAccNumFormat() throws InvalidAccNumException {
    AccountNumber.createAccountNumber("1234-1234");
  }

  @Test(expected = InvalidAccNumException.class)
  public void checkInvalidAccNumFormat() throws InvalidAccNumException {
    AccountNumber.createAccountNumber("123");
  }

  @Test
  public void checkGetAccountNumber() throws InvalidAccNumException {
    AccountNumber accountNum = AccountNumber.createAccountNumber("1234-1237");
    assertEquals(accountNum.getAccountNumber(),"1234-1237");
  }
}