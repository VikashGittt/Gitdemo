package com.a3hp.automationpracticee.framework.test.myaccount;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;
import com.a3hp.automationpracticee.framework.helper.TestBase.TestBasee;
import com.a3hp.automationpracticee.framework.pageobject.createaccountandlogin.SignInPage;
import com.a3hp.automationpracticee.framework.pageobject.homepage.Homepage;
import com.a3hp.automationpracticee.framework.pageobject.myaccount.MyAccountPage;
import com.a3hp.automationpracticee.framework.pageobject.myaccount.MyAddressesPage;
import com.a3hp.automationpracticee.framework.pageobject.myaccount.MyPersonalInfoPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class MyPersonalInfoPageTest extends TestBasee {

	SignInPage lognObj;
	MyAccountPage myAccountPageObj;
	MyPersonalInfoPage myPersonalInfoPageObj;
	String elementName;
	String Comment;
	String actualResult;
	String expectedResult;
	String screenshot_Path;
	String image;

	@BeforeMethod
	public void setup(String Browser, String URL) throws IOException{
		System.out.println("*******Now navigate to login page*******");
		lognObj = homeObj.navigateToSignInPage();
		System.out.println("*******Login page is in display*******");
		myAccountPageObj = lognObj.validateLogin("1");
		System.out.println("**********My Account page in Display**********");
		myPersonalInfoPageObj = myAccountPageObj.navigateToMyPersonalInformationPage();
		System.out.println("**********MyPersonalInformationPage in Display**********");
 
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException, IOException, InvalidFormatException {
		System.out.println("publishReport_HP");
		String resultStatus = null;
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
			 */
			
		} else if(result.getStatus()==ITestResult.SUCCESS){
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
			*/
		}else{
			extentTestLogger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+ " TestCase Skippedd", ExtentColor.YELLOW));
			extentTestLogger.skip(result.getThrowable());
		}
	    extentReports.flush();
		System.out.println("closing now_HP");
		driverObj.quit();
	
	}
	/*
	@Test(priority = 1)
	public void validate_PageHeading_MyPersonalInfoPage() throws Exception {
		System.out.println("In validate_PageHeading_MyPersonalInfoPage Method");
		logger = report.startTest("validateMyPersonalInfoPage_PageHeading");
		elementName = "MyPersonalInfoPage_PageHeading_txt";
		Comment = "validatePageHeading_MyPersonalInfoPage";
		String actual_pageHeading = gm_getActualText(myPersonalInfoPageObj.MyPersonalInfoPage_PageHeading_Txt,
				elementName, logger, Comment);
		System.out.println("actual_pageHeading = " + actual_pageHeading);
		String expected_pageHeading = "YOUR PERSONAL INFORMATION";
		resultStatus = gm_assertionAndResultReporting(actual_pageHeading, expected_pageHeading, elementName, logger);
		System.out.println("resultStatus = " + resultStatus);
		System.out.println("Out  of validate_PageHeading_MyPersonalInfoPage method");
	}

	@Test(priority = 3)
	public void validateBackToYourAccountButton_MyPersonalInfoPage() throws Exception {
		System.out.println("In validateBackToYourAccountButton_MyPersonalInfoPage Method");
		logger = report.startTest("validateBackToYourAccountButton_MyPersonalInfoPage");
		elementName = "BackToYourAccountButton_MyPersonalInfoPage";
		Comment = "Validate BackToYourAccountButton_MyPersonalInfoPage";
		String actualURL = gm_getActualURL(myPersonalInfoPageObj.MyPersonalInfoPage_backToYourAccount_btn, elementName,
				logger, Comment);
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		resultStatus = gm_assertionAndResultReporting(actualURL, expectedURL, elementName, logger);
		System.out.println("Out of validateBackToYourAccountButton_MyPersonalInfoPage Method");
	}

	@Test(priority = 3)
	public void validateHomeButton_MyPersonalInfoPage() throws Exception {
		System.out.println("In validateHomeButton_MyPersonalInfoPage Method");
		logger = report.startTest("validateHomeButton_MyPersonalInfoPage");
		elementName = "HomeButton_MyPersonalInfoPage";
		Comment = "Validate HomeButton_MyPersonalInfoPage";
		String actualURL = gm_getActualURL(myPersonalInfoPageObj.MyPersonalInfoPage_backToYourAccount_btn, elementName,
				logger, Comment);
		String expectedURL = "http://automationpractice.com/index.php";
		resultStatus = gm_assertionAndResultReporting(actualURL, expectedURL, elementName, logger);
		System.out.println("Out of validateHomeButton_MyPersonalInfoPage Method");
	}

	*/
}