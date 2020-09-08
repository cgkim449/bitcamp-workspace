package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Board;
import com.eomcs.util.ArrayList;
import com.eomcs.util.Prompt;

public class BoardHandler {

  // ArrayList객체에 Board타입과 그 하위타입객체만 담고 싶다는게 아니다
  // ArrayList가 Board타입과 그 하위타입만 다루고 싶다는 얘기
  ArrayList<Board> boardList = new ArrayList<>();

  public void add() {
    System.out.println("[게시물 등록]");

    Board board = new Board();
    board.setNo(Prompt.inputInt("번호? "));
    board.setTitle(Prompt.inputString("제목? "));
    board.setContent(Prompt.inputString("내용? "));
    board.setWriter(Prompt.inputString("작성자? "));
    board.setRegisteredDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);

    boardList.add(board); // 아규먼트 Board타입인거 확인~, 그 하위타입도 아규먼트로 넘길수있음~

    System.out.println("게시글을 등록하였습니다.");
  }

  public void list() {
    System.out.println("[게시물 목록]");

    Board[] boards = boardList.toArray(Board[].class); // 리턴 타입 E로 바꿨었다 그럼 E가 Task가 되는거지

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
