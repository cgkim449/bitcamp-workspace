// # 필드의 캡슐화와 프로퍼티
//
// ## 캡술화 : 막기
// - 특정 필드 접근 막기(private 필드)
// (예) 합계, 평균값을 임의로 변경하지 못하게 해야한다

// ## 프로퍼티(세터/게터 등) : 필드에 값을 직접 넣는게 아니라 간접적으로 넣는 메서드
// ### 세터
// - 캡슐화한 필드에 값을 넣게 하기
// - 필드의 값을 세터로 세팅할때마다 특정작업을 수행하게 하기
// (예) 합계, 평균값을 계산안하는것을 방지해야한다 -> 국, 영, 수 점수를 바꿀 때 마다 자동으로 합계, 평균을 계산해야 한다.
// ### 게터
// - 대신 조회는 할수있게 하기

// (필드의 값을 변경할 때 마다 특정 작업을 수행하게 만들기)

package com.eomcs.oop.ex07.a;

class Sco {
  private String name;
  private int kor;
  private int eng;
  private int math;
  private int sum;
  private float aver;

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setKor(int kor) {
    this.kor = kor;
    compute();
  }

  public int getKor() {
    return kor;
  }

  public void setEng(int eng) {
    this.eng = eng;
    compute();
  }

  public int getEng() {
    return eng;
  }

  public void setMath(int math) {
    this.math = math;
    compute();
  }

  public int getMath() {
    return math;
  }

  public int getSum() {
    return sum;
  }

  public float getAver() {
    return aver;
  }

  private void compute() {
    sum = kor + eng + math;
    aver = sum / 3f;
  }

}

public class EncapsulationP {
  public static void main(String[] args) {

    Sco s = new Sco();
    s.setName("A");
    s.setEng(98);
    s.setKor(90);
    s.setMath(100);

    System.out.printf("%s, %d, %d, %d, %d, %f"
        , s.getName(), s.getEng(), s.getMath(), s.getKor(), s.getSum(), s.getAver());
  }
}