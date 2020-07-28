package com.eomcs.basic.ex04;

public class Ex0521 {
  public static void main(String[] args) {
    
    int[] arr1;
    arr1 = new int[5];
    arr1[0] =100;
    arr1[1] =90;
    arr1[2] =80;
    arr1[3] =70;
    arr1[4] =60;
    
    int sum = 0;
    
//    for (int i=0; i<arr1.length; i++) {
//      sum = sum+arr1[i] ;
//    }
      for (int item: arr1) {
        sum= sum+ item;
      }
    System.out.println(sum);
  }
}