package Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssert {
	
	@Test
	 public void test1()
	 {
		
		
			SoftAssert softAssert1 = new SoftAssert();
			System.out.println("Open browser");
			Assert.assertEquals(true, true);
			System.out.println("Enter username");
			System.out.println("Enter password");
		
			System.out.println("Click on login button");
			
			
			//if soft assertion is getting failed -- next lines will be execcuted -- tc marked as PASS
			
			softAssert1.assertEquals(true, false,"home oage title is missing");
			System.out.println("Validate home page");
			System.out.println("Click on deal page");
			
			//assertAll - tc will marked as fail if any soft assertion is getting failed
			softAssert1.assertAll();
	 }
}
