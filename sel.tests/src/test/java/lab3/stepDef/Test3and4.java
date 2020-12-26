package lab3.stepDef;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lab3.TestRuner;
import lab3.pages.ContactPage;

public class Test3and4 {
	public static ContactPage contact_page;
	
	//Test#3
  @Given("^The user is on the contact page \\(https:\\/\\/www\\.epam\\.com\\/about\\/who\\-we\\-are\\/contact\\)$")
  public void given() {
	  contact_page = new ContactPage(TestRuner.driver);
	  TestRuner.driver.get("https://www.epam.com/contact");
  }

  @When("^The user input \\\"([^\\\"]*)\\\" in the email form$")
  public void when1(String email){
	  JavascriptExecutor js = (JavascriptExecutor) TestRuner.driver;
	  js.executeScript("arguments[0].scrollIntoView();", contact_page.contactBox);
	  contact_page.inputEmail(email);
	  
  }

  @Then("^Show message about wrong email format$")
  public void then1() {
	  Assert.assertEquals("true", contact_page.getEmailFormAttribute("aria-invalid"));
	  Assert.assertEquals("INCORRECT EMAIL FORMAT", contact_page.getEmailValidationText());
  }

  //Test #4
  @When("^The user inputed (.+) that contains forbidden characters$")
  public void when2(String phone) throws Throwable {
		  contact_page.inputTelephone(phone);
  }

  @Then("^show message about wrong phone format$")
  public void then2(){
	  Assert.assertEquals("true", contact_page.getTelephoneFormAttribute("aria-invalid"));
	  Assert.assertEquals("Only digits, space, plus, and semicolon are allowed. Maximum number of characters is 50.".toUpperCase(), contact_page.getTelValidationText());
  }
}
