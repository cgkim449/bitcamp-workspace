package com.eomcs.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.service.BoardService;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    BoardService boardService =
        (BoardService) ctx.getAttribute("boardService");

    // 웹주소에 동봉된 데이터(Query String: qs)를 읽는다.
    int no = Integer.parseInt(request.getParameter("no"));



    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>게시글조회</title></head>");
    out.println("<body>");
    try {
      out.println("<h1>게시물 조회</h1>");

      Board board = boardService.get(no);

      if (board == null) {
        out.println("해당 번호의 게시글이 없습니다.");
        return;
      }
      out.println("<form action='update' method='post'>");
      out.printf("번호: <input type='text' name='no' value='%d' readonly><br>\n", board.getNo());
      out.printf("제목: <input type='text' name='title' value='%s'><br>\n", board.getTitle());
      out.printf("내용: <textarea name='content'>%s</textarea><br>\n", board.getContent());
      out.printf("작성자: %s<br>\n", board.getWriter().getName());
      out.printf("등록일: %s<br>\n", board.getRegisteredDate());
      out.printf("조회수: %d<br>\n", board.getViewCount());
      out.println("<p>");
      out.println("<button>변경</button>");
      out.printf("<a href='delete?no=%d'>삭제</a>", board.getNo());
      /*
       * 삭제를 post방식으로 하려면 form을 새로 또 만들어야됨
       * 그래서 그냥 링크로 했음(get)
       */
      out.println("</p>");
      out.println("</form>");

    } catch (Exception e) {
      out.printf("<p>작업 처리 중 오류 발생! - %s</p>\n", e.getMessage());

      StringWriter errOut = new StringWriter();
      e.printStackTrace(new PrintWriter(errOut));

      out.printf("<pre>%s</pre>\n", errOut.toString());
    }

    out.println("</body>");
    out.println("</html>");
  }
}
