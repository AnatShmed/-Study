package lab3.stepDef;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lab3.TestRuner;
import lab3.pages.NewsPage;

public class Test5 {
	public static NewsPage news_page;
	
  @Given("^The user is on the In The News page \\(https:\\/\\/www\\.epam\\.com\\/about\\/newsroom\\/in\\-the\\-news\\)$")
  public void given() throws Throwable {
      news_page = new NewsPage(TestRuner.driver);
      TestRuner.driver.get("https://www.epam.com/about/newsroom/in-the-news");
  }

  @When("^The user choose \\\"([^\\\"]*)\\\" from Year list on the In The News page$")
  public void when(String year) throws Throwable {
	  JavascriptExecutor js = (JavascriptExecutor) TestRuner.driver;
	  switch(year) {
	  case "2002":news_page.clickYearArrow();
		js.executeScript("arguments[0].scrollIntoView();", news_page.getSelector2002());
		news_page.clickSelector2002();
		break;
	  default: throw new Exception( "This year is undefined" );
		  }
  }

  @Then("^Show article 'DECEMBER 17, 2002, Las Vegas takes its show on the Information Highway'$")
  public void then() throws Throwable {
	  Assert.assertEquals("DECEMBER 17, 2002", news_page.getFirstArticleDate());
	  Assert.assertEquals("Las Vegas takes its show on the Information Highway", news_page.getFirstArticleName());
  }

}
