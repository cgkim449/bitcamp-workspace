// dynamic sql 다루기 - <where> 사용 전: 조건이 빠졌을 때 문제 발생하는 경우
/*
 * 첫번째 if 건너뛰면
 * where 바로뒤에 or가 붙는다 그래서 에러남
 * 그래서 where 1=1 하고 if문에 전부 or 넣음
 * 아니면 1=0 넣으면 기본이 선택이 안되고 조건에따라 선택하게 하는거
 * 그래서 Exam0160으로 해결 => <where> 태그
 * Exam0170 : prefix복잡 => 그러나 where말고도 아무거나 다 넣을수잇음
 * 근데 trim 보단 where을 써라
 */
package com.eomcs.mybatis.ex03;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0140 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream(//
        "com/eomcs/mybatis/ex03/mybatis-config.xml");
    SqlSessionFactory factory = //
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();

    // 실행 예:
    // => 여러 개의 조건을 합쳐서 검색하기
    HashMap<String, Object> params = new HashMap<>();

    Scanner keyScan = new Scanner(System.in);

    System.out.print("번호? ");
    String value = keyScan.nextLine();
    if (value.length() > 0) {
      params.put("no", value);
    }

    System.out.print("제목? ");
    value = keyScan.nextLine();
    if (value.length() > 0) {
      params.put("title", value);
    }

    System.out.print("내용? ");
    value = keyScan.nextLine();
    if (value.length() > 0) {
      params.put("content", value);
    }

    keyScan.close();


    List<Board> list = sqlSession.selectList("BoardMapper.select5", //
        params);

    // select5의 문제점:
    // => no 값이 없을 경우 잘못된 SQL문을 생성한다.
    // => 생성된 SQL 문 예:
    // select board_id, title, contents, created_date, view_count
    // from x_board
    // where
    // or title like concat('%', ?, '%') <== or 앞에 조건문이 없다.
    // or contents like concat('%', ?, '%')

    for (Board board : list) {
      System.out.printf("%d, %s, %s, %s, %d\n", //
          board.getNo(), //
          board.getTitle(), //
          board.getContent(), //
          board.getRegisteredDate(), //
          board.getViewCount());
    }

    sqlSession.close();
  }

}


