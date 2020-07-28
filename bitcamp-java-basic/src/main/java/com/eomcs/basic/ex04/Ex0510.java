package com.eomcs.basic.ex04;

public class Ex0510 {
  public static void main(String[] args) {
    
    int[] p;
    
    p = new int[3]; // c 언어 int* p = (int*)malloc(sizeof(int)*3)
    // p : '레퍼런스'(주소를 저장하는 변수)
    // new: 메모리를 확보하는 명령, 시작주소를 리턴한다. 즉, (int*)malloc()
    // 확보된 메모리를 '인스턴스'라 한다
    // new는 항상 인스턴스
    
    System.out.println(p.length);
    
    p[0] = 100;
    p[1] = 200;
    p[2] = 300;
    System.out.printf("%d %d %d\n", p[0], p[1], p[2]);
    
    // p[3] = 400; : 실행 예외 발생(runtime exception)
    // p[-1] =500; : 실행 예외 발생(runtime exception)
    
    int sum = 0;
    for (int i =0; i<p.length; i++) { 
      sum = sum + p[i];
    }
    
    System.out.println(sum);
    
    int[] p2; // 자바에서 주로 사용
    int p3[]; // C에서 쓰는 방식도 사용가능, 단 개수를 지정해서는 안된다
    // System.out.printf("%d\n", p2[1]);
    
    p2 = p; 
    p2[1] = 1000;
    System.out.println(p[1]);
    p = new int[4];
    p[1] = 2000;
    System.out.printf("%d %d\n",p[1], p2[1]);
    
    System.out.println(p); // 얘는 주소가 아닌 해쉬코드?를 출력
    // 자바에서는 절대! 주소출력못함 방법이 없다. C는 된다.
    
    // p2 = 100; 이렇게 직접적으로 저장할 수 없다. C는 된다
    // p2 = 0 ; 이렇게 직접적으로 초기화 시킬 수 없다. C는 된다
    p2 = null; // 0으로 초기화
    // 배열의 주소가 없는 상태에서 사용하지 말라. C는 된다
    // int[] p; // kotlin은 이렇게하면 자동으로 null로 초기화
    // 언어가 간결하면서도 null pointer 문제를 해결하기위해 나온게 코틀린
    // System.out.println(p2[0]); // 변수를 초기화시키지 않고 사용하면 컴파일 오류
    // 레퍼런스가 배열 인스턴스를 가리키지 않은 상태에서 사용하려 하면? arr = null;
    // NullPointerException 오류(runtime excpetion)
    
    int k1;
    // System.out.println(k1); // 변수를 초기화시키지 않고 사용하면 컴파일 오류
    int[] k2 = new int[3];
    //new 명령으로만! 메모리를 준비할때,
    //- 모든 메모리는 0으로 자동 초기화 된다.
    //- 따라서 따로 초기화할 필요없이 바로 사용할 수 있다.
    System.out.println(k2[0]);
    
    //------------------------------
    // 배열 생성 후 즉시 초기화하기
    int[] k3 = new int[] {100,200,300}; // 3 쓰면 문법오류

    //문법
    
    int[] k4;
    k4 = new int[] {10, 20};
    
    int[] k5 = {11,12,13}; // new int[] 생략가능, 컴파일하기전에 자동으로 붙는다
    
    int[] k6;
    // k6 = {111, 222, 333}; // 컴파일 오류, 변수선언 없이는 생략할 수 없다
    
    int[] x1 = new int[3];
    int[] x2 = new int[4];
    int[] x3 = x1; 
    x2 = x1;  
    // reference count를 JVM이 내부적으로 관리
    // x2가리켰던 메모리는 reference count가 0이됨, 쓰레기가 된다
    // dangling object = garbage가 된다
    // 가비지는 JVM이 자동으로 해제시킨다 단 바로 해제시키는 것이 아니라
    // 다음 조건이 해당될때 해제시킨다
    // 1 메모리가 부족할때
    // 2 cpu가 한참동안 한가할때
    // =>결론 : 언제 가비지를 메모리에서 해제시킬지 알 수 없다
    System.gc(); // 가능하다면 빠른 시일내에 가비지를 수집할 것을 요구하는것
    // 주의 
    // => gc를 호출한다고해서 가비지 컬렉터가 바로 동작하는 것은 아님.
    // => 가비지 컬렉터의 실행을 앞당겨 달라고 요구하는것
    // => 그 요구를 수용할지 여부는 JVM의 판단에 달려있다
    
    // free(x1); // x1은 dangling pointer가됨(허상 포인터;없어진걸 가리킨다)
    // 자바는 dangling pointer가 존재할 수 없다(free 명령어가 없어서)
    
  }
}