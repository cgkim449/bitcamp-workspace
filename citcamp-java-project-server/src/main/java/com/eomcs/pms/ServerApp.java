package com.eomcs.pms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
  public static void main(String[] args) {
    try(ServerSocket serverSocket = new ServerSocket(8888);) {
      System.out.println("서버 실행 중... ");
      try(Socket socket = serverSocket.accept();
          PrintWriter out = new PrintWriter(socket.getOutputStream());
          BufferedReader in = new BufferedReader(
              new InputStreamReader(socket.getInputStream()));){

        while(true) {
          String message = in.readLine();

          sendResponse(out, message);


          if (message.equalsIgnoreCase("stop")) {
            break;
          }
        }
      } 
    }catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void sendResponse(PrintWriter out, String message) {
    out.println(message);
    out.println();
    out.flush();    
  }
}
