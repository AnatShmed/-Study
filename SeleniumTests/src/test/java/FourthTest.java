import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class FourthTest {
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
        JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", contact_page.contactBox);
	}
	public void testTemplate(String tel, boolean expectedIsWrongFormat) {
		contact_page.clearTelephoneForm();
		contact_page.inputTelephone(tel);
		if(expectedIsWrongFormat) {
			Assert.assertEquals("true", contact_page.getTelephoneFormAttribute("aria-invalid"));
			Assert.assertEquals("Only digits, space, plus, and semicolon are allowed. Maximum number of characters is 50.".toUpperCase(), contact_page.getTelValidationText());
		}
		else
			Assert.assertEquals("false", contact_page.getTelephoneFormAttribute("aria-invalid"));
		contact_page.clearTelephoneForm();
	}

	@Test
    public void test() {
		testTemplate("qwe123",true);
		testTemplate("+123 456 +123 554",false);
		testTemplate("(097)-123",false);
		testTemplate("23444533",false);
		testTemplate("*123-232-333",true);
	}
	@AfterClass
    public static void end() {
        driver.quit(); 
    }
}
