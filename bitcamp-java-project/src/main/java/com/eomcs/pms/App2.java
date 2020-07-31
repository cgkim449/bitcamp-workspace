package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {

    class Project {
      int no;
      String title;
      String content;
      Date startDate;
      Date completedDate;
      String worker;
      String teammates;
    }
    Scanner keyScan = new Scanner(System.in);
    final int LENGTH = 100;
    int count = 0;

    Project[] projects = new Project[LENGTH];

    for (int i = 0; i < LENGTH; i++) {

      count++;
      Project p = new Project();

      System.out.print("번호? ");
      p.no = keyScan.nextInt();
      keyScan.nextLine();
      System.out.print("프로젝트명? ");
      p.title = keyScan.nextLine();
      System.out.print("내용? ");
      p.content = keyScan.nextLine();
      System.out.print("시작일? ");
      p.startDate = Date.valueOf(keyScan.nextLine());
      System.out.print("마감일? ");
      p.completedDate = Date.valueOf(keyScan.nextLine());
      System.out.print("소유자? ");
      p.worker = keyScan.nextLine();
      System.out.print("팀원? ");
      p.teammates = keyScan.nextLine();

      projects[i] = p;

      System.out.print("계속 입력하시겠습니까? (y/N)\n");
      String response = keyScan.nextLine();
      if(!response.equalsIgnoreCase("y")) {
        break;
      }
    }
    System.out.println();

    for (int i = 0; i < count; i++) {
      Project p = projects[i];
      System.out.printf("%d %s %s %s %s \n",
          p.no, p.title, p.content, p.completedDate.toString(), p.worker);
    }


    keyScan.close();
  }
}