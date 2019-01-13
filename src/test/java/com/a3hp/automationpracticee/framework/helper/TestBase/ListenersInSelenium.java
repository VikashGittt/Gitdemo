package com.a3hp.automationpracticee.framework.helper.TestBase;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlClass;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class ListenersInSelenium extends TestBasee implements ITestListener{
	
	String resultStatus = null;	
	
	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log(ITestResult.class.getSimpleName()+" Test Started");
		System.out.println(result.getName()+" Get Started");		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+" onTestSuccess");
		//System.out.println("result.getStatus() = "+result.is);
			if(result.isSuccess()){
			   	System.out.println("In onTestSuccess Listeners");							 
				resultStatus = "PASSED"; 
				System.out.println(elementName+"--"+resultStatus);	
				extentTestLogger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+ " TestCase Passed", ExtentColor.GREEN));
				try {
						//CoderComment1: Generate excel report
						gm_generateReportWithScreenshots(actualResult, expectedResult, elementName, resultStatus);					
						
						//CoderComment2: Generate extent report
						System.out.println("//CoderComment2: Generate extent report");
						String screenshot_Path = gm_setScreenshotPath_forExtentReporting(elementName, resultStatus);					
						gm_TakeSnapshot(screenshot_Path);				
						System.out.println("screenshot_Path: "+screenshot_Path);	
						extentTestLogger.info("details: "+ extentTestLogger.addScreenCaptureFromPath(screenshot_Path)); 
						//extentTestLogger.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_Path).build()); 
				} catch (InvalidFormatException | IOException | InterruptedException e) {				
					e.printStackTrace();
				}
				/*Below is extent2 version
					String image = extentTestLogger.addScreenCapture(screenshot_Path);
					extentTestLogger.log(LogStatus.PASS, Comment, image);
				*/
			}
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName()+" onTestFailure");
		if(!result.isSuccess()){			
	    	resultStatus = "FAILED"; 
	    	System.out.println(elementName+"--"+resultStatus);
	    	extentTestLogger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ " TestCase failed due tobelow issue", ExtentColor.RED));
			extentTestLogger.fail(result.getThrowable());
			
			//CoderComment1: Generate excel report
	    	try {
				gm_generateReportWithScreenshots(actualResult, expectedResult.toString(), elementName, resultStatus);			
	    	
	    	//CoderComment2: Generate extent report
				String screenshot_Path = gm_setScreenshotPath_forExtentReporting(elementName, resultStatus);
				gm_TakeSnapshot(screenshot_Path);			
				System.out.println("screenshot_Path: "+screenshot_Path);	
				extentTestLogger.info("details: "+ extentTestLogger.addScreenCaptureFromPath(screenshot_Path));
			//	extentTestLogger.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_Path).build());
			} catch (InvalidFormatException | IOException | InterruptedException e) {
				e.printStackTrace();
			}
			/*Below is extent2 version
				String image = extentTestLogger.addScreenCapture(screenshot_Path);
				logger.log(LogStatus.FAIL, Comment, image);
			 */
			
		
		}
		//https://stackoverflow.com/questions/9618774/jenkins-selenium-gui-tests-are-not-visible-on-windows
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName()+" onTestSkipped");
		System.out.println("result.getStatus() = "+result.getStatus());
		if(result.getStatus() ==ITestResult.SKIP){
			Assert.assertTrue(false);

		}
			//System.out.println("TestBasee.classPackNameSKIPPED: "+TestBasee.classPackName);
			//System.out.println("In onTestSkipped Listeners");
			//System.out.println("result.getClass(): "+result.getClass());
	    	//resultStatus = "SKIPPED"; 
	    	//System.out.println(elementName+"--"+resultStatus);
		//	extentTestLogger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+ " TestCase Skippedd", ExtentColor.YELLOW));
			//extentTestLogger.skip(result.getThrowable());
	    	
	    	
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(result.getName()+" onTestFailedButWithinSuccessPercentage");		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(context.getName()+" onStart");		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(context.getName()+" onFinish");		
	}

}
