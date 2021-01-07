package datadriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HalfEbdayTest {

	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://signup.ebay.com/pa/crte?hm=jqp54*71%3F%3E%3B15&hc=1&rv4=1");
	}
	
	
	@Test
	public void signUp(String firstName, String lastName, String email, String password)
	{
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
