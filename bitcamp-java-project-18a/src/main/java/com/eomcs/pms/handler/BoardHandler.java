package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Board;
import com.eomcs.util.ArrayList;
import com.eomcs.util.Prompt;

public class BoardHandler {

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

    boardList.add(board);

    System.out.println("게시글을 등록하였습니다.");
  }

  public void list() {
    System.out.println("[게시물 목록]");

    for (int i = 0; i < boardList.size(); i++) {
      Board board = boardList.get(i);
      System.out.printf("%d, %s, %s, %s, %d\n",
          board.getNo(),
          board.getTitle(),
          board.getWriter(),
          board.getRegisteredDate(),
          board.getViewCount());
    }
  }

  public void detail() { // board를 조회
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");
    Board board = findByNo(no);
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return; // 잊지말자!!!!
    }
    board.setViewCount(board.getViewCount() + 1);
    System.out.printf("%s, %s, %s, %s, %d\n",
        board.getTitle(),
        board.getContent(),
        board.getWriter(),
        board.getRegisteredDate(),
        board.getViewCount());
  }

  public void update() { // board를 업데이트
    System.out.println("[게시글 변경]");
    int no = Prompt.inputInt("번호? ");
    Board board = findByNo(no); 
    // 레퍼런스 선언하여 Board객체에 연결
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return; // 잊지말자!!!!
    }

    String title = Prompt.inputString(
        String.format("제목(%s)?", board.getTitle()));
    String content = Prompt.inputString("내용?" + "(" + board.getContent() + ")");
    String writer = Prompt.inputString("작성자?" + "(" + board.getWriter() + ")");
    //    String title = Prompt.inputString("제목?" + "(" + board.getTitle() + ")");
    //    String content = Prompt.inputString("내용?" + "(" + board.getContent() + ")");
    //    String writer = Prompt.inputString("작성자?" + "(" + board.getWriter() + ")");

    String response = Prompt.inputString("정말 변경하시겠습니까?(y/N)");
    if (!response.equalsIgnoreCase("y")) { // 잊지말자!!
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    } 
    board.setTitle(title);
    board.setContent(content);
    board.setWriter(writer);
    System.out.println("게시글을 변경하였습니다.");
  }

  private Board findByNo(int no) {
    for(int i = 0; i < boardList.size(); i++) {
      if(boardList.get(i).getNo() == no) {
        return boardList.get(i);
      }
    } return null;
  }

  public void delete() { // board를 삭제
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");
    int index = indexOf(no); 
    if (index == boardList.size()) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N)");
    if (!response.equalsIgnoreCase("y")) { 
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    } 
    //    System.arraycopy(boardList.elementData, 
    //        index + 1, 
    //        boardList.elementData, 
    //        index, 
    //        boardList.size() - index - 1);
    //    boardList.size--;
    boardList.remove(index); // !!!
    System.out.println("게시글을 삭제하였습니다.");

  }

  private int indexOf(int no) {
    for(int i = 0; i < boardList.size(); i++) {
      if(boardList.get(i).getNo() == no) {
        return i;
      }
    }
    return boardList.size();
  }
}
