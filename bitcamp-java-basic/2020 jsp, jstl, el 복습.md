일단 결론 :
JSTL 태그로 보관소에 객체 넣고 제거하고
EL로 보관소에서 값을 꺼내자

- - -


# 출력 방법 5가지

<h2>오호라!!!</h2>

<%
out.println("<h2>오호라!!!</h2>");
%>

<%="<h2>오호라!!!</h2>"%>

<!-- 밑 두가지 방법 추천, 위 두개는 자바코드인데 jsp에 자바코드 들어가는건 비추-->

${"<h2>오호라!!!</h2>"}

<c:out value="<h2>오호라!!!<h2>"/>

- - -

# JSTL

JSTL 쓰면 import 더이상 필요없다???

- - -

jsp에서는
출력만하자
자바코드에서 다 처리하고 넘겨주자는 선배도 있고

- - -

# JSP

## ex01 JSP 개요
## ex02 .jsp에서 그냥 텍스트 쓰면 out.write 다 붙음
## ex03 <% %> - 스크립트릿(scriptlet)과 JSP 주석
스크립트릿: JSP 파일 안에 자바 코드를 넣는 태그

## ex04 스크립트릿(scriptlet) 응용
이게 왜 응용인지
## ex05 <%= %> - 표현식(expression)
문장 : 걍 모든 문장
표현식이란 : 값을 리턴하는 문장
주의) out.println("okok")  <---- 이 문장은 값을 리턴하지 않는다. 따라서 표현식이 아니다.

예)
<%for (String name : names) {%>
<li><%=name%></li>
<%}%>

자바코드 :
for (String name : names) {
      out.write("\r\n");
      out.write("<li>");
      out.print(name);
      out.write("</li>\r\n");
}
즉, 무조건 out.print()가 붙음 
( out.print( = <%
    , ) = %>)

## ex06 <%! %> - 선언부
클래스에 멤버!를 추가할 때 사용한다.
jspInit()나 jspDestroy()와 같은 메서드를 오버라이딩 할 때도 사용할 수 있다.
선언하는 위치는 상관없다. : jsp 파일 내 아무데서나 <%! 멤버 선언 %> 해도 상관없음
문법 : <%! 멤버 선언 %>

## ex07,8,9 <%@ %> - 지시문
1) page
  - 서블릿 실행과 관련하여 특정 기능을 설정한다.
2) include
  - 다른 파일의 내용을 복사해온다.
3) taglib
  - JSTL 등 외부에서 정의한 태그 정보를 가져온다.

## ex10 : JSP 빌트인 객체 - JSP에서 기본으로 사용할 수 있는 객체, 보관소에 자바코드로 객체 넣기

```jsp
<body>
<%
// JSP에서 기본으로 준비한 변수를 사용할 수 있다.
application.setAttribute("ccc", "haha");
session.setAttribute("bbb", "nono");
request.setAttribute("aaa", "okok");
pageContext.setAttribute("s4", "윤봉길");
out.println("okok");
%>
</body>
</html>
```

## ex11 : JSP 액션 태그 - jsp:useBean, jsp:setProperty
- jsp:useBean
=> JSP에서 사용할 객체를 생성할 때 사용할 수 있다.
=> 또는 보관소(ServletContext, HttpSession, ServletRequest, PageContext)에 
   저장된 객체를 꺼낼 때도 사용한다.
=> 사용법
     <jsp:useBean scope="보관소명" id="객체명" class="클래스명"/> 
     만약 보관소에 이 id의 객체가 있으면 꺼내고
     없으면 "클래스명"의 클래스의 객체를 생성해 "객체명"이란 id로 보관소에 저장한다
     scope을 지정하지않으면 기본이 PageContext다
     보관소는 application, session, request, page 4개밖에 못쓴다 

