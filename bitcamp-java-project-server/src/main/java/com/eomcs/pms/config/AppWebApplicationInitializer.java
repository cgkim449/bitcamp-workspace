package com.eomcs.pms.config;

import javax.servlet.Filter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppWebApplicationInitializer 
extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    // ContextLoaderListner가 사용할 java config 클래스 리턴
    return new Class<?>[] {RootConfig.class, MybatisConfig.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    // DispatcherServlet이 사용할 java config 클래스 리턴
    return new Class<?>[] {AppWebConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] {"/app/*"};
  }

  @Override
  protected String getServletName() {
    return "app";
  }

  @Override
  protected Filter[] getServletFilters() {
    // TODO Auto-generated method stub
    return super.getServletFilters();
  }
}






