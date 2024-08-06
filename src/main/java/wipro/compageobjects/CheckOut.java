package wipro.compageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class CheckOut extends AbstractComponent {
	WebDriver driver;
	public CheckOut(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[placeholder='Select Country']")
	WebElement Country;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selection;
	
	@FindBy(css=".btnn")
	WebElement submittbutton;
	
	By element= By.cssSelector(".ta-item");
	
	public void selectCountry(String countryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(Country ,countryName).build().perform();
		waitForElementToAppear("By.cssSelector(.ta-item");
		selection.click();
	}
	public ConfirmationPage submitOrder()
	{
		submittbutton.click();
		ConfirmationPage cofirmationPage = new ConfirmationPage(driver);
		return cofirmationPage;
	}
	
	
	

}
