# eomcs-java-web
자바 웹 프로그래밍 예제 모음

## src-00

### 자바 웹 프로젝트 생성과 배포

- 자바 웹 프로젝트 폴더 준비
  - `$ gradle init` 실행 후 `src/main/webapp` 폴더 추가 
- build.gradle 설정
  - `java`, `eclipse-wtp`, `war` 플러그인 추가
  - `servlet-api` 라이브러리 추가
- 예제 파일 준비
  - `src/main/webapp/hello.html` 예제 HTML 파일 추가
  - `src/main/webapp/test.jpeg` 예제 이미지 파일 추가
- .war 파일 생성
  - `$ gradle build` 실행
- .war 파일을 톰캣 서버에 배포
  - `$CATALINA_HOME/webapps/` 폴더에 복사
- 톰캣 서버 실행  
  - 현재 실행 중이면 재실행한다.
  - `$CATALINA_HOME/bin/startup.bat` 파일 실행(Windows)
  - `$CATALINA_HOME/bin/startup.sh` 파일 실행(Linux/macOS/Unix)
  - webapps/*.war 파일이 자동으로 압축이 풀린다.
- 테스트
  - `http://localhost:8080/eomcs-web-project/hello.html` 요청

### 이클립스와 톰캣 서버 연동하기

- 이클립스에 톰캣 서버 경로 등록하기
  - 이클립스 메뉴 > Window >  Preferences...
    - Server > Runtime Environments > add 버튼 클릭
    - 톰캣 서버의 디렉토리를 등록한다.
- 이클립스에 웹 프로젝트 실행을 위한 테스트 서버 환경 구축하기
  - 이클립스 > Servers 뷰 > 새 서버 실행 환경 등록
- 웹 프로젝트를 테스트 서버에 배포하기
  - 이클립스 > Servers 뷰 > 서버 실행 환경 > add
    - 프로젝트를 추가한다.
- 테스트 서버 실행하기
  - 이클립스 > Servers 뷰 > 서버 실행 환경 > start 실행
  - 실행 과정
    - 테스트 서버의 특정 폴더에 웹 프로젝트 배포 폴더를 생성한다.
      - $HOME/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core
        - tmpX 폴더를 생성한다.
        - tmpX/wtpwebapps/ 폴더에 웹 애플리케이션을 배포한다.
    - 배포 대상과 위치
      - 자바 클래스 ==> wtpwebapps/웹애플리케이션폴더/WEB-INF/classes/
        - src/main/java 에 있는 모든 소스 파일을 컴파일한다.
        - 클래스 파일(.class)을 해당 폴더에 복사한다.
      - 기타 자원 파일 ==> wtpwebapps/웹애플리케이션폴더/WEB-INF/classes/
        - src/main/resources 에 있는 모든 파일을 해당 폴더에 복사한다.
      - 웹 파일 ==> wtpwebapps/웹애플리케이션폴더/
        - src/main/webapp 에 있는 모든 파일을 해당 폴더에 복사한다.
      - 라이브러리 파일 ==> wtpwebapps/웹애플리케이션폴더/WEB-INF/lib/
        - 프로젝트에서 사용하는 의존 라이브러리 파일(*.jar)을 해당 폴더에 복사한다. 

## src-01




