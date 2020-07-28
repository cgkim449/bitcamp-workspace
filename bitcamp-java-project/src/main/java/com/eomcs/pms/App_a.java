package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App_a {

  public static void main(String[] args) {
    
    Scanner keyInput = new Scanner(System.in); // 

    System.out.println("[회원]");
    
    int no1=0, no2=0, no3=0, no4=0, no5=0;
    String name1="", name2="", name3="", name4="", name5="";
    String email1="", email2="", email3="", email4="", email5="";
    String password1="", password2="", password3="", password4="", password5="";
    String photo1="", photo2="", photo3="", photo4="", photo5="";
    String tel1="", tel2="", tel3="", tel4="", tel5="";
    Date now1=null, now2=null, now3=null, now4=null, now5=null;
    long currentMillis1=0;
    int count =1;
    
    // 1번회원 입력
    System.out.print("번호? ");
    no1 = keyInput.nextInt(); 
    keyInput.nextLine(); 
    
    System.out.print("이름? ");
    name1 = keyInput.nextLine(); 
    
    System.out.print("이메일? ");
    email1 = keyInput.nextLine(); 
    
    System.out.print("암호? ");
    password1 = keyInput.nextLine(); 
    
    System.out.print("사진? ");
    photo1 = keyInput.nextLine(); 
    
    System.out.print("전화? ");
    tel1 = keyInput.nextLine(); 
    
    currentMillis1 = System.currentTimeMillis();
    now1 = new Date(currentMillis1);
    System.out.println();
    
    System.out.print("계속 입력하시겠습니까?(y/N)");
    String response = keyInput.nextLine();
    
    if (response.equals("y") || response.equals("Y")){
      count = count+1;
      System.out.print("번호? ");
      no2 = keyInput.nextInt(); 
      keyInput.nextLine(); 
      
      System.out.print("이름? ");
      name2 = keyInput.nextLine(); 
      
      System.out.print("이메일? ");
      email2 = keyInput.nextLine(); 
      
      System.out.print("암호? ");
      password2 = keyInput.nextLine(); 
      
      System.out.print("사진? ");
      photo2 = keyInput.nextLine(); 
      
      System.out.print("전화? ");
      tel2 = keyInput.nextLine(); 
      
      currentMillis1 = System.currentTimeMillis();
      now2 = new Date(currentMillis1);
      System.out.println();
      
      System.out.print("계속 입력하시겠습니까?(y/N)");
      response = keyInput.nextLine();
      
      if(response.equalsIgnoreCase("y")) {
        count = count+1;
        
        // 3번회원 입력
        System.out.print("번호? ");
        no3 = keyInput.nextInt(); 
        keyInput.nextLine(); 
        
        System.out.print("이름? ");
        name3 = keyInput.nextLine(); 
        
        System.out.print("이메일? ");
        email3 = keyInput.nextLine(); 
        
        System.out.print("암호? ");
        password3 = keyInput.nextLine(); 
        
        System.out.print("사진? ");
        photo3 = keyInput.nextLine(); 
        
        System.out.print("전화? ");
        tel3 = keyInput.nextLine(); 
        
        currentMillis1 = System.currentTimeMillis();
        now3 = new Date(currentMillis1);
        System.out.println();
        
        System.out.print("계속 입력하시겠습니까?(y/N)");
        response = keyInput.nextLine();
        
        if(response.equalsIgnoreCase("y")) {
          count++;
          System.out.print("번호? ");
          no4 = keyInput.nextInt(); 
          keyInput.nextLine(); 
          
          System.out.print("이름? ");
          name4 = keyInput.nextLine(); 
          
          System.out.print("이메일? ");
          email4 = keyInput.nextLine(); 
          
          System.out.print("암호? ");
          password4 = keyInput.nextLine(); 
          
          System.out.print("사진? ");
          photo4 = keyInput.nextLine(); 
          
          System.out.print("전화? ");
          tel4 = keyInput.nextLine(); 
          
          currentMillis1 = System.currentTimeMillis();
          now4 = new Date(currentMillis1);
          System.out.println();
          
          System.out.print("계속 입력하시겠습니까?(y/N)");
          response = keyInput.nextLine();
          
          if(response.equalsIgnoreCase("y")) {
            count+=1;
            System.out.print("번호? ");
            no5 = keyInput.nextInt(); 
            keyInput.nextLine(); 
            
            System.out.print("이름? ");
            name5 = keyInput.nextLine(); 
            
            System.out.print("이메일? ");
            email5 = keyInput.nextLine(); 
            
            System.out.print("암호? ");
            password5 = keyInput.nextLine(); 
            
            System.out.print("사진? ");
            photo5 = keyInput.nextLine(); 
            
            System.out.print("전화? ");
            tel5 = keyInput.nextLine(); 
            
            currentMillis1 = System.currentTimeMillis();
            now5 = new Date(currentMillis1);
            System.out.println();
          }
          
        }
        
      }
    }

    
    keyInput.close(); 
    
    System.out.println("-----------------------");
    System.out.printf("%d, %s, %s, %s, %s\n", no1, name1, email1, tel1, now1.toString());
    if(count>1) {
      System.out.printf("%d, %s, %s, %s, %s\n", no2, name2, email2, tel2, now2.toString());
    
      if(count>2) {
        System.out.printf("%d, %s, %s, %s, %s\n", no3, name3, email3, tel3, now3.toString());
     
        if(count>3) {
          System.out.printf("%d, %s, %s, %s, %s\n", no4, name4, email4, tel4, now4.toString());
     
          if(count>4) {
            System.out.printf("%d, %s, %s, %s, %s\n", no5, name5, email5, tel5, now5.toString());
          }
        }
      }
    }
  }
}