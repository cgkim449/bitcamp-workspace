package com.eomcs.algorithm.data_structure.linkedlist;

public class YourTest {
  public static void main(String[] args) {
    YourLinkedList list = new YourLinkedList();
    list.add("aaa");
    print(list);
    list.add("bbb");
    print(list);
    list.add("ccc");
    print(list);
    list.add("ddd");
    print(list);
    System.out.println("--------------------------");
    list.add("eee", 4); // aaa, bbb, ccc, ddd, eee
    print(list);
    list.add("xxx", 0); // xxx, aaa, bbb, ccc, ddd, eee
    print(list);
    list.add("zzz", 6); // xxx, aaa, bbb, ccc, ddd, eee, zzz
    print(list);
    list.remove(0); // aaa, ccc, ddd, eee, zzz
    print(list);
    list.remove(4); // aaa, ccc, ddd, eee
    print(list);
    System.out.println("--------------------------");
    list.set(1, "ggg");
    print(list);
    list.set(0, "ppp");
    print(list);
    list.set(3, "qqq"); // ppp ggg ddd qqq
    print(list);
    System.out.println("--------------------------");
    print2(list.toArray());
  }

  static void print(YourLinkedList list) {
    for (int i = 0; i < list.size; i++) {
      System.out.print(list.get(i) + ", ");
    }
    System.out.println();
  }

  static void print2(Object[] arr) {
    for (Object obj : arr) {
      System.out.print(obj + ", ");
    }
    System.out.println();
  }
}
