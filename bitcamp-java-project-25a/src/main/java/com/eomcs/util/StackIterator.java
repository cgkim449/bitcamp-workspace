package com.eomcs.util;

import java.util.NoSuchElementException;

public class StackIterator<E> implements Iterator<E> {

  Stack<E> stack;

  public StackIterator(Stack<E> stack) {
    this.stack = stack; // Stack 객체 하나 받아서 레퍼런스에 연결
  }

  @Override
  public boolean hasNext() {
    return !stack.empty();
  }

  @Override
  public E next() {
    if (stack.empty()) 
      throw new NoSuchElementException();
    return stack.pop();
  }


}
