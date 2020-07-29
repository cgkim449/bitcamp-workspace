package com.eomcs.pms;

import java.util.Scanner;

public class App_test {
  
  public static void main(String[] args) {
    
    Scanner keyScan = new Scanner(System.in);
    
    System.out.print("나이가? ");
    int age = keyScan.nextInt();
    
    if (age < 8)
      System.out.println("아동입니다");
    else if (age < 19)
      System.out.println("미성년자입니다");
    else if (age < 65)
      System.out.println("성인입니다");
    else
      System.out.println("노인입니다");
    
    
    keyScan.close();
  }
}