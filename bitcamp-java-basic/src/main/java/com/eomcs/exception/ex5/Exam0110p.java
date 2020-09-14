package com.eomcs.exception.ex5;

import java.sql.Date;
import java.util.Scanner;

public class Exam0110p {

  static Board read() throws BoardException {
    try (Scanner keyScan = new Scanner(System.in)){
      Board board = new Board();

      System.out.print("번호> ");
      board.setNo(Integer.parseInt(keyScan.nextLine()));

      System.out.print("제목> ");
      board.setTitle(keyScan.nextLine());

      System.out.print("내용> ");
      board.setContent(keyScan.nextLine());

      System.out.print("등록일> ");
      board.setCreatedDate(Date.valueOf(keyScan.nextLine()));

      return board;
    } catch (Exception 원본오류) {
      throw new BoardException("게시물 입력 도중 오류 발생!", 원본오류);
    }
  }

  public static void main(String[] args) {
    try {
      Board board = read();
      System.out.println("---------------------");
      System.out.printf("번호: %d\n", board.getNo());
      System.out.printf("제목: %s\n", board.getTitle());
      System.out.printf("내용: %s\n", board.getContent());
      System.out.printf("등록일: %s\n", board.getCreatedDate());
    } catch (BoardException e){
      System.out.println(e.getMessage());
      System.out.println("게시물 입력 중에 오류 발생");
      //      e.printStackTrace();
    }
  }
}

