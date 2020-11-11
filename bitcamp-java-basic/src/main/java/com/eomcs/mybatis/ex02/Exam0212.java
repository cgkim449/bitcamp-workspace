// Mybatis - SQL에 파라미터 지정하기: Map에 값을 담아 넘기기

/* # 페이징 처리
 * 게시글이 몇만개일때 20개씩 짤라서 보여줘야한다
 *
 * 엄:
 * next next next... 이렇게하면 뒤에가 느림
 * 정확히 그 부분을 딱 달라그래야됨
 *
 * dbms마다 페이징 처리가 다르다
 */
package com.eomcs.mybatis.ex02;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0212 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream(//
        "com/eomcs/mybatis/ex02/mybatis-config04.xml");
    SqlSessionFactory factory = //
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();

    // SQL을 실행할 때 파라미터 값을 전달하려면
    // 두 번째 파라미터로 전달해야 한다.
    // 여러 개의 값을 전달해야 한다면,
    // Map 객체에 담아 전달하라!
    // 또는 도메인 객체(ex: Board, Lesson 등)에 담아 전달하라!

    // 예) 페이징 처리를 위한 시작 인덱스와 개수를 파라미터로 넘겨라.
    /*
     * 시작위치(인덱스는 0부터시작), 개수
     */
    HashMap<String, Object> params = new HashMap<>();
    params.put("startIndex", 6);
    params.put("size", 3);

    List<Board> list = sqlSession.selectList(//
        "BoardMapper.selectBoard3", params);

    for (Board board : list) {
      System.out.printf("%d, %s, %s, %s\n", //
          board.getNo(), //
          board.getTitle(), //
          board.getContent(), //
          board.getRegisteredDate());
    }

    sqlSession.close();
  }

}


