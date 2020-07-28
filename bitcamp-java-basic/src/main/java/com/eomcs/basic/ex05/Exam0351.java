package com.eomcs.basic.ex05;

//# 비트 연산자 & 를 이용하여 % 연산 구현하기
//
public class Exam0351 {
  public static void main(String[] args) {
    
    
    System.out.println(57 % 2);
    System.out.println(57 & 0b1);
    // %연산은 나누기 연산을 수행해야 한다
    // 나누기연산은 여러번의 계산을 수행하게 된다
    // 그에 비해 & 비트연산은 한번만하면 된다
    // 결론 : 
    // - 짝수인지 홀수인지 알아내거나 
    // - 2의나머지를 구하고 싶다면 &비트연산을 수행하는것이 빠르다
    // 
    // 어떤 값에 대해 2로 나눈 나머지 값을 구하고 싶다면,
    // & 연산자를 이용하여 그 값의 하위 1비트 값만 추출하면 된다. 
    
    System.out.println(57 % 4);
    System.out.println(57 & 0b11);
    // 어떤 값에 대해 4로 나눈 나머지 값을 구하고 싶다면,
    // & 연산자를 이용하여 그 값의 하위 2비트 값만 추출하면 된다.
    // 주의!
    // - 나누는 값이 2의 제곱수여야한다
    // - 계산속도가 빠르다
    // 권고
    // - 너무 고민 말고 그냥 퍼센트 써라
    
    
    System.out.println(57 % 8);
    System.out.println(57 & 0b111);
    
    System.out.println(57 % 16);
    System.out.println(57 & 0b1111);
    
  }
}

