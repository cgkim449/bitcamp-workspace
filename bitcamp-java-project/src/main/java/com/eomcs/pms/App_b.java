package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App_b {

  public static void main(String[] args) {
    
    Scanner keyInput = new Scanner(System.in); // 

    System.out.println("[회원]");
    
    int[] no = new int[5]; // 초기화할 필요도 없다!
    String[] name=new String[5];
    String[] email=new String[5];
    String[] password=new String[5];
    String[] photo=new String[5];
    String[] tel=new String[5];
    Date[] now=new Date[5];
    
    long currentMillis1=0;
    int count =1;
    
    // 1번회원 입력
    System.out.print("번호? ");
    no[0] = keyInput.nextInt(); 
    keyInput.nextLine(); 
    
    System.out.print("이름? ");
    name[0] = keyInput.nextLine(); 
    
    System.out.print("이메일? ");
    email[0] = keyInput.nextLine(); 
    
    System.out.print("암호? ");
    password[0] = keyInput.nextLine(); 
    
    System.out.print("사진? ");
    photo[0] = keyInput.nextLine(); 
    
    System.out.print("전화? ");
    tel[0] = keyInput.nextLine(); 
    
    currentMillis1 = System.currentTimeMillis();
    now[0] = new Date(currentMillis1);
    System.out.println();
    
    System.out.print("계속 입력하시겠습니까?(y/N)");
    String response = keyInput.nextLine();
    
    if (response.equals("y") || response.equals("Y")){
      count = count+1;
      System.out.print("번호? ");
      no[1] = keyInput.nextInt(); 
      keyInput.nextLine(); 
      
      System.out.print("이름? ");
      name[1] = keyInput.nextLine(); 
      
      System.out.print("이메일? ");
      email[1] = keyInput.nextLine(); 
      
      System.out.print("암호? ");
      password[1] = keyInput.nextLine(); 
      
      System.out.print("사진? ");
      photo[1] = keyInput.nextLine(); 
      
      System.out.print("전화? ");
      tel[1] = keyInput.nextLine(); 
      
      currentMillis1 = System.currentTimeMillis();
      now[1] = new Date(currentMillis1);
      System.out.println();
      
      System.out.print("계속 입력하시겠습니까?(y/N)");
      response = keyInput.nextLine();
      
      if(response.equalsIgnoreCase("y")) {
        count = count+1;
        
        // 3번회원 입력
        System.out.print("번호? ");
        no[2] = keyInput.nextInt(); 
        keyInput.nextLine(); 
        
        System.out.print("이름? ");
        name[2] = keyInput.nextLine(); 
        
        System.out.print("이메일? ");
        email[2] = keyInput.nextLine(); 
        
        System.out.print("암호? ");
        password[2] = keyInput.nextLine(); 
        
        System.out.print("사진? ");
        photo[2] = keyInput.nextLine(); 
        
        System.out.print("전화? ");
        tel[2] = keyInput.nextLine(); 
        
        currentMillis1 = System.currentTimeMillis();
        now[2] = new Date(currentMillis1);
        System.out.println();
        
        System.out.print("계속 입력하시겠습니까?(y/N)");
        response = keyInput.nextLine();
        
        if(response.equalsIgnoreCase("y")) {
          count++;
          System.out.print("번호? ");
          no[3] = keyInput.nextInt(); 
          keyInput.nextLine(); 
          
          System.out.print("이름? ");
          name[3] = keyInput.nextLine(); 
          
          System.out.print("이메일? ");
          email[3] = keyInput.nextLine(); 
          
          System.out.print("암호? ");
          password[3] = keyInput.nextLine(); 
          
          System.out.print("사진? ");
          photo[3] = keyInput.nextLine(); 
          
          System.out.print("전화? ");
          tel[3] = keyInput.nextLine(); 
          
          currentMillis1 = System.currentTimeMillis();
          now[3] = new Date(currentMillis1);
          System.out.println();
          
          System.out.print("계속 입력하시겠습니까?(y/N)");
          response = keyInput.nextLine();
          
          if(response.equalsIgnoreCase("y")) {
            count+=1;
            System.out.print("번호? ");
            no[4] = keyInput.nextInt(); 
            keyInput.nextLine(); 
            
            System.out.print("이름? ");
            name[4] = keyInput.nextLine(); 
            
            System.out.print("이메일? ");
            email[4] = keyInput.nextLine(); 
            
            System.out.print("암호? ");
            password[4] = keyInput.nextLine(); 
            
            System.out.print("사진? ");
            photo[4] = keyInput.nextLine(); 
            
            System.out.print("전화? ");
            tel[4] = keyInput.nextLine(); 
            
            currentMillis1 = System.currentTimeMillis();
            now[4] = new Date(currentMillis1);
            System.out.println();
          }
          
        }
        
      }
    }

    
    keyInput.close(); 
    
    System.out.println("-----------------------");
    System.out.printf("%d, %s, %s, %s, %s\n", no[0], name[0], email[0], tel[0], now[0].toString());
    if(count>1) {
      System.out.printf("%d, %s, %s, %s, %s\n", no[1], name[1], email[1], tel[1], now[1].toString());
    
      if(count>2) {
        System.out.printf("%d, %s, %s, %s, %s\n", no[2], name[2], email[2], tel[2], now[2].toString());
     
        if(count>3) {
          System.out.printf("%d, %s, %s, %s, %s\n", no[3], name[3], email[3], tel[3], now[3].toString());
     
          if(count>4) {
            System.out.printf("%d, %s, %s, %s, %s\n", no[4], name[4], email[4], tel[4], now[4].toString());
          }
        }
      }
    }
  }
}