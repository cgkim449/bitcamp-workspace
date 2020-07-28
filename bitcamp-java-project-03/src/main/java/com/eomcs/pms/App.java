package com.eomcs.pms;

public class App {

  public static void main(String[] args) {
//    키보드 input stream : System.in
//    input stream에서 data를 읽어 적절한 타입으로 리턴하는 도구 : Scanner
    
    long currentMillis =System.currentTimeMillis(); //1970-1-1 00:00:00에서 지금까지의 시간
    java.sql.Date now=new java.sql.Date(currentMillis);
    
    java.util.Scanner keyInput = new java.util.Scanner(System.in); // 
    //레퍼런스(리모컨) = 도구
    System.out.println("[회원]");
    System.out.print("번호? ");
    
    int no = keyInput.nextInt(); // nextLine() : 리모컨의 기능 : 한줄의 문자열을 입력받아라
    keyInput.nextLine(); // 숫자뒤에 남아있는 CR/LF 값 제거하기위해  
    // 기능을 수행한다음에 int 값이 놓여진다
    //값이 안놓이는 기능도 있다(void) ctrl+space하면 나옴
    System.out.print("이름? ");
    String name = keyInput.nextLine(); 
    System.out.print("이메일? ");
    String email = keyInput.nextLine(); 
    System.out.print("암호? ");
    String pw = keyInput.nextLine(); 
    System.out.print("사진? ");
    String pic = keyInput.nextLine(); 
    System.out.print("전화? ");
    String tel = keyInput.nextLine(); 
    System.out.print("가입일? ");
    
    keyInput.close(); // close() : 수도꼭지를 잠근다
    
    System.out.println("-----------------------");
    System.out.printf("번호: %d\n" + no);
//  System.out.printf("번호: %s\n" + no); 수도 %s로 되긴된다
    System.out.printf("이름: %s\n", name);
    System.out.printf("이메일: %s\n", email);
    System.out.printf("암호: %s\n", pw);
    System.out.printf("사진: %s\n", pic);
    System.out.printf("전화: %s\n", tel);
    System.out.printf("가입일: %s\n", now.toString());
  }
}//시스템을 유지보수하기좋게끔 코딩을 리팩토링(마틴 파울러 리팩토링)
//