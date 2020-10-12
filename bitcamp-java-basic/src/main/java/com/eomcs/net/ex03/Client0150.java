// 서버와 입출력 테스트 - byte stream
package com.eomcs.net.ex03;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client0150 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);

    try (Socket socket = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream())) {
      // printStream은 데코레이터, 그래서 다른거도 붙일 수 있다
      // Scanner는 데코레이터 아님, InputStream 이 아님.
      // 데코레이터는 아니지만 nextLine()이 있어서 마치 데코레이터처럼 편하게 쓸 수 있다
      // 


      System.out.println("서버와 연결되었음!");

      // 서버에 데이터를 보내기 전에 잠깐 멈춤!
      System.out.print(">");
      keyScan.nextLine();

      out.println("ABC가각간");
      // out.flush();
      // byte stream 을 사용할 때는 바로 출력한다.
      // 따라서 flush()를 호출하지 않아도 된다.
      System.out.println("서버에 데이터를 보냈음!");

      String str = in.nextLine();
      System.out.println(str);

    } catch (Exception e) {
      e.printStackTrace();
    }

    keyScan.close();
  }
}


