package com.eomcs.io.ex06;

public class Exam0110 {
  public static void main(String[] args) throws Exception {
    BufferedInputStream in = new BufferedInputStream("temp/jls11.pdf");
    BufferedOutputStream out = new BufferedOutputStream("temp/jls11_3.pdf");

    byte[] buf = new byte[8192]; // 보통 8KB 정도 메모리를 준비한다.
    int len = 0;

    long startTime = System.currentTimeMillis(); // 밀리초

    while ((len = in.read(buf)) != -1)
      out.write(buf, 0, len);

    long endTime = System.currentTimeMillis();

    System.out.println(endTime - startTime);

    in.close();
    out.close();
  }
}
