package com.eomcs.algorithm.data_structure.queue;

import com.eomcs.algorithm.data_structure.linkedlist.MyLinkedList;

//Queue를 구현하기 위해 기존에 작성한 MyLinkedList를 상속 받는다
public class MyQueue extends MyLinkedList {

  public boolean offer(Object e) {
    return this.add(e);
  }

  public Object poll() {
    if (size() == 0) {
      return null;
    }
    return remove(0); // head
  }

  public Object peak() {
    if (size() == 0) {
      return null;
    }
    return get(0); // head
  }
}