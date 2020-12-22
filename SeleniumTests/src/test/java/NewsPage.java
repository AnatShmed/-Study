import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NewsPage {
	public WebDriver driver;
    public NewsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    
    @FindBy(xpath ="//b")
    private WebElement yearArrow;
    public void clickYearArrow() {
    	yearArrow.click();
    }
    
    @FindBy(xpath ="//*[contains(@id, '2002')]")
    private WebElement selector2002;
    
    public WebElement getSelector2002() {
    	return selector2002;
    }
    public void clickSelector2002() {
    	selector2002.click();
    }
    
    @FindBy(xpath ="//*[contains(@class, 'news-filter__date')][contains(text(), '2002')]")
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
