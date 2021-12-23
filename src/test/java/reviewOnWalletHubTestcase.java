import java.lang.reflect.Method;
import org.testng.annotations.Test;

public class reviewOnWalletHubTestcase extends testRunner{
	
@Test(priority=1,description="Verify that User can add a review on wallet page")

public void reviewOnWallet(Method method) throws InterruptedException{

	
	WalletHubReviewPage walletHubReviewPageObj =  new WalletHubReviewPage(driver);
	walletHubReviewPageObj.ReviewOnWalletHub();
	}

}
