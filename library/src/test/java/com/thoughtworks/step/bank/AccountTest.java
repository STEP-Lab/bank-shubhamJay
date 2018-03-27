package com.thoughtworks.step.bank;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.*;
import static org.junit.Assert.assertThat;

public class AccountTest {
  private Account account;

  @Before
  public void setUp() throws InvalidAccNumException {
    account = new Account("yogi", AccountNumber.createAccountNumber("1234-1234"),1000);
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
  public void checkCashDebit() throws LowBalanceException {
    assertThat(account.debit(500),is(500));
    assertThat(account.getBalance(),is(500.0));
  }

  @Test(expected = LowBalanceException.class)
  public void checkInvalidCashDebit() throws LowBalanceException {
    account.debit(2000);
  }

  @Test
  public void checkCredit() throws InvalidAccNumException {
    Account account = new Account("yogi", AccountNumber.createAccountNumber("1212-1212"), 1000);
    assertThat(account.credit(3000),is(4000));
    assertThat(account.getTransactions(),hasItem(new CreditTransaction(3000)));
  }

  @Test
  public void checkTransactions() throws LowBalanceException, InvalidAccNumException {
    Account account = new Account("yogi", AccountNumber.createAccountNumber("1212-1212"), 1000);
    account.credit(3000);
    account.debit(2000);
    assertThat(account.getTransactions(),hasItems(new CreditTransaction(3000),new DebitTransaction(2000)));
  }
}
