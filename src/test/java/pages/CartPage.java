package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.WaitUtils;

public class CartPage {

	private WebDriver driver;
	private By checkoutbtn = By.name("checkout");
	private By Fname = By.id("first-name");
	private By Lname = By.id("last-name");
	private By PostalCode = By.id("postal-code");
	public By continuebtn = By.id("continue");
	public CartPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	public void CartDetails()
	{
		driver.findElement(checkoutbtn).click();
	}
	
	public void UserDetails(String FirstName, String LastName, String Postcode)
	{
		driver.findElement(Fname).sendKeys(FirstName);
		driver.findElement(Lname).sendKeys(LastName);
		driver.findElement(PostalCode).sendKeys(Postcode);
	}
	
	public WebElement continuebtn()
	{
		
	WebElement element = driver.findElement(continuebtn);
	return WaitUtils.waitForElementVisible(driver, element);
	}
	
	
	
}
