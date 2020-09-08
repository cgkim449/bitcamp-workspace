// 문법 정리 - 레퍼런스와 인스턴스 생성
// <?> : 제네릭 검사가 필요한 코드를 컴파일 할 수 없다, 예를들어 get()같은 조회용 메서드를 쓸때나 쓰는 것
package com.eomcs.generic.ex01;

import java.util.ArrayList;

public class Exam0211 {
  public static void main(String[] args) {
    ArrayList list1;
    list1 = new ArrayList();
    list1 = new ArrayList<>();
    list1 = new ArrayList<Object>();
    list1 = new ArrayList<String>();
    list1 = new ArrayList<Member>();
    
    list1.add(new String());
    
    // ArrayList가 다루는 타입에 상관없이 ArrayList 레퍼런스를 선언하고 싶다면,
    // list1 처럼 선언하지 말고 다음과 같이 명확하게 <?> 를 붙여라!
    ArrayList<?> list2; 
    list2 = new ArrayList(); // 이렇게 사용하지 말고, 명확히 제네릭의 타입을 지정하라.
    list2 = new ArrayList<>();
    list2 = new ArrayList<Object>();
    list2 = new ArrayList<String>();
    list2 = new ArrayList<Member>();
    
    //=> 단 이 경우에는 제네릭의 타입이 명확하게 선언되어 있지 않기 때문에
    //   제네릭 검사가 필요한 코드를 컴파일 할 수 없다.
    //list2.add(new String()); // 컴파일 오류!
    //list2.add(new Integer(100)); // 컴파일 오류!
    //list2.add(new java.util.Date()); // 컴파일 오류!
    //list2.add(new Member("홍길동", 20)); // 컴파일 오류!
  }
}
