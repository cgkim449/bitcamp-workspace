// stateless 에서 다중 클라이언트 요청 처리하기
package com.eomcs.net.ex04.stateless3;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class CalcServer {

  static Map<Long, Integer> resultMap = new HashMap<>();

  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중");
    ServerSocket ss = new ServerSocket(8888);

    while(true) {
      System.out.println("클라이언트의 연결을 기다림|");
      Socket socket = ss.accept();
      InetSocketAddress remoteAddr = (InetSocketAddress) socket.getRemoteSocketAddress();
      System.out.printf("클라이언트(%s:%d)가 연결되었음\n",
          remoteAddr.getAddress(), remoteAddr.getPort());
    }

  }

}


