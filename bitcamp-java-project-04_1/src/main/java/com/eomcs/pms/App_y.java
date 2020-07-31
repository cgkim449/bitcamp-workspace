package com.eomcs.pms;

import java.sql.Date;

public class App_y {

  public static void main(String[] args) {
    java.util.Scanner keyInput = new java.util.Scanner(System.in);
    System.out.print("[프로젝트]\n");
    System.out.print("번호? ");
    int num = keyInput.nextInt(); // CR, LF 못읽음
    keyInput.nextLine(); // CR, LF 읽음
    System.out.print("프로젝트명? ");
    String title = keyInput.nextLine();
    System.out.print("내용? ");
    String content = keyInput.nextLine();
    
    System.out.print("시작일? ");
    java.sql.Date startDate = java.sql.Date.valueOf(keyInput.nextLine());
    // 나중에 하자
    
    System.out.print("종료일? ");
    java.sql.Date endDate = java.sql.Date.valueOf(keyInput.nextLine());
    
    System.out.print("만든이? ");
    String author = keyInput.nextLine();
    System.out.print("팀원? ");
    String teammates = keyInput.nextLine();
    System.out.print("--------------");
    
    keyInput.close(); // 이거 안해도 딱히 상관업는건가
    
    System.out.printf("번호: %d\n", num);
    System.out.printf("프로젝트명: %s\n", title);
    System.out.printf("내용: %s\n", content);
    System.out.printf("시작일: %s\n", startDate);
    System.out.printf("종료일: %s\n", endDate);
    System.out.printf("만든이: %s\n", author);
    System.out.printf("팀원: %s\n", teammates);
  
  }
}