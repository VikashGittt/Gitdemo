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
import com.a3hp.automationpracticee.framework.pageobject.homepage.Homepage;
import com.a3hp.automationpracticee.framework.pageobject.information.AboutUsPage;
import com.a3hp.automationpracticee.framework.pageobject.information.ContactUsPage;
import com.a3hp.automationpracticee.framework.pageobject.information.StoresPage;
import com.a3hp.automationpracticee.framework.pageobject.search.SearchResultPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;



public class ContactUsTest extends TestBasee {

	ContactUsPage contactUsPageObj;
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
    		contactUsPageObj = homeObj.navigateToContactUsPage();
			System.out.println("*******ContactUsPage is in display*******");
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
	
	
	//"********Validation of ContactUsPageHeading********");
  	@Test (priority = 1)
  	public  void validateContactUsPageHeading() throws Exception{
  		System.out.println("In validateContactUsPageHeading Method");  		
		elementName = "ContactUs_PageHeading_txt";
		Comment = "validateContactUsPageHeading";
	//	String actual_pageHeading = gm_getActualText(contactUsPageObj.PageHeading_ContactUsPage_Txt, elementName, logger, Comment);
	//	System.out.println("actual_pageHeading = "+actual_pageHeading);
		String expected_pageHeading = "CUSTOMER SERVICE - CONTACT US";
	//	resultStatus = gm_assertionAndResultReporting(actual_pageHeading, expected_pageHeading, elementName, logger);
		System.out.println("resultStatus = "+ resultStatus);
		System.out.println("Out  of validateContactUsPageHeading method");
  	}	
  	
	//"********Validation of ContactUsPageBreadcrumb********");
  	@Test (priority = 2)
  	public  void validateContactUsPageBreadcrumbText() throws Exception{
  		System.out.println("In validateContactUsPageBreadcrumbText Method");
		elementName = "ContactUs_Breadcrumb_txt";
		Comment = "validateContactUsPageBreadcrumbText";
	//	String actual_breadcrumb = gm_getActualText(contactUsPageObj.breadCrumb_ContactUsPage_Txt, elementName, logger, Comment);
		String expected_breadcrumb = "Contact";
	//	resultStatus = gm_assertionAndResultReporting(actual_breadcrumb, expected_breadcrumb, elementName, logger);
		System.out.println("Out  of validateContactUsPageBreadcrumbText method");
  	}	
  	
 
  		/////////////////////////Validate ContactUs Process With Valid values
	@Test (priority = 3)
	public void validateContactUsProcess() throws Exception {
		System.out.println("In validateContactUsProcess Method");	
		ContactUsPage contactUsPageObjs=contactUsPageObj.validateContactUsProcess("1");
		String elementName = "Contact Us Confirmation Message";
		Comment = "Validate ContactUs Submit Process";
	//	String actual_ConfirmationMessage = gm_getActualText(contactUsPageObj.ContactUsConfirmationMessage_txt, elementName, logger, Comment);
		String expected_ConfirmationMessage = "Your message has been successfully sent to our team.";
	//	resultStatus = gm_assertionAndResultReporting(actual_ConfirmationMessage, expected_ConfirmationMessage, elementName, logger);
		System.out.println("Out ofIn validateContactUsProcess Method");
 
   
}
		/////////////////////////Validate ContactUs Process With Valid values
	@Test (priority = 4)
	public void validateHomeButton_ContactUsConfirmationPage() throws Exception {
		System.out.println("In validateHomeButton_ContactUsConfirmationPage Method");				
		ContactUsPage contactUsPageObjs=contactUsPageObj.validateContactUsProcess("1");
		String elementName = "HomeButton_ContactUsConfirmationPage";
		Comment = "Validate HomeButton_ContactUsConfirmationPage";
	//	String actualURL = gm_getActualURL(contactUsPageObj.HomeBtn_Btn, elementName, logger, Comment);
		String expectedURL = "http://automationpractice.com/index.php";
	//	resultStatus = gm_assertionAndResultReporting(actualURL, expectedURL, elementName, logger);
		System.out.println("Out of validateHomeButton_ContactUsConfirmationPage Method");
		
	
	}	
	
	
	
	
	
	
	
	
}
