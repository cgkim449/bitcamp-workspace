
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {

  public static void main(String[] args) {

    // String url1 = "";
    // String user = "";
    // String passwd = "";
    // Map<Integer, Integer> cdMap = new HashMap<>();
    // Connection con = null;

    // // 1) JDBC 드라이버 로딩
    // try {
    // Class.forName("com.mysql.jdbc.Driver");
    // } catch (ClassNotFoundException e1) {
    // // TODO Auto-generated catch block
    // e1.printStackTrace();
    // }
    // // 2) DB연결
    // try {
    // con = DriverManager.getConnection(url1, user, passwd);
    // } catch (SQLException e1) {
    // // TODO Auto-generated catch block
    // e1.printStackTrace();
    // }
    // String sql =
    // "SELECT movie_CD FROM d_diver.movie where synopsis is null and movie_cd > 20190265 ";
    // PreparedStatement pstmt = null;
    // ResultSet rs = null;
    //
    // int a = 0;
    // try {
    // pstmt = con.prepareStatement(sql);
    // rs = pstmt.executeQuery();
    //
    // while (rs.next()) {
    // cdMap.put(a, rs.getInt(1));
    // a++;
    // }
    // System.out.println("map Size = " + cdMap.size());
    // pstmt.close();
    //
    // } catch (SQLException e) {
    // e.printStackTrace();
    // } finally {
    //
    // }

    // for (int k = 0; k < cdMap.size(); k++) {
    try {
      SeleniumTest selTest = new SeleniumTest();
      Map<Integer, String> map = selTest.crawl(String.valueOf(20192193));

      // th_cov 생성, 삽입
      String cov = map.get(1);
      int index = cov.indexOf("movie");
      map.put(2, cov.substring(0, index + 14) + "thumb_x640/thn_" + cov.substring(index + 14));

      // still_cut_url str 수정
      for (int i = 3; i < 8; i++) {
        if (map.get(i) != null) {
          String st = map.get(i);
          st = st.substring(13, st.length());
          st = st.substring(0, st.indexOf("'"));
          st = "http://www.kobis.or.kr" + st;
          int t = st.indexOf("thumb_x640");
          map.put(i, st.substring(0, t) + st.substring(t + 15));
        }
      }

      System.out.println(map.get(1));
      System.out.println(map.get(2));
      System.out.println(map.get(3));
      System.out.println(map.get(4));
      System.out.println(map.get(5));
      System.out.println(map.get(6));
      System.out.println(map.get(7));
      System.out.println(map.get(8));
      System.out.println(map.get(9));
      System.out.println(map.get(10));
      System.out.println(map.get(11));
      // map의 내용 디비 삽입

      // sql =
      // "UPDATE d_diver.movie set synopsis = ?, cov_url = ?, cov_th_url = ? where movie_cd = ? ";
      // pstmt = con.prepareStatement(sql);
      // pstmt.setString(1, map.get(0));
      // pstmt.setString(2, map.get(1));
      // pstmt.setString(3, map.get(2));
      // pstmt.setInt(4, cdMap.get(k));
      // try {
      // pstmt.executeUpdate();
      // } catch (Exception e0) {
      // e0.printStackTrace();
      // } finally {
      // pstmt.close();
      // }
      //
      // sql = "INSERT INTO D_DIVER.MOVIE_STILL_CUT (MOVIE_CD, STILL_CUT_URL) VALUES(?,?) ";
      // for (int h = 3; h < 8; h++) {
      // pstmt = con.prepareStatement(sql);
      // pstmt.setInt(1, cdMap.get(k));
      // pstmt.setString(2, map.get(h));
      // try {
      // pstmt.executeUpdate();
      // } catch (Exception e0) {
      // e0.printStackTrace();
      // } finally {
      // pstmt.close();
      // }
      // }

      // System.out.println("success, key = " + cdMap.get(k));
    } catch (Exception e) {
      // System.out.println("error, key = " + cdMap.get(k));
      e.printStackTrace();
    } finally {
    }

    // }

  }


  // WebDriver
  private WebDriver driver;

  private WebElement webElement;
  // Properties
  public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
  public static final String WEB_DRIVER_PATH = "chromedriver.exe";

  // 크롤링 할 URL
  private String base_url;

  public SeleniumTest() {
    super();

    // System Property SetUp
    System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);


    // Driver SetUp
    ChromeOptions options = new ChromeOptions();
    options.addArguments("headless");
    options.setCapability("ignoreProtectedModeSettings", true);
    driver = new ChromeDriver(options);
    base_url = "http://www.kobis.or.kr/kobis/business/mast/mvie/searchUserMovCdList.do";
  }

  public Map crawl(String movieCd) {
    Map<Integer, String> map = new HashMap<Integer, String>();
    try {
      // get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
      driver.get(base_url);

      webElement = driver.findElement(By.name("movieCd"));
      webElement.sendKeys(movieCd);


      webElement = driver.findElement(By.className("btn_blue"));
      webElement.submit();
      webElement =
          driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/table/tbody/tr[1]/td[1]/a"));
      webElement.click();
      // 시놉시스
      webElement = driver.findElement(By.xpath("//*[@id=\"ui-id-1\"]/div/div[1]"));
      WebElement plotEl = webElement.findElement(By.tagName("p"));
      map.put(0, plotEl.getText());

      // cov
      webElement = driver.findElement(By.xpath("//*[@id=\"ui-id-1\"]/div/div[1]/div[2]/a"));
      map.put(1, webElement.getAttribute("href"));

      // still_cut
      List<WebElement> list = driver.findElements(By.className("thumb_slide"));
      if (list.size() != 0) {
        List<WebElement> stillCutList =
            list.get(list.size() - 1).findElements(By.className("item_slide"));
        map.put(3, stillCutList.get(1).findElement(By.tagName("a")).getAttribute("onclick"));
        map.put(4, stillCutList.get(2).findElement(By.tagName("a")).getAttribute("onclick"));
        map.put(5, stillCutList.get(3).findElement(By.tagName("a")).getAttribute("onclick"));
        map.put(6, stillCutList.get(4).findElement(By.tagName("a")).getAttribute("onclick"));
        map.put(7, stillCutList.get(5).findElement(By.tagName("a")).getAttribute("onclick"));
      }


    } catch (Exception e) {

      e.printStackTrace();

    } finally {
      driver.quit();
    }
    return map;
  }


  public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
    try {
      if (con != null) {
        con.close();
      }

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      if (pstmt != null) {
        pstmt.close();
      }

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      if (rs != null) {
        rs.close();
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }// close()


}
