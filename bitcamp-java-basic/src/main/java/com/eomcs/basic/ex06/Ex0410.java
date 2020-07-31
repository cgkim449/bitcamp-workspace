package com.eomcs.basic.ex06;

import java.util.ArrayList;
import java.util.Date;

public class Ex0410 {
  public static void main(String[] args) {
    ArrayList<String> scores = new ArrayList<>();

    scores.add("오호라");
    scores.add("오호라");
    scores.add("오호라");
    scores.add("오호라");
    scores.add("오호라");
    scores.add("오호라");
    Date date = new Date();

    for (String value : scores) {
      System.out.println(value);
    }


  }
}