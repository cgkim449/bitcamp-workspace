package com.eomcs.pms;

import java.util.ArrayList;

public class App_test {
  public static void main(String[] args) {

    ArrayList<String> list = new ArrayList<>();

    list.add("홍길동");
    list.add("유관순");
    list.add("안중근");
    list.add("윤봉길");

    for (String value : list) {
      System.out.println(value);
    }

  }
}