package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;
import utils.ExcelUtils;
import utils.ScreenshotUtils;
import utils.WaitUtils;

public class OrderTest extends BaseTest {
	
	@Test(dataProviderClass = ExcelUtils.class, dataProvider = "TestData")
	public void login(String user_name, String pass_word) throws InterruptedException, IOException
	{
		LoginPage loginpage = new LoginPage(driver);
		
	
		loginpage.enterUsername(user_name);
		loginpage.enterpassword(pass_word);
		loginpage.clickloginbtn().click();
		ScreenshotUtils.CaptureScreenshot();
		
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
		cart.UserDetails("John", "Cook", "90227788");
		
	//	Utils util = new Utils();
	
		cart.continuebtn().click();
		System.out.println("Cart details Test - Passed");
		
		CheckoutPage chkout = new CheckoutPage(driver);
		chkout.checkoutdetails();
	    String actualOrderText = driver.findElement(By.className("complete-header")).getText();
	    String expectedOrderText = "Thank you for your order!";
	    Assert.assertEquals(expectedOrderText, actualOrderText);
	    
	    System.out.println("Order is placed successfully");
		ScreenshotUtils.CaptureScreenshot();
	    
	    
	}
/*	@DataProvider(name="login")
	public Object[][] Testdata() 
	{
		return new Object[][] 
				{
					{"standard_user","secret_sauce"},
					{"locked_out_user","standard_user"},
					{"problem_user","secret_sauce"},
					{"performance_glitch_user","standard_user"}
				};
	}
	*/

}
