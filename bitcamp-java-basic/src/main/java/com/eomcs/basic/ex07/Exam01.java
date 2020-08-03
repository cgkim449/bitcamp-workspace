// 실행속도가 느려지더라도 가독성을 위해서 최대한 메서드를 활용한다
// 1. printStar, printSpace
// + spaceCount

package com.eomcs.basic.ex07;

import java.util.Scanner;

public class Exam01 {

  static Scanner keyScan = new Scanner(System.in);
  static int spacePrint = 1;
  static int starPrint = 1;
  static int starCount = 1;
  static int totalLength;

  public static void main(String[] args) {

    System.out.print("밑변의 길이? ");
    totalLength = keyScan.nextInt();

    while (starCount <= totalLength) {
      spacePrint = 1;
      starPrint =1;

      printSpace();
      printStar();

      System.out.println();
      starCount+=2;
    }
    keyScan.close();
  }

  static void printSpace() {
    while (spacePrint <= spaceCount(totalLength, starCount)) { // 이거!!!!!!!!!!!!!!!
      System.out.print(" ");
      spacePrint++;
    }
  }

  static void printStar() {
    while (starPrint <= starCount) {
      System.out.print("*");
      starPrint++;
    }
  }

  static int spaceCount(int totalLength, int starCount) {
    return (totalLength-starCount)/2;
  }

}
