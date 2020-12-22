import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class EighthTest {
	public static ConsultAndDesignPage CAD_page;
	public static WebDriver driver;

	@BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        CAD_page = new ConsultAndDesignPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.epam.com/services/consult-and-design");
	}
	@Test
    public void test() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", CAD_page.getPlayerSection());
		CAD_page.clickPlayerSection();
		CAD_page.clickPlayerSection();
		CAD_page.clickPlayerSection();
		boolean isActive;
		if(CAD_page.getPlayerSectionAtr("class").equals("video-showcase__player-section mouse-move overlay-play-active"))
			isActive=true;
		else
			isActive=false;
		Assert.assertEquals(true, isActive);
		js.executeScript("arguments[0].scrollIntoView();", CAD_page.getTopElement());
		WebDriverWait wait = new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.visibilityOf(CAD_page.getTopElement()));
		if(CAD_page.getPlayerSectionAtr("class").equals("video-showcase__player-section mouse-move overlay-play-active"))
			isActive=true;
		else
			isActive=false;
		Assert.assertEquals(false, isActive);
	}
	@AfterClass
    public static void end() {
        driver.quit(); 
    }

}
