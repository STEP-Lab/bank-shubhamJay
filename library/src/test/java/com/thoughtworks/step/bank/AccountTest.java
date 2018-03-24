package com.thoughtworks.step.bank;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class AccountTest {
  private Account account;

  @Before
  public void setUp() throws InvalidAccNumException {
    account = new Account("yogi",new AccountNumber("1234-1234"),1000);
  }

  @Test
  public void checkBalance() {
    assertThat(account.getBalance(),is(1000.0));
  }

  @Test
  public void checkAccountNumber() {
    assertThat(account.getAccountNumber(),is("1234-1234"));
  }
  @Test

  public void checkAccountName() {
    assertThat(account.getName(),is("yogi"));
  }

  @Test
  public void checkCashWithdraw() throws LowBalanceException {
    assertThat(account.withdraw(500),is(500));
    assertThat(account.getBalance(),is(500.0));
  }

  @Test(expected = LowBalanceException.class)
  public void checkInvalidCashWithdraw() throws LowBalanceException {
    account.withdraw(2000);
  }

  @Test
  public void checkCredit() throws InvalidAccNumException {
    Account account = new Account("yogi", new AccountNumber("1212-1212"), 1000);
    assertThat(account.credit(3000),is(4000));
    assertThat(account.getTransactions(),hasItem(new CreditTransaction(3000)));
  }

  @Test
  public void checkTransactions() throws LowBalanceException, InvalidAccNumException {
    Account account = new Account("yogi", new AccountNumber("1212-1212"), 1000);
    account.credit(3000);
    account.withdraw(2000);
    assertThat(account.getTransactions(),hasItems(new CreditTransaction(3000),new DebitTransaction(2000)));
  }
}
