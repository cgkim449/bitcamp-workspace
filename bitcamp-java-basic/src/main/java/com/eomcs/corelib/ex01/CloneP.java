// # 오버라이딩의 활용
// - protected 메서드를 오버라이딩해서 public으로 바꿔 공개할 수 있다(범위를 좁힐 수는 없다)

// 같은 일 다른 파라미터 같은 이름
// 다른 일 같은 파라미터 같은 이름

// 보호되있어서 난 못쓰니까 갖고와서 공개좀해줘라 - overriding
// 클론허락

// println은 무조건 String으로 출력한다

package com.eomcs.corelib.ex01;

public class CloneP {
  static class Engine implements Cloneable {
    int cc;
    int valve;

    @Override
    public Engine clone() throws CloneNotSupportedException {
      return (Engine) super.clone();
    }

    @Override
    public String toString() {
      return cc + " " + valve;
    }
    public Engine(int cc, int valve) {
      this.cc = cc;
      this.valve = valve;
    }
  }

  static class Car implements Cloneable {
    String maker;
    String name;
    Engine engine;
    public Car(String maker, String name, Engine engine) {
      this.maker = maker;
      this.name = name;
      this.engine = engine;
    }

    @Override
    public Car clone() throws CloneNotSupportedException {

       Car copy = (Car) super.clone();
      copy.engine = this.engine.clone();
      return copy;
    }
  }

  public static void main(String[] args) throws Exception {
    Engine engine = new Engine(3000, 16);
    Car car = new Car("비트자동차", "비트비트", engine);

    // 자동차 복제
    Car car2 = car.clone();

    System.out.println(car == car2);
    System.out.println(car);
    System.out.println(car2);
    System.out.println(car.engine == car2.engine);

    // car의 엔진과 car2의 엔진이 다른 엔진인지 확인해보자!
    car.engine.cc = 2000;
    System.out.println(car2.engine.cc);
  }

}