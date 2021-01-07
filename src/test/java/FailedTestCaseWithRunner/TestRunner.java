package FailedTestCaseWithRunner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.util.Strings;

public class TestRunner {

	public static void main(String []args)
	{
	TestNG runner = new TestNG();
	List<String>list = new ArrayList<>();
	list.add("C:\\Users\\Garvita\\Selenium\\Projects\\TestNG\\test-output\\SmokeTestScenarios\\testng-failed.xml");
	runner.setTestSuites(list);
	runner.run();
	}
}
