package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

// 1) 명령 프롬프트를 출력한다
public class App {
  public static void main(String[] args) {
    Scanner keyInput = new Scanner(System.in);

    final int LENGTH = 10;
    int[] no = new int[LENGTH];
    String[] name = new String[LENGTH];
    String[] email = new String[LENGTH];
    String[] password = new String[LENGTH];
    String[] photo = new String[LENGTH];
    String[] tel = new String[LENGTH];
    Date[] now = new Date[LENGTH];
    long currentMilli;

    int count = 0;

    final int PLENGTH = 10;

    int[] pno = new int[PLENGTH];
    String[] ptitle = new String[PLENGTH];
    String[] pcontent = new String[PLENGTH];
    String[] pauthor = new String[PLENGTH];
    String[] pteammates = new String[PLENGTH];
    Date[] pstartDate = new Date[PLENGTH];
    Date[] pendDate = new Date[PLENGTH];

    int pcount = 0;

    loop : while (true) {
      System.out.print("명령> ");
      String command = keyInput.nextLine();
      switch (command.toLowerCase()) {
        case "/member/add":
          command = "[회원등록]";

          System.out.println("[회원]");
          System.out.print("번호? ");
          no[count] = keyInput.nextInt();
          keyInput.nextLine();
          System.out.print("이름? ");
          name[count] = keyInput.nextLine();
          System.out.print("이메일? ");
          email[count] = keyInput.nextLine();
          System.out.print("암호? ");
          password[count] = keyInput.nextLine();
          System.out.print("사진? ");
          photo[count] = keyInput.nextLine();
          System.out.print("전화? ");
          tel[count] = keyInput.nextLine();

          currentMilli = System.currentTimeMillis();
          now[count] = new Date(currentMilli);
          count++;
          System.out.println();
          break;

        case "/member/list":
          command = "[회원목록]";
          for (int i = 0; i < count; i++) {
            System.out.printf("%d, %s, %s ,%s, %s\n", no[i], name[i], email[i], tel[i], now[i].toString());
          }
          break;

        case "/project/add":
          command = "[프로젝트 등록]";
          System.out.print("번호? ");
          pno[pcount] = keyInput.nextInt();
          keyInput.nextLine();
          System.out.print("프로젝트명? ");
          ptitle[pcount] = keyInput.nextLine();
          System.out.print("내용? ");
          pcontent[pcount] = keyInput.nextLine();
          System.out.print("시작일? ");
          pstartDate[pcount] = Date.valueOf(keyInput.nextLine());
          // 예외처리 문법이있다(날짜 형식에 안맞게 쳤을때 프로그램이 종료되는것을 방지)
          System.out.print("종료일? ");
          pendDate[pcount] = Date.valueOf(keyInput.nextLine());
          System.out.print("만든이? ");
          pauthor[pcount] = keyInput.nextLine();
          System.out.print("팀원? ");
          pteammates[pcount] = keyInput.nextLine();
          pcount++;
          break;
        case "/project/list":
          command = "[프로젝트 목록]";
          for (int i = 0; i < pcount; i++) {
          System.out.printf("%d, %s, %s, %s, %s",
              pno[i], ptitle[i], pstartDate[i].toString(), pendDate[i].toString(), pauthor[i]);
        }
          break;
        case "exit" :
        case "break":
          command = "안녕!";
          break loop;

        default :
          command = "실행할 수 없는 명령입니다";
      }
//      if (command.equals("안녕!")) {
//        break;
        System.out.println(command);
    }
   keyInput.close(); // 한번 닫으면 다시는 열지 않는다 (그래서 반복문에 넣으면 안됨)
  }
}