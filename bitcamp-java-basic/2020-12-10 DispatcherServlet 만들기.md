Front Controller

@WebServlet("/app/*") 로 하면
request.getServletPath() 햇을때
/app/board/list요청을 받아도
System.out.println(request.getServletPath());해보면
/app만 출력됨

## DispatcherServlet
```java
package com.eomcs.pms.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/app/*")
public class DispatcherServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 예) 요청 URL => /app/board/list
    //    String servletPath = request.getServletPath(); //=> /app
    String controllerPath = request.getPathInfo(); //=> /board/list

    // include하는 쪽에서 처리해야!
    // include : 원래 서블릿이 하는일을 그대로 유지 포워드는 유지 안함
    //    response.setContentType("text/html;charset=UTF-8");
    // 원래 썼었는데  지금 jsp로 include가 아예없음 

    /*
     * 요청이 들어오면
     * request.getPathInfo로 controllerPath를 받는다 
     * (예: /app/board/list가 오면 우리가 지금 /app/*이기 때문에 controllerPath는 /board/list임)
     * 그리고 controolerPath의 서블릿을 인클루드한다
     * 그럼 그 서블릿이 자기 일을 다 한다 즉 프론트 서블릿은 요청을 받고 그 요청을 넘겨주기만함
     * 그 서블릿이 일을 다 마치면 이제 jsp를 include하던지 다른 서블릿을 redirect하던지 error.jsp를 포워드하던지 
     * 다른 서블릿을 리프레시하던지 하는데
     * 그 시키는것도 frontContoller가 하는것
     * 그래서 그 서블릿이 그다음에 시킬 애의 경로를 request 보관소에 담는다
     * 그럼 frontController가 그 request에 있는 경로를 꺼내서
     * 얘가 "viewName"이면 포워드(원래 include로 할려그랫는데 그럴 필요가 없어서 포워드로 함)
     * "redirect"이면 response.sendRedirect(redirect); 이런식으로 처리함
     *
     * 그래서 내가 할거는 경로를 담기만 하면된다
     * 그리고 프론트 컨트롤러는 그 경로에 대비만 하면됨
     */

    // 페이지 컨트롤러에게 위임한다
    RequestDispatcher rd = request.getRequestDispatcher(controllerPath);
    rd.include(request, response);

    // ! 인클루드한쪽에서 보관소에 담은걸
    Exception exception = (Exception) request.getAttribute("exception");
    if (exception != null) {
      request.getRequestDispatcher("/error.jsp").forward(request, response);
      return;
    }

    String viewName = (String) request.getAttribute("viewName");
    if (viewName != null) {
      request.getRequestDispatcher(viewName).forward(request, response);
      return;
    }

    String redirect = (String) request.getAttribute("redirect");
    if (redirect != null) {
      response.sendRedirect(redirect);
      // 응답헤더
      // HTTP/1.1 302
      // location: list
      // 이때 list가 상대경로
      // 바로 app 밑에 board밑에 list
      return;
    }
  }
}
```

경로를 이미 알고있으면 경로를 굳이 보관소에 안넣어도된다
예)/error.jsp
즉 핵심만 알면 유연하게 하면된다
핵심은 프론트 컨트롤러가
그 다음 애한테 일시켜야하는데
그럼 경로만 알면 된다는 거다
근데 물론 그 경로로 
include해야되는지
forword해야되는지
redirect해야되는지
refresh해야되는지도 알아야함
이 두가지만 알면 된다


/app/project/detail 요청
Dispatcher 서블릿이 받음
패스인포를 보고 인클루드함
ProjectDetailServlet을.
디스패처가 /project/detail.jsp를 포워드
그담에

근데 왜 detail jsp에서 task list 서블릿을 인클루드를 못하는 상황?


# ex06

