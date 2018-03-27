package com.thoughtworks.step.bank;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TransactionTest {
  @Test
  public void checkGetBalance() {
    DebitTransaction debitTransaction = new DebitTransaction(3000);
    assertThat(debitTransaction.getAmount(), is(3000));
  }

  public void checkGetDate() {
    DebitTransaction debitTransaction = new DebitTransaction(3000, new Date());
    assertThat(debitTransaction.getDate().toString(), is(new Date().toString()));
  }
}