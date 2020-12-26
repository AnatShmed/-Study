package lab3.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactPage {
	public WebDriver driver;
    public ContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    
    @FindBy(xpath ="//*[contains(@class, 'layout-box__desktop bg-color-smoke-gray')]")
    public WebElement contactBox;
    
    @FindBy(xpath ="//*[contains(@class, 'form-component__label')][contains(text(), 'Email')]")
    private WebElement emailLabel;
    
    @FindBy(xpath ="//*[contains(@class, 'form-component__label')][contains(text(), 'Phone')]")
    private WebElement telephoneLabel;
    
    @FindBy(xpath ="//*[contains(@id, '_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_email')]")
    private WebElement emailForm;
    public void inputEmail(String str) {
    	emailForm.sendKeys(str);
    	emailLabel.click();
    }
    //"aria-invalid"
    public String getEmailFormAttribute(String atr) {
    	return emailForm.getAttribute(atr);
    }
 
    @FindBy(xpath ="//*[contains(@id, '_content_epam_en_about_who-we-are_contact_jcr_content_content-container_section_section-par_form_constructor_user_phone')]")
    private WebElement telephoneForm;
    public void inputTelephone(String str) {
    	telephoneForm.sendKeys(str);
    	telephoneLabel.click();
    }
    //"aria-invalid"
    public String getTelephoneFormAttribute(String atr) {
    	return telephoneForm.getAttribute(atr);
    }
    public void clearTelephoneForm() {
    	telephoneForm.clear();
    }
    
    @FindBy(xpath ="//*[contains(@class, 'validation-text')][contains(text(), 'Incorrect email format')]")
    private WebElement emailValidationText;
    public String getEmailValidationText() {
    	return emailValidationText.getText();
    }
    
    @FindBy(xpath ="//*[contains(@class, 'validation-text')][contains(text(), 'Only digits, space, plus, and semicolon are allowed.')]")
    private WebElement telValidationText;
    public String getTelValidationText() {
    	return telValidationText.getText();
    }
}
