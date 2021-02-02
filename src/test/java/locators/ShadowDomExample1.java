package locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDomExample1 {

	
	@Test
	public void shadowDom()
	{
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.get("https://books-pwakit.appspot.com/");
	driver.manage().window().maximize();
	//driver.findElement(By.cssSelector("#input")).sendKeys("testing");
	
	WebElement root = driver.findElement(By.tagName("book-app"));  // shadow host /root element
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	WebElement shadowDom1 = (WebElement) js.executeScript("return arguments[0].shadowRoot" , root);
	
	WebElement appHeader = shadowDom1.findElement(By.tagName("app-header"));
	WebElement apptoolbar = appHeader.findElement(By.cssSelector("app-toolbar.toolbar-bottom"));
	WebElement bookinputdecorator = apptoolbar.findElement(By.tagName("book-input-decorator"));
	bookinputdecorator.findElement(By.cssSelector("input#input")).sendKeys("Testing");
	}
}

  