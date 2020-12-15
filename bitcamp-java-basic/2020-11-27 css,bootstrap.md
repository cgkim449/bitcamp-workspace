# css

div말고도 모든 태그에 id를 지정할 수 있음
div : 태그들을 묶어서 그룹지음

아예 상관없이 태그를 임의적으로 분류할 때 쓰는게 class
한태그가 여러개 그룹class에 소속될수잇다

슈도셀렉터 = 상태 셀렉터라 이해하자
대상자의 상태를 지정하는 문법이다
li:hover : hover상태인 li

같은 id를 갖는 태그가 존재해선 안된다

정밀

/* 스타일 적용 순서
     => specificity 값이 같을 때?
        나중에 선언된 스타일이 이전에 선언한 스타일을 덮어쓴다.
        주의!
        같은 스타일을 덮어쓴다는 것이다.
        다른 스타일은 아니다.
         (기존에 있는 스타일은 안 없앤다는 거임)

    CSS 작성 순서에 대한 권장!
    => 우선 순위에 낮은 스타일부터 작성하라!
    => 아래로 내려 갈수록 우선 순위가 높은 스타일을 작성하라.
    => 예)
    * {...}
    태그명 {...}
    .클래스명 {...}
    #아이디명 {...}
   */


### 5-3 in-line은 안먹여진다 그게 싫다 in-line block
in-line tag는 위아래margin, width, heigth 다 안먹여짐(좌우 margin은 됨)
근데 in-line인데 다 먹이고 싶다 그럼 in-line block으로!

주의 : 마진이랑 html 코드 공백이랑 헷갈리지말자

### 5-4 width, height는 기본이 컨텐츠다 content-box 그게 싫다 border-box
보더! 패딩!을 조절하면 전체 크기가 변하지 않게!

태그 너비와 높이
    content-box(기본)
      => width = 콘텐츠 너비
      => height = 콘텐츠 높이
    border-box
    => width = 콘텐츠너비 + 좌,우 패딩너비 + 좌,우 테두리너비
    => height = 콘텐츠높이 + 위,아래 패딩높이 + 위,아래 테두리높이

### 6-1 폰트 종류
#menu {
    font-family: '맑은 고딕', 굴림체, 'Apple SD Gothic Neo', sans-serif;
    // 이름에 공백이 있으면 '' 붙여야됨
    /* 의미
       => 맑은 고딕 폰트를 사용하라. 없다면 다음 폰트 사용하라.
       => 모두 없다면 웹브라우저에 설정된 sans-serif 기본 폰트를 사용하라.

       그래서 순서는 항상 폰트, 폰트, ... , 폰트 그룹명
       현업 : 윈도우 상에서 많이 있는 폰트, 맥or리눅스, 맥or리눅스, 그래도 없으면 마지막
     */
  } 

### 6-2 폰트 크기
  /* font-size: 20px; */ 폰트사이즈는 너비가 아니라 높이!다 보통 바디 폰트사이즈 small을 많이 쓴다
  /* 실무에서는 유지보수를 쉽게 하기 위해 
       body!! 태그에 설정한 기본 폰트 크기를 기준으로 비율로 지정한다. */
    /* font-size: 1.2em; */
    그래서 바디만 폰트 사이즈 조절하면 전체다 조절되게!

### 6-3 폰트 종류와 폰트 크기는 바디에서!!! 상속된다!
/* 폰트 크기 II
    => 폰트 크기를 특정 숫자로 고정을 시키면
       유지보수할 때 폰트의 크기를 변경하기가 번거로워진다.
       모든 스타일을 다 변경해야 하기 때문이다.
    => 실전!
       폰트는 자동으로 자식 태그에게 상속하는 스타일이기 때문에
       body에서 font-family를 지정한다.
       그리고, body에 폰트 크기를 지정한 다음,
       나머지 태그에 대해서는 상대 크기를 지정한다.
    => font-size 상대 크기를 지정하는 문법
       몇 배수인지 지정 => 2.4em
       %로 지정         => 240%
  */

### 7-5 배경이미지 너비를 정하면 높이는 자동으로 결정됨
### 7-6 
#d2 {
    background: red url('img02.png') no-repeat right 100px top 10px;
    /*
    right top 둘다 써야 먹히더라 right하나만 쓰니까 안먹힘
    */
  }
### 7-7 배경 이미지를 여러개 설정하기
body {
    height: 300px;
    border: 2px solid red;
    background: url('img02.png') no-repeat left top,
                url('img01.jpeg') no-repeat left 80px top 50px;
                /*
                밑에 쓴이미지가 먼저 출력되고 위에거가 나중에 출력되서
                위에거가 밑에거 위에 올라가게 겹쳐짐
                */
    background-size: 100px, 50px; 
    /* 값을 한 개 주면 그 값을 모든 이미지에 적용한다.
    각각의 이미지에 너비를 지정하고 싶다면,
    이와같이 콤마(,)를 사용하여 지정하라! */
  }
