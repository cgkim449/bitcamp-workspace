package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> {

  // static 상수 DEFAULT_CAPACITY
  static final int DEFAULT_CAPACITY = 3;

  // instance 변수 Object배열, size

  // ArrayList는 Object배열이란걸 잊지말자, E타입만 다룬다고 해서 E배열로 선언하는게 아님
  Object[] list; 
  int size = 0;

  // 생성자로 의존객체 주입 : 바깥에서 생성자 호출하면 생성자 안의 new 의존객체 코드
  public ArrayList() {
    // 제네릭 배열은 생성(new) 할 수 없다
    list = new Object[DEFAULT_CAPACITY];
  }

  // 생성자로 의존객체 주입 : initialCapacity를 파라미터로 받아서
  // DEFAULT_CAPACITY보다 작거나 같으면 DEFAULT_CAPACITY 크기(=3)인 Object배열 생성
  // DEFAULT_CAPACITY보다 크면 initialCapacity 크기인 Object배열 생성
  public ArrayList(int initialCapacity) {
    if (initialCapacity <= DEFAULT_CAPACITY) {
      list = new Object[DEFAULT_CAPACITY];
    } else {
      list = new Object[initialCapacity];
    }
  }

  // 의존객체를 파라미터로 받아서 Object배열에 넣는다
  // 그 의존객체의 타입을 E로 제한하고 싶다
  public void add(E e) {
    // add할수록 size++되는데
    // 만약 현재 size값이 Object배열 length랑 같으면 배열 length를 늘려야지 
    // 즉, 현재 배열에 객체가 꽉 찼으면, 배열을 늘린다.
    if (size == list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);

      //      Object[] arr = new Object[newCapacity];
      //      for (int i = 0; i < list.length; i++) {
      //        arr[i] = list[i];
      //      }
      //      list = arr;

      // 근데이건 의존객체는 아니잖아? 그냥 의존클래스지 이거도 의존객체라고 하나?
      // 그럼 대충 의존 클래스는 static 메서드 쓸때
      // 의존 객체는 instance 메서드 쓸때?

      // T[]을 길이 newCapacity로 카피하여 T[]리턴
      // 그럼 앞에부터 다 채워지고 뒤에 나머지는 null로 되는듯?
      list = Arrays.copyOf(list, newCapacity);
      System.out.printf("==> 새 배열을 %d 개 생성하였음!\n", newCapacity);
    }

    // list[size] = e를 하고 size++
    list[size++] = e;
  }
  // ------------------------------------------------
  //  @SuppressWarnings("unchecked")
  //  public E[] toArray() {
  //    //    Object[] arr = new Object[size];
  //    //    for (int i = 0; i < size; i++) {
  //    //      arr[i] = list[i];
  //    //    }
  //    //    return arr;
  //
  //    return (E[]) Arrays.copyOf(list, size);
  //  }
  // 이거 아니다.... (E[]) Arrays.copyOf(list, size); 이게 이상한건가
  // 이거랑 밑에의 차이점은 뭐지

  // Class<E[]> arrayType : E배열의 타입정보(클래스 정보?, 배열이라 타입정보라 하는건가?)
  // 아규먼트는 .class랑 getClass()인가?
  public E[] toArray(Class<E[]> arrayType) {
    // Object배열을 size 길이의 E배열로 카피하고 싶다
    // 이게 배열을 형변환하는 거 아닌가

    // Object[] 배열이 아닌 임의 타입 배열을 만들어 복사하려면 
    // Arrays.copyOf() 를 호출할 때 반드시 배열의 타입 정보를 넘겨야 한다.
    // 이를 위해 toArray() 메서드에서 배열의 타입 정보를 받을 수 있도록 파라미터를 선언한다.
    return Arrays.copyOf(list, size, arrayType);
  }
}




