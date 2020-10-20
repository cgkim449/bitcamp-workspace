package com.eomcs.util.concurrent;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {

  //스레드풀의 종료 상태
  boolean stopping = false;

  List<Worker> workers = new ArrayList<>();

  // 스레드 + 작업주고 깨움 + 작업끝나면 돌아감
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
      // 워커는 스타트 상태이다
      //    - 1 생성해서 스타트 시키거나
      //    - 2 원래 있었던 애들은 스타트 상태?
      // cpu를 받으면 런한다?
      // 언제 cpu를 받을지 모른다 wait시켜놓자
      while(true) {
        try {
          this.wait();
        } catch (InterruptedException e) {
          break; // 대기하고 있는데 인터럽트 예외 발생하면 스레드 종료시키자
        }
        try {
          task.run();
        } catch (Exception e) {
          // 작업하는데 예외 발생해도 스레드 종료시키지말고 유효하게 하자
        } finally {
          workers.add(this); // 작업 끝나면 스레드풀로 돌아가자
        }
      }
    }

  }

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

