//로컬 변수 선언
package com.eomcs.basic.ex04;

public class Ex0810 // 클래스 선언
{ // 클래스 블록 == 클래스 정의

  static int x;
  
  public static void main(String[] args) // 메서드 선언 
  { // 메서드 블록 == 메서드 정의
  
    int a;
    int x; 
    // 0.같은 블록에 소속된 로컬변수가 아니라면 
    // 같은 이름으로 변수를 선언!할 수 있다. 위에 애랑 다른 변수임
    
//    int a; // 컴파일 오류! == 문법오류!
    // 1.같은 블록에 이름이 같은 변수를 중복 선언할 수 없다, JavaScript는 된다  
    // JS는 블록의 영향을 받지 않는다?
    
    { // 로컬 블록(일반 블록)
//      int a; // 2.바깥 블록에 선언!된 같은 이름을 가질 수 없다
      int b;
      {
//        int b; 
//        int a; 
        int c;
        int d;
        // 3.블록 안에 선언!된 변수는 블록을 나가는 순간 자동 삭제된다!
      }
//      c=100;
      b=100;
      int c; // 이 c변수는 하위블록 c와 다르다
      {
        int d; // 이전 블록에서 만든 d 변수는 이미 삭제되었기 때문에 
        // 이 블록에서 같은 이름으로 변수를 만들수 있다
      }
      b=100;
      c=200;
//      d=300;
    }
    
    int i;
    for (i=0; i<10; i++) {
      System.out.println(i);
    }
    System.out.println(i); // 모르겟다 왜 10인지 나올때 한번더 ++인가
    
    for (int k=0; k<10; k++) { // 여기서 k는 if블록안에서 선언된 변수임
      System.out.println(k);
    }
//    System.out.println(k);
    int age =20;
    int m;  
    if(age>19) { // 변수라서 컴파일러가 얘가 맞는지 틀리는지 확신못한다고 한다
      m=200;
      int n=30;
    }
//    System.out.println(m); : 위에 m 초기화 안하면 컴파일 오류 : 
    // 변수라서 컴파일러가 조건문이 맞는지 틀리는지 확신못한다고 한다
  }
}
