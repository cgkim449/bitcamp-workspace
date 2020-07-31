package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;


public class App {

  public static void main(String[] args) {


    // 3) 레퍼런스 배열을 사용하여 인스턴스를 다루기 보다는
    // 낱개의 레퍼런스를 만드는게 더 편리

    class Member { // Member class 정의, Member의 설계도
      int no;
      String name;
      String email;
      String password;
      String photo;
      String tel;
      Date createdDate; // c는 이름을 줄이지만, 자바개발자는 이름을 끝까지 준다
    }
    Scanner keyInput = new Scanner(System.in);
    final int LENGTH = 100;
    long currentMilli;
    int count = 0;

    Member[] members = new Member[LENGTH]; // Member 인스턴스들의 주소를 담을 배열 생성
    // new로 선언되는 것은 항상 초기화되어있다(0 = null)
    // 그냥 for문안에서 m.no 이렇게 쓰는게 더 편하니까 선언하는것뿐이다

    for (int i =0; i < LENGTH; i++) {
      count++;
      Member m = new Member(); // 설계도에 따라 인스턴스 생성 동시에 인스턴스 주소를 저장

      System.out.print("번호는? ");
      m.no = keyInput.nextInt(); // 인스턴스에 있는 각 필드에 찾아가서 데이터 저장
      keyInput.nextLine();
      System.out.print("이름은? ");
      m.name = keyInput.nextLine();
      System.out.print("이메일은? ");
      m.email = keyInput.nextLine();
      System.out.print("비밀번호는? ");
      m.password = keyInput.nextLine();
      System.out.print("사진은? ");
      m.photo = keyInput.nextLine();
      System.out.print("전화번호는? ");
      m.tel = keyInput.nextLine();
      currentMilli = System.currentTimeMillis();
      m.createdDate = new Date(currentMilli);

      members[i] = m;

      System.out.println();
      System.out.print("계속 입력하시겠습니까? (y/N)");
      String response = keyInput.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }
    }

    keyInput.close();

    for (int i = 0; i < count; i++) {

      Member m = members[i];

      System.out.printf("%d, %s, %s ,%s, %s\n",
          m.no,
          m.name,
          m.email,
          m.tel,
          m.createdDate.toString());
    }
  }
}

//    System.out.println(m.createdDate);
//    // => m이라는 변수에 저장된 주소로 찾아가서 no이라는 이름의 항목 값을 꺼내기
//    // => 레퍼런스 m이 가리키는 인스턴스의 no 항목의 값을 꺼내기
//    // => 레퍼런스 m이 가리키는 인스턴스의 no 필드 값 꺼내기
//    // => m객체의 no필드 값 꺼내기 (m이 가리키는 인스턴스(객체))의 no 필드 값꺼내기
//    // m의 객체의 no의 필드 값 꺼내기
