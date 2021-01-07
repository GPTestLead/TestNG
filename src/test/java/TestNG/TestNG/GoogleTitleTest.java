package TestNG.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class GoogleTitleTest {
	WebDriver driver;
	

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com/");
	}
	@Test
	public void login()
	{
	String title = driver.getTitle();
	System.out.println(title);
	Assert.assertEquals(title, "Google","Title is not matched");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
