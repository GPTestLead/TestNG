package TestNG.TestNG;

import org.testng.annotations.ExpectedExceptions;
import org.testng.annotations.Test;

public class ExceptionTimeoutTest {

	
//	@Test(invocationTimeOut=2,expectedExceptions=NumberFormatException.class)
//	public void infiniteLoopTest() 
//	{
//		int i =1;
//		while(i==1)
//		{
//			System.out.println(i);
//		}
//	}
	
	@Test(expectedExceptions=ArithmeticException.class)
	public void testCase1()
	{

	int i = 9/0;
	
	}
	
	@Test(expectedExceptions=NumberFormatException.class)
	public void testCase2()
	{

	String x = "100";
	Integer.parseInt(x);
	
	}
}

