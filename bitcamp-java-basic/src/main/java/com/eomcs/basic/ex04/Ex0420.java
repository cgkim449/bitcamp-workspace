package com.eomcs.basic.ex04;

public class Ex0420 {
  public static void main(String[] args) {

    // 레퍼런스
    // String str;

    //-----------------------------
    // 2. 부동소수점-부동소수점
    // 주의!
    // 정수의 경우 리터럴을 표현할 때 
    // 값이 그 크기를 넘어가면 컴파일 오류가 발생하지만,
    // 부동소수점의 경우 리터럴이 메모리의 크기를 넘어갈 때
    // 컴파일 오류 대신 단지 값이 짤리거나 반올림되거나 쓰레기값생긴다
    // 즉,부동소수점은 유효자릿수를 넘어가도 에러 발생하지 않는다
    // 유효자리 안에서도 99%만 맞다(오차있음), 15자리까진 99%, 16자리는 90%
    // f = 0.000001234567f도 가능하다!!
    
    // 결론 : 
    // 1. float에 double 아예 못넣음, double에 float 넣음(정수형과 합쳐서 기본 그림 완성)
    // 2. float형을 double형에 넣을 때 : 
    // 계산방식에 의해 소수점 이하의 수가 근사값으로 계산된다? 
     
    // 3. 큰거를 작은거에 저장할때( 예: float f=123456789.1234567f)
    //  - byte 넘어가는거 단순히 자른다?
    // 4. 작은걸 큰거에 저장할때( 예: float f=3.14f)
    //  - 3.14 출력
    // 질문 :
    // 1. float형을 double형에 넣을때 원리(걍 작은걸 큰거에 저장할때랑 같을거같음)
    // 2. 정수형을 부동소수점형에 넣을때 원리(걍 정규화일거같음)
    //--------------------------------------------------------------
    //흔히 하는 실수: 부동소수점 연산하다가 유효자릿수 넘긴다
    float f;
    double d;
    /*
    f=999.99993f;
    System.out.println(f);
    
    float fa=1.234567f;
    float fb=92345.22f;
    f=fa+fb; // 흔히하는 실수
    double d=fa+fb;
    System.out.println(fa);
    System.out.println(fb);
    System.out.println(f); 
    System.out.println(d);*/
    //----------------------------------------------------------
    // 큰걸 작은거에 넣을때(정수와 다르다? 정수도 단순히 자르는건데)
    f = 123456789.1234567f; // 
    System.out.println(f); 

    d = 123456789.1234567; // 
    System.out.println(d); 
    // 2345678912.123456f
    // > 4바이트를 넘어가는 값은 자른다(단순히 자른다?)
    // > 따라서 f에 저장되는 값은 이미 잘린 값이다
    //(저장할때 잘린다고 착각많이함, 임시메모리에서 이미 잘리는거임)
    //----------------------------------------------------------
    //작은걸 큰거에 넣을때(정수와 다르다, 자세힌 모르겟음)
    // 계산방식에 의해 소수점 이하의 수가 근사 값으로 바뀐다
    f=123456.7f;
    System.out.println(f);
    
    d=123456.7;
    System.out.println(d);
    
    d=123456.7f;
    System.out.println(d); // 위에랑 다르다..
    }
}