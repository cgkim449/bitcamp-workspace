package com.eomcs.basic.ex05.assignment;


//# 과제1 : 4바이트 정수값을 입력받은 후에 
// 다음과 같이 첫 바이트부터 끝 바이트까지 순서대로 출력하라
//실행 예)
//aa
//bb
//cc
//dd
//

public class Test03 {
  public static void main(String[] args) {
        
    int value=0xaabbccdd;
    
    System.out.println(Integer.toHexString(value >>> 24));
    System.out.println(Integer.toHexString((value >>> 16)&0xff));
    System.out.println(Integer.toHexString((value >>> 8)&0xff));
    System.out.println(Integer.toHexString(value&0xff));
    
  }
}