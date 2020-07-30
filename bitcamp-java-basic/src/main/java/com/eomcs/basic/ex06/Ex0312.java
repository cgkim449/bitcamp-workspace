package com.eomcs.basic.ex06;

public class Ex0312 {
  public static void main(String[] args) {
    int i = 2;
    int j = 1;
    int result = 0;


      while (i<=9) {
        j = 1;
        while (j<=9) {
         System.out.printf("%d x %d = %d\n", i, j, i*j);
          if (i == 5 && j == 5)
           break;
          j++;
         }
          if (i == 5)
            break;
          i++;
      }
      System.out.println("-----------------");

    System.out.println("종료!");
  }
}