package com.a3hp.automationpracticee.framework.test.createaccountandlogin;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;
import com.a3hp.automationpracticee.framework.helper.TestBase.TestBasee;
import com.a3hp.automationpracticee.framework.pageobject.createaccountandlogin.ForgotPasswordPage;
import com.a3hp.automationpracticee.framework.pageobject.createaccountandlogin.RegistrationPage;
import com.a3hp.automationpracticee.framework.pageobject.createaccountandlogin.SignInPage;
import com.a3hp.automationpracticee.framework.pageobject.homepage.Homepage;
import com.a3hp.automationpracticee.framework.pageobject.information.ContactUsPage;
import com.a3hp.automationpracticee.framework.pageobject.myaccount.MyAccountPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class ForgotPasswordTest extends TestBasee{



	ForgotPasswordPage forgotPswdPageObj;
	SignInPage signInPgObj; 

	
    @BeforeMethod(alwaysRun = true)
    @Parameters({ "Browser", "URL", "OSName"/**/})
    public void getBrowser(String Browser, String URL, String OSName/**/) throws IOException, InterruptedException, InstantiationException, IllegalAccessException{
    
		System.out.println("getBrowser Method ");
    	System.out.println("Launch "+URL+" on "+Browser+" on "+OSName);    	
    	homeObj = gm_OpenApp(Browser, URL, OSName); 
      	System.out.println("*******Now navigate to login page*******");
    	signInPgObj = homeObj.navigateToSignInPage();
    	System.out.println("*******Login page is in display*******");
		forgotPswdPageObj = signInPgObj.navigateToForgotPasswordPage();
		System.out.println("*******Forgot Password page is in display*******");
		gm_WaitVIsibility(forgotPswdPageObj.ForGotPassword_PgTtl, 50000);
		
	}	
    

	 @AfterMethod (alwaysRun = true)
		public void publishReport_FP(ITestResult result) throws InterruptedException, IOException, InvalidFormatException{
			System.out.println("publishReport_FP");
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
				 
				
			}*/ /*else if(result.getStatus()==ITestResult.SUCCESS){
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
			System.out.println("closing now_FP");
			driverObj.quit();
		
		}
 
	@Test (priority = 0, groups = {"ForgotPasswordpage_txt", "txt", "Low", "createaccountandlogin"})
  	public  void validateForgotPasswordPage_PageHeading_FP() throws Exception{
  		System.out.println("In validateForgotPasswordPage_PageHeading Method_FP");
  		elementName = "ForgotPasswordPage_PageHeading_txt";
		Comment = "validatePageHeading_ForgotPasswordPage";
		actualResult = gm_getActualText(forgotPswdPageObj.ForGotPassword_PgTtl, elementName, extentTestLogger, Comment);
		System.out.println("actual_pageHeading = "+actualResult);
		expectedResult = "FORGOT YOUR PASSWORDD?";
  		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of validateForgotPasswordPage_PageHeading method_FP");
  	}	
   
 	//@Test (priority = 2) [Need to work on this ]
	/*	public  void validateForgotPasswordPage_Breadcrumn_text() throws Exception{
  		System.out.println("In validateForgotPasswordPage_Breadcrumb_text Method");
  		logger=report.startTest("validateForgotPasswordPage_Breadcrumb_text");
		elementName = "SignInPage_SignInSectionHeading_txt";
		Comment = "validateBreadcrumb_text_SignInpage";
		String actual_pageHeading = gm_getActualText(forgotPswdPageObj, elementName, logger, Comment);
		System.out.println("actual_pageHeading = "+actual_pageHeading);
		String expected_pageHeading = "ALREADY REGISTERED?";
		resultStatus = gm_assertionAndResultReporting(actual_pageHeading, expected_pageHeading, elementName, logger);
		System.out.println("resultStatus = "+ resultStatus);
		System.out.println("Out  of validateSignInPageHeading method");
  	}	
  	*/
	@Test (priority = 1, groups = {"ForgotPasswordpage_func", "func", "ForgotPasswordpage_smoke", "smoke", "createaccountandlogin"})
	public void validateforgotPasswordProcess_FP() throws InvalidFormatException, IOException, InterruptedException{
	  		System.out.println("In validateforgotPasswordProcess Method_FP");
			elementName = "ForgotPasswordConfirmationMessages_txt";
			String emailValue =  forgotPswdPageObj.validateForgotPassword("1");
			System.out.println("emailValue = "+emailValue);
			Comment = "ForgotPasswordConfirmation_message";
			actualResult = gm_getActualText(forgotPswdPageObj.forgotPwdConfirmationMesg_txt, elementName, extentTestLogger, Comment);
			System.out.println();
			expectedResult = "A confirmation email has been sent to your address: "+emailValue;
			Assert.assertEquals(actualResult, expectedResult);
			System.out.println("Out  of validateforgotPasswordProcess method_FP");
	} 
	@Test (priority = 2, groups = {"ForgotPasswordpage_func", "func", "Medium", "createaccountandlogin"})
	public void validateBackToLoginButton_FP() throws Exception{
			System.out.println("In validateBackToLoginButton_FP Method");		
			String emailValue =  forgotPswdPageObj.validateForgotPassword("1");
			elementName = "BackToLoginButton_ForgotPasswordConfirmationPage";
			Comment = "Validate BackToLogin Button_FPConfirmationPage";
			actualResult = gm_getActualURL(forgotPswdPageObj.BackToLogin_Btn, elementName, extentTestLogger, Comment);
			expectedResult = "http://automationpractice.com/index.php?controller=authentication";
			System.out.println("Out of validateBackToLoginButton_FP Method");
			
		
		}
		
}






