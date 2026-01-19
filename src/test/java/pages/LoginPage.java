package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseTest;
import utils.WaitUtils;

public class LoginPage{
	
	 WebDriver driver;
	private By usernametext = By.id("user-name");
	private By passnametext = By.id("password");
	private By loginbtnclick = By.name("login-button");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void enterUsername(String username)
	{
		driver.findElement(usernametext).sendKeys(username);
	}
	
	public void enterpassword(String password)
	{
		
		driver.findElement(passnametext).sendKeys(password);
	}
	
	public WebElement clickloginbtn()
	{
		
		WebElement element = driver.findElement(loginbtnclick);
		return WaitUtils.waitForElementVisible(driver, element);
	}
}
