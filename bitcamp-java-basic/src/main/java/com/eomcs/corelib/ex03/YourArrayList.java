package com.eomcs.corelib.ex03;

public class YourArrayList {
  static Object[] elementData = new Object[5];
  static int size;

  public static boolean add(Object e) {
    if (elementData.length == size) {
      Object[] newData = new Object[size+1];
      for (int i = 0; i < size; i++) {
        newData[i] = elementData[i];
      }
      elementData = newData;
    }
    elementData[size++] = e;
    return true;
  }

  public static Object get(int index) {
    return elementData[index];
  }

  public static void add(int index, Object e) {
    if (index < 0 || index > size) {
      throw new ArrayIndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }
    if (elementData.length == size) {
      Object[] newData = new Object[size+1];
      for (int i = 0; i < size; i++) {
        newData[i] = elementData[i];
      }
      elementData = newData;
    }
    for (int i = size; i >= index; i--) {
      elementData[i] = elementData[i-1];
    }
    elementData[index] = e;
    size++;
  }

  public static Object set(int index, Object e) {
    Object old = elementData[index];
    elementData[index] = e;
    return old;
  }

  public static Object remove(int index) {
    Object old = elementData[index];
    for (int i = index; i < size-1; i++) {
      elementData[i] = elementData[i+1];
    }
    size--;
    return old;
  }
}
