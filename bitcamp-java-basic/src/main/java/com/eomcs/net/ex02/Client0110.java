// 클라이언트 만들기
package com.eomcs.net.ex02;

import java.net.Socket;

public class Client0110 {

  public static void main(String[] args) throws Exception {
    // 1) 서버에 연결 요청을 할 때 사용할 도구를 준비한다.
    // => 서버와의 연결이 이루어지면 Socket 객체를 리턴한다.
    // => 클라이언트 측의 포트 번호는 OS가 자동으로 부여한다.
    //    서버 측은 개발자가 명시적으로 부여해야 한다.
    Socket socket = new Socket("localhost", 8888);
    System.out.println("서버와 연결되었음!");

    socket.close();
    System.out.println("서버와 연결을 끊었음!");
  }

}


