package com.eomcs.basic.ex07;

import java.util.ArrayList;

public class Exam {

  static class No {
    int x;
    int y;
    int z;
    int w;
  }

  public static void main(String[] args) {

    No n = new No();
    ArrayList list = new ArrayList();

    n.x = 1;
    n.y = 2;
    n.z = 3;
    n.w = 4;

    for (Object num : n) {
      System.out.println(num);
    }
  }
}