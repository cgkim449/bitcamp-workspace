package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {
    
    Scanner keyInput = new Scanner(System.in);
    
    String project;
    
    final int MAX_LENGTH =3;
    int[] no = new int[MAX_LENGTH];
    String[] content = new String[MAX_LENGTH];
    Date[] endDate = new Date[MAX_LENGTH];
    String[] status = new String[MAX_LENGTH];
    String[] manager = new String[MAX_LENGTH];
    
    int count = 0;

    System.out.print("[작업]\n");
    System.out.print("프로젝트? ");
    project = keyInput.nextLine();
    
    for(int i = 0; i < MAX_LENGTH; i++ ) {
      count++;
      System.out.println();
      System.out.print("번호? ");
      no[i] = keyInput.nextInt();
      keyInput.nextLine();
      
      System.out.print("내용? ");
      content[i] = keyInput.nextLine();
      
      System.out.print("마감일? ");
      endDate[i] = Date.valueOf(keyInput.nextLine());
      
      System.out.print("상태? \n");
      System.out.print("0: 신규 \n");
      System.out.print("1: 진행중 \n");
      System.out.print("2: 완료 \n");
      System.out.print(">");
      status[i] = keyInput.nextLine();
      
      switch(status[i]) {
        case "0" :
          status[i] = "신규";
          break;
        case "1" :
          status[i] = "진행중";
          break;
        default:
          status[i] = "완료";
      }
//      if(status[i].equals("0")==true) {
//        status[i]= "신규";
//      } else if(status[i].equals("1")==true) {
//        status[i]= "진행중";
//      } else {
//        status[i]= "완료";
//      }
//      
      System.out.print("담당자? ");
      manager[i] = keyInput.nextLine();
      
      System.out.println();
      System.out.print("계속 입력하시겠습니까?(y/N) ");
      String response = keyInput.nextLine();
      
      if (response.equalsIgnoreCase("y")==false) {
        break;
      }
    }
        
    keyInput.close();
    System.out.println("--------------------------");
    System.out.printf("[%s]\n", project);
    
    for(int i=0;i<count;i++) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          no[i], content[i], endDate[i].toString(), status[i], manager[i]);
    }
  }
}
