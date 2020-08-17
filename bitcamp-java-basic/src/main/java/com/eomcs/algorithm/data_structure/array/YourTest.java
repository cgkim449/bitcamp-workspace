package com.eomcs.algorithm.data_structure.array;

public class YourTest {
  public static void main(String[] args) {

    YourArrayList list = new YourArrayList();

    list.add("aaa");
    print();
    list.add("bbb");
    print();
    list.add("ccc");
    print();
    list.add("ddd");
    print();
    list.add("eee");
    print();
    list.add("fff");
    print();
    list.add(1, "xxx"); // a x b c d e f
    print();
    list.add(3, "yyy"); // a x b y c d e f
    print();
    list.add(2, "zzz"); // a x z b y c d e f
    print();
    list.add(0, "www"); // w a x z b y c d e f
    print();
    System.out.println(list.get(0));
    System.out.println(list.set(0, "ppp")); // p a x z b y c d e f
    print();
    System.out.println(list.set(2, "qqq")); // p a q z b y c d e f
    print();
    System.out.println(list.remove(0)); // a q z b y c d e f
    print();
    System.out.println(list.remove(5)); // a q z b y d e f
    print();

  }

  static void print() {
    for (int i = 0; i < YourArrayList.size; i++) {
      System.out.print(YourArrayList.get(i) + ", ");
    }
    System.out.println();
  }
}
