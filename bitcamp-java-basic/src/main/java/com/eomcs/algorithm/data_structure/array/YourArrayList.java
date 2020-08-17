package com.eomcs.algorithm.data_structure.array;

import java.util.Arrays;

public class YourArrayList{
  private static final int DEFAULT_CAPACITY = 5;
  private Object[] elementData = new Object[DEFAULT_CAPACITY];
  private int size;

  public YourArrayList() {
    elementData = new Object[DEFAULT_CAPACITY];
  }

  public YourArrayList(int initialCapacity) {
    if (initialCapacity < 0) {
      throw new IndexOutOfBoundsException("유효하지 않은 길이입니다");
    }
    if (initialCapacity < DEFAULT_CAPACITY) {
      elementData = new Object[DEFAULT_CAPACITY];
    } else {
      elementData = new Object[initialCapacity];
    }
  }

  public boolean add(Object e) {
    if (elementData.length == size) {
      elementData = Arrays.copyOf(elementData, elementData.length + (elementData.length >> 1));
      // 원래 배열을 길이를 늘리고 카피한다
    }
    elementData[size++] = e;
    return true;
  }

  public void add(int index, Object e) {

    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("유효하지않은 인덱스다");
    }

    if (size == elementData.length) {
      elementData = Arrays.copyOf(elementData, elementData.length + (elementData.length >> 1));
    }

    for (int i = size - 1; i >= index; i--) {
      elementData[i+1] = elementData[i];
    }

    elementData[index] = e;
    size++;
  }

  public Object remove(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("유효하지않은 인덱스다");
    }
    Object old = elementData[index];
    System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
//    for (int i = index; i < size - 1; i++) {
//      elementData[i] = elementData[i + 1];
//    }
    size--;
    return old;
  }

  public Object set(int index, Object e) {
    if (index < 0 || index > size) { // cannot make a static reference to the non-static field size
      throw new IndexOutOfBoundsException("유효하지않은 인덱스다");
    }
    Object old = elementData[index];
    elementData[index] = e;

    return old;
  }

  public Object get(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("유효하지않은 인덱스다");
    }
    return elementData[index];
  }

  public Object toArray() {
//    Object[] arr = new Object[size];
//    for (int i = 0; i < size; i++) {
//      arr[i] = elementData[i];
//    }
    return Arrays.copyOf(elementData, size);
  }
}
