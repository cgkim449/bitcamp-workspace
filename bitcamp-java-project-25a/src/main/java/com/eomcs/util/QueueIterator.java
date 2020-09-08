package com.eomcs.util;

import java.util.NoSuchElementException;

public class QueueIterator<E> implements Iterator<E> {

  Queue<E> queue;

  public QueueIterator(Queue<E> queue) {
    this.queue = queue; // Stack 객체 하나 받아서 레퍼런스에 연결
    // 아니 그 큐를 써야지 우리가 생성하면 어떻게해 이양반아
  }

  @Override
  public boolean hasNext() {
    //    return !stack.empty(); // queue는 empty가 없다
    return queue.size() != 0;
  }

  @Override
  public E next() {
    if (queue.size() == 0)
      throw new NoSuchElementException("없어");
    return queue.poll();
  }


}
