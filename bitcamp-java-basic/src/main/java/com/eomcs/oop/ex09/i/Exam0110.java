//프로그래밍을 하다가 인터페이스가 등장하면 바로 caller callee 파악!!!!!!!!
// 이거만 해도 인터페이스 80퍼는 먹고들어감
// 주로 calleer 만드는 입장이 60퍼
// 스프링에서 맨날 이거함

// caller를 만드는 입장
package com.eomcs.oop.ex09.i;

import java.util.ArrayList;
import java.util.Iterator;

public class Exam0110 {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();

    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");

    // ArrayList의 iterator()는 이 Iterator을 구현한 클래스의 객체를 만들어 리턴한다
    Iterator<String> iterator = list.iterator();

    // 인터페이스를 기준으로 한 개발자 입장 :
    // => 인터페이스 호출 규칙에 따라 객체를 사용한다
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

  }
}
