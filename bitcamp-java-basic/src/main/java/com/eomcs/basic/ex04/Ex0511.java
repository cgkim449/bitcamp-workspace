package com.eomcs.basic.ex04;

public class Ex0511 {
  public static void main(String[] args) {
    
    int[] p = new int[3]; // int* p = (int*)malloc(sizeof(int)*3)
    System.out.println(p.length);
    
    int[] p2;
    p2 = p;
    System.out.println(p);// 자바에서는 어떤방법으로도 주소를 출력하지 못한다!
    p2=null;
    
    int[] k = new int[] {100, 200, 300};
    int[] k1 = new int[] {1, 2, 3};
    
    int[] x1 = new int[3];
    int[] x2 = new int[4];
    int[] x3 = new int[3];
    x3 = x1;
    x2 = x1;
    System.gc();
    
  }
}