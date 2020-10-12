// 대기열 테스트
package com.eomcs.net.ex02;

import java.net.ServerSocket;
import java.util.Scanner;

public class Server0210 {
  public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);

    System.out.println("서버 실행");

    // => 대기열을 초과하여 클라이언트 요청을 들어 왔을 때 서버는 응답하지 않는다.
    // 클라이언트는 내부에 설정된 시간(timeout)동안 기다리다 응답을 받지 못하면
    // 예외를 던지고 연결 요청을 취소한다.
    // => new ServerSocket(포트번호, 대기열크기);
    // 다음과 같이 대기열의 개수를 지정하지 않으면, 기본이 50개이다.
    //
    ServerSocket ss = new ServerSocket(8888);
    System.out.println("서버 소켓 생성 완료!");
    System.out.println("클라이언트 연결을 기다리는 중...");

    // 잠깐 멈추기
    // => 클라이언트가 접속하게 하라!
    // => 최대 몇 개까지 접속 가능한가?
    keyboard.nextLine();

    ss.close();
    System.out.println("서버 종료!");

    keyboard.close();
  }
}


