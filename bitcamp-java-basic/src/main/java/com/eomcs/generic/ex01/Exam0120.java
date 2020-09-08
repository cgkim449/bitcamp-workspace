// 제네릭 특징
// 1 넣을 때 타입을 제한할 수 있다
// 2 꺼낼 때 (조회할때) 형변환을 안해도 된다(제네릭을 지정하면 그와 관련된 메서드의 타입 정보가 자동으로 바뀌기 때문이다?)
// (메서드보면 리턴타입이 E로 되있다는 당연한 얘기)
package com.eomcs.generic.ex01;

import java.util.ArrayList;

public class Exam0120 {
  public static void main(String[] args) {
    ArrayList<Member> list = new ArrayList<Member>();
    list.add(new Member("홍길동", 20));
    
    Member member = list.get(0);
    System.out.println(member.name);
    System.out.println(member.age);
  }
}
