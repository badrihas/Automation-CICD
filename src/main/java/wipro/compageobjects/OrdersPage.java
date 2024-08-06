package wipro.compageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent {
	WebDriver driver;
	public OrdersPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderProducts;
	
	@FindBy(css=".totalRow button")
	WebElement submitbutton;
	
	
	public boolean verifyOrdertDisplay(String productName)
	{
	  Boolean match=orderProducts.stream().anyMatch(s-> s.getText().equalsIgnoreCase("productName"));
	  return match;
	}
	

}
