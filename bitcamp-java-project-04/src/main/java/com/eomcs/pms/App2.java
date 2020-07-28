package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
    
    Scanner keyInput = new Scanner(System.in);
    
    final int MAX_LENGTH=3;
    int[] no = new int[MAX_LENGTH];
    String[] title = new String[MAX_LENGTH];
    String[] content = new String[MAX_LENGTH];
    
    Date[] startDate = new Date[MAX_LENGTH];
    Date[] endDate = new Date[MAX_LENGTH];
    
    String[] author = new String[MAX_LENGTH];
    String[] teammates = new String[MAX_LENGTH];
    
    int count = 0;
    
    System.out.println("[프로젝트]");
    
    for(int i = 0; i < MAX_LENGTH; i++ ) {
      count++;
      System.out.println();
      System.out.print("번호? ");
      no[i] = keyInput.nextInt();
      keyInput.nextLine();
      
      System.out.print("프로젝트명? ");
      title[i] = keyInput.nextLine();
      System.out.print("내용? ");
      content[i] = keyInput.nextLine();
      
      System.out.print("시작일? ");
      startDate[i] = Date.valueOf(keyInput.nextLine());
      System.out.print("종료일? ");
      endDate[i] = Date.valueOf(keyInput.nextLine());
      
      System.out.print("만든이? ");
      author[i] = keyInput.nextLine();
      
      System.out.print("팀원? ");
      teammates[i] = keyInput.nextLine();
      
      System.out.println();
      System.out.print("계속 입력하시겠습니까?(y/N)");
      
      String response = keyInput.nextLine();
      
      if (response.equalsIgnoreCase("y")==false) {
        break;
      }
    }
    System.out.println("-----------------------");
    keyInput.close();
    for(int i=0;i<count;i++) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          no[i], title[i], startDate[i].toString(), endDate[i].toString(), author[i]);
    }
  }
}
