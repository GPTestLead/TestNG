package listeneres;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeneres extends TestListenerAdapter{

	
	public void onTestStart(ITestResult tr) {
	    System.out.println("Test started");
	  }
	
	
	
	  public void onTestFailure(ITestResult tr) {
		System.out.println("Test Failed");
	  }
	 
	
	  public void onTestSkipped(ITestResult tr) {
		  System.out.println("Test Skipped");
	  }
	 
	  public void onTestSuccess(ITestResult tr) {
		  System.out.println("Test Successed");
	  }

}
