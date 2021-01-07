package extentReports;

import javax.swing.text.html.HTML;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReports {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	WebDriver driver;
	
	
	@BeforeClass
	public void beforeClass()
	{
		htmlReporter=new ExtentHtmlReporter("./Reports/extent.html");
		htmlReporter.config().setDocumentTitle("Automation Reports");
		htmlReporter.config().setEncoding("UTF-8");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		
	}
	
	@Test
	public void test()
	{
		System.out.println("Test");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("AfterMethod");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("AfterClass");
	}
}
