package com.eomcs.util;

import java.util.NoSuchElementException;

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

  //static nested class
  private static class ListIterator<E> implements Iterator<E> {

    List<E> list;
    int cursor; // 값을 꺼낼 위치를 가리킴

    public ListIterator(List<E> list) {
      this.list = list;
    }

    @Override
    public boolean hasNext() {
      return cursor < list.size();
    }

    @Override
    public E next() {
      if (cursor == list.size())
        throw new NoSuchElementException();
      return list.get(cursor++);
    }
  }

}
