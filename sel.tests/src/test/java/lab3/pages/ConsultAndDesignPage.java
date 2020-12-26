package lab3.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsultAndDesignPage {
	public WebDriver driver;
    public ConsultAndDesignPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    
    //@FindBy(xpath ="/html/body/div[2]/main/div[1]/div[1]/div[1]")
    @FindBy(xpath ="/html/body/div[2]/main/div[1]/div[1]/div[1]")
    private WebElement topElement;
    public WebElement getTopElement() {
    	return topElement;
    }
    
    @FindBy(xpath ="/html/body/div[2]/main/div[1]/div[7]/section/div/div[3]/div/div/div[1]")
    private WebElement playerSection;
    public WebElement getPlayerSection() {
    	return playerSection;
    }
    public void clickPlayerSection() {
    	playerSection.click();
    }
    public String getPlayerSectionAtr(String atr) {
    	return playerSection.getAttribute(atr);
    }
    
}
