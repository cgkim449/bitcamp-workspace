package com.eomcs.basic.ex05;

public class Exam01301 {
  public static void main(String[] args) {

      byte x = 5, y =6 , z;
      // z = x + y;
    
      char b = (char)65.14;
    System.out.println(b);
    
    System.out.println(5.75 % 0.24);
    
  }
}

// 참고
// - byte는 보통 파일의 데이터를 읽어 들일 때 사용한다.(byte 배열사용)


// 결론!
//- 자바는 정수 변수에 대해 산술 연산을 수행할 때, 
// 그 변수의 값이 4바이트보다 작다면 임시 4바이트 정수 메모리를 만든 다음에 연산을 수행한다.
// - 연산은 항상 같은 타입끼리만 가능하다! int 연산 int는 int, float 연산 float는 float
// - '자바의 최소연산단위' : 4byte! : 그림에 더하자

// - ...000001 : IEEE754의 이진수 변환 문제
// - boolean은 걍 다 안된다