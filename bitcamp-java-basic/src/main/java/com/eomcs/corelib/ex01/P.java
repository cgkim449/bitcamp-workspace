// - 오버로딩 : 같은 이름, 같은 일, 다른 파라미터, 리턴 타입 달라도 됨
// - 오버라이딩 : 같은 이름, 다른 일, 같은 파라미터, 리턴 타입 달라도 됨
//------------------------------------------------------------------------------------
// # Object 클래스의 주요 메서드
// 1) toString()
//    => 클래스이름과 해시코드를 리턴한다.
// 2) equals()
//    => 같은 인스턴스인지 검사한다.
// 3) hashCode()
//    => 인스턴스를 식별하는 값을 리턴한다.
// 4) getClass()
//    => 인스턴스의 클래스 정보를 리턴한다.
// 5) clone()
//    => 인스턴스를 복제한 후 그 복제 인스턴스를 리턴한다.
// 6) finalize()
//    => 가비지 컬렉터에 의해 메모리에서 해제되기 직전에 호출된다.
//-------------------------------------------------------------------------------------
// # 오버라이딩의 활용
// - super 클래스가 지정되지 않았으면 모두 Object의 서브 클래스이다
// - 그래서 Object 메서드들을 오버라이딩 해서 많이 사용한다

// ## 인스턴스의 내용물 + String,Wrapper 클래스는 이미 오버라이딩이 되어있기 때문에 그점을 이용할 수 있다

// - toString() : 인스턴스의 "내용물"을 빠르게 확인하고 싶을 때
//
//  ### 해시코드(4바이트정수) : 인스턴스의 "내용물"이 같으면 같은 해쉬코드를 주고싶다
//      - hashCode() : String.format()으로 인스턴스의 내용물을 문자열로 만든다음,
//                     그 문자열에 대해 hashCode()를 호출하면 String 클래스는 이미 hashCode()가
//                     오버라이딩 돼있기때문에 문자열에 따라서 해시코드가 결정되는것
//
//  ### 해시셋, 해시맵 :인스턴스의 "내용물", 해시코드로 중복검사한다
//      - equals() : 인스턴스의 "내용물"이 같은지 비교하고 싶을 때
//      - hashCode() : 인스턴스 주소다르지만 인스턴스의 "내용물"이 같으면 같은 해쉬값을 주고 싶을때가 있다

// ## protected된 메서드를 오버라이딩을 이용하여 공개해서 사용할 수 있다
// 보호되있어서 난 못쓰니까 갖고와서 공개좀해줘라 - overriding
// 클론허락
// - clone() : protected니까 오버라이딩해서 공개해서 사용하자(범위 좁힐 수는 없음)
//---------------------------------------------------------------------------------------
// # 오버라이딩 활용
//- 인스턴스의 내용물!
//- String, Wrapper 클래스를 이용하자! 이미 오버라이딩 되있는 클래스들을 이용하자!
//- protected된 메서드를 공개하여 사용할 수 있다!
//
//--------------------------------------------------------------------------------------
// # getClass : 오버라이딩과 관계없나?
// - getClass()와 배열
// - getCalss()와 배열의 항목 이름



package com.eomcs.corelib.ex01;

public class P {

}
