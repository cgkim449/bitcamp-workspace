package com.eomcs.basic.ex04;

public class Ex0560 {
  public static void main(String[] args) {
    
    int v;
//    System.out.println(v);
    
    int[] arr1 = new int[5];
    float[] arr2 = new float[5];
    boolean[] arr3 = new boolean[5];
    char[] arr4 = new char[5];
    Object[] arr5 = new Object[5];
    
    System.out.println(arr1[0]); // 0
    System.out.println(arr2[0]); // 0.0
    System.out.println(arr3[0]); // false
    System.out.println(arr4[0]); // '\u0000'
    System.out.println(arr5[0]); // null
    System.out.println('\u0000');
  }
}