### 7-9 배경 응용 - 위치이동방식
아이콘 파일 1개
이미지가 들어갈 div를 딱 하나 만든다 <div id="state"></div>

위치이동 말고
아예 아이콘색이 단색!이라면 폰트로 만들어버린다 트위터가 그렇게함
폰트는 문자코드다 
### 7-10 배경 응용 - 폰트방식
단색?이 뭔진 모르겟지만 단색일때밖에 못한다고함
### 7-11 배경 응용 - 가장중요
웹페이지를 작성할때 검색엔진 친화적으로 작성해야한다
검색엔진에게 충분한 정보를 줘야한다
검색엔진이 이해할수있도록 의미있는 태그를 작성한다

바깥에 밀려난 컨텐츠는 화면에 안보이게한다 - overflow - hidden

### 9
block : 
       => [한 줄]을 모두 점유한다.
       => 자신의 너비와 높이를 가질 수 있다.
inline : 
       => 한 줄 속에 포함되어 다른 태그와 그 [줄]을 함께 공유한다.
       => 자신의 너비와 높이를 가질 수 없다.
          [콘텐츠의 크기에 따라 너비와 높이가 결정된다.]

          패딩이랑 좌우마진은 먹는다, 근데 높이너비는 안먹어..
          그렇다고 block으로 바꾸자니 높이너비, 위아래마진은 먹는데 한줄을 다 점유해버려서 세로로 서버려..
          그래서 다른놈과 라인을 공유하면서도! 블록처럼 자신만의 크기를 갖고싶다!
          그럼 가로로 ( 한줄로! 놓여지는거지)
          마진과 공백(스페이스바)는 항상 주의하자

inline-block : 
       => inline 처럼 한 줄을 다른 태그와 공유한다.
       => block 처럼 자신의 너비와 높이를 가질 수 있다.


누르면 나타나고 없어지고 : display : none? visibility : hidden?

### 10,11 하이라이트!!
#### 10-2 float
float
    => 태그가 출력되는 현재 위치!에서 공중부양시킨다.
    => 다음 태그가 현재 태그의 자리를 차지할 것이다.
    => left 또는 right 정렬만 가능하다.
    => float일 때 유의할 점
      1) width와 height를 지정하지 않으면, inline 처럼 콘텐츠의 크기에 따라!
          너비, 높이가 결정된다.
      2) margin이 서로 겹치지 않고 그대로 유지한다.(원래는 위아래 마진 겹치는거 알잖슴, 근데 플롯하자마자 마진이 20이 되버림 원랜 10이었다면)
         일반적인 경우 위,아래 margin은 서로 겹쳐 표현한다. 

#### 10-3 32분부터

- - -

12-9
남이 만든 css, js 쓸때 두가지방법이 있다

## 다운방식(실무에선 이걸씀)
<link rel="stylesheet" type="text/css" href="../node_modules/sweetalert2/dist/sweetalert.css">
npm -v
webapp에서
npm install bootstrap@next
이클립스 webapp폴더 새로고침 -> node_modules 폴더 생김 이것이 다운로드 방식

### nodejs 다운
https://nodejs.org/en/ -> lts버전 other download -> Installing Node.js via package manager

또는 scoop install nodejs

  
## 임포트 방식CDN
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" 
  rel="stylesheet" 
  integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" 
  crossorigin="anonymous">
test11_2.html
사이트의 introduction에서 css, js 링크 모두 복붙
https://sweetalert2.github.io/#download의 installation에서
npm install sweetalert2 복붙(webapp폴더 밑에서)
그럼 이클립스에서 새로고침하면 node_modules 폴더 밑에 sweetalert2생김
그 밑에 dist폴더(distribution)

주의! : (실무)옛날꺼 유지보수할땐 절대 라이브러리 교체 ㄴㄴ(예: 부트스트랩 옛날 버전이더라도 교체 ㄴㄴ npm을 쓸일이 없을거다)

.gitignore 수정해야(mini pms 참고)


주의
nodemodules 폴더가 분명히 있음에도 안보인다면 이클립스에서 안보이게 설정된것이다


팀원중 한명이
webapp에서 
npm init 
계속 엔터
그럼 package.json 파일 생성(gradle init 마냥)
npm install --save bootstrap@next 
npm install --save sweetalert2
푸쉬

나머지 팀원은 깃풀하고
packcage.json이 있으면 쉽다(거기에 gradle 의 dependency처럼 bootstrap, sweetalert2 이런애들이있음) 
npminstall(webapp밑에서)


