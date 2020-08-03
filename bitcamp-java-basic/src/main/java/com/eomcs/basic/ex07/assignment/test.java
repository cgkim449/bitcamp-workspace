package com.eomcs.basic.ex07.assignment;

public class test {
  public static void main(String[] args) {
    int[][] arr = new int[6][6];

    for (int i = 0; i <= 5; i++) {
      arr[i][i] = 1;
    }

    for (int i = 1; i <= 5; i++) {
      for (int j = 1; j <= 5; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }
  }
}
