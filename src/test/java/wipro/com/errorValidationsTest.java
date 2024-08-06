package wipro.com;
import java.io.IOException;
import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import TestComponents.BaseTest;
import wipro.compageobjects.CartPage;
import wipro.compageobjects.CheckOut;
import wipro.compageobjects.ConfirmationPage;
import wipro.compageobjects.LandingPage;
import wipro.compageobjects.ProductCatalogue;

public class errorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"}, retryAnalyzer=Retry.class)
	public void errorValidationTests() throws IOException {
		// TODO Auto-generated method stub
		String productName= "ZARA COAT3";
		LandingPage landingPage=launchApp();
		landingPage.loginApplication("bavani@gmail.com","Badri@123");
		Assert.assertEquals("Incorrect email or password",landingPage.getErrorMessage());
	}
	@Test
	public void productCatalogueValidations() throws IOException {
		// TODO Auto-generated method stub
		String productName= "ZARA COAT3";
		ProductCatalogue productCAtalogue =landingPage.loginApplication("bhavani@gmail.com","Badri@123");
		List<WebElement> products= productCAtalogue.getProductList();
		productCAtalogue.addProductToCart(productName);
	}
 
}
