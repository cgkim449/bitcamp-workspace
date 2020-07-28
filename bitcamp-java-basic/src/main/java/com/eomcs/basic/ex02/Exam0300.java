// 주제 : 애노테이션(annotation)
// 컴파일러나 JVM에게 명령하는 것

package com.eomcs.basic.ex02;

  
public class Exam0300 { 

   public static void main(String[] args) {

   }

    @Override // 기존 기능을 재정의하는 것이 맞는지 검사하라는 명령
   public String toStrong() { // 뭔 재정의냐 오타있다(@Override 없으면 에러안남(컴파일러는 걍 새로운 ?라고 생각함))
       return "test";  
   }
} 