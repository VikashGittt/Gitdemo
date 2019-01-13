package com.a3hp.automationpracticee.framework.test.information;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
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
import com.a3hp.automationpracticee.framework.pageobject.information.AboutUsPage;
import com.a3hp.automationpracticee.framework.pageobject.information.StoresPage;
import com.a3hp.automationpracticee.framework.pageobject.information.TermsAndConditionsPage;
import com.a3hp.automationpracticee.framework.pageobject.myaccount.MyAccountPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class TermsAndConditionsTest extends TestBasee{
	
	
 
		TermsAndConditionsPage termsAndConditionsPageObj; 
		String actualResult;
		String expectedResult;
		String resultStatus;
		String elementName;
		String screenshot_Path;
		String image;
		String Comment;
	
	    @BeforeMethod
	    @Parameters({ "Browser", "URL" })
	    public void setup(String Browser, String URL) throws IOException{
				System.out.println("*******Now navigate to T&C page*******");
				termsAndConditionsPageObj  = homeObj.navigateToTermsAndConditionsPage();
				System.out.println("******* T&C Page is in display*******");
	
	    }

		@AfterMethod
		public void tearDown(ITestResult result) throws InterruptedException, IOException, InvalidFormatException{
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
	   //"********Validation of TermsAndConditionsPageHeading********");
	  	@Test (priority = 1)
	  	public  void validateTermsAndConditionsPageHeading() throws Exception{
	  		System.out.println("In validateTermsAndConditionsPageHeading Method");	  		
	  		elementName = "TermsAndConditionsPageHeading_txt";
	  		Comment = "validateTermsAndConditionsPageHeading";
	  		//String actual_pageHeading = gm_getActualText(termsAndConditionsPageObj.TermsAndConditionsPageTitle_txt, elementName, logger, Comment);
	  		//System.out.println("actual_pageHeading = "+actual_pageHeading);
	  		String expected_pageHeading = "TERMS AND CONDITIONS OF USE";
	  		//resultStatus = gm_assertionAndResultReporting(actual_pageHeading, expected_pageHeading, elementName, logger);
	  		System.out.println("resultStatus = "+ resultStatus);
	  		System.out.println("Out  of validateTermsAndConditionsPageHeading method");
	  	}	
	  	  	
	  		//"********Validation of AboutUsPageHeading********");
	  	@Test (priority = 2)
	  	public  void validateTermsAndConditionsBreadcrumbtText() throws Exception{	  		
	  		System.out.println("In validateTermsAndConditionsBreadcrumbHeading Method");
	  		elementName = "Terms&Conditions_Breadcrumb_txt";
	  		Comment = "validate TermsAndConditions Breadcrumb Text";
	  	//	String actual_breadcrumb = gm_getActualText(termsAndConditionsPageObj.BreadCrumb_TermsAndConditions_txt, elementName, logger, Comment);
	  		String expected_breadcrumb = "Terms and conditions of use";
	  	//	resultStatus = gm_assertionAndResultReporting(actual_breadcrumb, expected_breadcrumb, elementName, logger);
	  		System.out.println("Out  of validateTermsAndConditionsBreadcrumbHeading method");
	  	}	
	  	  			
  
}
