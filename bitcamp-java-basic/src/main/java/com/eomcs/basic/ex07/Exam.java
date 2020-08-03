// 메서드 만들때 가변 파라미터 매우 유용!
// 그러나 가변 파라미터는 파라미터에 1개밖에 못쓰지만, 배열은 여러개 한번에 사용가능!
// 메서드의 return은 메서드를 break ?? m10

// 빈배열이라는 것도 있다!!(length가 0이다!)
// for (:) 복습 : 많이 쓰일듯
// boolean 뭐냐, boolean 뿐만이 아니라 문자열 연결해주는 + 이거 다른거에도 잘됨


package com.eomcs.basic.ex07;
public class Exam {
  public static void main(String[] args) {
    m1();
    m2("홍길동");

    System.out.println(m3());

    m3();

    System.out.println(m4("홍길동"));

    System.out.println(m5("홍길동", 20, false));

    System.out.println(m6("홍길동", 100, 90, 80));

    m7("홍길동", new int[] {100,90,80,70,60});
    m7("홍길동", new int[] {100,90});
    m7("홍길동", new int[] {100});
    m7("홍길동", new int[] {});

    m8("홍길동", 100, 90, 80);
    m8("홍길동", 100);
    m8("홍길동");

  }

  static void m1() {
    System.out.println("henlo");
  }

  static void m2(String name) {
    System.out.println(name+"아 안녕");
  }

  static String m3() {
    return "메세지다";
  }

  static String m4(String name) {
    return name+"님 반가워요";
  }

  static String m5(String name, int age, boolean working) {
    return name+"님은 "+age+"세 "+working+"이시군요"; // boolean뭐냐 이게 되네
  }

  static String m6(String name, int score1, int score2, int score3) {
    int sum = score1 + score2 + score3;
    int average = sum/3;
    return name+"아 너의 총점은 "+ sum+"이고 평균은 "+average+"이야 ㅎㅎ";
  }

  static void m7(String name, int[] scores) {
    int sum =0;
    for (int i = 0; i < scores.length; i++) {
      sum += scores[i]; // 아 이거 하는거 있었는데
    }
    int average = 0;
    if (scores.length > 0) {
      average = sum / scores.length;
    }
    System.out.printf("%s:%d(%d)\n", name, sum, average);
  }

  static void m8(String name, int... scores) {
    int sum =0;
    for (int i = 0; i < scores.length; i++) {
      sum += scores[i]; // 아 이거 하는거 있었는데
    }
    int average = 0;
    if (scores.length > 0) {
      average = sum / scores.length;
    }
    System.out.printf("%s:%d(%d)\n", name, sum, average);
  }

  static void m10(int[] scores, String[] subjects, String name) {
    if (scores.length != subjects.length) {
      System.out.println("과목 수와 점수의 개수가 다릅니다.");
      return;
    }
    System.out.println(name + "님 점수!");
    for (int i = 0; i < scores.length; i++) {
      System.out.printf("%s = %d 점\n", subjects[i], scores[i]);
    }
  }
}
