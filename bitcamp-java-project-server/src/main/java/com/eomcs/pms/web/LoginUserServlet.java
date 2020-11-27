package com.eomcs.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.eomcs.pms.domain.Member;

@WebServlet("/auth/loginUser")
public class LoginUserServlet extends   HttpServlet {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;


  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();


    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>로그인 유저</title></head>");
    out.println("<body>");

    Member loginUser = (Member) session.getAttribute("loginUser");
    if (loginUser == null) {
      out.println("<h1>로그인 하지 않았습니다!</h1>");
    } else {
      out.println("<h1>너</h1>");
      out.printf("<p>사용자 번호: %d\n</p>", loginUser.getNo());
      out.printf("<p>이름: %s\n</p>", loginUser.getName());
      out.printf("<p>이메일: %s\n</p>", loginUser.getEmail());
      out.printf("<p>사진: %s\n</p>", loginUser.getPhoto());
      out.printf("<p>전화: %s\n</p>", loginUser.getTel());
      out.printf("<p>등록일: %s\n</p>", loginUser.getRegisteredDate());
    }

    out.println("</body>");
    out.println("</html>");

  }
}
