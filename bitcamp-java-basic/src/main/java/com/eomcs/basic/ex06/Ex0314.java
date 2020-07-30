package com.eomcs.basic.ex06;
// 반복문 : do 문장 while(조건)
public class Ex0314 {
  public static void main(String[] args) {
    int i = 0;
    do {
      System.out.println(i);
      i++;
    } while (i < 10); // 차이점 : 0번이상 반복, 1번이상 반복
  }
}