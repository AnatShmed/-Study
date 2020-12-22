import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SeventhTest {
	public static HistoryPage history_page;
	public static WebDriver driver;

	@BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        history_page = new HistoryPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.epam.com/about/who-we-are/history");
	}
	@Test
    public void test() {
		history_page.clickVideoButton();
		Assert.assertEquals("https://www.youtube.com/embed/EyxIZd9lBYk?enablejsapi=1&rel=0&wmode=opaque", history_page.getMagnificPopupIframeAtr("src"));
	}
	@AfterClass
    public static void end() {
        driver.quit(); 
    }
}
