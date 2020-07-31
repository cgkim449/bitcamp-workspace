package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {

    Scanner keyInput = new Scanner(System.in);

    final int LENGTH = 10;

    int[] no = new int[LENGTH];
    String[] title = new String[LENGTH];
    String[] content = new String[LENGTH];
    String[] author = new String[LENGTH];
    String[] teammates = new String[LENGTH];
    Date[] startDate = new Date[LENGTH];
    Date[] endDate = new Date[LENGTH];

    int count = 0;

    System.out.println("[프로젝트]");

    for (int i = 0; i < LENGTH; i++) {
      count++;
      System.out.print("번호? ");
      no[i] = keyInput.nextInt();
      keyInput.nextLine();
      System.out.print("프로젝트명? ");
      title[i] = keyInput.nextLine();
      System.out.print("내용? ");
      content[i] = keyInput.nextLine();
      System.out.print("시작일? ");
      startDate[i] = Date.valueOf(keyInput.nextLine());
      // 예외처리 문법이있다(날짜 형식에 안맞게 쳤을때 프로그램이 종료되는것을 방지)
      System.out.print("종료일? ");
      endDate[i] = Date.valueOf(keyInput.nextLine());
      System.out.print("만든이? ");
      author[i] = keyInput.nextLine();
      System.out.print("팀원? ");
      teammates[i] = keyInput.nextLine();

      System.out.println();
      System.out.print("계속 입력하시겠습니까? (y/N) ");
      String response = keyInput.nextLine();
      System.out.println();
      if (!response.equalsIgnoreCase("y")) // y가 아니라면 멈춰라
        break;
    }

    System.out.println("--------------------------------------");

    for (int i = 0; i < count; i++) {
      System.out.printf("%d, %s, %s, %s, %s",
          no[i], title[i], startDate[i].toString(), endDate[i].toString(), author[i]);
    }
    keyInput.close();
  }
}