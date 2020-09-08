package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.util.Prompt;

public class ProjectHandler {

  static class Project {
    int no;
    String title;
    String content;
    Date startDate;
    Date endDate;
    String owner;
    String members;
  }
  static final int LENGTH = 100; // 공통으로 사용할 값을 보관하는 변수는 스태틱 멤버(클래스 멤버)로 만든다.

  Project[] list = new Project[LENGTH]; // 개별적으로 값을 보관해야 하는 변수는 인스턴스 멤버(non-static 멤버)로 만든다.
  int size = 0;

  //외부에서 직접 이 변수를 사용하지 않기 때문에
  // public으로 공개한 것을 취소한다
  private MemberHandler memberHandler; // 의존객체 레퍼런스 선언 : 메서드들이 사용한다

  // 인스턴스 변수들을 유효한 값으로 초기화시키는
  public ProjectHandler(MemberHandler memberHandler) {
    this.memberHandler = memberHandler;
  }

  public void add() {
    System.out.println("[프로젝트 등록]");

    Project project = new Project();
    project.no = Prompt.inputInt("번호? ");
    project.title = Prompt.inputString("프로젝트명? ");
    project.content = Prompt.inputString("내용? ");
    project.startDate = Prompt.inputDate("시작일? ");
    project.endDate = Prompt.inputDate("종료일? ");

    while (true) {
      String name = Prompt.inputString("만든이?(취소: 빈 문자열) ");

      if (name.length() == 0) {
        System.out.println("프로젝트 등록을 취소합니다.");
        return;
      } else if (memberHandler.findByName(name) != null) {
        project.owner = name;
        break;
      }

      System.out.println("등록된 회원이 아닙니다.");
    }

    StringBuilder members = new StringBuilder();
    while (true) {
      String name = Prompt.inputString("팀원?(완료: 빈 문자열) ");

      if (name.length() == 0) {
        break;
      } else if (memberHandler.findByName(name) != null) { // 의존객체
        if (members.length() > 0) {
          members.append(",");
        }
        members.append(name);
      } else {
        System.out.println("등록된 회원이 아닙니다.");
      }
    }
    project.members = members.toString();

    list[size++] = project;
    // MemberHandler의 인스턴스 필드가 외부로부터의 접근을 막지 않기 때문에
    // 다음과 같이 임의의 값으로 변경될 수 있다
    // => 문제는 이렇게 변경된 값을 사용하는 다른 쪽에서 영향을 받을 수 있다
//    memberHandler.size = 0;
    // 이렇게 무효한 값으로 변경하는 것을 막지 못한다면?
    // 코드를 작성한 의도와 다르게 동작할 수 있다
    //project.add 했을뿐인데
  }

  public void list() {
    System.out.println("[프로젝트 목록]");

    for (int i = 0; i < size; i++) {
      Project project = list[i];
      System.out.printf("%d, %s, %s, %s, %s, [%s]\n",
          project.no,
          project.title,
          project.startDate,
          project.endDate,
          project.owner,
          project.members);
    }
  }
}
