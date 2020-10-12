package com.eomcs.io.ex09.step3;

import java.io.FileInputStream;

public class Exam0210 {
  public static void main(String[] args) throws Exception {
    BufferedInputStream in = new BufferedInputStream(
        new FileInputStream("temp/jls11.pdf"));

    int b;
    long startTime = System.currentTimeMillis();

    while ((b = in.read())!=-1);

    long endTime = System.currentTimeMillis();

    System.out.println(endTime - startTime);


    in.close();
  }
}
