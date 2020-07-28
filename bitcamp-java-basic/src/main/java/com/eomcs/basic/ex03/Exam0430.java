package com.eomcs.basic.ex03;

public class Exam0430 //클래스 선언 
{ // 클래스 정의
    public static void main(String[] args) /*메서드 선언*/
    { // 메서드 정의
        System.out.println(0x0041);
        System.out.println(0x41);
        System.out.println(0x0041);
        System.out.println('\u0041');
        System.out.println((char)0x0041);
        System.out.println('A');
        System.out.println((int)'A');
        
        System.out.println('A'+1);
        
        System.out.println((char)('A'+1));
        System.out.println("-------------------");
        for (int i='A'; i<'z';i++) {
          System.out.println((char)i);
        }
    }
}
