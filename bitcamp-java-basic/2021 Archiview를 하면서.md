## 문제 : 
- 팔로우버튼 누르면 지금 메인화면으로 리다이렉트되있음 :
타일즈 적용하면서 follow/addUser를 어디로 보내느냐가 복잡해짐
팔로우버튼은 어디에나 있음 그걸 누르면 그냥 그 페이지(에이잭스?!!)

- 팔로우 리팩토링

- 프로필 화면 [에이잭스] : 윗부분만 남기고 밑부분 에이잭스

----------------------------------------------------------------------

## redirect vs refresh

### 1. 리프레시 : 화면을 출력한 후 다른 화면으로 자동 이동(출력시간 설정 가능)

구현 방법
Response Header에 리프레시 설정을 추가 resp.addHeader("Refresh", "1:url=list");
html meta 태그로 설정 <meta http-equiv='Refresh' content='1; url=list'>

### 2. 리다이렉트 : 화면을 출력하지 않고 바로 다른 화면으로 이동

구현 방법
response.sendRedirect() 메서드를 사용
HTTP 응답 상태코드가 302로 반환됨(요청 자원이 다른 URL로 이동되었으니 Location Header에 있는 주소로 다시 요청하라)
HTTP Header에 Location 으로 리다이렉트되는 URL이 들어감
response.sendRedirect("list");

