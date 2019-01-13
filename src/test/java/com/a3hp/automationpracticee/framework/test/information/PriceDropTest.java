package com.a3hp.automationpracticee.framework.test.information;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.a3hp.automationpracticee.framework.pageobject.homepage.Homepage;
import com.a3hp.automationpracticee.framework.pageobject.information.PriceDropPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;





public class PriceDropTest extends TestBasee{
	
 
	PriceDropPage priceDropPageObj;
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
       		priceDropPageObj = homeObj.navigateTopriceDropPage();
			System.out.println("*******PriceDrop Page is in display*******"); 	
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
  	public  void validatePriceDropPageHeading_txt() throws Exception{
  		System.out.println("In validatePriceDropPageHeading_txt Method");
  		
		elementName = "PriceDrop_PageHeading_txt";
		Comment = "Validate PriceDrop PageHeading";
	//	String actual_pageHeading = gm_getActualText(priceDropPageObj.PageTitle_PriceDropPage_txt, elementName, logger, Comment);
	//	System.out.println("actual_pageHeading = "+actual_pageHeading);
		String expected_pageHeading = "PRICE DROP";
	//	resultStatus = gm_assertionAndResultReporting(actual_pageHeading, expected_pageHeading, elementName, logger);
		System.out.println("resultStatus = "+ resultStatus);
		System.out.println("Out  of validatePriceDropPageHeading_txt method");
   
  	}		 
   
  	@Test (priority = 2)
  	public  void validatePriceDropBreadcrumb_txt() throws Exception{
  		System.out.println("In validatePriceDropBreadcrumb_txt Method");
  		
		elementName = "PriceDrop_Breadcrumb_txt";
		Comment = "validate PriceDropPage Breadcrumb Text";
	//	String actual_breadcrumb = gm_getActualText(priceDropPageObj.Breadcrumb_PriceDropPage_txt, elementName, logger, Comment);
		String expected_breadcrumb = "Price drop";
	//	resultStatus = gm_assertionAndResultReporting(actual_breadcrumb, expected_breadcrumb, elementName, logger);
		System.out.println("Out  of validatePriceDropBreadcrumb_txt method");
   
  	}	
   
  //"********Validation of productBlockImageLinks********");
  	@Test (priority = 3)
   	public  void validateproductBlockImageLinks_PD() throws Exception{
   		System.out.println("In validateproductBlockImageLinks_PD Method");
   		
 		List <WebElement> productBlockImageLinkCollection = priceDropPageObj.productBlocksImageLinkCollection_imglnk;
 		   	System.out.println("Total productBlockImageLink = "+productBlockImageLinkCollection.size());
 		   	ArrayList<String> actualURLList = new ArrayList<String>();
 		   	ArrayList<String> expectedURLList = new ArrayList<String>();
 		   	for(int i=0; i<productBlockImageLinkCollection.size(); i++){
 		   		System.out.println("1");
 		   		productBlockImageLinkCollection =  priceDropPageObj.productBlocksImageLinkCollection_imglnk;
 		   		WebElement productBlockImageLinkEle = productBlockImageLinkCollection.get(i);
 		     	System.out.println("2");
 		   		String elementName = productBlockImageLinkEle.getText();
 		   		Comment = "ProductImageLinks validation --> PriceDropPage";
 		//   		String actualURL = gm_getActualURL(productBlockImageLinkEle, elementName, logger, Comment);
 		//   		System.out.println(actualURL);
 		//   		actualURLList.add(actualURL);
 		   		driverObj.navigate().back();
 	   	}
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=7&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=5&controller=product");
		   	elementName = "PriceDrop-productBlockImageLinks_link";
 		//   	resultStatus = gm_assertionAndResultReporting(actualURLList.toString(), expectedURLList.toString(), elementName, logger);
 		   	System.out.println("Out of validateproductBlockImageLinks_PD Method");
 	}
  //"********Validation of productBlockNameLinks********");
  	@Test (priority = 4)
   	public  void validateproductBlockNameLinks_PD() throws Exception{
   		System.out.println("In validateproductBlockNameLinks_PD Method");
   		
 		List <WebElement> productBlockNameLinkCollection = priceDropPageObj.productBlock_NameLinkCollection_lnk;
 		   	System.out.println("Total ProductBlockNameLinks = "+productBlockNameLinkCollection.size());
 		   	ArrayList<String> actualURLList = new ArrayList<String>();
 		   	ArrayList<String> expectedURLList = new ArrayList<String>();
 		   	for(int i=0; i<productBlockNameLinkCollection.size(); i++){
 		   		System.out.println("1");
 		   		productBlockNameLinkCollection =  priceDropPageObj.productBlock_NameLinkCollection_lnk;
 		   		WebElement productBlockNameLinkEle = productBlockNameLinkCollection.get(i);
 		     	System.out.println("2");
 		   		String elementName = productBlockNameLinkEle.getText();
 		   		Comment = "ProductNameLinks validation PriceDropPage";
 		//   		String actualURL = gm_getActualURL(productBlockNameLinkEle, elementName, logger, Comment);
 		//   		System.out.println(actualURL);
 		//   		actualURLList.add(actualURL);
 		   		driverObj.navigate().back();
 	   	}
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=7&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=5&controller=product");
 		   	
 		   	elementName = "PriceDropPage-productBlockNameLinks_link";
 	//	   	resultStatus = gm_assertionAndResultReporting(actualURLList.toString(), expectedURLList.toString(), elementName, logger);
 		   	System.out.println("Out of validateproductBlockNameLinks_PD Method");
 	}
  	
