package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App_g {
  
  static class Member{
    int no;
    String name;
    String email;
    String password;
    String photo;
    String tel;
    Date now;
  }
  static int count =0;
  final static int MAX_LENGTH=5;
  static Member[] members = new Member[MAX_LENGTH]; 

  public static void main(String[] args) {
    

    System.out.println("[회원]");
    
    inputMembers(); 
    
    System.out.println("-----------------------");
    
    printMembers();
    
  }
  
  static void inputMembers() {
    Scanner keyInput = new Scanner(System.in); // 
    long currentMillis1=0;
    
    for(int i =0; i<MAX_LENGTH; i++) {
      count++;
      Member m =new Member();
      
      System.out.print("번호? ");
      m.no = keyInput.nextInt(); 
      keyInput.nextLine(); 
      
      System.out.print("이름? ");
      m.name = keyInput.nextLine(); 
      
      System.out.print("이메일? ");
      m.email = keyInput.nextLine(); 
      
      System.out.print("암호? ");
      m.password = keyInput.nextLine(); 
      
      System.out.print("사진? ");
      m.photo = keyInput.nextLine(); 
      
      System.out.print("전화? ");
      m.tel = keyInput.nextLine(); 
      
      currentMillis1 = System.currentTimeMillis();
      m.now = new Date(currentMillis1);
      System.out.println();
      
      members[i]=m;
      
      System.out.print("계속 입력하시겠습니까?(y/N)");
      String response = keyInput.nextLine();
      
      if (response.equalsIgnoreCase("y")==false) {
        break; // 반복문을 멈춰라
      }
    }
    
    keyInput.close(); 
  }
  
  static void printMembers() {
    
    for (int i=0; i<count; i++) {
      Member m = members[i];
      System.out.printf("%d, %s, %s, %s, %s\n", 
          m.no, m.name, m.email, m.tel, m.now.toString());
    }
    
  }
  
}