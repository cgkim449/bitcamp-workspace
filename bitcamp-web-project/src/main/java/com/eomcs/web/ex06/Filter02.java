// 필터 초기화 파라미터 : 애노테이션으로 설정한 값 가져오기
package com.eomcs.web.ex06;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(
    value="/ex05/*", // web.xml의 url-pattern
    initParams={
        @WebInitParam(name="encoding", value="UTF-8"),
        @WebInitParam(name="aaa", value="okok")
    })
public class Filter02 implements Filter {

  FilterConfig filterConfig;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("ex05.Filter02.init()");
    this.filterConfig = filterConfig;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    // 필터의 DD 설정으로 지정한 파라미터 값 가져오기
    System.out.printf("ex06.Filter02 : encoding=%s\n", filterConfig.getInitParameter("encoding"));
    System.out.printf("ex06.Filter02 : aaa=%s\n", filterConfig.getInitParameter("aaa"));

    chain.doFilter(request, response);
  }
}
// 1이랑 다똑같음
// 위에 애노테이션만 다름


