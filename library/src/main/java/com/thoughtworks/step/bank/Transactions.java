package com.thoughtworks.step.bank;

import java.util.ArrayList;

public class Transactions {

  private ArrayList<Transaction> transactions;

  public Transactions() {
    this.transactions = new ArrayList<>();
  }

  public void addDebitTransaction(int amount) {
    this.transactions.add(new DebitTransaction(amount));
  }

  public ArrayList<Transaction> getTransactions() {
    return transactions;
  }

  public void addCreditTransaction(int amount) {
    transactions.add(new CreditTransaction(amount));
  }
}
