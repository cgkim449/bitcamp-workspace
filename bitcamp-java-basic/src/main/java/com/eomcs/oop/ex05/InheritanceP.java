// ### 상속
// - 상속이라는 용어에 오해많이함, 기존코드를 그대로 상속받는다고
// 즉 그대로 자동복사된다고 생각함, 그러나 기존 클래스파일을 삭제하면 에러뜸
// 자동복사 되는게 아니라 링크정보가 있음
// ### 상속이 필요한 이유
// - 버그가 나왔을 때 유지보수가 너무 힘들어서
//---------------------------------------------------------------------
// ## 클래스 로딩 순서, 생성자 호출 순서
// - 클래스 찾기
// - 검증
// - 로딩(상위 클래스부터)
// - static 변수 생성 > 블록 실행(변수초기화 문장, 스태틱초기화블록)
// - instance 변수 생성 > 생성자 호출(변수초기화문장, 인스턴스초기화블록, 생성자)(하위클래스부터 호출되고 super()로 하나씩 올라감)

// ### super();과 기본생성자
// - new로 B의 생성자가 호출될때 항상 A의 생성자가 호출됨 컴파일러가 super(); 자동으로 추가함
// A에 기본생성자가 없으면 super(100);등 직접 지정해줘야됨

package com.eomcs.oop.ex05;

public class InheritanceP {
  public String model;
  public String maker;
  public int capacity;

  public InheritanceP() {}

  public InheritanceP(String model, String maker, int capacity) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
  }
}
