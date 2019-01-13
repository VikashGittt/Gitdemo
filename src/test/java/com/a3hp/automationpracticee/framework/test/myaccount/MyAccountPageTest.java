package com.a3hp.automationpracticee.framework.test.myaccount;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
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
import com.a3hp.automationpracticee.framework.pageobject.information.ContactUsPage;
import com.a3hp.automationpracticee.framework.pageobject.myaccount.MyAccountPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class MyAccountPageTest extends TestBasee{
	
	 
	SignInPage lognObj; 
	MyAccountPage myAccountPageObj;
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
		
	@Test (priority = 1)
	public  void validateMyAccountPage_PageHeading() throws Exception{
		System.out.println("In validateMyAccountPage_PageHeading Method");
		
		elementName = "MyAccountPage_PageHeading_txt";
		Comment = "validatePageHeading_MyAccountPage";
//		String actual_pageHeading = gm_getActualText(myAccountPageObj.MyAccount_PageHeading_Txt, elementName, logger, Comment);
//		System.out.println("actual_pageHeading = "+actual_pageHeading);
		String expected_pageHeading = "MY ACCOUNT";
	//	resultStatus = gm_assertionAndResultReporting(actual_pageHeading, expected_pageHeading, elementName, logger);
		
		System.out.println("Out  of validateMyAccountPage_PageHeading method");
	}	
	   
	@Test (priority = 2)
	public  void validateMyAccountPageBreadcrumbText() throws Exception{
  		System.out.println("In validateMyAccountPageBreadcrumbText Method");
  		
		elementName = "MyAcountPage_Breadcrumb_txt";
		Comment = "validateMyAcountPageBreadcrumbText";
	//	String actual_breadcrumb = gm_getActualText(myAccountPageObj.MyAccount_Breadcrumb_txt, elementName, logger, Comment);
		String expected_breadcrumb = "My account";
//		resultStatus = gm_assertionAndResultReporting(actual_breadcrumb, expected_breadcrumb, elementName, logger);
		System.out.println("Out  of validateMyAscountPageBreadcrumbText method");
  	}	
  	
	@Test (priority = 3)
   	public  void validateMyAccount_ModuleLinks() throws Exception{
   		System.out.println("In validateMyAccount_ModuleLinks Method");
   		
 		List <WebElement> moduleLinkCollection = myAccountPageObj.MyAccount_ModuleLinksCollection_lnk;
 		   	System.out.println("Total module Links = "+moduleLinkCollection.size());
 		   	ArrayList<String> actualURLList = new ArrayList<String>();
 		   	ArrayList<String> expectedURLList = new ArrayList<String>();
 		   	for(int i=0; i<moduleLinkCollection.size(); i++){
 		   		System.out.println("1");
 		   		moduleLinkCollection =  myAccountPageObj.MyAccount_ModuleLinksCollection_lnk;
 		   		WebElement moduleLinkEle = moduleLinkCollection.get(i);
 		     	System.out.println("2");
 		   		String elementName = moduleLinkEle.getText();
 		   		Comment = "ModuleLink Validation -- MyAccount page";
 	//	   		String actualURL = gm_getActualURL(moduleLinkEle, elementName, logger, Comment);
 	//	   		System.out.println(actualURL);
 	//	   		actualURLList.add(actualURL);
 		   		driverObj.navigate().back();
 	   	}
 		   	expectedURLList.add("http://automationpractice.com/index.php?controller=history");
 		   	expectedURLList.add("http://automationpractice.com/index.php?controller=order-slip");
		   	expectedURLList.add("http://automationpractice.com/index.php?controller=addresses");
 		   	expectedURLList.add("http://automationpractice.com/index.php?controller=identity");
 		   	expectedURLList.add("http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist");
 		   
 		   	elementName = "MyAccount_ModuleLinks_link";
 //		   	resultStatus = gm_assertionAndResultReporting(actualURLList.toString(), expectedURLList.toString(), elementName, logger);
 		   	System.out.println("Out of validateMyAccount_ModuleLinks Method");
 	}
	
	@Test (priority = 4)
	public void validateHomeButton_MyAccountPage() throws Exception {
		System.out.println("In validateHomeButton_MyAccountPage Method");
			
		elementName = "HomeButton_MyAccountPage";
		Comment = "Validate HomeButton_MyAccountPage";
	//	String actualURL = gm_getActualURL(myAccountPageObj.MyAccount_HomeButton_Btn, elementName, logger, Comment);
		String expectedURL = "http://automationpractice.com/index.php";
	//	resultStatus = gm_assertionAndResultReporting(actualURL, expectedURL, elementName, logger);
		System.out.println("Out of validateHomeButton_MyAccountPage Method");
		
	
	}	
	
	
	
	
	
	
	
	
	
	
	
}
