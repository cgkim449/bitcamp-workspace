package com.eomcs.pms;

public class App_x {

  public static void main(String[] args) {
    java.util.Scanner keyInput = new java.util.Scanner(System.in);
    
    System.out.print("[회원]\n");
    System.out.print("번호? ");
    String num = keyInput.nextLine();
    System.out.print("이름? ");
    String name = keyInput.nextLine();
    System.out.print("이메일? ");
    String email = keyInput.nextLine();
    System.out.print("암호? ");
    String pw = keyInput.nextLine();
    System.out.print("사진? ");
    String pic = keyInput.nextLine();
    System.out.print("전화? ");
    String tell = keyInput.nextLine();
    
    keyInput.close();
    
    long currentMillis=System.currentTimeMillis(); // System. () 하면 뭔가 있구나
    
    java.sql.Date now = new java.sql.Date(currentMillis); // 그렇구나
    
    
    System.out.println("---------------");
    
    System.out.printf("번호: %s\n", num);
    System.out.printf("이름: %s\n", name);
    System.out.printf("이메일: %s\n", email);
    System.out.printf("암호: %s\n", pw);
    System.out.printf("사진: %s\n", pic);
    System.out.printf("전화: %s\n", tell);
    System.out.printf("가입일: %s\n", now);
    
  }
}