package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	
	private static WebDriver driver;
	
 	public static WebElement waitForElementVisible(WebDriver driver,WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
