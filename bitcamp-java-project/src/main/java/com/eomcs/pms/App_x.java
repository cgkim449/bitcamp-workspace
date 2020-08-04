// 단계가 중요하다 미켈란젤로가 아니면
// project-05 : App, App2, App3의 코드를 합친다
// 1. 명령어를 무한대로 받는다 > 명령어 별로 구분한다
// 2. 각각 명령어에 대한 코드를 작성

// project-06


package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App_x {
  public static void main(String[] args) {
    Scanner keyInput = new Scanner(System.in);
    final int LENGTH = 10;
    int[] no = new int[LENGTH];
    String[] name = new String[LENGTH];
    String[] email = new String[LENGTH];
    String[] pw = new String[LENGTH];
    String[] pic = new String[LENGTH];
    String[] tel = new String[LENGTH];
    Date[] now = new Date[LENGTH];
    
    int count = 0;
    long currentMilli;
    
    final int PLENGTH = 10;
    int[] pno = new int[PLENGTH];
    String[] ptitle = new String[PLENGTH];
    String[] pcontent = new String[PLENGTH];
    Date[] pstartDate = new Date[PLENGTH];
    Date[] pendDate = new Date[PLENGTH];
    String[] pworker = new String[PLENGTH];
    String[] pteammates = new String[PLENGTH];
    
    int pcount = 0;
    
    final int TLENGTH = 10;
    int[] tno = new int[TLENGTH];
    String[] tcontent = new String[TLENGTH];
    Date[] tendDate = new Date[TLENGTH];
    String[] tstate = new String[TLENGTH];
    String[] tworker = new String[TLENGTH];
    
    int tcount = 0;
    
    loop : while (true) {
      System.out.print("명령> ");
      String command = keyInput.nextLine();
      switch (command) {
        case "/member/add":
          System.out.print("번호? ");
          no[count] = keyInput.nextInt();
          keyInput.nextLine();
          System.out.print("이름? ");
          name[count] = keyInput.nextLine();
          System.out.print("이메일? ");
          email[count] = keyInput.nextLine();
          System.out.print("암호? ");
          pw[count] = keyInput.nextLine();
          System.out.print("사진? ");
          pic[count] = keyInput.nextLine();
          System.out.print("전화? ");
          tel[count] = keyInput.nextLine();
          
          currentMilli = System.currentTimeMillis();
          now[count] = new Date(currentMilli);
          count++;
          break;
        case "/member/list":
          for (int i = 0; i < count; i++) {
            System.out.printf("%d %s %s %s %s\n",
                no[i], name[i], email[i], tel[i], now[i].toString());
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
          pworker[pcount] = keyInput.nextLine();
          System.out.print("팀원? ");
          pteammates[pcount] = keyInput.nextLine();
          pcount++;
          break;
        case "/project/list":
          for (int i = 0; i < pcount; i++) {
            System.out.printf("%d %s %s %s %s\n",
                pno[i], ptitle[i], pstartDate[i].toString(), pendDate[i].toString(), pworker[i]);
          }
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
          System.out.print("담당자? ");
          tworker[tcount] = keyInput.nextLine();
          tcount++;
          break;
        case "/task/list":
          for (int i = 0; i < tcount; i++) {
            switch (tstate[i]) {
              case "0":
                tstate[i] = "신규";
                break;
              case "1":
                tstate[i] = "진행중";
                break;
              case "2":
                tstate[i] = "완료";
                break;
            }
            System.out.printf("%d %s %s %s %s\n",
                tno[i], tcontent[i], tendDate[i].toString(), tworker[i], tstate[i]);
          }
          break;
        case "exit":
        case "quit":
          System.out.println("안녕!");
          break loop;
        default :
          System.out.println("실행할 수 없는 명령입니다."); 
      }
      System.out.println();
    }
    keyInput.close();
  }
}