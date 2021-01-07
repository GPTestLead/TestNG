package Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class hardAssert {
 
	@Test
 public void test1()
 {
		
		// if hard assert is fail - tc will marked as FAIL and tc will be terminated.
		System.out.println("Open browser");
		Assert.assertEquals(false, true);
		System.out.println("Enter username");
		System.out.println("Enter password");
		System.out.println("Click on login button");
		System.out.println("Validate home page");
 }
}
