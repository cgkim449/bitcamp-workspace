<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<h1>JSTL - c:import</h1>
<pre>
- HTTP 요청을 수행하는 코드를 만든다.
</pre>

<h2>HTTP 요청하기</h2>
<!-- URL을 만들고 url1이라는 이름으로 PageContext에 보관한다 -->
<c:url value="ex10_sub.jsp" 
       var="url1">
    <c:param name="name" value="홍길동"/>
    <c:param name="age" value="20"/>
    <c:param name="gender" value="woman"/>
</c:url>
<pre>${url1}</pre>

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
</body>
</html>












