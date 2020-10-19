package com.eomcs.concurrent.ex7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam0230 {

  static class MyRunnable implements Runnable {
    long millisec;

    public MyRunnable(long millisec) {
      this.millisec = millisec;
    }

    @Override
    public void run() {
      try {
        System.out.printf("%s 스레드 실행중\n", Thread.currentThread().getName());
        Thread.sleep(millisec);
        System.out.printf("%s 스레드 종료\n", Thread.currentThread().getName());
      } catch (InterruptedException e) {
        System.out.printf("%s 스레드 실행중 오류발생", Thread.currentThread().getName());
      }
    }
  }

  public static void main(String[] args) throws Exception {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    executorService.execute(new MyRunnable(4000));
    executorService.execute(new MyRunnable(6000));
    executorService.execute(new MyRunnable(2000));
    executorService.execute(new MyRunnable(9000));
    executorService.shutdown();
    System.out.println("main() 종료");

  }
}
