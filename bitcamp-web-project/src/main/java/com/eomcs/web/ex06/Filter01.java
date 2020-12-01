// 필터 초기화 파라미터 : web.xml에서 설정한 값 가져오기

package com.eomcs.web.ex06;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter01 implements Filter {

  FilterConfig filterConfig;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    this.filterConfig = filterConfig;
    System.out.println("ex05.Filter01.init()");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    // 필터의 DD 설정으로 지정한 파라미터 값 가져오기
    System.out.printf("ex06.Filter01 : encoding=%s\n", filterConfig.getInitParameter("encoding"));

    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
    System.out.println("ex06.Filter01.destroy()");
  }
}

/*
 * init dofilter destroy있다
 */

/*
 * 필터 객체가 사용할(dofilter 등 에서) 값을 외부 파일인 web.xml에 둘 수 있다
 * 
 * <filter>
    <filter-name>f1</filter-name>
    <filter-class>com.eomcs.web.ex06.Filter01</filter-class>
      <init-param>
        <param-name>encoding</param-name>  <== 이렇게 파라미터 이름과
        <param-value>UTF-8</param-value>   <== 파라미터 값을 설정할 수 있다
      </init-param>
      <init-param>  <== 여러 개 설정하고 싶다면 이렇게 반복하라
        <param-name>aaa</param-name>
        <param-value>okok</param-value>
      </init-param>
  </filter>
  <filter-mapping>
    <filter-name>f1</filter-name>
    <url-pattern>/ex05/*</url-pattern>
  </filter-mapping>

  필터에서 web.xml에 설정된 파라미터 값을 꺼내고 싶다면,
  => FilterConfig.getInitParameter(파라미터명) 메서드를 사용하라

  init로 필드값을 초기화시킴(web.xml에 있는 값을 가져와서 filterConfig에 넣는다)
  그리고 그걸 doFilter에서 쓴다

  웹브라우저에서 Filter를 실행시킬 방법은 없다
  그냥 서블릿을 실행요청해야함
 */

