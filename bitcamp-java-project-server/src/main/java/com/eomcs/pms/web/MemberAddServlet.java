package com.eomcs.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.service.MemberService;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet{

  private static final long serialVersionUID = 1L;
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServletContext ctx = request.getServletContext();
    MemberService memberService =
        (MemberService) ctx.getAttribute("memberService");

    request.setCharacterEncoding("UTF-8"); 

    Member member = new Member();
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPassword(request.getParameter("password"));
    member.setTel(request.getParameter("tel"));
    member.setPhoto(request.getParameter("photo"));

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    Part photoPart = request.getPart("photo");

    String filename = UUID.randomUUID().toString();
    String saveFilePath = ctx.getRealPath("/upload/"+filename);

    photoPart.write(saveFilePath);

    member.setPhoto(photoPart.getSubmittedFileName());

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    //    out.println("<meta http-equiv='Refresh' content='1;list'>");
    out.println("<title>회원 등록</title></head>");
    out.println("<body>");
    try {
      out.println("<h1>회원 등록</h1>");
      memberService.add(member);

      out.println("<p>회원을 등록하였습니다.</p>");

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
