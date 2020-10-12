package com.eomcs.concurrent.ex5;

public class Exam0110 {
  public static void main(String[] args) {
    Account account = new Account("111-11-1111-111", 100_0000);

    ATM a = new ATM("a", account);
    ATM b = new ATM("b", account);
    ATM c = new ATM("c", account);
    ATM d = new ATM("d", account);
    ATM e = new ATM("e", account);

    a.start();
    b.start();
    c.start();
    d.start();
    e.start();
  }
}
