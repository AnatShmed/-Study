import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HistoryPage {
	public WebDriver driver;
    public HistoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    
    @FindBy(xpath ="//*[contains(@class, 'video__button')]")
    private WebElement videoButton;
    public void clickVideoButton() {
    	videoButton.click();
    }
    
    @FindBy(xpath ="//*[@class='mfp-iframe']")
    private WebElement magnificPopupIframe;
    public String getMagnificPopupIframeAtr(String atr) {
    	return magnificPopupIframe.getAttribute(atr);
    }
    
}


