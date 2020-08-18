package com.eomcs.corelib.ex08;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class P {
  public static void main(String[] args) {
    Member v1 = new Member("홍길동", 20);
    Member v2 = new Member("임꺽정", 30);
    Member v3 = new Member("유관순", 16);
    Member v4 = new Member("안중근", 20);
    Member v5 = new Member("윤봉길", 25);

    HashMap map = new HashMap();

    map.put("s01", v1);
    map.put("s02", v2);
    map.put("s03", v3);
    map.put("s04", v4);
    map.put("s05", v5);

    Set keys = map.keySet();
    Iterator iterator = keys.iterator();

    map.remove("s01");
    map.remove("s02");
    map.remove("s03");


    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
