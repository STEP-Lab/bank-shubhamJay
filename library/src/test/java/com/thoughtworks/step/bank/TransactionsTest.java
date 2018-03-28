package com.thoughtworks.step.bank;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class TransactionsTest {

  private Transactions transactions;

  @Before
  public void setUp() {
    transactions = new Transactions();
  }

  @Test
  public void checkAddingDebitTransaction() {
    transactions.addDebitTransaction(3000);
    assertThat(transactions.getTransactions(), hasItem(new DebitTransaction(3000)));
  }

  @Test
  public void checkAddingCreditTransaction() {
    transactions.addCreditTransaction(3000);
    assertThat(transactions.getTransactions(), hasItem(new CreditTransaction(3000)));
  }

  @Test
  public void checkGetAllDebitTransactions() {
    transactions.addDebitTransaction(200);
    transactions.addCreditTransaction(300);
    transactions.addDebitTransaction(400);
    Transactions allDebitTransactions = transactions.getAllDebitTransactions();
    assertThat(allDebitTransactions.getTransactions(), hasItems(new DebitTransaction(200), new DebitTransaction(400)));
    assertThat(allDebitTransactions.getTransactions(), not(hasItem(new CreditTransaction(300))));
  }

  @Test
  public void checkGetAllCreditTransactions() {
    transactions.addCreditTransaction(200);
    transactions.addDebitTransaction(400);
    transactions.addCreditTransaction(300);
    Transactions allCreditTransaction = transactions.getAllCreditTransaction();
    assertThat(allCreditTransaction.getTransactions(), hasItems(new CreditTransaction(200), new CreditTransaction(300)));
    assertThat(allCreditTransaction.getTransactions(), not(hasItem(new DebitTransaction(400))));
  }

  @Test
  public void checkGetTransactionsAbove() {
    transactions.addCreditTransaction(200);
    transactions.addCreditTransaction(400);
    transactions.addCreditTransaction(600);
    transactions.addDebitTransaction(700);
    Transactions transactionsAbove = transactions.getTransactionsAbove(500);
    assertThat(transactionsAbove.getTransactions(), hasItems(new DebitTransaction(700), new CreditTransaction(600)));
    assertThat(transactionsAbove.getTransactions(), not(hasItems(new CreditTransaction(200), new CreditTransaction(400))));
  }

  @Test
  public void checkTransactionBelow() {
    transactions.addCreditTransaction(200);
    transactions.addCreditTransaction(400);
    transactions.addCreditTransaction(600);
    transactions.addDebitTransaction(700);
    Transactions transactionsBelow = transactions.getTransactionsBelow(500);
    assertThat(transactionsBelow.getTransactions(), hasItems(new CreditTransaction(200), new CreditTransaction(400)));
    assertThat(transactionsBelow.getTransactions(), not(hasItems(new DebitTransaction(700), new CreditTransaction(600))));
  }
}