package com.eomcs.generic.ex01;

import java.util.ArrayList;

public class Exam0212 {
  
  static class A {}
  static class B1 extends A {}
  static class B2 extends A {}
  static class C extends B1 {}
  
  //  Object
  //    |
  //    A
  //   / \
  //  B1 B2
  //  |
  //  C
  
  public static void main(String[] args) {
    
    ArrayList<A> list;
    list = new ArrayList<Object>();
  }
}
