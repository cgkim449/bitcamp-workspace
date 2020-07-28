package com.eomcs.basic.ex03;
// 주제 : 부동소수점을 저장하는 메모리의 크기
class Exam0320 /*클래스 선언*/
{ // 클래스 정의
    public static void main(String[] args) /*메서드 선언*/
    { // 메서드 선언
        // 정수는 기본이 4바이트
        // 실수는 기본이 8바이트    
        System.out.println(3.14D);
        System.out.println(3.14d);
        System.out.println(3.14f);
        System.out.println(3.14F);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);

    }
}
//- 자바는 부동소수점을 저장할 때 전기전자기술자협회(IEEE)에서 
//  개발한 IEEE 754 명세에 따라 2진수로 변환한다.
