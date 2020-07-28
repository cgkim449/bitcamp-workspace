package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App_e {

  public static void main(String[] args) {
    
    Scanner keyInput = new Scanner(System.in);
    
    final int MAX_LENGTH = 3;
    int[] no = new int[MAX_LENGTH];
    String[] name = new String[MAX_LENGTH];
    String[] email = new String[MAX_LENGTH];
    String[] pw = new String[MAX_LENGTH];
    String[] photo = new String[MAX_LENGTH];
    String[] tel = new String[MAX_LENGTH];
    Date[] now = new Date[MAX_LENGTH];
    
    long currentMillis = System.currentTimeMillis();
    int count = 0;
    
    System.out.print("[회원]");
    
    for(int i = 0; i < MAX_LENGTH; i++ ) {
      count++;
      System.out.println();
      System.out.print("번호? ");
      no[i] = keyInput.nextInt();
      keyInput.nextLine();
      
      System.out.print("이름? ");
      name[i] = keyInput.nextLine();
      System.out.print("이메일? ");
      email[i] = keyInput.nextLine();
      System.out.print("암호? ");
      pw[i] = keyInput.nextLine();
      System.out.print("사진? ");
      photo[i] = keyInput.nextLine();
      System.out.print("전화? ");
      tel[i] = keyInput.nextLine();
      
      now[i] = new Date(currentMillis);
      System.out.println();
      System.out.print("계속 입력하시겠습니까?(y/N)");
      
      String response = keyInput.nextLine();
      
      if (response.equalsIgnoreCase("y")==false) {
        break;
      }
    }
    keyInput.close();
    
    System.out.println("------------------");
    for(int i=0;i<count;i++) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          no[i], name[i], email[i], tel[i], now[i].toString());
    }
  }
}
