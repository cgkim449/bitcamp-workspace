package com.eomcs.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.domain.Member;

public class BoardDao {
  public int insert(Board board) throws Exception {
    /*
     * 순수 insert.. 예외처리도 안함..
     */
    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "insert into pms_board(title,content,writer) values(?,?,?)")) {

      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());
      stmt.setInt(3, board.getWriter().getNo());
      return stmt.executeUpdate();
    }
  }

  public int delete(int no) throws Exception {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement("delete from pms_board where no=?")) {

      stmt.setInt(1, no);
      return stmt.executeUpdate();
    }
  }

  public int update(Board board) throws Exception {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "update pms_board set title = ?, content = ? where no = ?")) {

      stmt.setString(1, board.getTitle());
      stmt.setString(2, board.getContent());
      stmt.setInt(3, board.getNo());
      return stmt.executeUpdate();
    }
  }

  public Board findByNo(int no) throws Exception {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "select b.no, b.title, b.content, b.cdt, b.vw_cnt, m.no writer_no, m.name"
            /*
             * 프라이머리 키로 찾아가서 멤버 정보 사용할 수 있으니까.. 확장성..
             * 프라이머리 키도 담아서 리턴으로 넘겨주자..
             */
            + " from pms_board b inner join pms_member m on b.writer=m.no"
            + " where b.no = ?")) {

      stmt.setInt(1, no);
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          Board board = new Board();
          board.setNo(rs.getInt("no"));
          board.setTitle(rs.getString("title"));
          board.setContent(rs.getString("content"));

          Member member = new Member();
          member.setNo(rs.getInt("writer_no"));
          member.setName(rs.getString("name"));
          board.setWriter(member);

          board.setRegisteredDate(rs.getDate("cdt"));
          board.setViewCount(rs.getInt("vw_cnt")+1);

          try (PreparedStatement stmt2 = con.prepareStatement(
              "update pms_board set vw_cnt = vw_cnt + 1"
                  + " where no = ?")) {
            stmt2.setInt(1, no);
            stmt2.executeUpdate(); // 조회수 증가
          }
          return board;
        } else {
          return null;
        }
      }
    }
  }

  public List<Board> findAll() throws Exception {
    ArrayList<Board> list = new ArrayList<>();
    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "select b.no, b.title, b.cdt, b.vw_cnt, m.no writer_no, m.name"
                + " from pms_board b inner join pms_member m on b.writer=m.no"
                + " order by b.no desc")) {

      try (ResultSet rs = stmt.executeQuery()) {
        System.out.println("번호, 제목, 작성자, 등록일, 조회수");
        while (rs.next()) {
          Board board = new Board();
          board.setNo(rs.getInt("no"));
          board.setTitle(rs.getString("title"));

          Member member = new Member();
          member.setNo(rs.getInt("writer_no"));
          member.setName(rs.getString("name"));
          board.setWriter(member);

          board.setRegisteredDate(rs.getDate("cdt"));
          board.setViewCount(rs.getInt("vw_cnt"));

          list.add(board);
        }
        return list;
      }
    }
  }
}
