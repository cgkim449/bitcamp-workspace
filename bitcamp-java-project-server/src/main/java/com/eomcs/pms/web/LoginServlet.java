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
import javax.servlet.http.HttpSession;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.service.MemberService;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;


  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {


    HttpSession session = request.getSession();


    request.setCharacterEncoding("UTF-8"); 

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    // 클라이언트 전용 보관소를 준비한다

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>로그인</title></head>");
    out.println("<body>");

    try {
      out.println("<h1>로그인</h1>");

      if (session.getAttribute("loginUser") != null) {
        out.println("<p>로그인 되어 있습니다!</p>");
      } else {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        ServletContext ctx = request.getServletContext();
        MemberService memberService = (MemberService) ctx.getAttribute("memberService");

        Member member = memberService.get(email, password);
        if (member == null) {
          out.println("사용자 정보가 맞지 않습니다.");
        } else {
          // 로그인이 성공했으면 회원 정보를
          // 각 클라이언트의 전용 보관소인 session에 저장한다.
          session.setAttribute("loginUser", member);
          out.printf("<p>%s 님 반갑습니다.</p>", member.getName());
        }
      }
    } catch (Exception e) {
      out.println("<h2>작업 처리 중 오류 발생! - %s</h2>\n");
      out.printf("<pre>%s</pre>\n", e.getMessage());

      StringWriter errOut = new StringWriter();
      e.printStackTrace(new PrintWriter(errOut));
      out.println("<h3>작업 처리 중 오류 발생! - %s</h3>\n");
      out.printf("<pre>%s</pre>\n", errOut.toString());
    }

    out.println("</body>");
    out.println("</html>");
  }
}
