package com.thoughtworks.step.bank;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionTest {

  private DebitTransaction debitTransaction;

  @Before
  public void setUp() throws Exception {
    debitTransaction = new DebitTransaction(3000, new Date());
  }

  @Test
  public void checkGetBalance() {
    assertThat(debitTransaction.getAmount(), is(3000));
  }

  @Test
  public void checkGetDate() {
    assertThat(debitTransaction.getDate().toString(), is(new Date().toString()));
  }

}