// # 오버로딩
//
// - 오버로딩 : 1. 같은 일을 하고 파라미터만 다른 메서드들을 같은 메서드명으로 하자
//              2. 서브클래스에서 오버로딩하자
//

// ## 필요성 : '같은 일'을 하고 파라미터만 다른 메서드를
// 필요할때마다 계속 만들어서 관리하는게 번거롭다
// 그 메서드들을 같은 이름을 갖게 해서 일관성있는 프로그래밍을 하자
//
// 리턴값까지 고려하면 너무 문법이 정교해지기 때문에 오히려 안좋다
// 자판기를 생각하라 리턴값은 다르지만 하는일은 같다
//
// 컴파일러는 파라미터로 오버로딩 메서드들 구분

// ## 상속과 오버로딩(서브클래스에서 오버로딩하기)
//   - 오버로딩은 한 클래스에서만 할 수있는게 아니라,
//     상위 클래스의 메서드를 서브 클래스에서 오버로딩할 수 있다

// ## 오버로딩의 예 : println(),Integer.valueOf()

// ## 다형성
// - 다형적 변수 : 한 변수가 다양한 형태를 갖는다
// - 오버로딩 : 한 메서드가 다양한 형태를 갖는다
//   (한 메서드가 실제로는 다양한 메서드이다)

package com.eomcs.oop.ex06.b;

public class OverloadingP {
  public static void main(String[] args) {

    System.out.println(100);
    System.out.println(true);
    System.out.println("hello");

    Integer obj1 = Integer.valueOf(100);
    Integer obj2 = Integer.valueOf("100");
    Integer obj3 = Integer.valueOf("64", 16);

    System.out.printf("%d %d %d\n", obj1, obj2, obj3);
  }
}
