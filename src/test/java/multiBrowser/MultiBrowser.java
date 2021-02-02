package multiBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


@Test
public class MultiBrowser {

	
	WebDriver driver;
	

	@Parameters("browserName")
	@BeforeTest
	public void setUp(String browserName)
	{
		
		System.out.println("Browser name : "+browserName);
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("ie"))
		{
			
			WebDriverManager.edgedriver().setup();
		
			driver =new EdgeDriver();
		}
		
		
	}
	public void test1()
	{
		driver.get("http://www.google.com/");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		System.out.println("Test completed");
	}
}
