import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class FifthTest {
	public static NewsPage news_page;
	public static WebDriver driver;

	@BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        news_page = new NewsPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.epam.com/about/newsroom/in-the-news");
	}
	@Test
    public void test() {
		news_page.clickYearArrow();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", news_page.getSelector2002());
		news_page.clickSelector2002();
		Assert.assertEquals("DECEMBER 17, 2002", news_page.getFirstArticleDate());
		Assert.assertEquals("Las Vegas takes its show on the Information Highway", news_page.getFirstArticleName());
	}
	@AfterClass
    public static void end() {
        driver.quit(); 
    }
}
