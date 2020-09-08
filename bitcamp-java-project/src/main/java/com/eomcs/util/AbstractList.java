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
    class ListIterator<T> implements Iterator<T> {
      int cursor;

      @Override
      public boolean hasNext() {
        return cursor < AbstractList.this.size();
      }

      @SuppressWarnings("unchecked")
      @Override
      public T next() {
        //
        if (cursor ==  /*AbstractList.this.*/size())
          throw new NoSuchElementException();

        return (T) /*AbstractList.this.*/get(cursor++);
      }
    }
    return new ListIterator<E>();
  }
}
