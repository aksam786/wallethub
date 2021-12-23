import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


public class testRunner {
		 public WebDriver driver;
		 
@BeforeClass
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();    
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1400,800");  
        driver = new ChromeDriver(options);  
		driver.manage().window().maximize();
		
			}

@AfterClass
	public void broweserClosure() {
	driver.close();
	}

}