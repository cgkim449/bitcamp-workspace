// callee를 만드는 입장
package com.eomcs.oop.ex09.i;

import java.io.File;
import java.io.FilenameFilter;

public class Exam0120 {
  public static void main(String[] args) {
    File file = new File(".");

    // 인터페이스를 기준으로 한 개발자 입장:
    // => File의 list() 메서드가 사용할 필터 객체를 만드는 입장
    // => FilenameFilter 인터페이스 규칙에 따라 클래스를 작성한다
    // => 이렇게 작성한 클래스는 list()메서드에서 사용할 것이다
    class MyFilter implements FilenameFilter{
      @Override
      public boolean accept(File dir, String name) {

        return name.endsWith(".java") ? true : false;
      }
    }
    String[] filenames = file.list(new MyFilter());
    // 호출하는건 list()가 내부적으로!!!! 할거다
    // 근데 0110은 우리가 호출하는 코드를 짜는것

    for(String filename : filenames) {
      System.out.println(filename);
    }
  }
}
