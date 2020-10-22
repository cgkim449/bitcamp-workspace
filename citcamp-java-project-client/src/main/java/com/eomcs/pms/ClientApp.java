package com.eomcs.pms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import com.eomcs.util.Prompt;

public class ClientApp {
  public static void main(String[] args){

    if (args.length != 2) {
      System.out.println("프로그램 사용법");
      System.out.println("java -cp bin/main com.eomcs.pms.ClientApp 서버주소 포트번호");
      System.exit(0);
    }

    try(Socket socket = new Socket(args[0], Integer.parseInt(args[1]));
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));){

      while(true) {

        String message = Prompt.inputString("명령> ");
        out.println(message);
        out.flush();

        receiveResponse(in);

        if (message.equalsIgnoreCase("quit")) {
          break;
        }

        if (message.equalsIgnoreCase("stop")) {
          break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void receiveResponse(BufferedReader in) throws Exception {
    while (true) {
      String input = in.readLine();

      if (input.length() == 0) {
        break;
      }

      System.out.println(input);
    }

  }
}
