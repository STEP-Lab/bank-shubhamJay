package com.thoughtworks.step.bank;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

public class TransactionsTest {
  @Test
  public void checkAddingDebitTransaction() {
    Transactions transactions = new Transactions();
    transactions.addDebitTransaction(3000);
    assertThat( transactions.getTransactions(),hasItem(new DebitTransaction(3000)));
  }

  @Test
  public void checkAddingCreditTransaction() {
    Transactions transactions = new Transactions();
    transactions.addCreditTransaction(3000);
    assertThat(transactions.getTransactions(),hasItem(new CreditTransaction(3000)));
  }
}