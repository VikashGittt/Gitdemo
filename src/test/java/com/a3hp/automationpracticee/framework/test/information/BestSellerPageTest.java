package com.a3hp.automationpracticee.framework.test.information;

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
import com.a3hp.automationpracticee.framework.pageobject.homepage.Homepage;
import com.a3hp.automationpracticee.framework.pageobject.information.BestSellersPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class BestSellerPageTest extends TestBasee{

	BestSellersPage bestSellerPageObj;
	String actualResult;
	String expectedResult;
	String elementName;
	String screenshot_Path;
	String image;
	String Comment;
	
 
	
	
	@BeforeMethod
	@Parameters({ "Browser", "URL" })
    public void setup(String Browser, String URL) throws IOException{
    		bestSellerPageObj = homeObj.navigateToBestSellersPage();
			System.out.println("*******BestSellers Page is in display*******");
 	
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
   
	//"********Validation of NewProductPageHeading********");
  	@Test (priority = 1)
  	public  void validateBestSellersPageHeading_txt() throws Exception{
  		System.out.println("In validateBestSellersPageHeading_txt Method");

		elementName = "BestSellers_PageHeading_txt";
		Comment = "Validate BestSellers PageHeading";
	//	String actual_pageHeading = gm_getActualText(bestSellerPageObj.PageTitle_BestSellersPage_txt, elementName, logger, Comment);
	//	System.out.println("actual_pageHeading = "+actual_pageHeading);
		String expected_pageHeading = "BEST SELLERS";
	//	resultStatus = gm_assertionAndResultReporting(actual_pageHeading, expected_pageHeading, elementName, logger);
		System.out.println("Out  of validateBestSellersPageHeading_txt method");
   
  	}		 
   
  	@Test (priority = 2)
  	public  void validateBestSellersBreadcrumb_txt() throws Exception{
  		System.out.println("In validateBestSellersBreadcrumb_txt Method");

		elementName = "BestSellers_Breadcrumb_txt";
		Comment = "validate BestSellersPage Breadcrumb Text";
	//	String actual_breadcrumb = gm_getActualText(bestSellerPageObj.Breadcrumb_BestSellersPage_txt, elementName, logger, Comment);
		String expected_breadcrumb = "Best sellers";
	//	resultStatus = gm_assertionAndResultReporting(actual_breadcrumb, expected_breadcrumb, elementName, logger);
		System.out.println("Out  of validateBestSellersBreadcrumb_txt method");
   
  	}	
   
  //"********Validation of productBlockImageLinks********");
  	@Test (priority = 3)
   	public  void validateproductBlockImageLinks_PD() throws Exception{
   		System.out.println("In validateproductBlockImageLinks_PD Method");

 		List <WebElement> productBlockImageLinkCollection = bestSellerPageObj.productBlocksImageLinkCollection_imglnk;
 		   	System.out.println("Total productBlockImageLink = "+productBlockImageLinkCollection.size());
 		   	ArrayList<String> actualURLList = new ArrayList<String>();
 		   	ArrayList<String> expectedURLList = new ArrayList<String>();
 		   	for(int i=0; i<productBlockImageLinkCollection.size(); i++){
 		   		System.out.println("1");
 		   		productBlockImageLinkCollection =  bestSellerPageObj.productBlocksImageLinkCollection_imglnk;
 		   		WebElement productBlockImageLinkEle = productBlockImageLinkCollection.get(i);
 		     	System.out.println("2");
 		   		String elementName = productBlockImageLinkEle.getText();
 		   		Comment = "ProductImageLinks validation --> BestSellersPage";
 		//   		String actualURL = gm_getActualURL(productBlockImageLinkEle, elementName, logger, Comment);
 		//   		System.out.println(actualURL);
 		//   		actualURLList.add(actualURL);
 		   		driverObj.navigate().back();
 	   	}
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=7&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=1&controller=product");
 			expectedURLList.add("http://automationpractice.com/index.php?id_product=2&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=5&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=3&controller=product");
 			expectedURLList.add("http://automationpractice.com/index.php?id_product=6&controller=product");
 			expectedURLList.add("http://automationpractice.com/index.php?id_product=4&controller=product");
 			
		   	elementName = "BestSellers-productBlockImageLinks_link";
 	//	   	resultStatus = gm_assertionAndResultReporting(actualURLList.toString(), expectedURLList.toString(), elementName, logger);
 		   	System.out.println("Out of validateproductBlockImageLinks_PD Method");
 	}
  //"********Validation of productBlockNameLinks********");
  	@Test (priority = 4)
   	public  void validateproductBlockNameLinks_PD() throws Exception{
   		System.out.println("In validateproductBlockNameLinks_PD Method");

 		List <WebElement> productBlockNameLinkCollection = bestSellerPageObj.productBlock_NameLinkCollection_lnk;
 		   	System.out.println("Total ProductBlockNameLinks = "+productBlockNameLinkCollection.size());
 		   	ArrayList<String> actualURLList = new ArrayList<String>();
 		   	ArrayList<String> expectedURLList = new ArrayList<String>();
 		   	for(int i=0; i<productBlockNameLinkCollection.size(); i++){
 		   		System.out.println("1");
 		   		productBlockNameLinkCollection =  bestSellerPageObj.productBlock_NameLinkCollection_lnk;
 		   		WebElement productBlockNameLinkEle = productBlockNameLinkCollection.get(i);
 		     	System.out.println("2");
 		   		String elementName = productBlockNameLinkEle.getText();
 		   		Comment = "ProductNameLinks validation BestSellersPage";
 		//   		String actualURL = gm_getActualURL(productBlockNameLinkEle, elementName, logger, Comment);
 		//   		System.out.println(actualURL);
 		//   		actualURLList.add(actualURL);
 		   		driverObj.navigate().back();
 	   	}
 			expectedURLList.add("http://automationpractice.com/index.php?id_product=7&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=1&controller=product");
 			expectedURLList.add("http://automationpractice.com/index.php?id_product=2&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=5&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=3&controller=product");
 			expectedURLList.add("http://automationpractice.com/index.php?id_product=6&controller=product");
 			expectedURLList.add("http://automationpractice.com/index.php?id_product=4&controller=product");
 			
		   	
 		   	elementName = "BestSellersPage-productBlockNameLinks_link";
 	//	   	resultStatus = gm_assertionAndResultReporting(actualURLList.toString(), expectedURLList.toString(), elementName, logger);
 		   	System.out.println("Out of validateproductBlockNameLinks_PD Method");
 	}
  	
	//"********Validation of productBlockMoreButton*******");//
	@Test (priority = 5)
	public  void validateproductBlock_MoreButton_PD() throws Exception{
		System.out.println("In validateproductBlock_MoreButton_PD Method");

		List <WebElement> productBlockMoreButtonCollection = bestSellerPageObj.ProductBlock_MoreButtonCollection_btn;
		   	System.out.println("Total ProductBlockNameLinks = "+ productBlockMoreButtonCollection.size());
		   	ArrayList<String> actualURLList = new ArrayList<String>();
		   	ArrayList<String> expectedURLList = new ArrayList<String>();
		   	for(int i=0; i<productBlockMoreButtonCollection.size(); i++){
		   		System.out.println("1");
		   		productBlockMoreButtonCollection =  homeObj.ProductBlockMoreButtonCollection_btn;
		   		WebElement productBlockMoreButtonEle = productBlockMoreButtonCollection.get(i);
		     	System.out.println("2");
		   		String elementName = productBlockMoreButtonEle.getText();
		   		Comment = "ProductNameLinks validation BestSellers";
		//   		String actualURL = gm_getActualURL(productBlockMoreButtonEle, elementName, logger, Comment);
		//   		System.out.println(actualURL);
	//	   		actualURLList.add(actualURL);
		   		driverObj.navigate().back();
	   	}
		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=7&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=1&controller=product");
 			expectedURLList.add("http://automationpractice.com/index.php?id_product=2&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=5&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=3&controller=product");
 			expectedURLList.add("http://automationpractice.com/index.php?id_product=6&controller=product");
 			expectedURLList.add("http://automationpractice.com/index.php?id_product=4&controller=product");
 			elementName = "BestSellers-productBlockMoreButton_Btn";
	//	   	resultStatus = gm_assertionAndResultReporting(actualURLList.toString(), expectedURLList.toString(), elementName, logger);
		   	System.out.println("Out of validateproductBlock_MoreButton_PD Method");
	}
	
}
