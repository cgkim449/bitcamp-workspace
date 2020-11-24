package com.eomcs.pms.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.service.BoardService;

@WebServlet("/board/list")
public class BoardListCommand extends HttpServlet {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    BoardService boardService = (BoardService) ctx.getAttribute("boardService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>게시글 목록</title></head>");
    out.println("<body>");
    try {
      out.println("<h1>게시물 목록</h1>");
      out.println("<table border='1'>");
      out.println("<tr>"
          + "<th>번호</th>"
          + "<th>제목</th>" 
          + "<th>작성자</th>" 
          + "<th>등록일</th>" 
          + "<th>조회수</th>" 
          + "</tr>");

      List<Board> list = boardService.list();

      for (Board board : list) {
        out.printf("<tr>"
            + "<td>%d</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%s</td>"
            + "<td>%d</td>"
            + "</tr>\n", board.getNo(), board.getTitle(),
            board.getWriter().getName(), board.getRegisteredDate(), board.getViewCount());
      }
      out.println("</table>");
    } catch (Exception e) {
      out.printf("<p>작업 처리 중 오류 발생! - %s</p>\n", e.getMessage());
      StringWriter errOut = new StringWriter();
      e.printStackTrace(new PrintWriter(errOut));
      out.printf("<pre>%s</pre>", errOut.toString());
      // <pre> : 자동으로 정렬하지말고 그냥 그대로 출력하라
    }
    out.println("</body>");
    out.println("</html>");
  }


}
