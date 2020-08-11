package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App {

  static Scanner keyboardScan = new Scanner(System.in);
  static class Member {
    int no;
    String name;
    String email;
    String password;
    String photo;
    String tel;
    Date registeredDate;
  }
  static final int LENGTH = 100;
  static int size = 0;
  static Member[] members = new Member[LENGTH];


  static class Project {
    int no;
    String title;
    String content;
    Date startDate;
    Date endDate;
    String owner;
    String members;
  }
  static final int PLENGTH = 100;
  static int psize = 0;
  static Project[] projects = new Project[PLENGTH];

  static class Task {
    int no;
    String content;
    Date deadline;
    String owner;
    int status;
  }
  static final int TLENGTH = 100;
  static int tsize = 0;
  static Task[] tasks = new Task[TLENGTH];

  public static void main(String[] args) {

    loop:
      while (true) {
        String command = promptString("명령> ");

        switch (command) {
          case "/member/add":
            addMember();
            break;
          case "/member/list":
            listMember();
            break;
          case "/project/add":
            addProject();
            break;
          case "/project/list":
            listProject();
            break;
          case "/task/add":
            addTask();
            break;
          case "/task/list":
            listTask();
            break;
          case "quit":
          case "exit":
            System.out.println("안녕!");
            break loop;
          default:
            System.out.println("실행할 수 없는 명령입니다.");
        }
        System.out.println(); // 이전 명령의 실행을 구분하기 위해 빈 줄 출력
      }

    keyboardScan.close();
  }

  static void addMember() {
    System.out.println("[회원 등록]");
    Member m = new Member();
    m.no = promptInt("번호? ");
    m.name = promptString("이름? ");
    m.email = promptString("이메일? ");
    m.password = promptString("암호? ");
    m.photo = promptString("사진? ");
    m.tel = promptString("전화? ");
    m.registeredDate = new java.sql.Date(System.currentTimeMillis());
    members[size++] = m;
  }

  static void listMember() {
    System.out.println("[회원 목록]");

    for (int i = 0; i < size; i++) {
      Member m = members[i];
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          m.no, m.name, m.email, m.tel, m.registeredDate);
    }
  }

  static void addProject() {
    System.out.println("[프로젝트 등록]");
    Project p = new Project();
    p.no = promptInt("번호? ");
    p.title = promptString("프로젝트명? ");
    p.content = promptString("내용? ");
    p.startDate = promptDate("시작일? ");
    p.endDate = promptDate("종료일? ");
    p.owner = promptString("만든이? ");
    p.members = promptString("팀원? ");

    projects[psize++] = p;
  }

  static void listProject() {
    System.out.println("[프로젝트 목록]");

    for (int i = 0; i < psize; i++) {
      Project p = projects[i];
      System.out.printf("%d, %s, %s, %s, %s\n",
          p.no, p.title, p.startDate, p.endDate, p.owner);
    }
  }

  static void addTask() {
    System.out.println("[작업 등록]");
    Task t = new Task();
    t.no = promptInt("번호? ");
    t.content = promptString("내용? ");
    t.deadline = promptDate("마감일? ");
    t.status = promptInt("상태?\n0: 신규\n1: 진행중\n2: 완료\n> ");
    t.owner = promptString("담당자? ");

    tasks[tsize++] = t;
  }

  static void listTask() {
    System.out.println("[작업 목록]");
    for (int i = 0; i < tsize; i++) {
      Task t = tasks[i];
      String stateLabel = null;
      switch (tstatus[i]) {
        case 1:
          stateLabel = "진행중";
          break;
        case 2:
          stateLabel = "완료";
          break;
        default:
          stateLabel = "신규";
      }
      // 번호, 작업명, 마감일, 프로젝트, 상태, 담당자
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          tno[i], tcontent[i], tdeadline[i], stateLabel, towner[i]);
    }
  }

  static String promptString(String title) {
    System.out.print(title);
    return keyboardScan.nextLine();
  }

  static int promptInt(String title) {
    return Integer.parseInt(promptString(title));
  }

  static Date promptDate(String title) {
    return Date.valueOf(promptString(title));
  }
}
