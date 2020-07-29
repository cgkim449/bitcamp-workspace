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

public class Test04_1 {
  public static void main(String[] args) {
    int value = 23_459_876;
    
    int a=10;
    int b=1;
    
    for(int i=0; i<8; i++) {
    
      System.out.println(value%a/b);
      
      a*=10;
      b*=10;
    }
    
////    while (value > 0) {
//      System.out.println(value%10);
//      value = value /10;
//    }
  }
}