- jsp:setProperty
객체의 setter 메서드를 호출한다
<jsp:setProperty name="b3" property="no" value="100"/>
<jsp:setProperty name="b3" property="contents" value="내용입니다."/>
<jsp:setProperty name="b3" property="viewCount" value="88"/>
자바 원시 타입과 문자열을 제외한 속성의 값을 지정할 수 없다. 따로 처리해야 한다. 
와 진짜 불편하네 어떻게함?
예) <jsp:setProperty name="b3" property="createdDate" value="2019-4-8"/>

## ex12 : JSP 액션 태그 - jsp:useBean : 보관소에 저장된 객체 꺼내기
보관소에 없는 객체를 꺼내려 하면 예외 발생!
type 속성, class 속성 둘다 써도 된다
## ex13~17 : JSP 액션 태그 - jsp:useBean : 보관소에 저장된 객체 꺼내기
page 보관소에서 key=list로 저장되있는 java.util.ArrayList<String> 객체를 꺼내고 싶다
<!-- class 속성은 제네릭을 쓸수없음 -->
<%-- <jsp:useBean id="list" class="java.util.ArrayList" scope="page"/> --%>
<jsp:useBean id="list" type="java.util.ArrayList<String>" scope="page"/>

type에는 인터페이스, 추상클래스도?를 지정할 수 있다.
<jsp:useBean id="list" type="java.util.List<String>" scope="page"/>
type 속성을 사용했을때 id로 지정된 객체를 찾지 못하면 예외가 발생한다. 
class는 객체를 찾지못하면 만든다
그래서 인터페이스, 추상클래스를 지정할수없는것! 제네릭도 지정할 수 없다

## ex13~18 : JSP 액션 태그 - jsp:useBean : type과 class를 함께써라!
for ( : ) 문을 제대로 사용하려면 목록에 보관된 객체의 타입이 무엇인지 
     제네릭!으로 지정해야 한다.
     그러나 class에서는 제네릭을 지정할 수 없다.
     해결책?
     - type과 class를 함께써라!
     - type으로 제네릭을 표현하고 class로 객체를 생성할 클래스를 지정하라! 
<jsp:useBean id="list"
    type="java.util.List<String>"
    class="java.util.ArrayList" scope="page"/>

## ex19 : JSP 액션 태그 - jsp:include, jsp:forward
jsp:include
=> 다른 페이지로 실행을 위임한 후 그 실행 결과를 포함시킬 때 사용한다.
   실행이 끝난 후 제어권!이 되돌아 온다.
=> 따라서 page 속성에 지정하는 URL은 서블릿/JSP 이어야 한다.
=> RequestDispatcher.include() 코드를 생성한다.

jsp:forward
=> 다른 페이지로 실행을 위임할 때 사용한다.
   제어권이 넘어가면! 되돌아 오지 않는다.
=> 따라서 page 속성에 지정하는 URL은 서블릿/JSP 이어야 한다.
=> RequestDispatcher.forward() 코드를 생성한다.


## ex20 : errorPage 속성과 isErrorPage 속성 : page 지시문의 속성

errorPage
=> JSP를 실행하는 중에 오류가 발생했을 때 실행할 JSP를 지정할 수 있다.
=> 어떻게?
     <%@ page errorPage="URL"%>
=> 이 속성에 URL을 지정하지 않으면 오류가 발생했을 때 
   서블릿 컨테이너의 기본 오류 출력 페이지가 실행된다.
     
isErrorPage
=> 오류가 발생했을 때 실행되는 JSP 쪽에서
   그 오류 내용을 받을 때 사용한다. 

오류가 발생했을 때 실행되는 JSP 페이지는 
exception이라는 변수를 통해 오류 내용을 받을 수 있다.
단, isErrorPage 속성이 true이어야 해당 변수가 준비된다.

- - -

# EL

## ex01
## ex02,3 보관소에서 값 꺼내는 문법
key로 꺼낸다
    pageScope 
      - ${ pageScope.객체이름 }
        => pageContext.getAttribute("객체이름");
    requestScope 
      - ${ requestScope.객체이름 }
        => request.getAttribute("객체이름");
    sessionScope 
      - ${ sessionScope.객체이름 }
        => session.getAttribute("객체이름");
    applicationScope 
      - ${ applicationScope.객체이름 }
        => application.getAttribute("객체이름");

