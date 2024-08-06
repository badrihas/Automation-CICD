package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import wipro.compageobjects.CartPage;
import wipro.compageobjects.CheckOut;
import wipro.compageobjects.ConfirmationPage;
import wipro.compageobjects.LandingPage;
import wipro.compageobjects.ProductCatalogue;


public class StepDefImpl extends BaseTest {
	public LandingPage landingPage;
	public ProductCatalogue productCAtalogue;
	public ConfirmationPage confirmationPage;
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page()
	{
		landingPage=launchApp();
	}
	@Given("^logged in with username (.+) and password (.+)$")
	public void Given_logged_in_with_username_and_password(String username,String password)
	{
		productCAtalogue= landingPage.loginApplication(username,password);
	}
	@When("^I added the product (.+) to the cart$")
	public void i_added_the_product_to_the_cart(String productName)
	{
		List<WebElement> products= productCAtalogue.getProductList();
		productCAtalogue.addProductToCart(productName);
	}
	@And("^checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String productName)
	{
		CartPage cartPage =productCAtalogue.goToCartPage();
		cartPage.verifyProductDisplay(productName);
		CheckOut checkOut=cartPage.goToCheckOut();
		checkOut.selectCountry("india");
		ConfirmationPage cofirmationPage = checkOut.submitOrder();
	}
	@Then ("{string} message is displayed on confirmationPage")
	public void message_is_displayed_confirmationPage(String string)
	{
		String ConfirmationMessage=confirmationPage.getFinalMessage();
		Assert.assertTrue(ConfirmationMessage.equalsIgnoreCase(string));
	}

	
}
