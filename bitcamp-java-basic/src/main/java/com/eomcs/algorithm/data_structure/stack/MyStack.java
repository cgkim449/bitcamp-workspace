package com.eomcs.algorithm.data_structure.stack;

import java.util.EmptyStackException;
import com.eomcs.algorithm.data_structure.linkedlist.MyLinkedList;

// 배열을 사용하여 stack , queue를 구현하시오
public class MyStack extends MyLinkedList {

  public Object push(Object item) {
    add(item);
    return item;
  }

  public Object pop() {
    if (this.size() == 0) {
      throw new EmptyStackException();
    }
    return remove(this.size() - 1);
  }

  public Object peak() {
    if (this.size() == 0) {
      throw new EmptyStackException();
    }
    return this.get(this.size() - 1);
  }
}
