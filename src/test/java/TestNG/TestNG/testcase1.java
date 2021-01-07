package TestNG.TestNG;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testCase1 {

	WebDriver driver;

	@SuppressWarnings("deprecation")

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://omayo.blogspot.com/");
	}

	@Test(priority = 1, groups = "Title")
	public void login() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	@Test(priority = 1, groups = "Alert")
	public void Alert() {
		boolean b = driver.findElement(By.id("alert1")).isSelected();
	}

	@Test(priority = 1, groups = "link")
	public void linkText() {
		boolean b = driver.findElement(By.linkText("compendiumdev")).isDisplayed();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}