package com.eomcs.basic.ex06;

public class while_ex {
  public static void main(String[] args) {
//    while (true); // true 빈문장 true 빈문장... // 보이지않는 무한루프
//       while (true) System.out.println("안녕!"); // 무한루프
    //기본
    System.out.println("--------------------");
    int count = 0;
    while (count++ < 10) { // 가독성이 제일중요
      // 1부터 시작해서 <=10가 이해하기 제일 명확하나 두번 연산하기때문에, C개발자들같은 사람들은
      //위에껄씀
      System.out.println(count);
    }
//    while
//    int temp = count;
//    count = count +1;
//    boolean condition = temp < 10;
//    if (condition == true) {
//      System.out.println("안녕");
//    }
    System.out.println("--------------------");
    count = 0;
    while (++count < 10) {
      System.out.println(count);
    }
    System.out.println("--------------------");
    count = 0;
    while (count < 10) {
      System.out.println(count);
      count++;
    }
    System.out.println("--------------------");
    count = 0;
    while (count < 10) {
      count++;
      System.out.println(count);
    }
    System.out.println("--------------------");
  }
}