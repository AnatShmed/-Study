import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	public WebDriver driver;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    @FindBy(xpath = "//*[contains(@class, 'top-navigation__item-link')][contains(text(), 'Services')]")
    private WebElement servicesLink;
    public void clickServicesLink() {
    	servicesLink.click(); }
    
    @FindBy(xpath = "//*[contains(@class, 'top-navigation__item-link')][contains(text(), 'How We Do It')]")
    private WebElement howLink;
    public void clickHowLink() {
    	howLink.click(); }
    
    @FindBy(xpath = "//*[contains(@class, 'top-navigation__item-link')][contains(text(), 'Our Work')]")
    private WebElement ourWorkLink;
    public void clickOurWorkLink() {
    	ourWorkLink.click(); }
    
    @FindBy(xpath = "//*[contains(@class, 'top-navigation__item-link')][contains(text(), 'Insights')]")
    private WebElement insightsLink;
    public void clickInsightsLink() {
    	insightsLink.click(); }
    
    @FindBy(xpath = "//*[contains(@class, 'top-navigation__item-link')][contains(text(), 'About')]")
    private WebElement aboutLink;
    public void clickAboutLink() {
    	aboutLink.click(); }
    
    @FindBy(xpath = "//*[contains(@class, 'top-navigation__item-link')][contains(text(), 'Careers')]")
    private WebElement careersLink;
    public void clickCareersLink() {
    	careersLink.click(); }
}
