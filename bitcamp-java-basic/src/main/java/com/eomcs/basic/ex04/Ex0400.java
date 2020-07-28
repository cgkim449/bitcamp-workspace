package com.eomcs.basic.ex04;

public class Ex0400 {

  public static void main(String[] args) {
    
// ### ''는 문자 리터럴의 유니코드값을 리턴한다
//    (char)은 변수값의 유니코드값을 리턴한다

//---------------------------------------------------------------------
    byte b; 
    int i=20;
    
    b=10+20;
    b=10+i; //b=10+20;은 되지만 b=10+i;는 에러

//### 변수에 리터럴 저장, 변수에 다른 변수값 저장
//    1. 정수-정수
//기본적으로 정수는 리터럴이든 변수이든 '자기 자신'이나 자기보다 더 큰 애한테만 저장할 수 있다.(그림)
//근데 리터럴은 좀 느슨하다. 4byte 정수나 문자 리터럴만은 '값 크기만 적당하면' 모든 변수에 저장할 수 있다.

//int type 리터럴을 byte type 변수에 저장할 때 앞에 3byte는 걍 날라간다
//byte type 리터럴을 int type 변수에 저장할 때 앞에 3byte는 다 0으로 채워진다
//boolean은 별도이며 제일 엄격하다.(내부적으로는 4byte정수로 저장되지만 정수로 다룰 수 없다)
//    2. 부동소수점-부동소수점
//복잡하니깐 그냥 첨부터 끝까지 type 맞추자
//    3. 정수-부동소수점
//보다시피 정수형은 모두 부동소수점형에 저장할 수 있으나, 부동소수점형을 정수형에 절대 저장 못한다
//정수형을 부동소수점형에 저장할때 유효자릿수만 잘 맞추면 될것이다
//정수형이 부동소수점형에 저장될때의 과정은 잘 모르겠다
//당연히 boolean은 별도이다
    byte bb=10;
    short ss=10;
    char cc=10;
    int ii=12345678;
    long ll=1234567891234567L;
    
    float ff;
    double dd;
    
    ff=true;
    ff='A';
    ff=10;
    ff=10L;
    
    dd=true;
    dd='A';
    dd=10;
    dd=10L;
    
    ff=bb;
    ff=ss;
    ff=cc;
    ff=ii;
    ff=ll;
    
    dd=bb;
    dd=ss;
    dd=cc;
    dd=ii;
    dd=ll;
    
    byte bbb;
    short sss;
    char ccc;
    int iii;
    long lll;
    
    float fff=10.0f;
    double ddd=10.0;
    
    bbb=fff;
    sss=fff;
    ccc=fff;
    iii=fff;
    lll=fff;
    
    bbb=ddd;
    sss=ddd;
    ccc=ddd;
    iii=ddd;
    lll=ddd;
    
    bbb=10.0f;
    sss=10.0f;
    ccc=10.0f;
    iii=10.0f;
    lll=10.0f;
    
    bbb=10D;
    sss=10D;
    ccc=10D;
    iii=10D;
    lll=10D;
    
//----------------------------------------------------------------------
    
//###''는 문자 리터럴의 유니코드값을 리턴한다
//(char)은 변수값의 유니코드값을 리턴한다
        
    char c;
    short s;
    int j;
    
    c='헐';
    s='헐'; //리터럴 값 크기가 적당하지 않다
    j='헐';
    System.out.println(c);
    System.out.println(j);
  
    for (int x = 65; x<80; x++) {
      System.out.println(x);
    }
    for (int x = 65; x<80; x++) {
      System.out.println((char)x);
    }
    
    for (int x = 65; x<80; x++) {
      System.out.println('x'); 
    }
    
//bollean의 엄격함        
    boolean b1,b2;
    b1= true;
    b2= false;
    System.out.println(b1);
    System.out.println(b2);
    s=true; // boolean은 너무 엄격하다
    
  }
}
