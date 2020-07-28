package com.eomcs.basic.ex03;
// 주제 : 부동소수점을 저장하는 메모리의 크기
class Exam0340
{ 
    public static void main(String[] args) 
    {  
// 4바이트 메모리에는 최대 7자리의 부동소수점을 
// 저장할 수 있다. 초과하면 반올림처리되거나 짤린다.        
        System.out.println(9999999f);
        System.out.println(999999.9f);
        System.out.println(9.999999f);
        System.out.println("1-----------------");

        System.out.println(9876543211.234567f);
        System.out.println(987654321123456.7f);
        System.out.println(9.876543211234567f);

// 8바이트 메모리에 부동소수점 저장하기

        System.out.println(98765432.1123456);
        System.out.println(98765432112345.6);
        System.out.println(9.87654321123456);
        System.out.println(987654321.1234567);
        System.out.println(987654321123456.7);
        System.out.println(9.876543211234567);
        System.out.println(9876543211.2345678);
        System.out.println(9876543211234567.8);
        System.out.println(9.8765432112345678);

// 8바이트 메모리에는 최대 16자리의 부동소수점을 
// 저장할 수 있다. 초과하면 반올림처리되거나 짤린다.        

//부동소수점의 일부는 정확하게 2진수로 변환할 수 없다.        
        System.out.println(7*0.1);
        // 0.7_000_000_000_000_001
    }
}
// 결론 : 유효자릿수라 하더라도 100% 정확하지 않으며, 유효자릿수 넘어가면 반올림되거나 짤리거나, 
//17번째 자릿수에서 쓰레기값 생김.
// 

// 유효자릿수
// - 소수점을 제외한 숫자의 개수
// 4바이트 메모리에는 최대 7자리
// 8바이트 메모리에는 최대 16자리
// 초과하는 수는 반올림처리되거나 잘린다.
// 유효자릿수라 하더라도 100% 정확하지 않다.
// 왜? IEE 754명세의 규격에 따라 2진수로 전환할때 일부 값은 완전히
// 정확하게 변환되지 않는 경우도 있다.

//- 자바는 부동소수점을 저장할 때 전기전자기술자협회(IEEE)에서 
//  개발한 IEEE 754 명세에 따라 2진수로 변환한다.
