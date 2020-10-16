package com.eomcs.pms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import com.eomcs.util.Prompt;

public class ClientApp01 {

  static String host;
  static int port;

  public static void main(String[] args) {

    if (args.length != 2) {
      System.out.println("프로그램 사용법:");
      System.out.println(" java -cp ... ClientApp 서버주소 포트번호");
      System.exit(0);
    }

    host = args[0];
    port = Integer.parseInt(args[1]);

    while(true) {

      String input = Prompt.inputString("명령> ");
      if (input.equalsIgnoreCase("quit")) {
        break;
      }
      request(input);

      if (input.equalsIgnoreCase("stop"))
        break;
    }
    System.out.println("안녕!");




  }

  private static void request(String message) {
    boolean stop = false;
    try (Socket socket = new Socket(host, port);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {


      out.println(message);
      out.flush();

      receiveResponse(out, in);

      if(message.equalsIgnoreCase("stop")) {
        stop = true;
      }


    } catch (Exception e) {
      e.printStackTrace();
    }

    if(stop) {
      try(Socket socket = new Socket(host, port)){

      }catch(Exception e) {

      }
    }

  }

  private static void receiveResponse(PrintWriter out, BufferedReader in) throws Exception {
    while(true) {
      String response = in.readLine();
      if (response.length() == 0) {
        break;
      }
      else if (response.equals("!{}!")) {
        // 사용자로부터 입력을 받아 서버로 보낸다
        out.println(Prompt.inputString(""));
        out.flush();
      } else {
        System.out.println(response);
      }
    }
  }
}
