서블릿으로 인클루드는 무조건 절대경로

# 46-a Spring WebMVC 도입하기 : DispatcherServlet 프론트 컨트롤러 적용

목표 : 우리가 만든 DispatcherServlet과 제공하는 DispatcherServlet을 비교

1 프론트 컨트롤러는 객체를 생성할 수 있다(Controller, Service, Dao, sqlSessionFactory)(애노테이션만 붙이면)
그리고 관리한다?

2 알아서 해준다
나는 파라미터, 리턴에 뭘 넣을 수 있는지 아닌지만 공부하면 됨


## 1단계 - 라이브러리 추가
spring-webmvc 검색
5.3.2

https://spring.io/projects/spring-framework#learn
GA
RC
M
SNAPSHOT
https://unordinarydays.tistory.com/136 참고 위 용어에대한 설명

gradle eclipse하면 레퍼런스라이브러리 보면
webmvc 추가되있고 얘가 의존하는 context, aop, web, beans, expression, core 추가되있음

## 2단계 - 프론트 컨트롤러를 설정한다

- /WEB-INF/web.xml 변경
  - Spring WebMVc 프레임워크에서 제공해주는 프론트 컨트롤러를 등록한다
  https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-servlet 
  에서
 <servlet>
        <servlet-name>app</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value></param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>app</servlet-name>
        <url-pattern>/app/*</url-pattern>
    </servlet-mapping>
     를 복사
     해서 web.xml에 붙여넣기

     <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/app-servlet.xml</param-value>
        </init-param>
        로 변경

- /WEB-INF/app-servlet.xml 생성
  - 프론트 컨트롤러가 사용할 설정 파일
  
  <beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:p="http://www.springframework.org/schema/p"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <context:component-scan base-package="org.example.web"/>

    <!-- ... -->

</beans>
를 복사해서 붙여넣기

<!-- 페이지 컨트롤러 등 웹 컴포넌트가 들어 있는 패키지를 지정한다
		프론트 컨트롤러는 이 패키지의 클래스를 조사하여 
		설정한 대로 객체를 생성하고 관리할 것이다
 -->
    <context:component-scan base-package="com.eomcs"/>

    <!-- 프론트 컨트롤러는 이 패키지의 모든 클래스를 찾아서
    스프링의 특별한 애노테이션이 붙은 클래스에 대해
    객체를 생성하고 관리할 것이다 -->

    로 수정

## 3단계 - 프론트 컨트롤러에서 객체를 생성할 수 있도록 설정한다

- 페이지 컨트롤러 클래스 설정하기
  - @Controller 애노테이션을 붙여 해당 클래스가 페이지 컨트롤러임을 지정하라

인터페이스대신!!!!!!!! 애노테이션을 붙인다
그다음 서버 재실행하면
org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.eomcs.pms.service.BoardService' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}
보드서비스가 없어서 페이지 컨트롤러에 넣을 수 없다

## 4단계 - 페이지 컨트롤러의 의존 객체를 설정한다

페이지 컨트롤러가 사용할 서비스 객체 생성을 프론트 컨트롤러에게 맡긴다
(이것이 우리가 만든 프론트 컨트롤러와의 차이점
프론트 컨트롤러는 서비스 객체를 생성한다)
- 서비스 클래스 설정하기
  - com.eomcs.pms.service.Default*Service 변경한다
  - @Service 애노테이션을 붙여라 ( 이 거 만들어줘)
그음에 서버 재실행하면
org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'defaultBoardService' defined in file [C:\Users\김찬구\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp3\wtpwebapps\bitcamp-java-project-server\WEB-INF\classes\com\eomcs\pms\service\DefaultBoardService.class]: Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.eomcs.pms.dao.BoardDao' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}


org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.eomcs.pms.dao.BoardDao' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}

## 5단계 - 서비스 객체의 의존 객체를 설정한다

서비스 객체가 사용할 DAO 객체 생성을 프론트 컨트롤러에게 맡긴다

- DAO 클래스 설정하기
@Repository 애노테이션을 붙인다(@Bean 붙여도 되는데 이렇게하자)
애노테이션을 붙이는 순간 프론트 컨트롤러는 얘를 만든다!

## 6단계 - DAO 객체가 사용할

일반적인 객체는 
@Component
붙인다

컨텍스트 로더 리스너 날리고
public SqlSessionFactoryProxy() throws Exception {
    // 생성자에서 원래의 구현체를 받아 보관해 둔다.
    this.original = new SqlSessionFactoryBuilder().build(
        Resources.getResourceAsStream("com/eomcs/pms/conf/mybatis-config.xml"));
  }
이렇게 수정
원래는 컨텍스트 로더 리스너에서 sqlSessionFactoryProxy를 생성했는데

그리고 서버 재실행해보면
잘됨

근데 memberAdd에서 multipart안됨
남이 만든 서블릿이라 애노테이션 못붙임
그럼 web.xml에다 하면됨

<servlet>
      <servlet-name>app</servlet-name>
      <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
      <init-param>
          <param-name>contextConfigLocation</param-name>
          <param-value>/WEB-INF/app-servlet.xml</param-value>
      </init-param>
      <load-on-startup>1</load-on-startup>
      <multipart-config>
        <max-file-size>10</max-file-size>      
      </multipart-config>
  </servlet>
로 변경(프론트 컨트롤러 만든애가 나보고 하라고 일부러 설정을 안함)

파라미터와 프로퍼티




### 저장소 안의 저장소
eomcs spring webmvc를 git clone해서
그 폴더를 bitcamp-workspace에 복사했다
그리고 이클립스에 임포트 했는데
bitcamp-spring-webmvc master라고 나온다
그럼 
.git
.gitattributes
.gitignore
삭제하라

.setting
.classpath
bin
등 gradle eclipse

