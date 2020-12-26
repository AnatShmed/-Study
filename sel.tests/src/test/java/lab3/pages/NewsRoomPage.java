package lab3.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NewsRoomPage {
	public WebDriver driver;
    public NewsRoomPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    
    @FindBy(xpath ="//b")
    private WebElement newsTypeArrow;
    public void clickNewsTypeArrow() {
    	newsTypeArrow.click();
    }
    
    @FindBy(xpath ="//div[2]/div/span/span/span/span[2]/b")
    private WebElement yearArrow;
    public void clickYearArrow() {
    	yearArrow.click();
    }
    
    @FindBy(xpath ="//*[contains(@id, 'business-news')]")
    private WebElement businessNewsSelector;
    
    public void clickBusinessNewsSelector() {
    	businessNewsSelector.click();
    }
    
    @FindBy(xpath ="//*[contains(@id, '2001')]")
    private WebElement year2001Selector;
    public WebElement getYear2001Selector() {
	return year2001Selector;
	}
    public void clickYear2001Selector() {
    	year2001Selector.click();
    }
    
    @FindBy(xpath ="//*[contains(@class, 'news-filter__date')][contains(text(), '2001')]")
    private WebElement firstArticleDate;
    public String getFirstArticleDate() {
    	return firstArticleDate.getText();
    }

    	
    @FindBy(xpath ="//*[contains(@class, 'news-filter__title')]")
    private WebElement firstArticleName;
    public String getFirstArticleName() {
    	return firstArticleName.getText();
    }
    
}
