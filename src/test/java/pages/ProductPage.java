package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

	private WebDriver driver;
	private By addToCart = By.id("add-to-cart-sauce-labs-backpack");
	private By shoppingCartlink = By.className("shopping_cart_link");
	
	
	public ProductPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void Backpack()
	{
		driver.findElement(addToCart).click();
	}
	
	public void CartLink()
	{
		driver.findElement(shoppingCartlink).click();
	}
	
}
