package com.eomcs.pms;

public class App3 {

  public static void main(String[] args) {
    
    java.util.Scanner keyInput = new java.util.Scanner(System.in); 
    // 리모컨에 저장한다 도구새로사오자 어떻게뿌릴까(물을 틀자)
    //리모컨에 저장한다 사온다 어떻게받을지에대한도구(키보드로 입력받자)
    //변수.메서드() ( 예: state.equals("0"))
    
    System.out.printf("[%s]\n", "작업");
    System.out.print("프로젝트? ");
    String project = keyInput.nextLine(); // 리모컨의 메서드
    // 문자열 타입 project라는 메모리에 저장한다 리모컨.기능을?
    
    System.out.print("번호? ");
    keyInput.nextLine();
    
    System.out.print("내용? ");
    String content = keyInput.nextLine();
    
    System.out.print("완료일? ");
    String fin = keyInput.nextLine();
    
    System.out.print("상태? \n"+"0: 신규\n"+"1: 진행중\n"+"2: 완료\n"+"> ");
    String state = keyInput.nextLine();
    
    System.out.print("담당자? ");
    String manager = keyInput.nextLine();
    
    keyInput.close(); // 리모컨.기능 꼭 잠구자
    
    System.out.println("------------------------");
    System.out.printf("프로젝트: %s\n", project);
    System.out.printf("번호: \n");
    System.out.printf("완료일: %s\n", fin);
    System.out.print("상태: ");
    
//    if(state.equals("0")) { // (true), (false)
//      System.out.println("신규");
//    } else if(state.equals("1")) {
//      System.out.println("진행중");
//    }  else {
//      System.out.println("완료");
//    }
    switch(state) {
      case "0":
        System.out.println("신규");
        break;
      case "1":
        System.out.println("진행중");
        break;
      default:
      System.out.println("완료");
    }        
    System.out.printf("담당자: %s\n", manager);

  }
}
