// 게시판 관리 - 등록
package com.eomcs.jdbc.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

// 다음과 같이 게시물을 등록하는 프로그램을 작성하라!
// ----------------------------
// 제목? aaa
// 내용? bbb
// 등록하시겠습니까?(Y/n) y
// 등록하였습니다.
// 등록하시겠습니까?(Y/n) n
// 등록을 취소 하였습니다.
// ----------------------------
public class Exam0400 {

  public static void main(String[] args) throws Exception {

    String title = null;
    String contents = null;
    ArrayList<String> files = new ArrayList<>();


    try (Scanner keyScan = new Scanner(System.in)) {

      // 사용자로부터 제목, 내용을 입력 받는다.
      System.out.print("제목? ");
      title = keyScan.nextLine();

      System.out.print("내용? ");
      contents = keyScan.nextLine();
      while(true) {
        System.out.print("첨부파일:(완료는 그냥 엔터!) ");
        String filename = keyScan.nextLine();
        /*
         * 엔터는 빈문자열(null이아님)
         */
        if (filename.length() == 0) {
          break;
        }
        files.add(filename);
      }
    }

    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement boardStmt =
            con.prepareStatement("insert into x_board(title,contents) values(?,?)");
        PreparedStatement fileStmt =
            con.prepareStatement("insert into x_board_file(file_path,board_id) values(?,?)")) {

      boardStmt.setString(1, title);
      boardStmt.setString(2, contents);
      int count = boardStmt.executeUpdate();

      int fileCount = 0;
      System.out.printf("%d 개 입력 성공!", count);
      for (String filename : files) {
        fileStmt.setString(1, filename);
        fileStmt.setInt(2, /* 어 ? 앞에서 입력한 게시글 번호가 뭐지*/0);
        /*
         * a foreign key constraint fails : fk 제약조건?때문에 fail
         */
        fileStmt.executeUpdate();
        fileCount++;
      }
      System.out.printf("%d개 첨부파일 입력 성공", fileCount);
    }
  }
}


