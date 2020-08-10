package com.eomcs.oop.ex04;

import java.util.Calendar;
import java.util.Date;

public class Practice {
  public static void main(String[] args) throws Exception {
    String s1 = new String("Hello");
    String s2 = new String("ABC가각");

    char c1 = s1.charAt(1);
    System.out.println(c1);

    char c2 = s2.charAt(1);
    System.out.println(c2);

    System.out.println(s1.compareTo(s2));

    System.out.println(s1.contains("ll"));
    System.out.println(s1.contains(s2));
    System.out.println(s1.equals(s2));

    System.out.println("------------------");
    byte[] bytes = s2.getBytes("MS949");

    for (byte b : bytes) {
      System.out.println(Integer.toHexString(b & 0xff));
    }

    System.out.println("-------------------");

    String s3 = String.format("%s님 방가방가", "홍길동");
    System.out.println(s3);

    String s4 = String.join(",", "홍길동","임","유");
    System.out.println(s4);

    String s5 = String.valueOf(true);
    String s6 = String.valueOf(100);
    String s7 = String.valueOf(3.14);

    System.out.printf("%s %s %s\n", s5, s6, s7);

    System.out.println(Math.abs(-100));
    System.out.println(Math.ceil(3.28));
    System.out.println(Math.floor(3.28));
    System.out.println(Math.round(3.14));
    System.out.println(Math.round(3.54));
    System.out.println(Math.pow(2, 7));

    Date d1 = new Date();
    System.out.println(d1.getYear() + 1900);
    System.out.println(d1.getMonth() + 1);
    System.out.println(d1.getDate());

    long millis = Date.parse("Sat, 12 August 1995 13:30:25 GMT");
    System.out.println(millis);

    java.sql.Date d2 = java.sql.Date.valueOf("2020-08-10");
    System.out.println(d2.getYear() + 1900);
    System.out.println(d2.getMonth() + 1);
    System.out.println(d2.getDate());

    long curr = System.currentTimeMillis();
    Date d3 = new Date(curr);
    System.out.println(d3.getYear()+1900);
    System.out.println(d3.getMonth()+1);
    System.out.println(d3.getDate());
    System.out.println("------------------------");
    Calendar cal = Calendar.getInstance();
    System.out.println(cal.get(1));
    System.out.println(cal.get(2)+1);
    System.out.println(cal.get(5));
    System.out.println(cal.get(7));
    System.out.println(cal.get(4));
    System.out.println(cal.get(10));
    System.out.println(cal.get(11));
    System.out.println(cal.get(12));
    System.out.println(cal.get(13));

    System.out.println(cal.get(Calendar.YEAR));
    System.out.println(cal.get((Calendar.MONTH)+1));
    System.out.println(cal.get(Calendar.DATE));
    System.out.println(cal.get(Calendar.DAY_OF_WEEK));
    System.out.println(cal.get(Calendar.WEEK_OF_MONTH));
    System.out.println(cal.get(Calendar.HOUR));
    System.out.println(cal.get(Calendar.HOUR_OF_DAY));
    System.out.println(cal.get(Calendar.MINUTE));
    System.out.println(cal.get(Calendar.SECOND));

    Integer i1 = new Integer(100);
    Integer i2 = new Integer(100);

    System.out.println(i1.toString());
    System.out.println(i2.toString());
    System.out.println(i1 == i2);

    Integer i3 = Integer.valueOf(100);
    Integer i4 = Integer.valueOf(100);

    System.out.println(i3.toString());
    System.out.println(i4.toString());
    System.out.println(i3 == i4);


  }
}