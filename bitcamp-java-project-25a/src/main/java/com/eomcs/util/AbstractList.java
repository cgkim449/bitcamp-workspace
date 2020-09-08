package com.eomcs.util;

public abstract class AbstractList<E> implements List<E>{

  protected int size;

  @Override
  public int size() {
    return size;
  }

  @Override
  public Iterator<E> iterator() {
    return new ListIterator<E>(this);
  }

}
