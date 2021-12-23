import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WalletHubReviewPage {
    /**
     * All WebElements are identified by @FindBy annotation
     */
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@class='rvs-svg']/div/*[name()='svg'][4]")
	WebElement fourthStar;
	
	@FindBy(xpath="//*[contains(text(),'Select...')]")
	WebElement dropdown;
	
	
	@FindBy(xpath="//li[contains(text(),'Health Insurance')]")
	WebElement healthInsurance;
	
	@FindBy(css="[class='android'] textarea")
	WebElement reviewTextArea;
	
	@FindBy(xpath="//div[contains(text(),'Submit')]")
	WebElement submitBtn;
	
	public WalletHubReviewPage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
	
	@SuppressWarnings("deprecation")
	public void ReviewOnWalletHub() throws InterruptedException {
		String reviewText = "product and service are superb. i am satisfied with the staff and they way they have cared about me. I highly recommend the health insurance services.";
		driver.get("https://wallethub.com/profile/13732055i");
		Actions action = new Actions(driver);
		action.moveToElement(fourthStar).click().build().perform();
		
//		Select dropdwn = new Select(dropdown);
//		dropdwn.selectByIndex(1);
		dropdown.click();
		healthInsurance.click();
		reviewTextArea.click();
		reviewTextArea.sendKeys(reviewText);
		submitBtn.click();
		Thread.sleep(8000);
		driver.get("https://wallethub.com/profile/13732055i");
		driver.findElement(By.xpath("(//article[@itemprop='review'])[1]/div[5]")).isDisplayed();
		String bodyText = driver.findElement(By.xpath("(//article[@itemprop='review'])[1]/div[5]")).getText();
		Assert.assertEquals(reviewText, bodyText);
	}
	

}
