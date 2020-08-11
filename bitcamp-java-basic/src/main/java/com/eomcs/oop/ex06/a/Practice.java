// 다형성 - 다형적 변수(polymorphic variables)

package com.eomcs.oop.ex06.a;

public class Practice {

  public static void print(Vehicle v) {
    System.out.println("[기본정보]");
    System.out.printf("모델명: %s\n", v.model);
    System.out.printf("수용인원: %d\n", v.capacity); // 일단은 여기까지가 앞에서 한거

    if (v instanceof Car) {
      Car car = (Car)v;
      System.out.printf("%d, %d", car.cc, car.valve);
      if (v instanceof Sedan) {
        Sedan sedan = (Sedan)v;
        System.out.printf("%b, %b", sedan.auto, sedan.sunroof);
      } else if (v instanceof Truck) {

      }
    } else if (v instanceof Bike) {

    }
  }
  public static void main(String[] args) {
    Bike bike = new Bike();
    bike.model = "비트오토바이2018";
    bike.capacity = 2;
    bike.engine = true;

    Sedan sedan = new Sedan();
    sedan.model = "티코";
    sedan.capacity = 5;
    sedan.cc = 800;
    sedan.valve = 16;
    sedan.auto = true;
    sedan.sunroof = true;

    Truck truck = new Truck();
    truck.model = "타이탄II";
    truck.capacity = 3;
    truck.cc = 10000;
    truck.valve = 32;
    truck.dump = true;
    truck.ton = 15;

    print(bike);

    print(sedan);

    print(truck);
  }
}
