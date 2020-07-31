package com.eomcs.pms;

import java.sql.Date;


public class App_test {

  public static void main(String[] args) {

    class Member { // Member class 정의: Member calss의 설계도
      int no;
      String name;
      String email;
      String password;
      String photo;
      String tel;
      Date createdDate;
    }

    final int LENGTH = 100;
    Member[] members = new Member[LENGTH]; // Member 레퍼런스 배열 생성 (아직 인스턴스 생성 안함)
                                           // null(0)로 초기화돼있음
    members[0] = new Member(); // 설계도에 따라 인스턴스 생성
    members[1] = new Member(); // 설계도에 따라 인스턴스 생성
    members[2] = new Member(); // 설계도에 따라 인스턴스 생성
    members[3] = new Member(); // 설계도에 따라 인스턴스 생성

    members[0].no = 1;         // 인스턴스의 각 필드에 데이터 넣기
    members[0].no = 1;         // 인스턴스의 각 필드에 데이터 넣기
    members[0].no = 1;         // 인스턴스의 각 필드에 데이터 넣기
    members[0].no = 1;         // 인스턴스의 각 필드에 데이터 넣기




  }
}