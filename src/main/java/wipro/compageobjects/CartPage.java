package wipro.compageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".cartSection h3")
	List<WebElement> headerProducts;
	
	@FindBy(css=".totalRow button")
	WebElement submitbutton;
	
	
	public boolean verifyProductDisplay(String productName)
	{
	  Boolean match=headerProducts.stream().anyMatch(s-> s.getText().equalsIgnoreCase("productName"));
	  return match;
	}
	public CheckOut goToCheckOut()
	{
		submitbutton.click();
		CheckOut checkOut = new CheckOut(driver);
		return checkOut;
	}
	

}
