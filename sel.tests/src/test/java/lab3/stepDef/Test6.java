package lab3.stepDef;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lab3.TestRuner;
import lab3.pages.NewsRoomPage;

public class Test6 {
	public static NewsRoomPage news_page;
	
  @Given("^The user is on the Press Releases page \\(https:\\/\\/www\\.epam\\.com\\/about\\/newsroom\\/press\\-releases\\)$")
  public void given() throws Throwable {
      news_page = new NewsRoomPage(TestRuner.driver);
      TestRuner.driver.get("https://www.epam.com/about/newsroom/press-releases");
  }

  @When("^The user choose \\\"([^\\\"]*)\\\" from Year list on the Press Releases page$")
  public void when(String year) throws Throwable {
	  JavascriptExecutor js = (JavascriptExecutor) TestRuner.driver;
	  switch(year) {
	  case "2001":
		news_page.clickYearArrow();
		js.executeScript("arguments[0].scrollIntoView();", news_page.getYear2001Selector());
		news_page.clickYear2001Selector();
		break;
	  default: throw new Exception( "This year is undefined" );
		  }
  }

  @And("^choose \\\"([^\\\"]*)\\\" from News Type list$")
  public void and(String type) throws Throwable {
		  switch(type) {
		  case "Business news":		
			news_page.clickNewsTypeArrow();
			news_page.clickBusinessNewsSelector();
			break;
		  default: throw new Exception( "This news type is undefined" );
			  }
	}
  
  @Then("^Show business news for 2001:$")
  public void then() throws Throwable {
	  Assert.assertEquals("OCTOBER 23, 2001", news_page.getFirstArticleDate());
	  Assert.assertEquals("ServiceWare partners with EPAM Systems to expand product development and support capabilities", news_page.getFirstArticleName());

  }

}
