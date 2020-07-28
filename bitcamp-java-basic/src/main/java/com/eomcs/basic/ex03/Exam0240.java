// 주제 : 메모리에 음수를 저장하는 법 + Excess-K
package com.eomcs.basic.ex03;

class Exam0240 {
    public static void main(String[] args) {
            
        int a = 0xaaaaaaaa;
        int b = -0xaaaaaaaa;
        System.out.println(a);
        System.out.println(0xaaaaaaaa);
        System.out.println(2_863_311_530‬);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(b);
        // System.out.println(21_4748_3648); 
        // System.out.println(-21_4748_3649); 

    }
}

    
// 10101010 10101010 10101010 10101010 : aaaaaaaa
// 01010101 01010101 01010101 01010110 : -aaaaaaaa 2의 보수
// 55 55 55 56 : 16진수 

// 1. 부호-크기(sign-magnitude) 
//- 부동 소수점에서 가수부(significand or mantissa)를 저장할 때 사용한다.

// 2. 보수
// 3. 2의 보수
//- 음수 0을 없앰으로써 -128까지 표현할 수 있음.
//- 음수 0이 없다. 0에 대한 표현이 한 가지이다.

// 4. K-초과
// - 부동 소수점의 지수부(exponent)를 저장할 때 사용한다.
// - K(바이어스:편견,치우침) :  K = 2^(비트수 - 1) - 1
