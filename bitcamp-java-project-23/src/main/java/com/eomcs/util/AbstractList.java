package com.eomcs.util;

public abstract class AbstractList<E> {
  private int size = 0; // 똑같은 변수

  public int size() { // 완전히 똑같은 메서드
    return this.size;
  }

  // 추상메서드 : 공통된 메서드 시그너처만(파라미터, 리턴, 메서드명) 이렇게 냅둘테니까
  // 서브클래스 너네가 알아서 오버라이딩해라
  public abstract boolean add(E e); 
  public abstract E get(int index);
  public abstract void add(int index, E element);
  public abstract E remove(int index);
  public abstract E set(int index, E element);
  public abstract Object[] toArray();
  public abstract E[] toArray(E[] arr);

}
