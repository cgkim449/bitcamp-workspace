// 스레드의 생명주기(lifecycle) - running 상태 : CPU 쟁탈전(racing)
package com.eomcs.concurrent.ex4;

public class Exam140 {
  public static void main(String[] args) {

    class MyThread extends Thread {
      public MyThread(String name) {
        super(name);
      }
      @Override
      public void run() {
        for (int i = 0; i < 1000; i++) {
          System.out.printf("%s %d\n", this.getName(), i);
        }
      }
    }

    MyThread t1 = new MyThread("kim==>");
    MyThread t2 = new MyThread("lee------>");
    MyThread t3 = new MyThread("son###");

    t1.start();
    t2.start();
    t3.start();

    for (int i = 0; i < 1000; i++)
      System.out.printf("main 스레드 : %d\n", i);

  }
}

