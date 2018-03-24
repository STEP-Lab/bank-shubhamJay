package com.thoughtworks.step.bank;

import org.junit.Test;

public class AccountNumberTest {
  private Account account;

  @Test
  public void checkAccNumFormat() throws InvalidAccNumException {
    account = new Account("yogi",new AccountNumber("1234-1234"),1000);
  }

  @Test(expected = InvalidAccNumException.class)
  public void checkInvalidAccNumFormat() throws InvalidAccNumException {
    account = new Account("yogi",new AccountNumber("123"),1000);
  }
}