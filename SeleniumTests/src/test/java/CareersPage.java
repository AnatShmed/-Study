import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareersPage {
	public WebDriver driver;
    public CareersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    @FindBy(xpath ="//*[contains(text(), 'Keyword or job ID')]")
    public WebElement keywordText;
    
    @FindBy(xpath ="//*[contains(@id, 'Kyiv')]")
   private WebElement kyivLink;
    
    @FindBy(xpath ="//*[contains(@class, 'select2-selection select2-selection--single')]")
    private WebElement searchForm;
    public void clickKyivLink() {
    	searchForm.sendKeys("Kyiv");
    	kyivLink.click();
    }
    
    @FindBy(xpath ="//*[contains(text(), 'All Skills')]")
    private WebElement skillsSelection;
    public void clickSkillsSelection() {
    	skillsSelection.click(); }
    
    @FindBy(xpath ="//*[contains(text(), 'User Experience & Design')][contains(@class, 'checkbox-custom-label')]")
    private WebElement UEDCheckbox;
    public void clickUEDCheckbox() {
    	UEDCheckbox.click(); }

    @FindBy(xpath ="//*[contains(@class,'recruiting-search__submit')]")
    private WebElement findButton;
    public void clickFindButton() {
    	findButton.click(); }
    
    @FindBy(xpath ="//*[contains(text(), 'Senior Experience Designer')]")
    private WebElement jobName;
    public String getJobName(){
    	return jobName.getText();
    }
    
    @FindBy(xpath ="//*[contains(text(), 'Kyiv, Ukraine')]")
    private WebElement jobLocation;
    public String getJobLocation(){
    	return jobLocation.getText();
    }
}
