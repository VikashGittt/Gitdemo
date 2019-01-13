package com.a3hp.automationpracticee.framework.test.createaccountandlogin;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;
import com.a3hp.automationpracticee.framework.helper.TestBase.TestBasee;
import com.a3hp.automationpracticee.framework.pageobject.createaccountandlogin.RegistrationPage;
import com.a3hp.automationpracticee.framework.pageobject.createaccountandlogin.SignInPage;
import com.a3hp.automationpracticee.framework.pageobject.homepage.Homepage;
import com.a3hp.automationpracticee.framework.pageobject.myaccount.MyAccountPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
 

public class RegistrationTest extends TestBasee{
	RegistrationPage registrationPageObj;
	SignInPage signInPgObj; 
	MyAccountPage myAccountPageObj;
	int i=1;

    @BeforeMethod(alwaysRun = true)
    @Parameters({ "Browser", "URL", "OSName"/**/})
    public void getBrowser(String Browser, String URL, String OSName/**/) throws IOException, InterruptedException, InstantiationException, IllegalAccessException{
   
		System.out.println("getBrowser Method ");
    	System.out.println("Launch "+URL+" on "+Browser+" on "+OSName);    	
    	homeObj = gm_OpenApp(Browser, URL, OSName); 
    	System.out.println("*******Now navigate to login page*******");
		signInPgObj = homeObj.navigateToSignInPage();
		System.out.println("*******SignIn page is in display*******");
		registrationPageObj = signInPgObj.validateCreateAccountBtn("1");
		gm_WaitVIsibility(registrationPageObj.PersonalInfoTitle_Txt, 50000);
		System.out.println("*******Registration page is in display*******");	
	}	

    
	 @AfterMethod (alwaysRun = true)
		public void publishReport_SIP(ITestResult result) throws InterruptedException, IOException, InvalidFormatException{
			System.out.println("publishReport_RP");
			/*	String resultStatus = null;
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
			
				Below is extent2 version
					String image = extentTestLogger.addScreenCapture(screenshot_Path);
					logger.log(LogStatus.FAIL, Comment, image);
				
				
			} */ /*else if(result.getStatus()==ITestResult.SUCCESS){
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
				
				Below is extent2 version
					String image = extentTestLogger.addScreenCapture(screenshot_Path);
					extentTestLogger.log(LogStatus.PASS, Comment, image);
				
			}else{
				extentTestLogger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+ " TestCase Skippedd", ExtentColor.YELLOW));
				extentTestLogger.skip(result.getThrowable());
			}*/
			extentReports.flush();
			System.out.println("closing now_RP");
			driverObj.quit();
		
	}
	 @Test (priority = 0, groups = {"Registrationpage_txt", "txt", "Low", "createaccountandlogin"}) 
  	public  void validatePageHeading_RP() throws Exception{
  		System.out.println("In validatePageHeading_RP Method");
  		elementName = "RegistrationPage_PageHeading_txt";
		Comment = "validatePageHeading_RegistrationPage";
		actualResult = gm_getActualText(registrationPageObj.CreateAccountPageTitle_Txt, elementName, extentTestLogger, Comment);
		System.out.println("actual_pageHeading = "+actualResult);
		expectedResult = "CREATE AN ACCOUNTT";
		System.out.println(actualResult);
	   	System.out.println(expectedResult);
	   	Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of validatePageHeading_RP method");
  	}	
   
  	@Test (priority = 1, groups = {"Registrationpage_txt", "txt", "Low", "createaccountandlogin"}) 
  	public  void validateBreadcrumbText_RP() throws Exception{
  		
  		System.out.println("In validateBreadcrumbText_RP Method");
		elementName = "RegistrationPage_Breadcrumb_txt";
		Comment = "validateBreadcrumbText_RegistrationPage";
		actualResult = gm_getActualText(registrationPageObj.CreateAccount_Breadcrumb_Txt, elementName, extentTestLogger, Comment);
	
			expectedResult = "Authenticationn";
	
	   	Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of validateBreadcrumbText_RP method");
  	}
  	
  // @Test (priority = 3, groups = {"Registrationpage_func", "smoke", "createaccountandlogin"})
   //@Parameters({ "TestDataPath1", "TDSheetName1", "rownum" })
	public void validateRegistrationProcess_RP () throws InvalidFormatException, IOException, InterruptedException  {
	   		System.out.println("In validateRegistrationProcess method_RP  ");			
	   		WebElement myAccountPageTitleEle = registrationPageObj.validateRegistrationPage("1");
			elementName = "ValidateRegistrationProcess_myAccountPageTitle_txt";
			Comment = "ValidateRegistrationProcess";
			actualResult = gm_getActualText(myAccountPageTitleEle, elementName, extentTestLogger, Comment);
			System.out.println("actual_pageHeading = "+actualResult);
			expectedResult = "MY ACCOUNT";		 
		   	Assert.assertEquals(actualResult, expectedResult);
			System.out.println("Out  of validateRegistrationProcess method_RP ");
			
	}
}
