// # 오버라이딩
// - 역할에 맞는 일


// ## 오버라이딩이란
// - 서브클래스에서 부모로부터 상속받은 메서드 중에서 자신의 역할에 맞지 않는 메서드가 있다면,
//   자신의 역할에 맞춰 메서드 시그너처는 그대로 놔두고 재정의!를 하는 것
// (한마디로 약간 다른일을 하는데 메서드 시그너처가 같음)
// (오버로딩은 같은일을 하는데 메서드명은 같음 파라미터가 다름, 리턴타입은 달라도 됨)

// ## 오버라이딩, 오버로딩 착각 ㄴㄴ

// ## 오버라이딩할때 상위 클래스에서 접근 범위 조정하기
// - private 등

// ## @Override

// ## this.m(); super.m(); (오버라이딩 쫙 있는 그림을 생각하자)


// 상속과 오버라이딩은 비슷하다 뗄레야 뗄수가 없다
// 둘다 서브클래스에서 자기의 목적을 위해 좀 뭔가를 한다

package com.eomcs.oop.ex06.c;

public class OverridingP extends C {
  @Override private void m1() {}

  @Override void m2() {}
  @Override protected void m3() {}
  @Override public void m4() {}

  }
}
