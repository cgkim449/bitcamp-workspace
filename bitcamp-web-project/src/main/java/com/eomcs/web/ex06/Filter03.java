// 컨텍스트 파라미터 가져오기
/*
 * 필터파라미터가 아님 컨텍스트 파라미터
 */
package com.eomcs.web.ex06;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/ex05/*")
public class Filter03 implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    // 필터의 DD 설정으로 지정한 파라미터 값 가져오기
    System.out.printf("ex06.Filter03 : encoding=%s\n",
        request.getServletContext().getInitParameter("encoding"));
    /*
     * getAttrubute아닌 getInitParamter임 -> web.xml에서 찾는다!
     * <context-param>
    <param-name>encoding</param-name>
    <param-value>UTF-8</param-value>
 </context-param>

 <context-param>
    <param-name>aaa</param-name>
    <param-value>okok</param-value>
 </context-param>
     */

    chain.doFilter(request, response);
  }
}

/* init 필요없음 왜냐면 context에 설정되있어서 context한테 달라고 하면됨
 * 그래서 init 오버라이딩 안하고 doFilter만 오버라이딩함
 * dofilter 셋다 똑같은데 printf 아규먼트만 다름
 */

/*
 * 필터는 실행 순서를 따지지않고 만들어야됨
 */

/*1,2 : 필터에 설정된 초기화 파라미터값, 근데 1은 DD, 2는 애노테이션
 *3 :ServletContext에 설정된 초기화 파라미터값, 3은 DD
 *
 *1,3의 차이 : 
 *필터 태그로 설정된 파라미터 값은 그 필터만 사용할 수 있다, 범위를 지정할 수 있다
 *애노테이션은 그 필터만 할수 있을듯?
 *컨텍스트 태그로 설정된 파라미터 값은 [모든] 필터가 사용할 수 있다
 */

/*
 * 필터1,2는 개인이 사용할 파라미터값을 설정한것(필터 파라미터: init() 필요함)
 * 필터3은 모든 필터가 다같이 사용할 파라미터값을 설정한것(컨텍스트 파라미터: 컨텍스트한테 달라고하면됨 init()필요없음)
 */