

package com.eomcs.oop.ex05.d;

public class Sedan extends Car {
  boolean sunroof;
  boolean auto;

  public Sedan() {}

  public Sedan(String model, String maker, int capacity, boolean sunroof, boolean auto) {
    super(model, maker, capacity);
    this.sunroof = sunroof;
    this.auto = auto;
  }
}
