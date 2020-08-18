package com.eomcs.algorithm.data_structure.queue;

public class YourTest {
  public static void main(String[] args) {
    YourQueue queue = new YourQueue();
    queue.offer("aaa");
    print(queue);
    queue.offer("bbb");
    print(queue);
    queue.offer("ccc");
    print(queue);
    System.out.println(queue.peek());
    System.out.println(queue.poll());
    print(queue);
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.peek());
  }

  static void print(YourQueue queue) {
    for (int i = 0; i < queue.size(); i++) {
      System.out.print(queue.get(i) + ", ");
    }
  }
}
