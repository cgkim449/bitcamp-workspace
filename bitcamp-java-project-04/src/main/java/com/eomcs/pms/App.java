package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App1e {
  public static void main(String[] args) {

    final int LENGTH = 10;

    int[] no = new int[LENGTH];
    String[] name = new String[LENGTH];
    String[] email = new String[LENGTH];
    String[] password = new String[LENGTH];
    String[] photo = new String[LENGTH];
    String[] tel = new String[LENGTH];
    Date[] now = new Date[LENGTH];

    long currentMilli;
    int count = 0;

    Scanner keyInput = new Scanner(System.in);

    System.out.println("[회원]");
    for (int i = 0; i < LENGTH; i++) {
      count++;
      System.out.print("번호? ");
      no[i] = keyInput.nextInt();
      keyInput.nextLine();
      System.out.print("이름? ");
      name[i] = keyInput.nextLine();
      System.out.print("이메일? ");
      email[i] = keyInput.nextLine();
      System.out.print("암호? ");
      password[i] = keyInput.nextLine();
      System.out.print("사진? ");
      photo[i] = keyInput.nextLine();
      System.out.print("전화? ");
      tel[i] = keyInput.nextLine();

      currentMilli = System.currentTimeMillis();
      now[i] = new Date(currentMilli);

      System.out.println();
      System.out.print("계속 입력하시겠습니까? (y/N)");
      String response= keyInput.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }
      System.out.println();
    }
    System.out.println("---------------------------");

    for (int i = 0; i < count; i++) {
      System.out.printf("%d, %s, %s ,%s, %s\n", no[i], name[i], email[i], tel[i], now[i].toString());
    }

  }
}