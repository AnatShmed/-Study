import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SecondTest {
	public static CareersPage careers_page;
	public static WebDriver driver;

	@BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        careers_page = new CareersPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.epam.com/careers");
	}
	@Test
    public void firstTest() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", careers_page.keywordText);
		careers_page.clickKyivLink();
		careers_page.clickSkillsSelection();
		careers_page.clickUEDCheckbox();
		careers_page.clickFindButton();
		Assert.assertEquals("Senior Experience Designer", careers_page.getJobName());
		Assert.assertEquals("KYIV, UKRAINE", careers_page.getJobLocation());
		}
	@AfterClass
    public static void end() {
        driver.quit(); 
    }
}
