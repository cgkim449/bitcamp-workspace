//쓰지않는 인스턴스의 주소를 제거하여 가비지가 될 수 있게 한다!

// 왜 linked list가 필요한지
package com.eomcs.corelib.ex03;

public class MyArrayList {
  private Object[] elementData = new Object[5];
  private int size;

  public boolean add(Object e) {
    if (size == elementData.length) {
      grow();
    }
    elementData[size++] = e;
    return true;
  }

  private void grow() {
    System.out.println("오 배열을 늘리자");
    Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
    for (int i = 0; i < elementData.length; i++) {
      newArray[i] = elementData[i];
    }
    elementData = newArray;
  }

  public void add(int index, Object element) {
    if (size == elementData.length) {
      grow();
    }
    if (index < 0 || index > size) {
      throw new ArrayIndexOutOfBoundsException("인덱스가 유효하지 않습니다");
    }
    for (int i = size; i > index ; i--) {
      elementData[i] = elementData[i-1];
    }
    elementData[index] = element;
    size++;
  }

  public Object get(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("인덱스가 유효하지 않습니다");//
    }
    return elementData[index];
  }

  public Object set(int index, Object element) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("인덱스가 유효하지 않습니다");
    }
    Object old = elementData[index];
    elementData[index] = element;
    return old;
  }

  public Object remove(int index) {
    Object old = elementData[index];
    for (int i = index; i < size - 1 ; i++) {
      elementData[i] = elementData[i+1];
    }
    size--;
    elementData[size] = null; //쓰지않는 인스턴스의 주소를 제거하여 가비지가 될 수 있게 한다!
    return old;
  }

  public int size() {
    return this.size;
  }
}