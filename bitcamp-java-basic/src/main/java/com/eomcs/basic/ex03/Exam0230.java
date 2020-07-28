// 주제 : 메모리 크기에 따른 표기법
package com.eomcs.basic.ex03;

class Exam0230 {
    public static void main(String[] args) {
        // 자바 정수값을 저장하는 기본 메모리 크기 : 4byte
        System.out.println(2_147_483_648L);
        System.out.println(-2_147_483_649l);

        System.out.println(1); // 4바이트 메모리를 사용하는 1
        System.out.println(1L); // 8바이트 메모리를 사용하는 1

        System.out.println(Integer.MAX_VALUE); //4바이트 정수 최대값
        System.out.println(Integer.MIN_VALUE); //4바이트 정수 최소값
        
        System.out.println(Long.MAX_VALUE); //8바이트 정수 최소값
        System.out.println(Long.MIN_VALUE); //8바이트 정수 최소값
    }
}