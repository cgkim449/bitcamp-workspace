import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class test {

  public static void main(String[] args) {
    // String url = "https://movie.naver.com/movie/bi/mi/photoViewPopup.nhn?movieCode=193194";
    // Document doc = null;
    //
    // try {
    // doc = Jsoup.connect(url).get();
    // // System.out.println(doc);
    //
    // Elements img = doc.select("img[src]");
    // String imgSrc = img.attr("src");
    // System.out.println(imgSrc);
    //
    // } catch (IOException e) {
    // e.printStackTrace();
    // }

    String url =
        "https://movie.naver.com/movie/bi/mi/photoView.nhn?code=193194&imageNid=6703932#tab";
    Document doc = null;

    try {
      doc = Jsoup.connect(url).get();
      // System.out.println(doc);

      Elements img = doc.select("li[data-json]");
      String imgSrc = img.attr("data-json");
      System.out.println(imgSrc);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

https:// movie.naver.com/movie/bi/mi/photoViewPopup.nhn?imageNid=6703934
https:// movie.naver.com/movie/bi/mi/photoViewPopup.nhn?imageNid=6703937
