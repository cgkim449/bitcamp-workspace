package com.eomcs.algorithm.data_structure.linkedlist;

public class YourLinkedList {

  Node first;
  Node last;

  int size = 0;

  static class Node {
    Object value;
    Node next;

    public Node() {}
    public Node(Object e) {
      value = e;
    }
  }

  public boolean add(Object e) {
    Node node = new Node(e);
    if (first == null) {
      first = node;
    } else {
      last.next = node;
    }
    last = node;
    size++;
    return true;
  }

  public Object get(int index) {

    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("유효한 인덱스가 아닙니다");
    }
    Node cursor = first;

    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }

    return cursor.value;
  }

  public void add(Object e, int index) {


    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("유효한 인덱스가 아닙니다");
    }

    Node node = new Node(e);

    size++;

    if (index == 0) {
      node.next = first;
      first = node;
      return;
    }

    Node cursor = first;

    for (int i = 1; i < index; i++) {
      cursor = cursor.next;
    }

    node.next = cursor.next;
    cursor.next = node;

    if (node.next == null) {
      last = node;
    }
  }

  public Object remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("유효한 인덱스가 아닙니다");
    }
    size--;

    if (index == 0) {
      Node old = first;
      first = first.next;
      old.next = null;
      return old.value;
    }
    Node cursor = first;
    for (int i = 1; i < index; i++) {
      cursor = cursor.next;
    }
    Node old = cursor.next;
    cursor.next = cursor.next.next;
    old.next = null;
    if (cursor.next == null) {
      last = cursor;
    }
    return old.value;
  }

  public Object set(int index, Object e) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("유효한 인덱스가 아닙니다");
    }
    Node cursor = first;

    for (int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }
    Object old = cursor.value;
    cursor.value = e;

    return old;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size];
    Node cursor = first;
    int i = 0;
    while (cursor != null) {
      arr[i] = this.get(i++);
      cursor = cursor.next;
    }
    return arr;
  }
}