package com.eomcs.pms;


public class App_z {

  public static void main(String[] args) {
    
    java.util.Scanner keyInput = new java.util.Scanner(System.in);
    
    System.out.print("[작업]\n");
    System.out.print("프로젝트? ");
    String title = keyInput.nextLine();
    System.out.print("번호? ");
    int num = keyInput.nextInt();
    keyInput.nextLine();
    System.out.print("내용? ");
    String content = keyInput.nextLine();
    System.out.print("완료일? ");
    java.sql.Date endDate  = java.sql.Date.valueOf(keyInput.nextLine());
    System.out.print("상태? \n");
    System.out.print("0: 신규 \n");
    System.out.print("1: 진행중 \n");
    System.out.print("2: 완료 \n");
    System.out.print("> ");
    String status = keyInput.nextLine();
    System.out.print("담당자? ");
    String manager = keyInput.nextLine();
    System.out.print("-------------------------\n");

    keyInput.close();
    
    System.out.printf("프로젝트: %s\n", title);
    System.out.printf("번호: %d\n",num);
    System.out.printf("내용: %s\n", content);
    System.out.printf("완료일: %s\n", endDate);
    if (status.equals("0")) {
      System.out.printf("상태: 신규\n");
      }
    else if (status.equals("1")) {
      System.out.printf("상태: 진행중\n");
    }
    else  {
      System.out.printf("상태: 완료\n");
    }
    System.out.printf("담당자: %s\n", manager);
  }
}