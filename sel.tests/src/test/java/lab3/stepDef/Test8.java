package lab3.stepDef;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lab3.TestRuner;
import lab3.pages.ConsultAndDesignPage;

public class Test8 {
	public static ConsultAndDesignPage CAD_page;
	
  @Given("^The user went to https:\\/\\/www\\.epam\\.com\\/services\\/consult\\-and\\-design$")
  public void given() throws Throwable {
	  CAD_page = new ConsultAndDesignPage(TestRuner.driver);
	  TestRuner.driver.get("https://www.epam.com/services/consult-and-design");
  }
  
  @And("^scrolled down to the video$")
  public void and1() throws Throwable {
	  JavascriptExecutor js = (JavascriptExecutor) TestRuner.driver;
	  js.executeScript("arguments[0].scrollIntoView();", CAD_page.getPlayerSection());
  }

  @And("^clicked on the play button$")
  public void and2() throws Throwable {
		CAD_page.clickPlayerSection();
		CAD_page.clickPlayerSection();
		CAD_page.clickPlayerSection();
  }
  
  @And("^the video began$")
  public void and3() throws Throwable {
	  boolean isActive;
		if(CAD_page.getPlayerSectionAtr("class").equals("video-showcase__player-section mouse-move overlay-play-active")||
				CAD_page.getPlayerSectionAtr("class").equals("video-showcase__player-section overlay-play-active"))
			isActive=true;
		else
			isActive=false;
		Assert.assertEquals(true, isActive);
  }
  
  @When("^The user scrolls up$")
  public void when() throws Throwable {
	  JavascriptExecutor js = (JavascriptExecutor) TestRuner.driver;
	  js.executeScript("arguments[0].scrollIntoView();", CAD_page.getTopElement());
	  WebDriverWait wait = new WebDriverWait(TestRuner.driver,10);
	  wait.until(ExpectedConditions.visibilityOf(CAD_page.getTopElement()));
  }

  @Then("^the video stops$")
  public void then() throws Throwable {
	  
	  boolean isActive;
	  if(CAD_page.getPlayerSectionAtr("class").equals("video-showcase__player-section mouse-move overlay-play-active")||
			  CAD_page.getPlayerSectionAtr("class").equals("video-showcase__player-section mouse-move overlay-play-active"))
			isActive=true;
		else
			isActive=false;
		Assert.assertEquals(false, isActive);
  }
}
