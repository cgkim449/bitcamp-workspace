// stateless 방식에서 클라이언트를 구분하고 작업 결과를 유지하는 방법
package com.eomcs.net.ex04.stateless2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class CalcServer {

  static Map<Long, Integer> resultMap = new HashMap<>();

  // 각 클라이언트의 작업 결과를 보관할 맵 객체
  // => Map<clientID, result>

  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중...");

    ServerSocket ss = new ServerSocket(8888);

    while (true) {
      Socket socket = ss.accept();
      System.out.println("클라이언트 요청 처리!");
      try {
        processRequest(socket);
      } catch (Exception e) {
        System.out.println("클라이언트 요청 처리 중 오류 발생!");
        System.out.println("다음 클라이언트의 요청을 처리합니다.");
      }
    }
    // ss.close();
  }

  static void processRequest(Socket socket) throws Exception {

    try (Socket socket2 = socket;
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream())){

      long clientId = in.readLong();
      String op = in.readUTF();
      int value = in.readInt();

      Integer obj = resultMap.get(clientId);
      int result = 0;

      if (obj == null) {
        System.out.println("신규고객처리");
        clientId = System.currentTimeMillis();
      } else {
        result = obj;
      }

    }
  }
}


