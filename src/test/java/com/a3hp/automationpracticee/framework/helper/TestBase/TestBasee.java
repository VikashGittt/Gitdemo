package com.a3hp.automationpracticee.framework.helper.TestBase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlClass;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;
import com.a3hp.automationpracticee.framework.pageobject.homepage.Homepage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class TestBasee extends UI_GenericMethods1 {
	public static String elementName;
	public static String Comment;
	public static String actualResult;
	public static String expectedResult;
 	public static ExtentHtmlReporter extentHtmlReporter;
 	public static ExtentReports extentReports;
	public static ExtentTest extentTestLogger;
	//public WebDriver driverObj; Already declared in UIGeneric
	//public Homepage homeObj; Already declared in UIGeneric
	public static String classPackName;
	public static XmlClass  failedClasses;
 	//WHen I use BeforeClass-- and Static extentreport & logger It will produce inbdividual report
	//If I write Beforesuite for static extent report it will produce single report 
	//If I use non static extent report it will produce error for other class except 1st
	@BeforeSuite(alwaysRun = true) 
	public void BeforeSuite(){		
 		System.out.println("In @@BeforeSuite");
 		String className =  this.getClass().getName(); 		
 		String[] arr = className.split("\\.");
 		System.out.println(arr[0]+" -- "+arr[1]);
 		String projectName = 	arr[1];	
 		String path1 = "E:\\QA\\Automation_Tools\\Selenium\\WorkspaceMars1\\A3hp.com.automationprac\\TestReports\\ExtentReport3\\ExtentReport"+"_"+projectName+"_"+fn_GetTimeStamp()+".html";
 		extentHtmlReporter = new ExtentHtmlReporter(path1);		
 		extentHtmlReporter.config().setDocumentTitle("AutomationTestingReport-Demosite"); //-->> This willgive name to the extent report file
 		extentHtmlReporter.config().setReportName("My Own Report");;
 		extentHtmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //htmpReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);		
 		extentHtmlReporter.config().setTheme(Theme.DARK); //htmpReporter.config().setTheme(Theme.STANDARD);		
 		extentReports = new ExtentReports();
 		extentReports.attachReporter(extentHtmlReporter);		
 		extentReports.setSystemInfo("OS", "Windows10");
 		extentReports.setSystemInfo("HostName", "VKHost");
 		extentReports.setSystemInfo("Environment", "QA");
 		extentReports.setSystemInfo("User Name", "Vkumar");
		System.out.println("Out @@BeforeSuite");
	} 
	@BeforeClass(alwaysRun = true)
	public void BeforeClass() throws Exception{
		System.out.println("In @BeforeClass ");
	 	classPackName =  this.getClass().getName();
		System.out.println("className = "+classPackName);

    }
	@BeforeMethod(alwaysRun = true)
	@Parameters({ "Browser"}) 
	public void BeforeMethodTB(Method method, String Browser) throws Exception{
		System.out.println("In @BeforeMethod -- testBase-setUp Method");
		extentTestLogger = extentReports.createTest((this.getClass().getSimpleName()+"::"+method.getName()+" ::  Browser-"+Browser), "TestMethod: "+method.getName()+" ::  Browser-"+Browser);
		extentTestLogger.assignAuthor("VK");
		extentTestLogger.assignCategory(this.getClass().getSimpleName()+"::"+"Smoketesting and TextTesting--Live :: Browser-"+Browser);  
    }
	
	@AfterSuite(alwaysRun = true)
	public void tearDown(ITestContext context) throws IOException, InterruptedException{
		System.out.println("@AfterSuite In tear down");
		ITestNGMethod[] tngMethods	= context.getAllTestMethods();
		int i=1;
		for(ITestNGMethod tng: tngMethods){			
			String methodName = "Method"+i+": "+ tng.getMethodName();
			i++;
			System.out.println(methodName);
		}
	}

 

	
}





















