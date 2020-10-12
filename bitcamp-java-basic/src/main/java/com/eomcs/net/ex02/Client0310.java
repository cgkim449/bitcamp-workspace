// 타입아웃 시간 설정하기
package com.eomcs.net.ex02;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Client0310 {
  public static void main(String[] args) throws Exception {
    Scanner keyScan = new Scanner(System.in);
    System.out.println("클라이언트 실행!");
    Socket socket = new Socket();
    System.out.println("소켓 생성됨.");

    SocketAddress socketAddress = new InetSocketAddress("localhost", 8888);
    // 3) 서버와의 연결을 시도한다.
    // => 타임아웃으로 지정된 시간 안에 서버와 연결되지 않으면 즉시 예외가 발생한다.
    // => Windows의 경우, 
    //    - 로컬에 접속할 때 타임아웃 설정이 정상적으로 동작되지 않는다.(확인 할 것!)
    //    - 원격 윈도우 PC에 서버를 실행하여 접속한다면 정상적으로 동작한다.
    //
    System.out.println("서버와 연결 중...");
    socket.connect(socketAddress, 10000); // timeout : milliseconds
    System.out.println("서버와 연결되었음!");

    keyScan.nextLine(); // 사용자가 엔터를 칠 때까지 다음 코드로 이동하지 않는다.

    socket.close();
    System.out.println("서버와의 연결을 끊었음.");

    keyScan.close();
  }
}