보관소의 이름을 지정하지 않으면 다음 순서로 값을 찾는다.
    pageScope ==> requestScope ==> sessionScope ==> applicationScope
보관소에 저장된 값을 찾지 못하면 빈 문자열!!을 리턴한다.
(참고 : java:usebean(type 속성)은 예외 던짐)

## ex04 리터럴 - 즉, EL에서 문자열이나 다른 리터럴들을 표현하는 방법
문자열 표현 방법은 알아야겠는데 나머지는 왜 알아야되는거지?

문자열: ${"홍길동"}<br>
문자열: ${'홍길동'}<br>
정수: ${100}<br>
부동소수점: ${3.14}<br>
논리값: ${true}<br>
null: ${null}<br>

## ex05~8 배열, List객체, Map 객체, 일반 객체에서 값꺼내기
예제에서는 단순히 jsp에서 선언한 위 객체들에서
값을 꺼낼때 EL을 사용하는 방법을 보여준다

## ex09 - 연산자
- 산술, 논리, 관계, 조건 연산자 : 위에서 리터럴 표현 방법과 마찬가지로 왜 알아야되는건지 모르겟는것들

- empty 연산자 
보관소에 해당 객체가 없는지 검사한다. 없으면 true, 있으면 false.
예 : ${empty name}
pageContext에 name이라는 key로 보관되있는 객체가 없는가?
없으면 true, 있으면 false



- - -

# JSTL
## ex01 : JSTL 개요
## ex01 :  c:out - 출력문을 만드는 태그
<c:out value="출력될 값" default="기본 값"/>
<c:out value="출력될 값>기본값<c:out>
## ex03 :  c:set - 보관소에 값을 저장한다
위에 JSP에서 자바코드로 보관소에 값 저장했는데 그러지말고 이거 쓰자
## ex04 :  c:remove - 보관소에 값을 제거한다

## ex05 :  c:if - 조건문을 만든다
조건문을 만든다
조건문의 결과를 보관소에 저장하기
## ex06 :  c:choose - 다중조건문을 만든다(자바의 switch와 유사)
## ex07 :  c:forEach - 반복문을 만든다
## ex08 :  c:forTokens - 반복문을 만든다

## ex09 :  c:url - 복잡한 형식의 URL을 만들 수 있다???????
네이버 검색 URL 만들기
## ex10 :  c:import - HTTP 요청을 수행하는 코드를 만든다??????
<!-- 겟요청보낼 url을 c:url 태그로 만들어서
그 url을 써서 c:import로 겟요청을 보내는것
그리고 var로 받는건 ... 
아 잠깐 그럼 내가 필요한거만 추출하면 되는건가? -->

<%-- 지정된 URL을 요청하고 서버로부터 받은 콘텐트를 contents라는 이름으로 
     PageContext 보관소에 저장한다. --%>
     <!-- 아니... 서버로부터 받은 콘텐트가..
     내가 위에서 겟요청? 보낸거.. 걔가 받은후의..
     걔 html전문이야? -->
<c:import url="${url1}" var="contents"/>

<textarea cols="120" rows="20">${pageScope.contents}</textarea>

<!-- 이거도.. 내가 요청을 보냇어..
근데 거기서 html전문을 보내왔어.. 이걸 어따 쓰는데 
잠깐만 이거랑 정규표현식 결합하면 크롤링인가? -->
<c:import url="https://www.naver.com" var="contents2"/>
<textarea cols="120" rows="20">${pageScope.contents2}</textarea>
## ex11 :  c:redirect - redirect 응답하기??????

## ex12 :  c:fmt:parseDate - 문자열로 지정된 날짜 값을 java.util.Date 객체로 만들기?
## ex13 :  fmt:formatDate - java.util.Date 객체의 값을 문자열로 만들기?