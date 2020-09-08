package com.eomcs.util;

public abstract class AbstractList<E> implements List<E> {

  protected int size;

  // 얘만 여기서 구현, 나머지는 얘의 서브클래스에서 하게끔
  @Override
  public int size() {
    return size;
  }
}
