package com.eomcs.pms;

import java.util.Scanner;
import java.sql.Date;

public class App_u3 {
  public static void main(String[] args) {
    
    Scanner keyInput = new Scanner(System.in);
    
    int[] no = new int[3];
    String[] name = new String[3];
    String[] email = new String[3];
    String[] tel = new String[3];
    Date[] now = new Date[3];
    long currentMillis;
    int count=0;    dd q  q
    
    for(int i=0; i<3; i++) {
      count++;
      
      System.out.print("번호? ");
      no[i] = keyInput.nextInt();
      keyInput.nextLine();
      System.out.print("이름? ");
      name[i] = keyInput.nextLine();
      System.out.print("이메일? ");
      email[i] = keyInput.nextLine();
      System.out.print("전화번호? ");
      tel[i] = keyInput.nextLine();
      
      currentMillis = System.currentTimeMillis();
      now[i] = new Date(currentMillis);
      
      System.out.println("계속 입력하시겠습니까? y/N");
      String response = keyInput.nextLine();
      if(response.equalsIgnoreCase("y")==false) {
        break;
      }
    }
    keyInput.close();
      
      for(int i=0; i<count; i++) {
        System.out.printf("%d %s %s %s %s", no[i], name[i], email[i], tel[i], now[i].toString());
      
    }
    
    
    
  }
}