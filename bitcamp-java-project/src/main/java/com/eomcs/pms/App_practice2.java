package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App_practice2 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);

    final int LENGTH = 10;

    int[] no = new int[LENGTH];
    String[] name = new String[LENGTH];
    String[] email = new String[LENGTH];
    String[] pw = new String[LENGTH];
    String[] pic = new String[LENGTH];
    String[] tel = new String[LENGTH];
    Date[] now = new Date[LENGTH];

    int count = 0; //

    final int PLENGTH = 10;

    int[] pno = new int[PLENGTH];
    String[] ptitle = new String[PLENGTH];
    String[] pcontent = new String[PLENGTH];
    Date[] pstartDate = new Date[PLENGTH];
    Date[] pendDate = new Date[PLENGTH];
    String[] pworker = new String[PLENGTH];
    String[] pteam = new String[PLENGTH];

    int pcount = 0;

    final int TLENGTH = 10;

    int[] tno = new int[TLENGTH];
    String[] tcontent = new String[TLENGTH];
    Date[] tendDate = new Date[TLENGTH];
    String[] tstate = new String[TLENGTH];
    String[] tmanager = new String[TLENGTH];

    int tcount = 10;

    loop : while (true) {
      System.out.print("명령> ");
      String command = keyScan.next();
      switch (command.toLowerCase()) { //
        case "/member/add":
          System.out.println("[회원 등록]");
          System.out.print("번호? ");
          no[count] = keyScan.nextInt();
          System.out.print("이름? ");
          name[count] = keyScan.next();
          System.out.print("이메일? ");
          email[count] = keyScan.next();
          System.out.print("암호? ");
          pw[count] = keyScan.next();
          System.out.print("사진? ");
          pic[count] = keyScan.next();
          System.out.print("전화? ");
          tel[count] = keyScan.next();

          now[count] = new Date(System.currentTimeMillis()); // long이란걸 잊지말자, 1970-1-1부터지금
          count++;
          break;
        case "/member/list":
          System.out.println("[회원 목록]");
          for (int i = 0; i < count; i++) {
            System.out.printf("%d, %s, %s, %s, %s\n",
                no[i], name[i], email[i], tel[i], now[i].toString());
          }
          break;
        case "/project/add":
          System.out.println("[프로젝트 등록]");
          System.out.print("번호? ");
          pno[pcount] = keyScan.nextInt();
          System.out.print("프로젝트명? ");
          ptitle[pcount] = keyScan.next();
          System.out.print("내용? ");
          pcontent[pcount] = keyScan.next();
          System.out.print("시작일? ");
          pstartDate[pcount] = Date.valueOf(keyScan.next()); //
          System.out.print("종료일? ");
          pendDate[pcount] = Date.valueOf(keyScan.next());
          System.out.print("만든이? ");
          pworker[pcount] = keyScan.next();
          System.out.print("팀원? ");
          pteam[pcount] = keyScan.next();

          pcount++;
          break;
        case "/project/list":
          System.out.println("[프로젝트 목록]");
          for (int i = 0; i < pcount; i++) {
            System.out.printf("%d, %s, %s, %s, %s\n",
                pno[i], ptitle[i], pstartDate[i].toString(), pendDate[i].toString(), pworker[i]);
          }
          break;
        case "/task/add":
          System.out.println("[작업 등록]");
          System.out.print("번호? ");
          tno[tcount] = keyScan.nextInt();
          System.out.print("내용? ");
          tcontent[tcount] = keyScan.next();
          System.out.print("마감일? ");
          tendDate[tcount] = Date.valueOf(keyScan.next());
          System.out.print("상태? \n");
          System.out.print("0: 신규 \n");
          System.out.print("1: 진행중 \n");
          System.out.print("2: 완료 \n");
          System.out.print("> ");
          tstate[tcount] = keyScan.next();
          System.out.print("담당자? ");
          tmanager[tcount] = keyScan.next();
          break;
        case "/task/list":
          System.out.println("[작업 목록]");
          for (int i = 0; i < tcount; i++) {
            System.out.printf("%d, %s, %s, %s, %s\n",
                tno[i], tcontent[i], tendDate[i].toString(), tmanager[i], tstate[i]);
          }
          break;
        case "quit": //
        case "exit":
          System.out.println("안녕!");
          break loop;
        default :
          System.out.println("잘못된 명령입니다.");
      }
      System.out.println();
    }
    keyScan.close();
  }
}