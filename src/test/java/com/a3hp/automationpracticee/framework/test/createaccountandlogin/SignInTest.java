package com.a3hp.automationpracticee.framework.test.createaccountandlogin;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.util.Strings;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;
import com.a3hp.automationpracticee.framework.helper.TestBase.TestBasee;
import com.a3hp.automationpracticee.framework.helper.TestBase.TestBasee;
import com.a3hp.automationpracticee.framework.pageobject.createaccountandlogin.SignInPage;
import com.a3hp.automationpracticee.framework.pageobject.homepage.Homepage;
import com.a3hp.automationpracticee.framework.pageobject.myaccount.MyAccountPage;
import com.a3hp.automationpracticee.framework.pageobject.search.SearchResultPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;



public class SignInTest extends TestBasee{
 

	

	
	SignInPage signInPgObj; 
	MyAccountPage myAccountPageObj;


/*
    public void navigationToTestPage() throws IOException{
    	
    	homeObj = gm_OpenApp(Browser, URL, OSName);
    	System.out.println("*******Now navigate to login page*******");
       		lognObj = homeObj.navigateToSignInPage();
			System.out.println("*******Login page is in display*******");
		
    }
*/
	
	@BeforeMethod(alwaysRun = true)
    @Parameters({ "Browser", "URL", "OSName"/**/})
    public void getBrowser(String Browser, String URL, String OSName/**/) throws IOException, InterruptedException, InstantiationException, IllegalAccessException{
	 
		System.out.println("getBrowser Method ");
    	System.out.println("Launch "+URL+" on "+Browser+" on "+OSName);    	
    	homeObj = gm_OpenApp(Browser, URL, OSName); 
    	System.out.println("Homepage is in display");
    	System.out.println("In navigationToTestPage Method \n*******Now navigate to login page*******");           	
    	signInPgObj = homeObj.navigateToSignInPage();
		System.out.println("*******Login page is in display*******");	
	}

	 @AfterMethod (alwaysRun = true)
		public void publishReport_SIP() throws InterruptedException, IOException, InvalidFormatException{
			System.out.println("publishReport_SIP");
			/*String resultStatus = null;
		    if(result.getStatus() == ITestResult.FAILURE){
		    	System.out.println("In If");
		    	resultStatus = "FAILED"; 
		    	System.out.println(elementName+"--"+resultStatus);
		    	extentTestLogger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ " TestCase failed due tobelow issue", ExtentColor.RED));
				extentTestLogger.fail(result.getThrowable());
				
				//CoderComment1: Generate excel report
		    	gm_generateReportWithScreenshots(actualResult, expectedResult.toString(), elementName, resultStatus);
		    	
		    	//CoderComment2: Generate extent report
				String screenshot_Path = gm_setScreenshotPath_forExtentReporting(elementName, resultStatus);
				gm_TakeSnapshot(screenshot_Path);
				System.out.println("screenshot_Path: "+screenshot_Path);	
				extentTestLogger.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_Path).build()); 
			
				/*Below is extent2 version
					String image = extentTestLogger.addScreenCapture(screenshot_Path);
					logger.log(LogStatus.FAIL, Comment, image);
				 
				
			}*/
			/*else if(result.getStatus()==ITestResult.SUCCESS){
				extentTestLogger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+ " TestCase Passed", ExtentColor.GREEN));			 
				System.out.println("In else if");
				resultStatus = "PASSED"; 
				System.out.println(elementName+"--"+resultStatus);
				
				//CoderComment1: Generate excel report
				gm_generateReportWithScreenshots(actualResult, expectedResult, elementName, resultStatus);
				
			  	//CoderComment2: Generate extent report
				String screenshot_Path = gm_setScreenshotPath_forExtentReporting(elementName, resultStatus);
				gm_TakeSnapshot(screenshot_Path);
				System.out.println("screenshot_Path: "+screenshot_Path);	
				extentTestLogger.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_Path).build()); 
				
				/*Below is extent2 version
					String image = extentTestLogger.addScreenCapture(screenshot_Path);
					extentTestLogger.log(LogStatus.PASS, Comment, image);
				
			}else{
				extentTestLogger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+ " TestCase Skippedd", ExtentColor.YELLOW));
				extentTestLogger.skip(result.getThrowable());
			}*/
		
			extentReports.flush();
			System.out.println("closing now_SIP");
			driverObj.quit();
		
		}
	 
		//	driverObj.get("file:///G:/QA/AutomationTools/Selenium/WorkspaceMars1/1.2hp.com.automationprac/TestReports/ExtentReport/ExtentReport.html");
			
	  
	
	
	
	
	
	
		 
	@Test (priority = 0, groups = {"SignInpage_txt", "txt", "Low", "createaccountandlogin"}/*, dependsOnMethods = { "validateSignInPage_SignInSectionHeading_SIP" }*/)
  	public  void validateSignInPage_PageHeading_SIP() throws Exception{
  		System.out.println("In validateSignInPage_PageHeading Method_SIP");  				
		elementName = "SignIn_PageHeading_txt";		
		Comment = "validatePageHeading_SignInpage";		
		actualResult = gm_getActualText(signInPgObj.PageHeading_SignIn_txt, elementName, extentTestLogger, Comment);				
		expectedResult = "AUTHENTICATION";
		System.out.println(actualResult);
	   	System.out.println(expectedResult);
	   	Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of validateSignInPageHeading method_SIP");
  	}	
   
