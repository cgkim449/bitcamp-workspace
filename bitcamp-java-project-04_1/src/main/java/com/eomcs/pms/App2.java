package com.eomcs.pms;

public class App2 {

  public static void main(String[] args) {
    java.util.Scanner keyInput = new java.util.Scanner(System.in);
    System.out.print("[");
    System.out.print("프로젝트");
    System.out.println("]");

    System.out.print("번호? ");
    int no = keyInput.nextInt();
    keyInput.nextLine();
    
    System.out.print("프로젝트명? ");
    String project = keyInput.nextLine();

    System.out.print("내용? ");
    String content = keyInput.nextLine();

    System.out.print("시작일? " );
    java.sql.Date start = java.sql.Date.valueOf(keyInput.nextLine());

    System.out.print("종료일? " );
    java.sql.Date end = java.sql.Date.valueOf(keyInput.nextLine());

    System.out.print("만든이? " );
    String who = keyInput.nextLine();
    
    System.out.print("팀원? ");
    String team = keyInput.nextLine();
    keyInput.close(); 
    System.out.println("-----------------------");
    System.out.println("번호: " + no);
    System.out.printf("프로젝트명: %s\n", project);
    System.out.printf("내용: %s\n", content);
    System.out.printf("시작일: %s\n", start);
    System.out.printf("종료일: %s\n", end);
    System.out.printf("만든이: %s\n", who);
    System.out.printf("팀원: %s\n", team);
  }
}
