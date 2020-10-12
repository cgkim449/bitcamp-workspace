package com.eomcs.io.ex09.step3;

import java.io.FileOutputStream;

public class Exam0110 {
  public static void main(String[] args) throws Exception {
    FileOutputStream fileOut = new FileOutputStream("temp/test6.data");
    DataOutputStream out = new DataOutputStream(fileOut);

  }
}
