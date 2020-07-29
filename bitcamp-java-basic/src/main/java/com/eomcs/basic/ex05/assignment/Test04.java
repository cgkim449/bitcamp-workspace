package com.eomcs.basic.ex05.assignment;


//# 과제1 : 4바이트 정수값을 입력받은 후에 
// 다음 int변수에 들어 있는 값을
// 각 자릿수의 10진수 값을 역순으로 출력하라
// 실행 예)
// 값 : 23459876
// 6
// 7
// 8
// 9
// 5
// 4
// 3
// 2
import java.util.Scanner;

public class Test04 {
  public static void main(String[] args) {
    
    Scanner keyInput = new Scanner(System.in);
    
    System.out.print("값 : ");
    int value = keyInput.nextInt();
    keyInput.nextLine();
    keyInput.close();

    while(value>0) {
      
      System.out.println(value%10);
      value /=10;
      
    }
  }
}
