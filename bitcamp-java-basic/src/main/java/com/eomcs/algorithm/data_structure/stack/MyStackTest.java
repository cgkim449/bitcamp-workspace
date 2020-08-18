package com.eomcs.algorithm.data_structure.stack;

public class MyStackTest {
  public static void main(String[] args) {
    MyStack stack = new MyStack();
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");
    System.out.println("==> " + stack.peak());
    stack.push("ddd");
    stack.push("eee");
    print(stack);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println("==> " + stack.peak()); // pop하기전에 조회
  }

  static void print(MyStack stack) {
    for (int i = 0; i < stack.size(); i++) {
      System.out.print(stack.get(i) + ",");
    }
    System.out.println();
  }
}
