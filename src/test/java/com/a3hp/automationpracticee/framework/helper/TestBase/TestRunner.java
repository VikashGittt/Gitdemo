package com.a3hp.automationpracticee.framework.helper.TestBase;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.Test;

public class TestRunner {
	
	@Test
	public static void testRunner(){
		TestNG runner = new TestNG();
		List <String> list = new ArrayList<String>();
		list.add("E:\\QA\\Automation_Tools\\Selenium\\WorkspaceMars1\\A3hp.com.automationprac\\test-output\\testng-failed.xml");
		runner.setTestSuites(list);
		runner.run();
		
	}

}
