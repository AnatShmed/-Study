import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class FirstTest {
	public static MainPage main_page;
	public static WebDriver driver;

	@BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        main_page = new MainPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.epam.com/"); }
	@Test
    public void firstTest() {
		main_page.clickServicesLink();
		Assert.assertEquals("https://www.epam.com/services", driver.getCurrentUrl());
		main_page.clickHowLink();
		Assert.assertEquals("https://www.epam.com/how-we-do-it", driver.getCurrentUrl());
		main_page.clickOurWorkLink();
		Assert.assertEquals("https://www.epam.com/our-work", driver.getCurrentUrl());
		main_page.clickInsightsLink();
		Assert.assertEquals("https://www.epam.com/insights", driver.getCurrentUrl());
		main_page.clickAboutLink();
		Assert.assertEquals("https://www.epam.com/about", driver.getCurrentUrl());
		main_page.clickCareersLink();
		Assert.assertEquals("https://www.epam.com/careers", driver.getCurrentUrl());
	}
	@AfterClass
    public static void end() {
        driver.quit(); 
    } 
}	
