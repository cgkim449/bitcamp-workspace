package com.eomcs.basic.ex05.assignment;


//# 과제1 : 4바이트 정수값을 입력받은 후에 
// 다음과 같이 첫 바이트부터 끝 바이트까지 순서대로 출력하라
//실행 예)
//aa
//bb
//cc
//dd
//
import java.util.Scanner;

public class Test03_1{
  public static void main(String[] args) {
    
    int value = 0xaabbccdd;
    int a = value >>> 24;
    int b = (value >>> 16) & 0xff;
    int c = (value >>> 8) & 0xff;
    int d = value & 0xff;
    
    System.out.println(Integer.toHexString(a));
    System.out.println(Integer.toHexString(b));
    System.out.println(Integer.toHexString(c));
    System.out.println(Integer.toHexString(d));
  }
}
