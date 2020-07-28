package com.eomcs.pms;

import java.sql.Date;

public class App_u {

  public static void main(String[] args) {
    
    java.util.Scanner keyInput = new java.util.Scanner(System.in);
    
    int[] num = new int[3];
    String[] name = new String[3];
    String[] email = new String[3];
    String[] pw = new String[3];
    String[] pic = new String[3];
    String[] tel = new String[3];

    Date now[] = new Date[3];
    long currentMillis = System.currentTimeMillis();
    
    String[] yesOrNo = {"1","1","1"};
    
    System.out.print("[회원]\n");
    
    
    int count= 0;
    
    for(int i = 0; yesOrNo[i].equals("N"); i++) { 
      
      
      System.out.print("번호? ");
      num[i] = keyInput.nextInt();
      keyInput.nextLine();
      System.out.print("이름? ");
      name[i] = keyInput.nextLine();
      System.out.print("이메일? ");
      email[i] = keyInput.nextLine();
      System.out.print("암호? ");
      pw[i] = keyInput.nextLine();
      System.out.print("사진? ");
      pic[i] = keyInput.nextLine();
      System.out.print("전화? ");
      tel[i] = keyInput.nextLine();
      
      currentMillis = System.currentTimeMillis();
      
      System.out.print("계속 입력하시겠습니까?(y/N) \n");
      yesOrNo[i] = keyInput.nextLine();
      
      count++;
    }
    
    keyInput.close();
    System.out.print("-------------------------- \n");
    
      
      System.out.printf("%d, %s, %s, %s \n", 
          num[0], name[0], email[0], tel[0]);
  }
    
}