import java.lang.reflect.Method;
import org.testng.annotations.Test;

public class statusPostTestCase extends testRunner {
	
	
@Test(priority=1,description="Verify that User can login with correct username and password and post a status")

public void successfullUserLogin(Method method) throws InterruptedException{

	
	facebookStatusPage facebookStatusPageObj =  new facebookStatusPage(driver);
	facebookStatusPageObj.login("Maheen.ali128@gmail.com", "Maheenali@1");
	facebookStatusPageObj.postStatus("Hello World");
	}
}
