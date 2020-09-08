// 생성자의 존재 가장 큰 이유 : 누락!
// + 간결성
package com.eomcs.pms;

import com.eomcs.pms.handler.BoardHandler;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.ProjectHandler;
import com.eomcs.pms.handler.TaskHandler;
import com.eomcs.util.Prompt;

// 1) `/board/add` 명령을 처리한다.
// 2) `/board/list` 명령을 처리한다.
// 3) 새 게시판을 추가한다.
// 4) 새 게시판을 4개 더 추가한다.
public class App {

  public static void main(String[] args) {

    // 외부에서 값을 받을 필요가 없다
    MemberHandler memberHandler = new MemberHandler();
    // ProjectHandler를 생성할 때 필요로 하는 의존객체를 전달한다
    // => 이렇게 생성자를 명확하게 지정하면
    //    객체를 생성하는 개발자에게 인스턴스 사용에 필요한
    //    값이나 의존 객체 주입을 강제하는 효과가 있다
    //    (기본생성자가 없으므로 기본생성자를 쓰면 컴파일러 에러가 뜨기때문에)


    ProjectHandler projectHandler = new ProjectHandler(memberHandler);
    // ProjectHandler의 의존객체 주입을 막는다
//     projectHandler.memberHandler = memberHandler;
    TaskHandler taskHandler = new TaskHandler(memberHandler);
    // TaskHandler의 의존객체 주입을 막는다
//     taskHandler.memberHandler = memberHandler;
    BoardHandler boardHandler = new BoardHandler();
    // 인스턴스를 사용하는데 필요한 의존객체 주입을 누락하더라도
    // 컴파일러는 알 수 없다
    // 실행할 때 의존객체가 누락된 문제가 발생할 것이다
    // nullPointerException : 선언된 의존 객체 레퍼런스가 0(인스턴스를 주지도 않고 어떻게 하냐)

    // nullPointerException : dangling point : 인스턴스 주소가 없다 null이다

    loop:
      while (true) {
        String command = Prompt.inputString("명령> ");

        switch (command) {
          case "/member/add": memberHandler.add(); break;
          case "/member/list": memberHandler.list(); break;
          case "/project/add": projectHandler.add(); break;
          case "/project/list": projectHandler.list(); break;
          case "/task/add": taskHandler.add(); break;
          case "/task/list": taskHandler.list(); break;
          case "/board/add": boardHandler.add(); break;
          case "/board/list": boardHandler.list(); break;
          case "quit":
          case "exit":
            System.out.println("안녕!");
            break loop;
          default:
            System.out.println("실행할 수 없는 명령입니다.");
        }
        System.out.println(); // 이전 명령의 실행을 구분하기 위해 빈 줄 출력
      }

    Prompt.close();
  }
}