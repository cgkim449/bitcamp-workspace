// 근데 finally에서 일일히 close하는게 귀찮다
// 그래서
package com.eomcs.exception.ex3;

import java.io.FileReader;
import java.util.Scanner;

public class Exam0630p {
  public static void main(String[] args) {
    try (Scanner keyScan = new Scanner(System.in); 
        FileReader in = new FileReader("Hello.java");){ 
      System.out.print("입력> ");
      int value = keyScan.nextInt();
      System.out.println(value * value);
    }
  }
}