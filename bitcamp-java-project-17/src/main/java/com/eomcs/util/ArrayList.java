// 제네릭은 단순히 '변수'에 넣을 거의 타입을 제한하는게 아니라
// '메서드'가 다룰(파라미터의 타입, 리턴값의 타입) 값의 타입을 제한할때도 사용하는 문법!
// 즉, 클래스가 특정 타입 객체와 그 하위타입 객체만 다루고 싶을때 제네릭을 사용

package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> {

  static final int DEFAULT_CAPACITY = 3;
  Object[] list;
  int size = 0;

  public ArrayList() {
    list = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int initialCapacity) {
    if (initialCapacity <= DEFAULT_CAPACITY) {
      list = new Object[DEFAULT_CAPACITY];
    } else {
      list = new Object[initialCapacity];
    }
  }

  public void add(E e) {
    if (size == list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);

      list = Arrays.copyOf(list, newCapacity);
      System.out.printf("==> 새 배열을 %d 개 생성하였음!\n", newCapacity);
    }
    list[size++] = e;
  }

  public E[] toArray(Class<E[]> arrayType) {
    return Arrays.copyOf(list, size, arrayType);
  }
}




