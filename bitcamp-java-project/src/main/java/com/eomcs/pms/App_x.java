package com.eomcs.pms;

import java.util.Scanner;

public class App_x {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    while(true) {
      System.out.print("명령> ");
      String command = keyScan.nextLine();
      System.out.println(command);
      if (command.equalsIgnoreCase("quit")||command.equalsIgnoreCase("exit")) {
        break;
      }
    }

    keyScan.close();
  }

}
