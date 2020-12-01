// 썸네일 이미지 만들기
package com.eomcs.web.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/ex04/s8")
public class Servlet08 extends GenericServlet {

  private static final long serialVersionUID = 1L;
  private String uploadDir;

  @Override
  public void init() throws ServletException {
    this.uploadDir = this.getServletContext().getRealPath("/upload");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

    // 테스트
    // - http://localhost:8080/java-web/ex04/test08.html 실행
    //

    req.setCharacterEncoding("UTF-8");

    HttpServletRequest httpReq = (HttpServletRequest) req;

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("<html>");
    out.println("<head><title>servlet04</title></head>");
    out.println("<body><h1>파일 업로드 결과</h1>");

    // 일반 폼 데이터를 원래 하던 방식대로 값을 꺼낸다.
    out.printf("이름=%s<br>\n", httpReq.getParameter("name"));
    out.printf("나이=%s<br>\n", httpReq.getParameter("age"));

    // 파일 데이터는 getPart()를 이용한다.
    Part photoPart = httpReq.getPart("photo");
    String filename = "";
    if (photoPart.getSize() > 0) {
      // 파일을 선택해서 업로드 했다면,
      filename = UUID.randomUUID().toString();
      photoPart.write(this.uploadDir + "/" + filename);
    }
    /*
     * 일단 저장한다음에 썸네일을 만들어야함
     */

    // 원본 사진을 가지고 특정 크기의 썸네일 이미지를 만들기
    // 1) 썸네일 이미지를 생성해주는 자바 라이브러리 추가
    // => mvnrepository.com에서 thumbnailator 라이브러리 검색
    // => build.gradle 에 추가
    // => '$ gradle eclipse' 실행
    // => eclise IDE에서 프로젝트 리프래시

    // 2) 썸네일 이미지 만들기
    // => 원본 이미지 파일이 저장된 경로를 알려주고
    // 어떤 썸네일 이미지를 만들어야 하는지 설정한다.
    // Thumbnails.of(this.uploadDir + "/" + filename).size(20, 20).outputFormat("jpg")
    // .toFiles(Rename.PREFIX_DOT_THUMBNAIL);

    Builder<File> thumbnailBuilder = Thumbnails.of(this.uploadDir + "/" + filename);
    thumbnailBuilder.size(20, 20);//
    thumbnailBuilder.outputFormat("jpg");//
    thumbnailBuilder.toFiles(new Rename() {
      /*
       * 추상클래스 Rename을 상속받은 애, apply 메서드를 정의
       * 
       */
      @Override
      public String apply(String name, ThumbnailParameter param) {
        return name + "_20x20";
      }
    });

    Thumbnails.of(this.uploadDir + "/" + filename)//
    .size(80, 80)// 리턴값이 thumbnailBuilder
    .outputFormat("jpg") // 리턴값이 thumbnailBuilder
    .toFiles(Rename.PREFIX_DOT_THUMBNAIL);
    /*
     * 위에랑 밑에랑 똑같은 이름
     * 그럼 밑에거가 덮어씀
     * 그래서 20X20 했던 방식 추천
     */

    Thumbnails.of(this.uploadDir + "/" + filename)//
    .size(160, 160) //
    .outputFormat("jpg") //
    .crop(Positions.CENTER)
    .toFiles(Rename.PREFIX_DOT_THUMBNAIL);

    out.printf("사진=%s<br>\n", filename);
    /*
     * db에는 원본파일명만 저장하라
     * 그리고 밑에처럼 썸네일 출력하라
     */
    out.printf("<img src='../upload/%s_20x20.jpg'><br>\n", filename);
    out.printf("<img src='../upload/%s_80x80.jpg'><br>\n", filename);
    out.printf("<img src='../upload/%s_160x160.jpg'><br>\n", filename);
    /*
     * 원본파일을 그대로가져와서 사이즈만 줄이는 이런방식은 하지마라
     * 왜냐면 그런식으로 하면 파일 크기가 똑같기 때문이다
     */
    /*
     * 기준은 항상 높이로 맞춰야한다!
     * 정사각형으로 짜르려면 crop해야한다 thumbnailator도 그 기능이잇음
     */
    out.printf("<img src='../upload/%s' height='80'><br>\n", filename);
    out.printf("<img src='../upload/%s'><br>\n", filename);
    out.println("</body></html>");
  }
}

