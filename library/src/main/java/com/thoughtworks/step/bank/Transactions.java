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

  public Transactions getAllDebitTransactions() {
    Transactions result = new Transactions();
    transactions.forEach((Transaction transaction) -> {
      if (transaction instanceof DebitTransaction) {
        result.addTransaction(transaction);
      }
    });
    return result;
  }

  private void addTransaction(Transaction transaction) {
    transactions.add(transaction);
  }

  public Transactions getAllCreditTransaction() {
    Transactions result = new Transactions();
    transactions.forEach((Transaction transaction) -> {
      if (transaction instanceof CreditTransaction) {
        result.addTransaction(transaction);
      }
    });
    return result;
  }
}
