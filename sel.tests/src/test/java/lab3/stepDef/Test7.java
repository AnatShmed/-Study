package lab3.stepDef;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lab3.TestRuner;
import lab3.pages.HistoryPage;

public class Test7 {
	public static HistoryPage history_page;
	
  @Given("^The user is on the History page \\(https:\\/\\/www\\.epam\\.com\\/about\\/who\\-we\\-are\\/history\\)$")
  public void given() throws Throwable {
	  history_page = new HistoryPage(TestRuner.driver);
      TestRuner.driver.get("https://www.epam.com/about/who-we-are/history");	  
  }

  @When("The user click on play button")
  public void when() throws Throwable {
	  history_page.clickVideoButton();
  }

  @Then("^Show video from youtube named EPAM's 2019 Year In Review$")
  public void then() throws Throwable {
	  Assert.assertEquals(true, history_page.isDisplayedMagnificPopupIframe());
	  Assert.assertEquals("https://www.youtube.com/embed/EyxIZd9lBYk?enablejsapi=1&rel=0&wmode=opaque", history_page.getMagnificPopupIframeAtr("src"));
  }
}
