package com.eomcs.basic.ex07;

public class Exam0415 {
  public static void main(String[] args) {
   int result = 1;
   int n = 5;

   for(int i = 2; i <= n; i++) {
     result *= i;
   }

   System.out.println(result);
   System.out.println("------------------");

   result = factorial(5);

   System.out.println(result);
  }

  static int factorial(int n) {
    // 장점 : 재귀호출만큼 직관성, 가독성있는 게 없음, 여러 수학공식을 구현할 수 있음
    // 단점 : 스택이 너무 많아서 실행속도가 너무 느려짐
    return n*factorial(n-1);
  }
}
