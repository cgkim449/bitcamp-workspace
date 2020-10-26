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
          if (ThreadPool.this.stopping) { // 스레드풀이 종료 상태라면,
            // 스레드는 깨어나는 즉시 실행을 멈춘다.
            break;
          }
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
    if (stopping) {
      throw new RuntimeException("스레드풀이 종료 상태입니다!");
    }
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

  public void shutdown() {
    try {
      this.stopping = true;

      while (!workers.isEmpty()) { // 스레드풀에 대기 중인 스레드가 있다면,
        Worker worker = workers.remove(0); // 맨 앞에 있는 스레드를 꺼내서
        synchronized (worker) {
          worker.notify(); // 스레드를 깨운다.
          // 스레드는 깨어나면 stopping 상태에 따라 종료 여부를 결정하도록 프로그래밍 되어 있다.
          // => Worker 스레드를 코드를 보라!
        }
      }

      // 스레드풀에서 대기하지 않고 현재 작업을 수행하는 스레드가 있을 수 있다.
      // 그 스레드가 작업을 끝낼 때까지 좀 기다리자.
      Thread.sleep(2000);

      // 다시 한 번 대기하고 있는 스레드를 종료해 보자!
      while (!workers.isEmpty()) { // 스레드풀에 대기 중인 스레드가 있다면,
        Worker worker = workers.remove(0); // 맨 앞에 있는 스레드를 꺼내서
        synchronized (worker) {
          worker.notify(); // 스레드를 깨운다.
          // 스레드는 깨어나면 stopping 상태에 따라 종료 여부를 결정하도록 프로그래밍 되어 있다.
          // => Worker 스레드를 코드를 보라!
        }
      }

    } catch (Exception e) {
      System.out.println("스레드풀을 종료하는 중에 예외 발생!");
      e.printStackTrace();
    }
  }
}

