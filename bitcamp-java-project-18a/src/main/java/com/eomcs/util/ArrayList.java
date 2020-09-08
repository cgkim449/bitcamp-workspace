package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> { // Object[]의 Box 근데 + size, DEFAULT_CAPACITY 

  private static final int DEFAULT_CAPACITY = 3;
  private Object[] elementData; // 의존객체의 배열이다! (의존객체 Object)
  private int size = 0;

  public ArrayList() {
    elementData = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int initialCapacity) {
    if (initialCapacity <= DEFAULT_CAPACITY) {
      elementData = new Object[DEFAULT_CAPACITY];
    } else {
      elementData = new Object[initialCapacity];
    }
  }

  public boolean add(E e) {
    if (size == elementData.length) {
      grow();
    }
    elementData[size++] = e;
    return true;
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] a) { // E[]이거 줄테니까 여기다가 내용물 그대로 복사해주세요
    // 아 그리고 배열 길이는 size만큼만요
    if (a.length < this.size) {
      // 배열의 형변환은 단순한게 아닌거같아
      // 배열 getClass()해서 클래스정보까지 넘겼는데 형변환을 또해야되
      // 그니까 클래스정보넘기는 Arrays.copyOf 이거로 배열 카피해도
      // Object[]가 리턴되네
      return (E[]) Arrays.copyOf(this.elementData, this.size, a.getClass());
    }
    System.arraycopy(this.elementData, 0, a, 0, this.size); // length 보다 작으면 이렇게 못하네
    return a;
  }

  // E[] 파라미터로 받을 필요 없이 그냥 알아서 만들어서 리턴해줌
  // 근데 이거 안쓰고 왜 위에껄 쓰지
  // 아무튼 2가지 방법이 있음
  // 아니 근데 이거는 형변환 안하네??
  // getClass로 받으면 형변환 해야되는데
  // .class로 받으면 형변환 안하네
  //    public E[] toArray(Class<E[]> arrayType) {
  //      return Arrays.copyOf(elementData, size, arrayType);
  //    }

  public void grow(){
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    elementData = Arrays.copyOf(elementData, newCapacity);    
  }

  public void add(int index, E element) {

    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("무효한 인덱스다");
    }

    if (size == elementData.length) {
      grow();
    }

    // 1. 꼼꼼하게 차근차근(뒤에서 부터다)
    // 2. index size 헷갈리지말자
    for (int i = size ; i > index; i--) {
      elementData[i] = elementData[i - 1];
    }
    elementData[index] = element;
    size++;
  }

  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("유효한 인덱스가 아닙니다");
    }
    return (E)elementData[index];
  }

  @SuppressWarnings("unchecked")
  public E set(int index, E e) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("유효한 인덱스가 아닙니다");
    }
    Object old = elementData[index];
    elementData[index] = e;
    return (E) old;
  }

  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("유효한 인덱스가 아닙니다");
    }
    Object old = elementData[index];

    //Object가 들어가야되는데 Object[]도 들어가지네
    System.arraycopy(
        elementData, // 복사 대상
        index + 1, // 복사할 항목의 시작 인덱스
        elementData, // 목적지
        index, // 복사 목적지 인덱스
        this.size - (index + 1)); // 복사할 항목의 개수
    //    for (int i = index ; i < size - 1; i++) {
    //      elementData[i] = elementData[i + 1]; 
    //    }

    size--;
    elementData[size] = null;
    // 쓰지 않는 객체의 주소를 제거하여 가비지가 될 수 있게 한다

    return (E) old;
  }

  public int size() {
    return this.size;
  }

  public Object[] toArray() { // 얘는 굳이 왜만들어지 Object[]을? 지금 제네릭인데?
    // 얘로 Object[]를 리턴해서 E[]로 형변환하면 간단하지않나?
    // 배열은 형변환이 안되는건가?
    // 왜 굳이 E[] 리턴하는 toArray(), Object[] 리턴하는 toArray() 두개를 만드는거지?
    return Arrays.copyOf(elementData, this.size);
  }
}




