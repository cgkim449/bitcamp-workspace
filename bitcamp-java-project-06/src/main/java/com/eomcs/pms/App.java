package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App {
  //-------------------------------------------
  static Scanner keyInput = new Scanner(System.in);

  static final int LENGTH = 10;

  static int[] no = new int[LENGTH];
  static String[] name = new String[LENGTH];
  static String[] email = new String[LENGTH];
  static String[] password = new String[LENGTH];
  static String[] photo = new String[LENGTH];
  static String[] tel = new String[LENGTH];
  static Date[] now = new Date[LENGTH];

  static int count = 0;
  //--------------------------------------------

  static final int PLENGTH = 10;

  static int[] pno = new int[PLENGTH];
  static String[] ptitle = new String[PLENGTH];
  static String[] pcontent = new String[PLENGTH];
  static String[] pauthor = new String[PLENGTH];
  static String[] pteammates = new String[PLENGTH];
  static Date[] pstartDate = new Date[PLENGTH];
  static Date[] pendDate = new Date[PLENGTH];

  static int pcount = 0;
  //---------------------------------------------
  static final int TLENGTH = 10;

  static int[] tno = new int[TLENGTH];
  static String[] tcontent = new String[TLENGTH];
  static Date[] tendDate = new Date[TLENGTH];
  static String[] tstate = new String[TLENGTH];
  static String[] tauthor = new String[TLENGTH];

  static int tcount = 0;
  //----------------------------------------------
  public static void main(String[] args) {

    loop : while (true) {

      String command = promptString("명령> ");

      switch (command.toLowerCase()) {
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
        case "exit":
        case "quit":
          System.out.println("안녕!");
          break loop;
        default :
          System.out.println("실행할 수 없는 명령어입니다.");
      }
      System.out.println();
    }
    keyInput.close();
 }

  static void addMember() {
    System.out.println("[회원등록]");

//    String input = prompt("번호? ");
//    no[count] = Integer.parseInt(input);

    no[count] = promptInt("번호? ");
//    no[count] = Integer.parseInt(App.prompt("번호? ")); // 도구함.도구

//    keyInput.nextLine(); 필요없어진다

    name[count] = promptString("이름? ");
    email[count] = promptString("이메일? ");
    password[count] = promptString("암호? ");
    photo[count] = promptString("사진? ");
    tel[count] = promptString("전화? ");

    now[count] = new Date(System.currentTimeMillis());
    count++;
  }

  static void listMember() {
    System.out.println("[회원목록]");
    for (int i = 0; i < count; i++) {
      System.out.printf("%d, %s, %s ,%s, %s\n",
          no[i], name[i], email[i], tel[i], now[i].toString());
    }
  }

  static void addProject() {
    pno[pcount] = promptInt("번호? ");
    ptitle[pcount] = promptString("프로젝트명? ");
    pcontent[pcount] = promptString("내용? ");
    pstartDate[pcount] = promptDate("시작일? ");
    pendDate[pcount] = promptDate("종료일");
    pauthor[pcount] = promptString("만든이");
    pteammates[pcount] = promptString("팀원");
    pcount++;
  }

  static void listProject() {
    for (int i = 0; i < pcount; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          pno[i], ptitle[i], pstartDate[i].toString(), pendDate[i].toString(), pauthor[i]);
    }
  }

  static void addTask() {
    tno[tcount] = promptInt("번호? ");
    tcontent[tcount] = promptString("내용? ");
    tendDate[tcount] = promptDate("마감일? ");

    tstate[tcount] = promptString("상태? \n0: 신규 \n1: 진행중 \n2: 완료 \n> ");
    switch (tstate[tcount]) {
      case "0":
        tstate[tcount] = "신규";
        break;
      case "1":
        tstate[tcount] = "진행중";
        break;
      case "2":
        tstate[tcount] = "완료";
        break;
    }

    tauthor[tcount] = promptString("담당자? ");
    tcount++;
  }

  static void listTask() {
    for (int i = 0; i < tcount; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          tno[i], tcontent[i], tendDate[i].toString(), tstate[i], tauthor[i] );
    }
  }

  static String promptString(String title) {
    System.out.print(title);
    return keyInput.nextLine();
  }

  static int promptInt(String title) {
    return Integer.parseInt(promptString(title));
  }

  static Date promptDate(String title) {
    return Date.valueOf(promptString(title));
  }
} // 중간과정을 훈련해야, 결과물만 연습 x