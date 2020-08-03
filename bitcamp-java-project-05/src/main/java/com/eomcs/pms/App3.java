package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {
  /**
   * @param args
   */
  public static void main(String[] args) {
 // 리모컨에 저장한다 도구새로사오자 어떻게뿌릴까(물을 틀자)
    //리모컨에 저장한다 사온다 어떻게받을지에대한도구(키보드로 입력받자)
    //변수.메서드() ( 예: state.equals("0"))


    final int LENGTH = 10;
    int[] no = new int[LENGTH];
    String[] content = new String[LENGTH];
    Date[] endDate = new Date[LENGTH];
    String[] state = new String[LENGTH];
    String[] author = new String[LENGTH];

    int count = 0;

    Scanner keyInput = new Scanner(System.in);

    System.out.println("[작업]");

    for (int i = 0; i < LENGTH; i++) {
      count++;
      System.out.print("번호? ");
      no[i] = keyInput.nextInt();
      keyInput.nextLine();
      System.out.print("내용? ");
      content[i] = keyInput.nextLine();
      System.out.print("마감일? ");
      endDate[i] = Date.valueOf(keyInput.nextLine());
      System.out.print("상태? \n");
      System.out.print("0: 신규 \n");
      System.out.print("1: 진행중 \n");
      System.out.print("2: 완료 \n");
      System.out.print("> ");

      state[i] = keyInput.nextLine();
      switch (state[i]) {
        case "0":
          state[i] = "신규";
          break;
        case "1":
          state[i] = "진행중";
          break;
        case "2":
          state[i] = "완료";
          break;
      }

      System.out.print("담당자? ");
      author[i] = keyInput.nextLine();

      System.out.println();
      System.out.print("계속 입력하시겠습니까? (y/N) ");
      String response = keyInput.nextLine();
      System.out.println();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }
    }

    System.out.println("------------------------------");

    System.out.println("[프로젝트]");

    for (int i = 0; i < count; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          no[i], content[i], endDate[i].toString(), state[i], author[i] );
    }

    keyInput.close();
  }
}