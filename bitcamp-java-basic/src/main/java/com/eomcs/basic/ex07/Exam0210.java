package com.eomcs.basic.ex07;

public class Exam0210 {
  public static void main(String[] args) {
    m1();

    m2("홍길동");

    String message = m3();
    System.out.println(message);

    m3();

    message = m4("홍길동");

    System.out.println(m5("홍길동", 20, false));

    m6("홍길동", 100, 90, 80);
    m7("홍길동", new int[] {100,90,80,70,60}); // 인스턴스 주소! 절대 배열자체를 주고받을수 없다
    m7("홍길동", new int[] {100,90});
    m7("홍길동", new int[] {100});
    m7("홍길동", new int[] {}); // 값이 없으면 빈배열이라도 넘겨야한다!

    System.out.println("------------------");

    m8("홍길동", 100, 90, 80, 70, 60); // 가변파라미터 : 파라미터의 개수가 변할수 있다
    m8("홍길동", 100, 90);
    m8("홍길동", 100);
    m8("홍길동"); // 가변파라미터 : 길이가 0인 배열!, 위에꺼가 너무 귀찮아서
    // 이 문법을 만들었다 컴파일러가 내부적으로 위에로 바꿈

    m10(new int[] {100,90,80}, new String[] {"국어","영어","수학"},"홍길동");

  }

  static void m1() {                // 어떤 입력값도 없고 어떤 출력값도 없다 그냥 지 할일할뿐
    System.out.println("Hello!");
  }

  static void m2(String name) {
    System.out.println(name + "님 반갑습니다");
  }

  static String m3() {
    return "안녕";
  }

  static String m4(String name) {
    return name + "님 반갑습니다";
  }

  static String m5(String name, int age, boolean working) { // 리턴값은 오직 한개
    return age + "살" + name + "님은 현재 재직상태가 " + working + "입니다.";
  }

  static void m6(String name, int a, int b, int c) {
    int sum = a + b + c;
    int aver = sum / 3;
    System.out.printf("%s: %d(%d)\n", name, sum, aver);
  }

  static void m7(String name, int[] scores) { // 배열 주소를 받는 변수
    int sum = 0;
    for (int i = 0; i < scores.length; i++) {
      sum += scores[i];
    }
    int aver = 0;
    if (scores.length > 0) {  // 값을 입력안 할 경우도 있다!
      aver = sum / scores.length;
    }
    System.out.printf("%s: %d(%d)\n", name, sum, aver);
  }

  static void m8(String name, int... scores) { // 쓰는 방법은 배열이랑 똑같이 쓴다,근데 선언은 이렇게함
    int sum = 0;
    for (int i = 0; i < scores.length; i++) {
      sum += scores[i];
    }
    int aver = 0;
    if (scores.length > 0) {  // 값을 입력안 할 경우도 있다!
      aver = sum / scores.length;
    }
    System.out.printf("%s: %d(%d)\n", name, sum, aver);
  }

//  static void m9(int...scores, int weight) { // 가변 파라미터는 무조건 맨 끝에 와야한다
  // 얘만 암기하면됨
//  }
//  static void m9(int...scores, int... scores2) { // 가변 파라미터는 여러개 선언할 수 없다
//  m9(100, 90, 80, 70, 60) // 이렇게 했을때 어느거가 어느건지 모름
//  }

  // 가변 파라미터 중간에 다른 타입의 변수가 오더라도
  // 가변 파라미터를 한개 초과하여 둘 수 없다
//  static void m9(String... titles, String name, int... scores2) {
//    //m9("국어", "수학", "홍길동", 100, 98);
//  }

  static void m10(int[] scores, String[] titles, String name) { // 앞에와도 상관없고,
    // 여러개 배열이어도 상관없고
    if (scores.length != titles.length) {
      System.out.println("과목 수와 점수의 개수가 다릅니다.");
      return;
    }
    System.out.println(name + "님 점수!");
    for (int i = 0; i < scores.length; i++) {
      System.out.printf("%s = %d 점\n", titles[i], scores[i]);
    }
  }
}