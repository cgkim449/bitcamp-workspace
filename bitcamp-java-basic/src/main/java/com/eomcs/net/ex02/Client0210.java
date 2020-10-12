// 대기열의 제한 확인하기
package com.eomcs.net.ex02;

import java.net.Socket;
import java.util.Scanner;

public class Client0210 {
  public static void main(String[] args) throws Exception {
    Scanner keyScan = new Scanner(System.in);
    System.out.println("클라이언트 실행!");

    Socket socket = new Socket("localhost", 8888);
    System.out.println("서버에 연결됨!");
    // 대기열에 대기
    // 서버에서 연결이 승인되면, 비로서 입출력을 할 수 있다.

    keyScan.nextLine();
    socket.close();
    System.out.println("서버와의 연결을 끊었음.");

    keyScan.close();
  }
}


