package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;

public class OrderTest extends BaseTest {
	
	@Test(priority=1)
	public void placeOrderTest() throws InterruptedException
	{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername("standard_user");
		loginpage.enterpassword("secret_sauce");
		loginpage.clickloginbtn();
		Thread.sleep(3000);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Swag Labs";
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Login Test - Passed");
		
		ProductPage product = new ProductPage(driver);
		product.Backpack(); // add backpack
		product.CartLink(); // add to cart
		System.out.println("Add Product Test - Passed");
		
	//	Alert alert = driver.switchTo().alert();
	//	alert.dismiss();
		
		CartPage cart = new CartPage(driver);
		cart.CartDetails();
	//	Thread.sleep(5000);
		cart.UserDetails("Mona", "Dhona", "90227788");
		cart.continuebtn();
		System.out.println("Cart details Test - Passed");
		
		CheckoutPage chkout = new CheckoutPage(driver);
		chkout.checkoutdetails();
	    String actualOrderText = driver.findElement(By.className("complete-header")).getText();
	    String expectedOrderText = "Thank you for your order!";
	    Assert.assertEquals(expectedOrderText, actualOrderText);
	    
	    System.out.println("Order is placed successfully");
	}

}
