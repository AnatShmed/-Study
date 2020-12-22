import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class ThirdTest {
	public static ContactPage contact_page;
	public static WebDriver driver;

	@BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        contact_page = new ContactPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.epam.com/contact");
	}
	@Test
    public void firstTest() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", contact_page.contactBox);
		contact_page.inputEmail("@gmail.com");
		Assert.assertEquals("true", contact_page.getEmailFormAttribute("aria-invalid"));
		Assert.assertEquals("INCORRECT EMAIL FORMAT", contact_page.getEmailValidationText());
		}
	@AfterClass
    public static void end() {
        driver.quit(); 
    }

}
