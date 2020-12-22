package com.eomcs.pms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.util.UrlPathHelper;

@ComponentScan("com.eomcs.pms.web")

@EnableWebMvc
public class AppWebConfig implements WebMvcConfigurer {

  @Bean
  public ViewResolver viewResolver() {
    return new InternalResourceViewResolver(//
        "/WEB-INF/jsp/", // prefix
        ".jsp" // suffix
        );
  }

  @Bean
  public MultipartResolver multipartResolver() {
    // 스프링 WebMVC에서 파일 업로드를 처리하고 싶다면,
    // 이 메서드를 통해 MultipartResolver 구현체를 등록해야 한다.
    // 그래야 request handler는 MultipartFile 객체를 받을 수 있다.
    //
    CommonsMultipartResolver mr = new CommonsMultipartResolver();
    mr.setMaxUploadSize(10000000);
    mr.setMaxInMemorySize(2000000);
    mr.setMaxUploadSizePerFile(5000000);
    return mr;
  }

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    UrlPathHelper helper = new UrlPathHelper();
    helper.setRemoveSemicolonContent(false);
    configurer.setUrlPathHelper(helper);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
  }
}


