package com.a3hp.automationpracticee.framework.helper.TestBase;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class FailedTestRunner extends TestBasee {
	
	@Test
	public static void testRunner(){
		
		
		XmlSuite suite = new XmlSuite();
		suite.setName("FailedTestSuite");
		XmlTest test = new XmlTest(suite);
		test.setName("FailedTest");
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.addAll(classes);
		//classes.add(new XmlClass("test.failures.Child"));
		test.setXmlClasses(classes) ; 		
		
		
	}

}
