// ArrayList!
// 1. 인덱스 개수가 가변적이다
// 2. 인덱스 지정해서 출력할수있는지는 아직 모르겟다
// 3. 제네릭까지 있음

//# for (:)
//- 배열 전체를 반복하거나 컬렉션(collection) 객체 전체를 반복할 때 유용한다.
//- 배열의 일부만 반복할 수 없다.
//- 배열의 값을 다룰 때 인덱스를 사용할 필요가 없어 편리하다.
//
//문법:
//for (변수 선언 : 배열, Iterable 구현체) 문장1;
//for (변수 선언 : 배열, Iterable 구현체) { 문장1; 문장2; ...}
//- 변수의 타입은 배열이나 Iterable 구현체의 항목 타입과 같아야 한다.
//- 반복문을 돌 때 마다 항목을 값을 꺼내 변수에 담는다.

package com.eomcs.basic.ex06;
import java.util.ArrayList;

public class for_ArrayList_ex {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add("홍길동");
    list.add(3.14f);
    list.add(true);
    list.add(365);

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }

    System.out.println("---------------------------------");

    for (Object value : list) {
      System.out.println(value);
    }

    System.out.println("---------------------------------");

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("a");
    stringList.add("b");
    stringList.add("c");

    for (Object value : stringList) {
      System.out.println(value);
    }

    System.out.println("---------------------------------");

    for (String value : stringList) {
      System.out.println(value);
    }
  }
}