package TestNG.TestNG;

import org.testng.annotations.Test;



public class TestNGFeatures {
	
@Test
public void loginTest ()
{
	System.out.println("Login test");
	int i = 9/0;
}

@Test(dependsOnMethods="loginTest")
public void HomePage ()
{
	System.out.println("Homepage test");
}

@Test(dependsOnMethods="loginTest")
public void SearchPage ()
{
 System.out.println("search");
}

@Test(dependsOnMethods="loginTest")
public void RealPage ()
{
	System.out.println("RealPage");
}
}
