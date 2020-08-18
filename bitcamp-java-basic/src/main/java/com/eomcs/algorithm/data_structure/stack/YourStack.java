package com.eomcs.algorithm.data_structure.stack;

import java.util.EmptyStackException;
import com.eomcs.algorithm.data_structure.linkedlist.MyLinkedList;

public class YourStack extends MyLinkedList {
  public Object push(Object e) {
    add(e);
    return e;
  }

  public Object pop() {
    if (this.size() == 0) {
      throw new EmptyStackException();
    }
    return remove(this.size() - 1);
  }
}
