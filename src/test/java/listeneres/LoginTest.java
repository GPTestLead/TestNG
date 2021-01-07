package listeneres;

import org.testng.annotations.Test;

public class LoginTest {
	
	@Test
	public void loginByEmail()
	{
		System.out.println("Login by Email");
		org.testng.Assert.assertEquals("garvita", "garvita");
	}
	
	@Test
	public void loginByFacebook()
	{
		System.out.println("Login by Facebook");
		org.testng.Assert.assertEquals("garvita", "patel");
	}
}
