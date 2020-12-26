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
import lab3.pages.CareersPage;

public class Test2 {
	public static CareersPage careers_page;
	
  @Given("^The user is on the Careers page \\(https:\\/\\/www\\.epam\\.com\\/careers\\)$")
  public void given() {
      careers_page = new CareersPage(TestRuner.driver);
      TestRuner.driver.get("https://www.epam.com/careers");
  }

  @And("^choosed \"([^\"]*)\" from Location list$")
  public void and1(String loc) throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) TestRuner.driver;
		js.executeScript("arguments[0].scrollIntoView();", careers_page.keywordText);
		switch(loc){
		case "Kyiv":careers_page.clickKyivLink();
			break;
		default: throw new Exception( "This location is undefined" );	
		}
		careers_page.clickKyivLink();
  }
  @And("^choosed \\\"([^\\\"]*)\\\" from Skills list$")
  public void and2(String skill) throws Throwable {
		switch(skill){
		case "User Experience & Design":careers_page.clickSkillsSelection();
			careers_page.clickUEDCheckbox();
			break;
		default: throw new Exception( "This skill is undefined" );	
		}
		careers_page.clickKyivLink();
  }
  
  @When("^On  the Careers page the user clicks on the find button$")
  public void when() {
	  careers_page.clickFindButton();
  }

  @Then("^Show 1 job: Senior Experience Designer; Kyiv, Ukraine$")
  public void then() {
	  WebDriverWait wait = new WebDriverWait(TestRuner.driver,3);
	  wait.until(ExpectedConditions.visibilityOf(careers_page.getJobsNumberWebEl()));
	  Assert.assertEquals("WE FOUND 1 JOB OPENING FOR YOU", careers_page.getJobsNumberText());
	  Assert.assertEquals("Senior Experience Designer", careers_page.getJobName());
	  Assert.assertEquals("KYIV, UKRAINE", careers_page.getJobLocation());
  }

}
