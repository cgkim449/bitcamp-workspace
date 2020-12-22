
프로젝트에 적용할것 :
1. welcome-file-list(희진님)
2. admin/* DS
3. 설정




org.springframework.beans.factory.parsing.BeanDefinitionParsingException: Configuration problem: Unable to locate Spring NamespaceHandler for XML schema namespace [http://mybatis.org/schema/mybatis-spring]
Offending resource: ServletContext resource [/WEB-INF/app-servlet.xml]

https://mybatis.org/schema/mybatis-spring
처럼 https를 붙여주면 해결

------------------------------------


# src-00
- build.gradle 가장 기본
plugins {
    id 'java'
    id 'eclipse-wtp'
    id 'war'
}

repositories {
    jcenter()
}

dependencies {
    implementation 'com.google.guava:guava:28.2-jre'
    testImplementation 'junit:junit:4.12'
}


- web.xml의 가장 기본

  <description>
    스프링 Web MVC 프레임워크 예제 테스트
  </description>

  <display-name>java-spring-webmvc</display-name>
  <!-- 서버관리자화면에서 그 애플리케이션 이름이 무엇인지 자세한 설명은 description에서,
  그래서 둘다 없어도됨-->

<welcome-file-list>
  <welcome-file>index.html</welcome-file>
  <welcome-file>index.htm</welcome-file>
  <welcome-file>default.htm</welcome-file>
</welcome-file-list>
------------------------------------

# src-01 : 웹 프로젝트 준비 = 서블릿 프로그래밍이 가능하다
- build.gradle
compileOnly group: 'javax.servlet', name: 'javax.servlet-api', version: '4.0.1'
compileOnly 'javax.servlet:javax.servlet-api:4.0.1'
두가지 다 가능하다

compileOnly 'javax.servlet:javax.servlet-api:4.0.1'
implementation group: 'javax.servlet', name: 'jstl', version: '1.2'
이거 두개 추가
- providedCompile
  - compileOnly처럼 컴파일 할때만 사용한다
  - 배포 파일에는 포함하지 않는다
  - 단 이 옵션은 'war' 플러그인을 사용할 때만 설정할 수 있다!!
- compileOnly 
  - 프로그래밍(컴파일) 하는 동안에만  사용한다
  - 배포 파일(.jar, .war, .ear)에는 포함하지 않는다
  - 프로그램이 배치되는 런타입 서버(예: 실행 중인 톰캣 서버)에서 라이브러리를 제공하는 경우!!! 굳이 배포할 필요가 없기 때문에 이 옵션을 사용한다(서블릿 api가 대표적이다)
- implementation
  - 베포파일에도 포함한다

------------------------------------

# src-02 : 스프링 WebMVC 적용

web.xml
프론트컨트롤러 역할을 수행할 서블릿을 배치하는일!

// log4j 2.x 라이브러리
implementation 'org.apache.logging.log4j:log4j-core:2.14.0'
// Spring WebMVC 프레임워크 라이브러리
implementation 'org.springframework:spring-webmvc:5.3.2'
두개 추가

package bitcamp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

```java
// 프론트 컨트롤러(DispatcherServlet)가 실행할 페이지 컨트롤러는
// 다음과 같이 @Controller 애노테이션을 붙여야 한다.
@Controller
public class HelloController {

  // 클라이언트 요청이 들어왔을 때 호출될 메서드(request handler)를
  // 표시하려면 다음과 같이 @RequestMapping 애노테이션을 붙여야 한다.
  // => @RequestMapping(요청URL)
  // 예:
  // @RequestMapping("/hello")
  // @RequestMapping(value="/hello")
  // @RequestMapping(path="/hello")
  @RequestMapping({"/hello", "/hello2", "/okok"})

  // 리턴하는 String 값이 뷰 컴포넌트(예: JSP)의 URL이 아닌 경우
  // 애노테이션으로 표시한다.
  // => @ResponseBody : 리턴하는 문자열이 클라이언트에게 보낼 콘텐트임을 표시한다.
  // => 이 애노테이션이 붙어 있으면 프론트 컨트롤러는 리턴 값을
  // 그대로 클라이언트에게 전송한다.
  @ResponseBody
  public String hello() throws Exception {
    return "<html><body><h1>Hello!</h1></body></html>";
  }
}
```

------------------------------------

# src-03 IoC 설정 파일의 위치
잘해라
# src-04 IoC 설정 파일의 위치

# src-05 : ContextLoaderListener와 DispatcherServlet의 IoC 컨테이너
그림참고

톰캣서버가 실행되면 ContextLoaderListener를 호출함
왜냐면 얘는 ServletContextListner이다
ServletContextListner은 web App 시작/종료할때 호출된다
ContextLoaderListener는 자체적으로 IoC Container를 포함하고 있다
즉 ApplicationContext인터페이스를 포함하고있다
IoC Container는 빈설정파일(app-context.xml)을 읽는다

요청이 들어오면 톰캣서버는
DispatcherServlet의 service()를 호출한다 DispatcherServlet은 IoC Container를 포함하고 있다 IoC Container는 빈설정파일(app-context.xml)을 읽는다

근데 src-05에서는 DispatcherServlet에 
<init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value></param-value>
</init-param>
param-value가 없다
그래서 설정파일이 없는 상태라느거다
그래서 DispatcherServlet의 IoC Container에는 페이지 컨트롤러가 없다는거다 그럼 ContextLoaderListener의 IoC Container를 사용한다
(DispatcherServlet의 IoC 컨테이너를 사용하고 싶지 않을때 이런방식으로 설정한다)
DispatcherServlet의 IoC Container는 다른 애들이 사용할 수 없다
ContextLoaderListener를의 IoC Container는 모두가 사용할 수 있다

단! src-05 서버를 실행시켜서
app/hello 요청을 날려도
실행이 안된다
왜냐면 DispatcherServlet 클래스와 달리 ContextLoaderListener의 IoC Container는 그 페이지 컨트롤러 객체를 생성하긴하지만 (@Component, @Controller, @Service 등의 애노테이션 붙은  
클래스에 대해 객체를 생성해 주지만)@RequestMapping, @ResponseBody 등과 같은 
웹 관련 애노테이션은 인식하지 못하기 때문이다. 따라서 페이지 컨트롤러의 요청 핸들러를 관리하는 일을 하지 못한다.
따라서 WebMVC 관련 애노테이션을 처리할 도우미 객체를 다음과 같이 등록하라.
  <mvc:annotation-driven/>

------------------------------------

# src-06 src-06 : ContextLoaderListener와 DispatcherServlet의 관계

일단 각자가 하는 일 :
- ContextLoaderListener의 IoC 컨테이너 :
모든 프론트 컨트롤러 및 페이지 컨트롤러가 공유할 객체를 보관한다.

- DispatcherServlet의 IoC 컨테이너 :
페이지 컨트롤러, 인터셉터 등 웹 관련 객체를 보관한다.

Dispatcher 서블릿은 여러개를 둘 수 있다
/app/*
/admin/*
/openapi/*
app-servlet.xml
admin-servlet.xml
openapi-servlet.xml
(CLL은 app-context.xml)
이런 식으로 app으로 시작하는 url, admin으로 시작하는 url, openapi로 시작하는 url을 처리하는 각각의 DS를 둘 수 있다
그럼 각각의 DS가 각각의 IoC Container를 갖는것
그리고 각각의 DS는 CLL의 IoC Container를 쓸 수 있다
CLL의 IoC는 DAO, Service 등 비즈니스 로직을 처리하는 객체를 관리한다.
각각의 DS의 IoC는 페이지 컨트롤러, 인터셉터(일종의 필터) 등 웹 요청 처리 객체를 관리한다.
실무에서는 이런식으로 관리한다.
그림참고.

CLL의 app-context.xml

(참고용어 : 테스트용으로 만든 객체 : 목업객체)


------------------------------------

# src-07 : Java Config로 DispatcherServlet의 IoC 컨테이너 설정하기
지금까진 xml로 했다면 이젠 java Config로 바꾸자

    <init-param>
      <param-name>contextClass</param-name>
      <param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
    </init-param>
    이건 복붙임

@ComponentScan("bitcamp")
// XML설정 파일에서 다음 설정과 같다
//<context:component-scan base-package="bitcamp">
public class AppConfig {

} 

------------------------------------

# src-08 : SerlvetContainerInitializer 구현체의 활용

web.xml에 DS가 없다!
근데 app/hello 가 실행이 된다
서블릿컨테이너이니셜라이저구현체 소개

    // 파일 시스템에 있는 .jar 파일 포함하기
    implementation fileTree(dir: 'lib',  include: '*.jar')
    를 build.gradle에 추가
    // gradle을 통해 자동으로 받은 라이브러리가 아니라,
    // 별도로 다운로드 받은 라이브러리 파일을 프로젝트에 포함시키는 방법
    // implementation fileTree(
    // dir: 현재 프로젝트 폴더를 기준으로 상대 경로 또는 절대 경로
    // include : '프로젝트에 포함한 라이브러리 파일들'
    implementation fileTree(dir: 'lib',  include: '*.jar')

DispatcherServlet을 설정하는방법
-xml
-java config

스프링부트!!는 java config를 기본으로 한다
이니셜라이저에서 onstartup이 실행될때 
여기서 

static nested class

  <servlet>
    <servlet-name>app</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <!-- Java Config로 IoC 컨테이너를 지정할 때는 기본 IoC 컨테이너를 교체해야 한다. 
         다음과 같이 초기화 파라미터를 통해 DispatcherServlet이 사용할 
         IoC 컨테이너 클래스와 Java Config 클래스를 설정한다.-->
    <init-param>
      <param-name>contextClass</param-name>
      <param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
    </init-param>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>bitcamp.AppConfig</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>app</servlet-name>
    <url-pattern>/app/*</url-pattern>
  </servlet-mapping>

```java
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import com.eomcs.web.MyWebInitializer;

public class MyWebInitializerImpl implements MyWebInitializer {
  @Override
  public void start(ServletContext ctx) { 
    System.out.println("MyWebInitializerImpl.. ok!");

    // xml과 비교해라 06? 07?
    AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
    ac.register(AppConfig.class);
    ac.refresh(); 

    // 중첩클래스라고 import했다 위에서
    DispatcherServlet servlet = new DispatcherServlet(ac);

    Dynamic registration = ctx.addServlet("app", servlet);

    registration.setLoadOnStartup(1);

    registration.addMapping("/app/*");
  }
}
```

둘이 똑같은것 한줄씩 비교해봐라

그리고 방법 하나더있다

ee 8 api
Interface ServletContainerInitializer
서블릿이나 필터나 리스너를 프로그래머틱 레지스트레이션할 경우에 
이 인터페이스의 구현은 handlesType을 붙일지도모른다?
receive받기위해서
onstartup할때
대체 어떤 객체를 받고싶으냐

서블릿컨테이너는 jar 파일을 다 뒤져서
meta-inf 밑에 service 밑에 저런 파일이 있나 보고
그 파일 안에 선언된 클래스의 객체를 생성해서
인터페이스에 나와잇는데로 onstartup이라는 메서드를 호출한다
파라미터를 두개넘길건데
Set<Class<?>>에는 HandlesType에 써있는 인터페이스를 구현한 클래스를 넘긴다
그 클래스에 대해서 객체를 생성해서 start를 호출

jdbc에서 한거랑 비슷하다....
jdbc 모든 jar를 다 뒤지는데 meta-inf 밑에 service 밑에 ~Driver가 있다면
그 파일에 등록된 org.mariadb.jdbc.Driver를 로딩함
우리가 직접 로딩하지 않아도 자동으로 로딩한다
jdbc 드라이버 로딩방법 참고 jdbc ex1 ex140,141~

그림참고





서블릿이나 필터를 등록하는 방법은 2가지가 있다
xml이나 애노테이션 선언으로한다=선언적인 방식이라 한다 declaration

java config : 개발자가 직접 코딩으로=프로그래머틱방법 개발자가 서블릿을 등록한다 programatic

------------------------------------

12-18 금요일
1교시 

그림
SerlvetContainerInitializer 인터페이스
이건 스프링 기술이 아니다 서블릿 기술이다
ServletContainer가 다 뒤져서 SerlvetContainerInitializer 파일 찾아서  그 구현체 생성
SerlvetContainerInitializer의 onStartup() 호출
파라미터 두개가 들어간다
클래스정보가 들어있는 집합 :  백개든 천개든 클래스들
servletContext: 웹어플리케이션이 시작할때 무조건 만들어짐

근데 어떤타입들의 집합이냐
@HandlesType에 있는
WebApplicationIntializer를 구현한 클래스들 백개든 천개든 jar파일 다 뒤져서 다 찾아줘
그리고 그 클래스들 정보 집합을 나한테 넘겨줘
- - - 
ServletContainer가 jar 다 뒤져서 SerlvetContainerInitializer 구현체 생성
걔한테 onStartup() 시킴
- 이때 주는 파라미터 : WebApplicationIntializer 구현한 클래스들의 정보들이 있는 집합, servletContext
- 그리고 그 클래스들 전부 객체 생성하고 걔네 다 start() 시킴 
start(ctx) : 서블릿 등록하는일

- - -

ServletContainer가 SerlvetContainerInitializer.onStartup() 시킴
WebApplicationIntializer 구현체들 한테 다 start() 시킴
이때 Dispatcher 서블릿이 등록되는거임

녹화했다
2교시
30분20초부터 끊김


------------------------------------

# src-09


------------------------------------

# src-10
------------------------------------

# src-11
------------------------------------

# src-12
------------------------------------
# src-13 : WebApplicationInitializer 구현체를 통해 DispatcherServlet 등록하기 응용 - Java Config 설정

- RootConfig 생성
  - ContextLoaderListener의 IoC 컨테이너가 사용할 Java Config 클래스
- AppServletConfig 생성
  - `app` DispatcherServlet의 IoC 컨테이너가 사용할 Java Config 클래스
- AdminServletConfig 생성
  - `admin` DispatcherServlet의 IoC 컨테이너가 사용할 Java Config 클래스
- AppDispatcherServletInitializer 생성
  - AbstractAnnotationConfigDispatcherServletInitializer 를 상속 받는다.
  - `/app/*` URL 매핑
  - 서블릿 이름은 `app` 으로 설정
- AdminDispatcherServletInitializer 생성
  - AbstractAnnotationConfigDispatcherServletInitializer 를 상속 받는다.
  - `/admin/*` URL 매핑
  - 서블릿 이름은 `admin` 으로 설정
    -


지금까지는 dispatcher Servlet!!!을 등록하는  다양한 방법, 그리고 왜 그렇게 돌아가는지

------------------------------------

App1Config 
bitcamp.app1 패키지에 있는 클래스를 다루는 놈

App1WebApplicationInitializer
등등

페이지 컨트롤러를 생성하는 다양한 방법
파라미터, 리턴 다양한 방법
애노테이션을 다루는 다양한 방법

# src-14


## webapp

------------------------------------

## resources
- log4j2.xml

------------------------------------
## config
- App1Config.java
- App1WebApplicationInitializer.java
- App2Config.java
- App2WebApplicationInitializer.java

------------------------------------
## app1
- Car.java
- Engine.java
  - 둘다 아무거도 안붙어있음

- GlobalControllerAdvice.java



### 하나의 url이 들어온다... 어떤애가 처리할거냐
클라이언트 요청을 구분하는 방법을 배우는거다!!!!!!!!!
1. url이들어온다
그럼 일단 매핑될수있는 메서드는 두개다 get,post

31. url이 들어온다.. 근데 get요청이다
근데 [파라미터] 이름이 뭐냐에 따라 request handler 가 여러개 있을 수 있다 
주의할 건 파라미터 개수, 이름
예)
"name"
"age"
{"age", "name"}
파라미터 없음
에따라 요청 핸들러가 다 다름

32. url이 들어온다.. 근데 get요청이다
근데 [요청헤더] 이름이 뭐냐에 따라
주의할 건 요청헤더 개수, 이름

자바스크립트! 등의 프로그래밍으로 임의의 HTTP 요청을 할 때
HTTP 프로토콜에 표준이 아닌 헤더가 추가될 수 있다.

보통 Open API를 개발하는 서비스 회사에서 많이 사용한다.

33. url이 들어온다 요청헤더중에서 [Accept]의 값에 따라 요청을 구분하기
text/plain 주세요
text/html 주세요
application/json 주세요
pdf 주세요
없음 : html 줄수잇어, ~줄수잇어, ~줄수잇어

34. [클라이언트가 서버에 데이터를 보낼때]
일반적인 링크는 안보낸다
post요청을 할때 보냄
application/x-www-form-urlencoded = 변수=값, 변수=값, 변수=값 ... (얘가 기본임)

자바스크립트!를 사용하여 개발자가 임의의 형식으로 값을 보낼 수 있다.

45. boolean은 파라미터로 null이 넘어오면 false, 근데 int는 null이 오면 자동형변환안되니까 디폴트값줘야됨
문자열을 날짜로 줄 수 없다
다른 페이지 컨트롤러에서 등록한 프로퍼티 에디터는 사용할 수 없다
그래서 글로벌 프로퍼티에디터가 있는것

46. 브라우저 정보는 요청헤더에서 user-agent에 들어있다
".*Edg.*"
. : 어떤 문자 한개
* : 0개이상의 어떤 문자
중간에 Edg가 있다면 엣지브라우저

47. 쿠키
@CookieValue(value = "name1", required = false) String name1
false로 하면 해당 쿠키가 없더라도 에러를 띄우지않음
쿠키를 보낼때 한글이 깨지면 이 예제를 보러와란

48. multipart/form-data 형식의 파라미터 값 받기

App1WebApplicationInitializer
@Override
  protected void customizeRegistration
  오버라이딩이 중요

49. 

51. Entity : 데이터 덩어리
52. 
jsp는 무조건 web-inf밑에둔다
접근못하게한다

DS가
RequestMappingHandlerMapping한테 물어봄
1 DS한테 요청이 들어오면
2 요청 핸들러 찾기 
 - RMHM가 요청핸들러 정보를 리턴해줌
8 

53. 빈그릇좀 줘라
스프링아 빈그릇좀줘라(Model)
h2 : map은 빈그릇
빈그릇 달라그런다음에 값을넣음

-----------------------------------

# app2

31. 
41. 인터셉터

필터 3종 기술(그림)

AOP : 모든객체에 대해서 메서드 호출 앞뒤로 꽂을수있다
주로 서비스, DAO



-----------------------------------

### 요청 핸들러의 파라미터
요청핸들러 : 파라미터로 값받아야지~
: 프론트컨트롤러야 값좀줘
  - 기본값좀줘
  - 클라이언트가 보낸 값좀줘
    - 기본
    - request 좀줘 그럼 내가 꺼낼께
    - 값 객체
      - 프론트 컨트롤러가 파라미터랑 세터명이랑 같으면 그냥 그대로 꽂아서 객체 만들어서 준다..
       - 만약 값 객체 안에 또 값 객체가 있다(Car의 Engine engine 필드)
         // 값 객체 안에 또 값 객체가 있을 때는 OGNL 방식으로 요청 파라미터 값을
         // 지정하면 된다.
         // 예) ...&engine.model=ok&engine.cc=1980&engine.valve=16
    - 44 값받았는데 자동 형변환이 안되는 값이네?(primitive 값만 자동형변환 해준다, 그 외의 타입은 타입 변환기(프로퍼티 에디터)가 있어야한다)
      - 프로퍼티 에디터
        - @RequestParam(defaultValue = "0") int capacity
      - 글로벌 프로퍼티 에디터
    - http 요청 헤더좀줘
    - 쿠키좀줘
    - multipart/form-data 형식값 줘
    - 클라이언트가 보낸 데이터를 한 덩어리로 받기
#### 기본값좀줘
요청 핸들러는 
  @Autowired
  ServletContext sc;
      
  @GetMapping("h1")
  @ResponseBody
  public void handler1(//
      // ServletContext sc, //
      // ServletContext는 파라미터로 받을 수 없다. 예외 발생!
      // 의존 객체로 주입 받아야 한다.
      ServletRequest request, //
      ServletResponse response, //
      HttpServletRequest request2, //
      HttpServletResponse response2, //
      // response, response2 는 주소가 같다
      HttpSession session, //
      Map<String, Object> map, // JSP에 전달할 값을 담는 임시 보관소
      Model model, // Map과 같다. 둘 중 한 개만 받으면 된다.
      PrintWriter out // 클라이언트에게 콘텐트를 보낼 때 사용할 출력 스트림
      ) {

https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-methods
1.3.3. Handler Methods
@RequestMapping handler methods have a flexible signature and can choose from a range of supported controller method arguments and return values.
// signature : 메서드 시그너처! 
요청헨들러는 메서드 시그너처가 유연하다 = 메서드 이름, 파라미터, 리턴타입 마음대로 할수있다 물론 일정지침이 있지만
우리가 선택할 수있는 범위가 있는데 컨트롤러 메서드가 지원하는 범위가 있다
컨트롤러 메서드 아규먼트로서 지원될수 있는 범위가 잇다
리턴타입 값의 범위가 있다
https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-arguments
여깄는거 다줍니다
https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-return-types
리턴값
#### 클라이언트가 보낸 값좀줘

@RequestParam(value = "name") String name1, //
      @RequestParam(name = "name") String name2, // value와 name은 같은 일을 한다.
      @RequestParam("name") String name3, // value 이름을 생략할 수 있다.
      String name // 요청 파라미터 이름과 메서드 파라미터(아규먼트)의 이름이 같다면
                  // 애노테이션을 생략해도 된다.
또는 request야 클라이언트가 보낸 값좀줘도 할수있다
request.getParameter("name")

@RequestParam("name1") String name1, // 애노테이션을 붙이면 필수 항목으로
                                           // 인지한다.
                                           // 따라서 파라미터 값이 없으면 예외가
                                           // 발생한다.
      String name2, // 애노테이션을 붙이지 않으면 선택 항목으로 인지한다.
                    // 따라서 파라미터 값이 없으면 null을 받는다.
      @RequestParam(value = "name3", required = false) String name3, //
      // required 프로퍼티를 false로 설정하면 선택 항목으로 인지한다.
      @RequestParam(value = "name4", defaultValue = "ohora") String name4//
  // 기본 값을 지정하면 파라미터 값이 없어도 된다.
### 요청 핸들러의 리턴값  - 콘텐트를 직접 리턴하기


### 1 페이지 컨트롤러 만드는 방법
spring IoC Container가 만드는거지 당연히..

- 페이지 컨트롤러 만드는 방법
이것이 최소 메서드
파라미터도 없고 클라이언트한테 보낼데이터가 문자열

controller01_1라는 앞글자가 소문자인 이름으로 객체 이름으로 사용된다

- 한 개의 페이지 컨트롤러에 여러 개의 요청 핸들러 두기
- 기본 URL과 상세 URL을 분리하여 설정하는 방법

### 2 GET, POST 구분하기
같은 url인데 get요청, post요청 구분
아니그럼 잠깐만
같은 url인데? 오
그럼 같은 url인데 request handler를 두개까지 둘수있구나

참고 : 상수를 정의하는 문법 enum
상수의 값은 따지지 않고
변수를 그냥 나열

@GetMapping
스프링 4.3부터 쓸수있는 애노테이션



### 4 요청 핸들러의 아규먼트 
- 프론트 컨트롤러로부터 받을 수 있는 파라미터 값
- @RequestParam
- 도메인 객체(값 객체; Value Object)로 요청 파라미터 값 받기
- 프로퍼티 에디터 사용하기
- 글로벌 프로퍼티 에디터 적용하기
- @RequestHeader

- @Cookie
- multipart/form-data 형식의 파라미터 값 받기
- @RequestBody : 클라이언트가 보낸 데이터를 한 덩어리로 받기

### 5 요청 핸들러의 리턴 값 
- 콘텐트를 직접 리턴하기
- view URL 리턴하기, 리다이렉트, forward/include

### 53 요청 핸들러에서 view 컴포넌트(JSP) 쪽에 데이터 전달하기

------------------------------------

## app2
Board.java
Task01.java

### 00 GlobalControllerAdvice.java
### 11 기본 View Resolver 사용하기

### 12 기본 View Resolver 교체 - InternalResourceViewResolver 사용하기

### 2 URL 에서 값 추출하기 
- @PathVariable
- @MatrixVariable
- 정규표현식으로 URL 다루기 

### 3 세션 다루기 
- HttpSession 직접 사용하기
- @SessionAttributes, @ModelAttribute
- 세션의 값을 무효화시키는 방법

### 41 

### 5 JSON 콘텐트 출력하기, 입력받기
- @RestController


### 6 예외 다루기

### ErrorController.java 예외 다루기