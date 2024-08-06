package wipro.com;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import wipro.compageobjects.CartPage;
import wipro.compageobjects.CheckOut;
import wipro.compageobjects.ConfirmationPage;
import wipro.compageobjects.LandingPage;
import wipro.compageobjects.OrdersPage;
import wipro.compageobjects.ProductCatalogue;

public class submitOrderTest extends BaseTest {
	String productName= "ZARA COAT3";

	@Test(dataProvider="getData", groups= {"Purchase"})
	public void submitOrderTest(HashMap<String,String> input) throws IOException {
		// TODO Auto-generated method stub
                //NEW COMMENTS ARE ADEED
		
		ProductCatalogue productCAtalogue =landingPage.loginApplication(input.get("email"),input.get("password"));
		List<WebElement> products= productCAtalogue.getProductList();
		productCAtalogue.addProductToCart(input.get("product"));
		CartPage cartPage =productCAtalogue.goToCartPage();
		cartPage.verifyProductDisplay(input.get("product"));
		CheckOut checkOut=cartPage.goToCheckOut();
		checkOut.selectCountry("india");
		ConfirmationPage cofirmationPage = checkOut.submitOrder();
		String ConfirmationMessage=cofirmationPage.getFinalMessage();
	}
	@Test(dependsOnMethods= {"submitOrderTest"})
	public void orderTest()
	{
		ProductCatalogue productCAtalogue =landingPage.loginApplication("bavani@gmail.com","Badri@123");
		OrdersPage ordersPage=productCAtalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.verifyOrdertDisplay(productName));
	}
	@DataProvider
	public Object[][] getData() {
		/*HashMap<String,String> map=new HashMap<String,String>();
		map.put("email", "bavani@gmail.com");
		map.put("password","Badri@123");
		map.put("product", "ZARA COAT3");
		HashMap<String,String> map1=new HashMap<String,String>();
		map1.put("email", "bhavani@gmail.com");
		map1.put("password","Badri@123");
		map1.put("product", "ADIDAS ORIGINAL");*/
		List<HashMap<String,String>> data= getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Data\\PurchaseOrder.jason");
		return new Object [][]  {{data.get(0)},{data.get(1)}};	
	}
 
}
