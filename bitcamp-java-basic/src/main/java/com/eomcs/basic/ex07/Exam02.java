// m10()!
// 1. 가변 파라미터는 걍 단순히 배열을 파라미터에 적는게 귀찮아서 만든거다.. 내부적으로 배열로 바뀐다
//    대신 단점이 있다.. 한개밖에 못쓴다 배열은 파라미터에 한번에 많이 쓸 수 있다..
//    배열이던 가변 파라미터던 메서드에 쓸 때 걍 for(:), .length에 많이 쓸듯
// 2. 배열을 파라미터로 쓸 때, 빈배열이라도 넘겨야한다(length가 0)
// 3. 빈배열을 받을 수 있으므로 빈배열 받을때를 항상 생각해서 메서드를 만들어야 한다
//    (평균같은거 계산할때 나누기하니까 0으로는 못나누니까)
//    항상 나누기할때는 빈배열 고려하듯이 0을 신경쓰자
// 4. 매서드 안에, if () { return;!!!!!!!!!} : 반복문에서 break;와 같은효과,
//    메서드도 재귀함수처럼 무한루프가 있기때문에

// 5. boolean 뭐냐, boolean 뿐만이 아니라 문자열 연결해주는 + 이거 다른거에도 잘됨

package com.eomcs.basic.ex07;

public class Exam02 {

  static void m10(int[] scores, String[] subjects, String name) {
    if (scores.length != subjects.length) {
      System.out.println("과목수랑 점수개수가 달라요 ");
      return;
    }
    System.out.println(name + "님 점수에요");
    int sum = 0;
    float aver = 0;
    for (int score : scores) {
      sum += score;
    }
    if (scores.length != 0) {
      aver = sum / scores.length;
    }
    for (int i = 0; i < scores.length; i++) {
      System.out.printf("%s = %d\n", subjects[i], scores[i]);
    }
    System.out.printf("총점 = %d, 평균 = %f\n", sum, aver);
  }


  public static void main(String[] args) {

    m10(new int[] {100,90,80}, new String[] {"국어","영어","수학"},"홍길동");

    System.out.println("-----------------------------------------------------");


    m6("홍길동", 100, 90, 80);
    m7("홍길동", new int[] {100,90,80,70,60}); // 인스턴스 주소! 절대 배열자체를 주고받을수 없다
    m7("홍길동", new int[] {100,90});
    m7("홍길동", new int[] {100});
    m7("홍길동", new int[] {}); // 값이 없으면 빈배열이라도 넘겨야한다!

    System.out.println("-----------------------------------------------------");

    m8("홍길동", 100, 90, 80, 70, 60);
    m8("홍길동", 100, 90);
    m8("홍길동", 100);
    m8("홍길동"); // 길이가 0인 배열

    System.out.println("-----------------------------------------------------");

    System.out.println(plus(plus(plus(2,3), 4),7));

    System.out.println("-----------------------------------------------------");

    System.out.println(m5("홍길동", 20, false));

    m3();

    String message = m3();
    System.out.println(message);

    m1();

    m2("홍길동");

    message = m4("홍길동");

  }

  static void m1() {                // 어떤 입력값도 없고 어떤 리턴값도 없다 그냥 지 할일할뿐
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

  static String m5(String name, int age, boolean working) { // 리턴값은 언제나 한개뿐!
    // 리턴값을 여러개 받고 싶다면 배열이나 객체로!
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

  static void m8(String name, int... scores) {
    int sum = 0;
    for (int score : scores) {
      sum += score;
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

  static int plus(int a, int b) {
    return a + b;
  }

}