package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App_a {
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

    final int TLENGTH = 10;
    int[] tno = new int[TLENGTH];
    String[] tcontent = new String[TLENGTH];
    Date[] tendDate = new Date[TLENGTH];
    String[] tstate = new String[TLENGTH];
    String[] tauthor = new String[TLENGTH];

    int tcount = 0;

    loop : while (true) {
      System.out.print("명령> ");
      String command = keyInput.nextLine();
      switch (command.toLowerCase()) {
        case "/member/list":
          System.out.println("[회원목록]");
          for (int i = 0; i < count; i++) {
            System.out.printf("%d, %s, %s ,%s, %s\n", no[i], name[i], email[i], tel[i], now[i].toString());
          }
          break;
        case "/member/add":
          System.out.println("[회원등록]");

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
          break;
        case "/project/list":
          for (int i = 0; i < pcount; i++) {
            System.out.printf("%d, %s, %s, %s, %s\n",
                pno[i], ptitle[i], pstartDate[i].toString(), pendDate[i].toString(), pauthor[i]);
          }
          break;
        case "/project/add":
          System.out.print("번호? ");
          pno[pcount] = keyInput.nextInt();
          keyInput.nextLine();
          System.out.print("프로젝트명? ");
          ptitle[pcount] = keyInput.nextLine();
          System.out.print("내용? ");
          pcontent[pcount] = keyInput.nextLine();
          System.out.print("시작일? ");
          pstartDate[pcount] = Date.valueOf(keyInput.nextLine());
          System.out.print("종료일? ");
          pendDate[pcount] = Date.valueOf(keyInput.nextLine());
          System.out.print("만든이? ");
          pauthor[pcount] = keyInput.nextLine();
          System.out.print("팀원? ");
          pteammates[pcount] = keyInput.nextLine();
          pcount++;
          break;
        case "/task/add":
          System.out.print("번호? ");
          tno[tcount] = keyInput.nextInt();
          keyInput.nextLine();
          System.out.print("내용? ");
          tcontent[tcount] = keyInput.nextLine();
          System.out.print("마감일? ");
          tendDate[tcount] = Date.valueOf(keyInput.nextLine());
          System.out.print("상태? \n");
          System.out.print("0: 신규 \n");
          System.out.print("1: 진행중 \n");
          System.out.print("2: 완료 \n");
          System.out.print("> ");

          tstate[tcount] = keyInput.nextLine();
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

          System.out.print("담당자? ");
          tauthor[tcount] = keyInput.nextLine();
          tcount++;
          break;
        case "/task/list":
          for (int i = 0; i < tcount; i++) {
            System.out.printf("%d, %s, %s, %s, %s\n",
                tno[i], tcontent[i], tendDate[i].toString(), tstate[i], tauthor[i] );
          }
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
}
