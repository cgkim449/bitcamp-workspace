package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App_e {

  public static void main(String[] args) {
    
    Scanner keyInput = new Scanner(System.in); // 

    System.out.println("[회원]");
    
    final int MAX_LENGTH=5;
    int[] no = new int[MAX_LENGTH]; // 초기화할 필요도 없다!
    String[] name=new String[MAX_LENGTH];
    String[] email=new String[MAX_LENGTH];
    String[] password=new String[MAX_LENGTH];
    String[] photo=new String[MAX_LENGTH];
    String[] tel=new String[MAX_LENGTH];
    Date[] now=new Date[MAX_LENGTH];
    
    long currentMillis1=0;
    int count =0;
    
    
    for(int i =0; i<MAX_LENGTH; i++) {
      count++;
      System.out.print("번호? ");
      no[i] = keyInput.nextInt(); 
      keyInput.nextLine(); 
      
      System.out.print("이름? ");
      name[i] = keyInput.nextLine(); 
      
      System.out.print("이메일? ");
      email[i] = keyInput.nextLine(); 
      
      System.out.print("암호? ");
      password[i] = keyInput.nextLine(); 
      
      System.out.print("사진? ");
      photo[i] = keyInput.nextLine(); 
      
      System.out.print("전화? ");
      tel[i] = keyInput.nextLine(); 
      
      currentMillis1 = System.currentTimeMillis();
      now[i] = new Date(currentMillis1);
      System.out.println();
      
      System.out.print("계속 입력하시겠습니까?(y/N)");
      String response = keyInput.nextLine();
      
      if (response.equalsIgnoreCase("y")==false) {
        break; // 반복문을 멈춰라
      }
    }
       
    keyInput.close(); 
    
    System.out.println("-----------------------");
    for (int i=0; i<count; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          no[i], name[i], email[i], tel[i], now[i].toString());
    }
  }
}