 	@Test (priority = 1, groups = {"SignInpage_txt", "txt", "Low", "createaccountandlogin"}/*, dependsOnMethods = { "validateSignInPageBreadcrumbText_SIP" }*/) //
  	public  void validateSignInPage_SignInSectionHeading_SIP() throws Exception{
  		System.out.println("In validateSignInPage_SignInSectionHeading Method_SIP");  		 		
		elementName = "SignInPage_SignInSectionHeading_txt";		
		Comment = "validateSectionHeading_SignInpage";		
		actualResult = gm_getActualText(signInPgObj.SectionHeading_SignIn_txt, elementName, extentTestLogger, Comment);		
		expectedResult = "ALREADY REGISTERED?";
		System.out.println(actualResult);
	   	System.out.println(expectedResult);
	   	Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of validateSignInPage_SignInSectionHeading method_SIP");
  	}	
   	

	@Test (priority = 2, groups = {"SignInpage_txt", "txt", "Low", "createaccountandlogin"}/*, dependsOnMethods = { "validateRegistrationSectionHeading_SignInPage_SIP" }*/) //
  	public  void validateSignInPageBreadcrumbText_SIP() throws Exception{
  		System.out.println("In validateSignInPageBreadcrumbText Method_SIP");  		 		
		elementName = "SignInPage_Breadcrumb_txt";		
		Comment = "validateSignInPageBreadcrumbText";		
		actualResult = gm_getActualText(signInPgObj.Brdcrmb_SignIn_Txt, elementName, extentTestLogger, Comment);		
		expectedResult = "Authentication";	
		System.out.println(actualResult);
	   	System.out.println(expectedResult);
	   	Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of validateSignInPageBreadcrumbText method_SIP");
  	}	
  	@Test (priority = 3, groups = {"SignInpage_txt", "smoke",  "Low", "createaccountandlogin"}/*, dependsOnMethods = { "validateLoginProcess_SIP" }*/)
  	public  void validateRegistrationSectionHeading_SignInPage_SIP() throws Exception{
  		System.out.println("In validateRegistrationSectionHeading_SignInPage Method_SIP");  		
  		elementName = "RegistrationSectionHeading_SignInPage_txt";
		Comment = "validateSectionHeading_SignInpage";
		actualResult = gm_getActualText(signInPgObj.SectionHeading_CreateAccount_txt, elementName, extentTestLogger, Comment);
		expectedResult = "CREATE AN ACCOUNT";
	 	System.out.println(actualResult);
	   	System.out.println(expectedResult);
	   	Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of validateRegistrationSectionHeading_SignInPage method_SIP");
  	}	
  	//https://123movierulz.me/watch-fanney-khan-2018-full-movie-online-free-movierulz-dvd-681.html
	//https://123movierulz.me/watch-badhaai-ho-2018-full-movie-online-free-movierulz-dvdrip-1579.html
  	//https://www.moviemez.com/movies/stree-2018-full-hindi-movie-watch-online-hd-print-free-download/
  	//https://www.moviemez.com/movies/omerta-2018-full-hindi-movie-watch-online-download/  	
  	//https://123movierulz.me/watch-batti-gul-meter-chalu-2018-full-movie-online-free-movierulz-hd-1-1577.html
  	//https://123movierulz.me/watch-paltan-2018-full-movie-online-free-movierulz-hd-7-1466.html
  	///https://123movierulz.me/watch-satyameva-jayate-2018-full-movie-online-free-movierulz-hd-1143.html
  	//https://123movierulz.me/watch-the-nun-2018-full-movie-online-free-movierulz-1460.html
  	//https://123movierulz.me/watch-102-not-out-2018-full-movie-online-free-movierulz-dvd-1-394.html
  	//https://123movierulz.me/watch-race-3-2018-full-movie-online-free-movierulz-dvd-6-135.html
  	//https://123movierulz.me/watch-mission-impossible-fallout-2018-full-movie-online-free-movierulz-1522.html
  	//https://123movierulz.me/watch-deadpool-2-2018-full-movie-online-free-movierulz-538.html
  	
	@Test (priority = 4, groups = {"SignInpage_func","SignInpage_smoke", "smoke", "func", "createaccountandlogin"}/*, dependsOnMethods = { "validateForgotPasswordLink_SIP" }*/) //
    public void validateLoginProcess_SIP() throws Exception {
  		System.out.println("In validateLoginProcess Method_SIP");				
		myAccountPageObj =  signInPgObj.validateLogin("1");
		System.out.println("login done using data from test data sheet");
		elementName = "Validate Login Process_txt";
		Comment = "validateLoginProcess";
		System.out.println(myAccountPageObj.MyAccount_PageHeading_Txt);
		actualResult = gm_getActualText(myAccountPageObj.MyAccount_PageHeading_Txt, elementName, extentTestLogger, Comment);
		expectedResult = "MY ACCOUNT";
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of validateLoginProcess method_SIP");
  	}
  	
	@Test (priority = 5, groups = {"SignInpage_func", "func", "Medium", "createaccountandlogin"}/**/)
  	public void validateForgotPasswordLink_SIP() throws IOException, InterruptedException, InvalidFormatException{
		System.out.println("In validateForgotPasswordLink Method_SIP");	
		elementName = "ForgotPassword_link";
		expectedResult = "http://automationpractice.com/index.php?controller=password";
		Comment = "ForgotPassword_link";
		actualResult = gm_getActualURL(signInPgObj.ForgotPassword_Lnk, elementName, extentTestLogger, Comment);	
		System.out.println(actualResult);
	   	System.out.println(expectedResult);
	   	Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of validateForgotPasswordLink method_SIP");
		
  	}
}