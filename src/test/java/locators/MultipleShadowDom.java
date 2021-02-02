package locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleShadowDom {

	

	WebDriver driver;
	@Test
	public void setUp() 
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.get("https://shop.polymer-project.org/");
	driver.manage().window().maximize();
	WebElement root = driver.findElement(By.tagName("shop-app"));  //root node/shadow host
	
	//multiple shadowdome
	
	
	WebElement shadowDome1 = getShadowDom(root, driver);
	WebElement ironPages = shadowDome1.findElement(By.tagName("iron-pages"));
	WebElement shophome = ironPages.findElement(By.name("home"));
	
	WebElement shadowDome2 = getShadowDom(shophome, driver);
	shadowDome2.findElement(By.cssSelector("div:nth-child(2) > shop-button >a")).click();
	}
	
	
	
	//use user defined method
 static WebElement getShadowDom(WebElement element, WebDriver driver)
	{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	WebElement shadowDom1 = (WebElement) js.executeScript("return arguments[0].shadowRoot" ,element);
	return shadowDom1;
	}
	
	
	
	
}

