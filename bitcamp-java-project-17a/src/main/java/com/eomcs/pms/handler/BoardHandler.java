package com.eomcs.pms.handler;

import java.sql.Date; // 의존 클래스
import com.eomcs.pms.domain.Board; // 의존 객체
import com.eomcs.util.ArrayList; // 의존 객체
import com.eomcs.util.Prompt; // 의존 클래스

public class BoardHandler {

  // Board 객체 목록을 저장할 ArrayList 객체를 준비한다.
  ArrayList<Board> boardList = new ArrayList<Board>();

  public void add() {
    System.out.println("[게시물 등록]");

    Board board = new Board();
    board.setNo(Prompt.inputInt("번호? "));
    board.setTitle(Prompt.inputString("제목? "));
    board.setContent(Prompt.inputString("내용? "));
    board.setWriter(Prompt.inputString("작성자? "));
    board.setRegisteredDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);

    // 제네릭 문법에 따라 Board 또는 그 하위 타입의 객체만 가능
    boardList.add(board);

    System.out.println("게시글을 등록하였습니다.");
  }

  public void list() {
    System.out.println("[게시물 목록]");

    Board[] boards = boardList.toArray(Board[].class);

    for (Board board : boards) {
      System.out.printf("%d, %s, %s, %s, %d\n",
          board.getNo(),
          board.getTitle(),
          board.getWriter(),
          board.getRegisteredDate(),
          board.getViewCount());
    }
  }
}
