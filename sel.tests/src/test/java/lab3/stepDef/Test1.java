package lab3.stepDef;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lab3.TestRuner;
import lab3.pages.MainPage;

public class Test1 {
	public static MainPage main_page;
	
  @Given("^The user is on the main page \\(https:\\/\\/www\\.epam\\.com\\/\\)$")
  public void given() {
      main_page = new MainPage(TestRuner.driver);
      TestRuner.driver.get("https://www.epam.com/"); 
  }

  @When("^The user clicks on (.+)$")
  public void when(String bname) throws Throwable {
	  switch(bname) {
	  case "Services":main_page.clickServicesLink();
		  			break;
	  case "How We Do It":main_page.clickHowLink();
					break;
	  case "Our Work":main_page.clickOurWorkLink();
					break;
	  case "Insights":main_page.clickInsightsLink();
					break;
	  case "About":main_page.clickAboutLink();
					break;
	  case "Careers":main_page.clickCareersLink();
	  				break;
	  default: throw new Exception( "This button is undefined" );
	  }
  }

  @Then("^Go to (.+)$")
  public void then(String address) {
	  Assert.assertEquals(address, TestRuner.driver.getCurrentUrl());
  }

}
