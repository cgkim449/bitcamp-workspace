package com.eomcs.util.concurrent;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool01 {

  List<Worker> workers = new ArrayList<>();

  // 스레드 + 작업주고 깨움 + 작업끝나면 다시 잠
  class Worker extends Thread {

    Runnable task;

    public void setTask(Runnable task) {
      this.task = task;
      synchronized (this) {
        this.notify();
      }
    }

    @Override
    public void run() {

    }

  }

  // execute() 호출
  // 작업을 파라미터로 넘기면
  // 1 워커가 어레이리스트에 없으면 생성해서 스타트시키고
  // 2 있으면 그거 꺼냄
  // 워커.setTask() 파라미터에 다시 작업을 넘김
  // 넘기면 작업을 인스턴스 필드에 넣고
  // notify함
  public void execute(Runnable task) {
    Worker t;
    if (workers.size() == 0) {
      t = new Worker();
      t.start();
      try {
        Thread.sleep(20); // 워커가 cpu를 가질 수 있게 main을 잠시 sleep
      } catch (InterruptedException e) {
      }
    } else {
      t = workers.remove(0); // ArrayList의 remove(index) 복습
    }
    t.setTask(task);
  }
}

