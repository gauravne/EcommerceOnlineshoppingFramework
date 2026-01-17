package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	private WebDriver driver;
	private By finishbtn = By.id("finish");
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void checkoutdetails() {
		
		driver.findElement(finishbtn).click();
	}

}
