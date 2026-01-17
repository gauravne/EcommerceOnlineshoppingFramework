package base;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	
	protected static WebDriver driver;

	@BeforeTest
	public void setUp()
	{
		
		ChromeOptions options = new ChromeOptions();

		// Disable password manager
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);

		// Disable notifications
		prefs.put("profile.default_content_setting_values.notifications", 2);

		options.setExperimentalOption("prefs", prefs);

		// Optional but recommended
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-extensions");
		options.addArguments("--start-maximized");

		driver = new ChromeDriver(options);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
		
	}
	
}
