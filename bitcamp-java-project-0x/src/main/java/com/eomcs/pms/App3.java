package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {
  public static void main(String[] args) {

    class Task {
      int no;
      String content;
      Date completedDate;
      String state;
      String worker;
    }

    final int LENGTH = 100;
    int count = 0;

    Scanner keyScan = new Scanner(System.in);

    Task[] tasks = new Task[LENGTH];

    for (int i = 0; i < LENGTH; i++) {
      count++;
      Task t = new Task();
      System.out.print("번호? ");
      t.no = keyScan.nextInt();
      keyScan.nextLine();
      System.out.print("내용? ");
      t.content = keyScan.nextLine();
      System.out.print("마감일? ");
      t.completedDate = Date.valueOf(keyScan.nextLine());
      System.out.print("상태? \n");
      System.out.print("0:신규 \n");
      System.out.print("1:진행중 \n");
      System.out.print("2:완료 \n");
      System.out.print("> ");
      t.state = keyScan.nextLine();
      switch (t.state) {
        case "0":
          t.state = "신규";
          break;
        case "1":
          t.state = "진행중";
          break;
        case "2":
          t.state = "완료";
          break;
      }
      System.out.print("작업자? ");
      t.worker = keyScan.nextLine();

      tasks[i] = t;

      System.out.println();
      System.out.print("계속 입력하시겠습니까? (y/N)");
      String response = keyScan.nextLine();
      System.out.println();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }
    }

    for (int i = 0; i < count; i++) {
      Task t = new Task();
      t = tasks[i];
      System.out.printf("%d %s %s %s\n", t.no, t.content, t.completedDate.toString(), t.state);
    }
    keyScan.close();
  }
}