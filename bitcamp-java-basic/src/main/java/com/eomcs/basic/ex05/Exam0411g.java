package com.eomcs.basic.ex05;

//# 비트 이동 연산자 : >>, >>>, <<
//
public class Exam0411 {
  public static void main(String[] args) {

    // 0111 1111 1111 1111 1111 1111 1111 1010 =  21_4748_3642
    // 1000 0000 0000 0000 0000 0000 0000 0110 = -21_4748_3642

    // 음수를 왼쪽으로 이동할 때는 부호비트에 상관없이 무조건 이동
    int a = -0x7f_ff_ff_fa; // -21_4748_3642
    System.out.println(a);
    System.out.println(a << 1); // 1|0000 0000 0000 0000 0000 0000 0000 1100 = 12
    System.out.println(a << 2);
    System.out.println(a << 3);
    System.out.println(a << 4);

    // 결론!
    // - '적당한 크기 양수'에 대해 왼쪽으로 x 만큼 비트를 이동시키는 것은 곱하기 '2**x'효과가 있다.
    // 곱하기 연산보다 비트 이동 연산이 속도가 빠르기 때문에 실무에서 자주 사용한다.
    // (오른쪽은 나누기 '2**x' 효과)
    // - 적당한 크기를 넘어가면 음수가 될 수 있다.
    // - 음수의 경우는 양수로 바뀔 수도 있다.
    //
    String s = "abc"; // 영어니까 3byte 1 1 1 
    String s2 = "a가b"; // 한글있으니까 6byte 2 2 2
    System.out.println(s.length());
    System.out.println(s2.length()); // 6byte에서 2나눠야 3나옴( >>1)
  }
}



