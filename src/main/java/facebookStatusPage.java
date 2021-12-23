import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class facebookStatusPage {
	
    /**
     * All WebElements are identified by @FindBy annotation
     */
	
	WebDriver driver;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="pass")
	WebElement password;
	
	@FindBy(xpath="//button[@name='login']")
	WebElement submittButton;
	
	@FindBy(xpath="//div/span[contains(text(),'on your mind')]")
	WebElement statusBoxField;
	
	@FindBy(xpath="/descendant::div[@role='textbox'][1]")
	WebElement statusBox;
	
	@FindBy(xpath="//div[@aria-label='Post']")
	WebElement postButton;
	
	
	public facebookStatusPage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
	
	public void login(String strEmail, String strPassword) throws InterruptedException {
		driver.get("https://www.facebook.com");
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(email));
		email.sendKeys(strEmail);
		password.sendKeys(strPassword);
		submittButton.click();
	}
	
	public void postStatus(String strStatus) throws InterruptedException {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(statusBoxField));
		statusBoxField.click();
		wait.until(ExpectedConditions.visibilityOf(statusBox));
		statusBox.sendKeys(strStatus);
		wait.until(ExpectedConditions.visibilityOf(postButton));
		postButton.click();
		
	}
	
}