	//"********Validation of productBlockMoreButton*******");//
	@Test (priority = 5)
	public  void validateproductBlock_MoreButton_PD() throws Exception{
		System.out.println("In validateproductBlock_MoreButton_PD Method");
		
		List <WebElement> productBlockMoreButtonCollection = priceDropPageObj.ProductBlock_MoreButtonCollection_btn;
		   	System.out.println("Total ProductBlockNameLinks = "+ productBlockMoreButtonCollection.size());
		   	ArrayList<String> actualURLList = new ArrayList<String>();
		   	ArrayList<String> expectedURLList = new ArrayList<String>();
		   	for(int i=0; i<productBlockMoreButtonCollection.size(); i++){
		   		System.out.println("1");
		   		productBlockMoreButtonCollection =  homeObj.ProductBlockMoreButtonCollection_btn;
		   		WebElement productBlockMoreButtonEle = productBlockMoreButtonCollection.get(i);
		     	System.out.println("2");
		   		String elementName = productBlockMoreButtonEle.getText();
		   		Comment = "ProductNameLinks validation PriceDrop";
		 //  		String actualURL = gm_getActualURL(productBlockMoreButtonEle, elementName, logger, Comment);
		 //  		System.out.println(actualURL);
		 //  		actualURLList.add(actualURL);
		   		driverObj.navigate().back();
	   	}
		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=7&controller=product");
		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=5&controller=product");
		  	elementName = "PriceDrop-productBlockMoreButton_Btn";
	//	   	resultStatus = gm_assertionAndResultReporting(actualURLList.toString(), expectedURLList.toString(), elementName, logger);
		   	System.out.println("Out of validateproductBlock_MoreButton_PD Method");
	}
	
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   //"********Validation of LetNavTitle Link********");
 	
	
	 //"********Validation of ManufactureBlkTitleLnk__ManufacturesBlock********");
	
	
	public  void validateManufactureBlkTitleLnk() throws Exception{
		
		String actualURL = new PriceDropPage().getActualURL(PriceDropPage.ManufactureBlkTitle_Lnk);
		String elementName = "ManufactureBlkTitleLnk__ManufacturesBlock";
		String expectedURL = "http://automationpractice.com/index.php?controller=manufacturer";
		try {
			Assert.assertEquals(actualURL, expectedURL);
		}	catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
		} finally{
			System.out.println("in final method");
			System.out.println(actualURL);
		//	gm_generateReportWithScreenshots_mvn(actualURL, expectedURL, elementName);
		}
		System.out.println("Out  of ManufactureBlkTitleLnk__ManufacturesBlock method");
	}	
	
	 //"********Validation of FashionManufacturer_Lnk__ManufacturesBlock********");
	public  void validateFashionManufacturerLnk() throws Exception{
		
		String actualURL = new PriceDropPage().getActualURL(PriceDropPage.FashionManufacturer_Lnk);
		String elementName = "FashionManufacturerLnk__ManufacturesBlock";
		String expectedURL = "http://automationpractice.com/index.php?id_manufacturer=1&controller=manufacturer";
		try {
			Assert.assertEquals(actualURL, expectedURL);
		}	catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
		} finally{
			System.out.println("in final method");
			System.out.println(actualURL);
			//gm_generateReportWithScreenshots_mvn(actualURL, expectedURL, elementName);
		}
		System.out.println("Out  of FashionManufacturer_Lnk__ManufacturesBlock method");
	}	
   
	 //"********Validation of SpecialBlkTitleLnk__SpecialsBlock********");
	

	public  void validatepecialBlkTitleLnk() throws Exception{
		
		String actualURL = new PriceDropPage().getActualURL(PriceDropPage.SpecialBlkTitle_Lnk);
		String elementName = "SpecialBlkTitleLnk__SpecialsBlock";
		String expectedURL = "http://automationpractice.com/index.php?controller=prices-drop";
		try {
			Assert.assertEquals(actualURL, expectedURL);
		}	catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
		} finally{
			System.out.println("in final method");
			System.out.println(actualURL);
		///	gm_generateReportWithScreenshots_mvn(actualURL, expectedURL, elementName);
		}
		System.out.println("Out  of SpecialBlkTitleLnk__SpecialsBlock method");
	}	
	
	 //"********Validation of AllspecialsBtn__SpecialsBlock********");
	

	public  void validateAllspecialsBtn() throws Exception{
		
		String actualURL = new PriceDropPage().getActualURL(PriceDropPage.Allspecials_Btn);
		String elementName = "AllspecialsBtn__SpecialsBlock";
		String expectedURL = "http://automationpractice.com/index.php?controller=prices-drop";
		try {
			Assert.assertEquals(actualURL, expectedURL);
		}	catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
		} finally{
			System.out.println("in final method");
			System.out.println(actualURL);
			//gm_generateReportWithScreenshots_mvn(actualURL, expectedURL, elementName);
		}
		System.out.println("Out  of AllspecialsBtn__SpecialsBlock method");
	}	
	
	 //"********Validation of OurStoresBlkTitleLnk__OurStoresBlock********");
	

	public  void validateOurStoresBlkTitleLnk() throws Exception{
		
		String actualURL = new PriceDropPage().getActualURL(PriceDropPage.OurStoresBlkTitle_Lnk);
		String elementName = "OurStoresBlkTitleLnk__OurStoresBlock";
		String expectedURL = "http://automationpractice.com/index.php?controller=stores";
		try {
			Assert.assertEquals(actualURL, expectedURL);
		}	catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
		} finally{
			System.out.println("in final method");
			System.out.println(actualURL);
			//gm_generateReportWithScreenshots_mvn(actualURL, expectedURL, elementName);
		}
		System.out.println("Out  of OurStoresBlkTitleLnk__OurStoresBlock method");
	}	
	
	
	 //"********Validation of DiscoverOurStoresBtn__SpecialsBlock********");
	

	public  void validateDiscoverOurStoresBtn() throws Exception{
		
		String actualURL = new PriceDropPage().getActualURL(PriceDropPage.DiscoverOurStores_Btn);
		String elementName = "DiscoverOurStoresBtn__SpecialsBlock";
		String expectedURL = "http://automationpractice.com/index.php?controller=stores";
		try {
			Assert.assertEquals(actualURL, expectedURL);
		}	catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
		} finally{
			System.out.println("in final method");
			System.out.println(actualURL);
			//gm_generateReportWithScreenshots_mvn(actualURL, expectedURL, elementName);
		}
		System.out.println("Out  of DiscoverOurStoresBtn__SpecialsBlock method");
	}	
	
	 //"********Validation of SuppliersBlkTitleLnk__SupplierBlock********");
	

	public  void validateSuppliersBlkTitleLnk() throws Exception{
		
		String actualURL = new PriceDropPage().getActualURL(PriceDropPage.SuppliersBlkTitle_Lnk);
		String elementName = "SuppliersBlkTitleLnk__SupplierBlock";
		String expectedURL = "http://automationpractice.com/index.php?controller=supplier";
		try {
			Assert.assertEquals(actualURL, expectedURL);
		}	catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
		} finally{
			System.out.println("in final method");
			System.out.println(actualURL);
		//	gm_generateReportWithScreenshots_mvn(actualURL, expectedURL, elementName);
		}
		System.out.println("Out  of SuppliersBlkTitleLnk__SupplierBlock method");
	}	
	
	 //"********Validation of FashionSupplierLnk__SupplierBlock********");
	

	public  void validateFashionSupplierLnk__SpecialsBlock() throws Exception{
		
		String actualURL = new PriceDropPage().getActualURL(PriceDropPage.FashionSupplier_Lnk);
		String elementName = "FashionSupplierLnk__SupplierBlock";
		String expectedURL = "http://automationpractice.com/index.php?id_supplier=1&controller=supplier";
		try {
			Assert.assertEquals(actualURL, expectedURL);
		}	catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
		} finally{
			System.out.println("in final method");
			System.out.println(actualURL);
			//gm_generateReportWithScreenshots_mvn(actualURL, expectedURL, elementName);
		}
		System.out.println("Out  of FashionSupplierLnk__SupplierBlock method");
	}	
	
	 //"********Validation of AllspecialsBtn__SpecialsBlock********");
	


	public  void validateAllspecialsBtn__SpecialsBlock() throws Exception{
		
		String actualURL = new PriceDropPage().getActualURL(PriceDropPage.Allspecials_Btn);
		String elementName = "AllspecialsBtn__SpecialsBlock";
		String expectedURL = "http://automationpractice.com/index.php?controller=prices-drop";
		try {
			Assert.assertEquals(actualURL, expectedURL);
		}	catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
		} finally{
			System.out.println("in final method");
			System.out.println(actualURL);
			//gm_generateReportWithScreenshots_mvn(actualURL, expectedURL, elementName);
		}
		System.out.println("Out  of AllspecialsBtn__SpecialsBlock method");
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
