// 걍 offer, poll 달려있는 linkedlist임
package com.eomcs.algorithm.data_structure.queue;

import com.eomcs.algorithm.data_structure.linkedlist.MyLinkedList;

public class YourQueue extends MyLinkedList {
  public boolean offer(Object e) {
    return add(e);
  }

  public Object poll() {
   if (size() == 0) {
     return null;
   }
    return remove(0);
  }

  public Object peek() {
    if (size() == 0) {
      return null;
    }
    return get(0);
  }
}
