package TestNG.TestNG;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class testRunner {

	public static void main(String[] args) {
		TestNG runner = new TestNG();
		List<String>list = new ArrayList<>();
		list.add("C:\\Users\\Garvita\\Selenium\\Projects\\TestNG\\test-output\\Regression\\testng-failed.xml");
		runner.setTestSuites(list);
		runner.run();
		
	}

}
