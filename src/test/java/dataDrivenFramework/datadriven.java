package dataDrivenFramework;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class datadriven {

	/* 1.add apache poi ooxml dependency
	   2.create folder - excel
	   3. right click of folder/property/create data.xlsx 
	

	*/
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
		
	}
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user,String pwd, String exp)
	{
	driver.get("https://admin-demo.nopcommerce.com/login");
	WebElement txtEmail= driver.findElement(By.id("Email"));
	txtEmail.sendKeys(user);
	
	driver.get("https://admin-demo.nopcommerce.com/login");
	WebElement txtPassword= driver.findElement(By.id("Password"));
	txtPassword.sendKeys(pwd);
	
	driver.findElement(By.xpath("//input[@value='Log in']")).click();
	
	String exp_title = "Dashboard / nonCommerce administration";
	String act_title = driver.getTitle();
	
	if (exp.equals("Valid")) {
		if(exp_title.equals(act_title))
		{
			driver.findElement(By.linkText("Logout")).click();
			Assert.assertTrue(true);
		}
		else {
			
			
			Assert.assertTrue(false);
		}
	}
	else if(exp.equals("Invalid"))
	{
		if(exp_title.equals(act_title))
		{
			driver.findElement(By.linkText("Logout")).click();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
		}
	}
	}
	
	
	@DataProvider(name="LoginData")
	
	public  Object [][] getData() throws IOException 
	{
		//if you have combination of data then use Object type
		//hard coded value
		
		/*Object loginData[][]= {
				{"admin@yourstore.com","admin" ,"valid"},
				{"admin@yourstore.com","adm" ,"Invalid"},
				{"adm@yourstore.com","admin" ,"Invalid"},
				{"adm@yourstore.com","adm" ,"Invalid"},
		}; */
		
		//get data from excel
		
		String path= "./excelDataFiles/data.xlsx";
		
		XLUtility xlUtil = new XLUtility(path);
		
		int totalrows = xlUtil.getRowCount("Sheet1");
		int totalcolumns = xlUtil.getCellCount("Sheet1", 1);
		
		String loginData[][]= new String[totalrows][totalcolumns];
		
		//ignoring header part so i=1
		for (int i = 1; i <=totalrows; i++) 
		{
			for (int j = 0; j < totalcolumns; j++) 
			{
				//excel ignore header so i-1
				loginData[i-1][j]=xlUtil.getCellData("Sheet1", i, j);
			}
		}
		return loginData;
	}

	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
