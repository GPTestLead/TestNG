package FailedTeastCase;

import org.testng.annotations.Test;

public class TeastCase3 {
	@Test
	public void testWorldPress()
	{
		org.testng.Assert.assertEquals(false, true);
		System.out.println("WorldPress is working as expected");
	}
}
