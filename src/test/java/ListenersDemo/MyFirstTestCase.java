package ListenersDemo;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

//package.classname.class
@Listeners(ListenersDemo.TestNGListener.class)

public class MyFirstTestCase {

	WebDriver driver;
	
	@Test
	public void setUp()
	{
		BasicConfigurator.configure();
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com/");
		driver.quit();
}
	
	@Test
	public void TitleMatch()
	{
		System.out.println("Dummy code");
		org.testng.Assert.assertEquals(false, true);
	}
	}

