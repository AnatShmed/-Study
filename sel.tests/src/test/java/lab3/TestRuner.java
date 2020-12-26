package lab3;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions( 
features = {"src/test/resources/cucumber/"},
tags = "@main_page or @job_page or @contact_page_1 or @contact_page_2 or @news_page or @press_releases_page or @history_page or @CAD_page")
public class TestRuner {
	public static WebDriver driver;
	
	@BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
    public static void end() {
        driver.quit(); 
    }
}