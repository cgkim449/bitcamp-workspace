package com.eomcs.pms;

import java.util.Scanner;
import java.sql.Date;

public class App_u2 {

  public static void main(String[] args) {
    
    int[] no = new int[3];
    String[] name = new String[3];
    String[] email = new String[3];
    String[] pw = new String[3];
    String[] pic = new String[3];
    String[] tel = new String[3];
    Date[] now = new Date[3];
    
    
    long currentMillis=0;
    
    Scanner keyInput = new Scanner(System.in);
    
    System.out.println("[회원]");
    
    for(int i=0; i<3; i++) {
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
      pic[i] = keyInput.nextLine();
      
      System.out.print("전화? ");
      tel[i] = keyInput.nextLine();
      
      currentMillis = System.currentTimeMillis();
      now[i] = new Date(currentMillis);
      
      System.out.println();
      System.out.print("계속 입력하시겠습니까? y/N");
      String yesOrNo = keyInput.nextLine();
      if(yesOrNo.equalsIgnoreCase("y")==false) {
        break;
      }
      
    }
    
    keyInput.close();
    
    for(int i=0; i<3; i++) {
      System.out.printf("%d %s %s %s %s\n", 
          no[i], name[i], email[i], tel[i], now[i].toString());
    }
    
  }
}