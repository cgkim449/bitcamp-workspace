// 생성자 활용 예 - 자바에서 제공하는 클래스 사용을 통해 생성자 활용을 익혀보자

package com.eomcs.oop.ex04;

public class Exam0110 {
  public static void main(String[] args) throws Exception {
    String s = new String();
    //문자열 리터럴을 사용하여 String 인스턴스를 초기화
    String s1 = new String("Hello");
    System.out.println(s);
    System.out.println(s1);

    s = null;
    System.out.println(s);

    // char 배열을 사용하여 String인스턴스를 초기화
    char[] chars = new char[] {'H','e','l', 'l', 'o'};
    String s2 = new String(chars);

    // 바이트 배열을 가지고 String 인스턴스를 초기화
    byte[] bytes = {
        0x48,
        0x65,
        0x6c,
        0x6c,
        0x6f
    };

    String s3 = new String(bytes);

    System.out.printf("%s %s %s\n", s1, s2, s3);
  }
}
