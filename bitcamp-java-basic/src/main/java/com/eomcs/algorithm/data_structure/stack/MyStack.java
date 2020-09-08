package com.eomcs.algorithm.data_structure.stack;

import java.util.EmptyStackException;
import com.eomcs.algorithm.data_structure.linkedlist.MyLinkedList;

public class MyStack<E> extends MyLinkedList<E> implements Cloneable {

  public E push(E item) {
    add(item);
    return item;
  }

  public E pop() {
    if (this.size() == 0) {
      throw new EmptyStackException();
    }
    return remove(this.size() - 1);
  }

  public E peek() {
    if (this.size() == 0) {
      throw new EmptyStackException();
    }
    return this.get(this.size() - 1);
  }
  
  public boolean empty() {
    return this.size() == 0;
  }
  
  // 오버라이딩은 공개범위를 넓히는건되지만 좁히는건 안된다!
  @SuppressWarnings("unchecked")
  @Override
  public MyStack<E> clone() throws CloneNotSupportedException {
    // 새 스택을 만든다.
    MyStack<E> newStack = new MyStack<>();

    // 기존 스택의 값을 가져온다.
    Object[] values = this.toArray();

    // 기존 스택의 값을 새 스택에 넣는다.
    for(Object value : values) {
      newStack.push((E)value);
    }
    return newStack;
  }
}
