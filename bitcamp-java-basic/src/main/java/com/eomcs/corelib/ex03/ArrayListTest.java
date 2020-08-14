package com.eomcs.corelib.ex03;

public class ArrayListTest {
  public static void main(String[] args) {
    YourArrayList.add("aaa");
    print();
    YourArrayList.add("bbb");
    print();
    YourArrayList.add("ccc");
    print();
    YourArrayList.add("ddd");
    print();
    YourArrayList.add("eee");
    print();
    YourArrayList.add("fff");
    print();
    YourArrayList.add("ggg");
    print();

    YourArrayList.add(1, "xxx");
    print();
    YourArrayList.add(1, "yyy");
    print();
    }

  static void print() {
    for (int i = 0; i < YourArrayList.size; i++) {
      String str = (String)YourArrayList.get(i);
      System.out.print(str + ", ");
    }
    System.out.println();
  }
}
