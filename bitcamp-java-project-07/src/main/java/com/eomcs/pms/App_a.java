package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;


public class App_a {

  public static void main(String[] args) {

// Member 클래스 정의(번호, 이름, 이메일, 암호, 사진, 전화번호)
// 값을 담기 위해 메모리를 준비할 때 어떤 종류의 메모리를 준비해야 하는지 설계도를 작성한다
// 이것을 '클래스 정의'라고 부른다
    class Member {
      int no;
      String name;
      String email;
      String password;
      String photo;
      String tel;
      Date now;
    }
    Scanner keyInput = new Scanner(System.in);

    final int LENGTH = 10;

    int[] no = new int[LENGTH];
    String[] name = new String[LENGTH];
    String[] email = new String[LENGTH];
    String[] password = new String[LENGTH];
    String[] photo = new String[LENGTH];
    String[] tel = new String[LENGTH];
    Date[] now = new Date[LENGTH];
    int count = 0;
    long currentMilli;

    for (int i =0; i < LENGTH; i++) {
      System.out.print("번호는? ");
      System.out.print("이름은? ");
      System.out.print("이메일은? ");
      System.out.print("비밀번호는? ");
      System.out.print("사진은? ");
      System.out.print("전화번호는? ");
      System.out.print("계속 입력하시겠습니까? (y/N)");
      System.out.print("번호는? ");
    }

    keyInput.close();

  }
}