// 클라이언트와 입출력 테스트 - byte stream + try with resources 문법
// close() 쓰는거 귀찮아서 이문법을 사용한다
// AutoCloseable 인터페이스를 구현한 자원들만 이 문법을 사용가능하다
// finally가 필요없다 : try를 벗어나기전에 전부 close() 한다

package com.eomcs.net.ex03;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server0111 {
  public static void main(String[] args) {

    try (Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888);) {

      System.out.println("클라이언트의 연결을 기다리고 있음.");

      try (Socket socket = serverSocket.accept();
          OutputStream out = socket.getOutputStream();
          InputStream in = socket.getInputStream();)
      {
        System.out.println("대기열에서 클라이언트 정보를 꺼내 소켓을 생성하였음.");
        System.out.println("클라이언트와 통신할 입출력 스트림이 준비되었음.");
        System.out.println("클라이언트가 보낸 1바이트를 기다리고 있음!");

        int request = in.read(); // blocking 모드로 작동한다.

        System.out.println(request);

        System.out.print("데이터를 보내기 전에 잠깐!");
        keyboard.nextLine();

        out.write(request);
        System.out.println("클라인트에게 데이터를 보냈음.");

      } catch (Exception e) {
        e.printStackTrace();

      } 
    } catch (Exception e) {
      e.printStackTrace();

    } 
    System.out.println("서버 종료!");
  }

}

