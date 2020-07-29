package com.eomcs.basic.ex05.assignment;

import java.util.Scanner;

//# 과제1 : 입력 받은 두 정수 사이의 합계를 구하라.
//실행 예)
//입력? 2 5
//2에서 5까지의 합은 14입니다.
//
public class Test01_1 {

  public static void main(String[] args) {
    java.util.Scanner keyInput = new java.util.Scanner(System.in);
    
    System.out.print("입력? ");
    int a = keyInput.nextInt();
    keyInput.nextLine();
    
    int b = keyInput.nextInt();
    keyInput.nextLine();
    
    keyInput.close();
    
    int sum =a;
    for(int i=a+1;i<=b;i++) {
      sum+=i;
    }
    
    System.out.printf("%d에서 %d까지의 합은 %d입니다", a,b,sum);
  }
}








