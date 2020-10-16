package com.eomcs.design_pattern.flyweight.after;

import java.util.Scanner;

public class BrushTest {

  public static void main(String[] args) {
    BrushPool brushPool = new BrushPool();
    Scanner keyboard = new Scanner(System.in);

    while(true) {
      System.out.println("패턴? ");
      String pattern = keyboard.nextLine();

      System.out.println("선 길이? ");
      int length = Integer.parseInt(keyboard.nextLine());
      if (length < 0)
        break;

      //
      Brush brush = brushPool.getBrush(pattern);
      brush.draw(length);
    }
    keyboard.close();

  }
}
