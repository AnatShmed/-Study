import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SixthTest {
	public static NewsRoomPage news_page;
	public static WebDriver driver;

	@BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        news_page = new NewsRoomPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.epam.com/about/newsroom/press-releases");
	}
	@Test
    public void test() {
		news_page.clickNewsTypeArrow();
		news_page.clickBusinessNewsSelector();
		news_page.clickYearArrow();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", news_page.getYear2001Selector());
		news_page.clickYear2001Selector();
		Assert.assertEquals("OCTOBER 23, 2001", news_page.getFirstArticleDate());
		Assert.assertEquals("ServiceWare partners with EPAM Systems to expand product development and support capabilities", news_page.getFirstArticleName());
	}
	@AfterClass
    public static void end() {
        driver.quit(); 
    }
}
