package com.eomcs.oop.ex04;

public class Exam0112 {
  public static void main(String[] args) throws Exception {
    byte[] bytes = {
        (byte)0xb0, (byte)0xa1, // 가
        (byte)0xb0, (byte)0xa2, // 각
        (byte)0xb6, (byte)0xca, // 똘
        (byte)0xb6, (byte)0xcb // 똠
    };

    String s = new String(bytes);
    System.out.println(s);
  }
}
