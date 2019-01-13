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
import com.a3hp.automationpracticee.framework.pageobject.information.SitemapPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


 



public class SiteMapTest extends TestBasee{

 
	SitemapPage sitemapPageObj;
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
       		sitemapPageObj = homeObj.navigateToSitemapPage();
			System.out.println("*******SiteMap Page is in display*******");
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
   //"********Validation of SitemapPageHeading********");
  	@Test (priority = 1)
  	public  void validateSitemapPageHeading() throws Exception{
  		System.out.println("In validateSitemapPageHeading Method");
  		try{
  			
  			elementName = "SitemapPageHeading_txt";
	  		Comment = "validate Sitemap Page Heading";
	 // 		String actual_pageHeading = gm_getActualText(sitemapPageObj.SitemapPageTitle_Txt, elementName, logger, Comment);
	  //		System.out.println("actual_pageHeading = "+actual_pageHeading);
	  		String expected_pageHeading = "SITEMAP";
	 // 		resultStatus = gm_assertionAndResultReporting(actual_pageHeading, expected_pageHeading, elementName, logger);
	  		System.out.println("resultStatus = "+ resultStatus);
	  		
  		}catch(Exception e){
  			System.out.println(e.getMessage());
  			e.printStackTrace();
  		}finally{
  			System.out.println("Out  of validateSitemapPageHeading method");
  		}
  	}	
  	  	
  		//"********Validation of AboutUsPageHeading********");
  	@Test (priority = 2)
  	public  void validateSitemapPageBreadcrumbtText() throws Exception{
  		try{
  			
	  		System.out.println("In validateSitemapPageBreadcrumbtText Method");
	  		elementName = "Sitemap_Breadcrumb_txt";
	  		Comment = "validate Sitemap Breadcrumb Text";
	 // 		String actual_breadcrumb = gm_getActualText(sitemapPageObj.BreadCrumb_SitemapPage_txt, elementName, logger, Comment);
	  		String expected_breadcrumb = "Sitemap";
	 // 		resultStatus = gm_assertionAndResultReporting(actual_breadcrumb, expected_breadcrumb, elementName, logger);
	  		System.out.println("Out  of validateSitemapPageBreadcrumbtText method");
 		
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			System.out.println("Out  of validateSitemapPageHeading method");
		}
	}	
  		//"********Validation of validateOurOffersLinks********");
  	@Test (priority = 3)
  	public  void validateOurOffersLinks() throws Exception{
  		System.out.println("In validateOurOffersLinks Method");
  		
		List <WebElement> ourOffersLinkCollection = sitemapPageObj.OurOffersLinks_SitemapPage_lnk;
		   	System.out.println("Total ourOffersLinks = "+ourOffersLinkCollection.size());
		   	ArrayList<String> actualURLList = new ArrayList<String>();
		   	ArrayList<String> expectedURLList = new ArrayList<String>();
		   	for(int i=0; i<ourOffersLinkCollection.size(); i++){
		   		System.out.println("1");
		   		ourOffersLinkCollection =  sitemapPageObj.OurOffersLinks_SitemapPage_lnk;
		   		WebElement ourOffersLinkEle = ourOffersLinkCollection.get(i);
		     	System.out.println("2");
		   		String elementName = ourOffersLinkEle.getText();
		   		Comment = "Links validation -->> OurOffers section -- Sitemap page";
		//   		String actualURL = gm_getActualURL(ourOffersLinkEle, elementName, logger, Comment);
		//   		System.out.println(actualURL);
		//   		actualURLList.add(actualURL);
		   		driverObj.navigate().back();
		   		
	   	}
		   	expectedURLList.add("http://automationpractice.com/index.php?controller=new-products");
		   	expectedURLList.add("http://automationpractice.com/index.php?controller=best-sales");
		   	expectedURLList.add("http://automationpractice.com/index.php?controller=prices-drop");
		   	expectedURLList.add("http://automationpractice.com/index.php?controller=manufacturer");
		   	expectedURLList.add("http://automationpractice.com/index.php?controller=supplier");

		   	elementName = "Sitemap-OurOfferssectionLinks_link";
		//   	resultStatus = gm_assertionAndResultReporting(actualURLList.toString(), expectedURLList.toString(), elementName, logger);
		   	System.out.println("Out of validateOurOffersLinks Method");
	}
   
	//"********Validation of validateYourAccountLinks********");
  	@Test (priority = 4)
  	public  void validateYourAccountLinks() throws Exception{
  		System.out.println("In validateYourAccountLinks Method");
  		
		List <WebElement> yourAccountLinksCollection = sitemapPageObj.YourAccountLinks_SitemapPage_lnk;
		   	System.out.println("Total yourAccountLinks = "+yourAccountLinksCollection.size());
		   	ArrayList<String> actualURLList = new ArrayList<String>();
		   	ArrayList<String> expectedURLList = new ArrayList<String>();
		   	for(int i=0; i<yourAccountLinksCollection.size(); i++){
		   		System.out.println("1");
		   		yourAccountLinksCollection =  sitemapPageObj.YourAccountLinks_SitemapPage_lnk;
		   		WebElement yourAccountLinksEle = yourAccountLinksCollection.get(i);
		     	System.out.println("2");
		   		String elementName = yourAccountLinksEle.getText();
		   		Comment = "Links validation -->> Your Account section -- Sitemap page";
		 //  		String actualURL = gm_getActualURL(yourAccountLinksEle, elementName, logger, Comment);
		 ////  		System.out.println(actualURL);
		  // 		actualURLList.add(actualURL);
		   		driverObj.navigate().back();
	   	}
		   	expectedURLList.add("http://automationpractice.com/index.php?controller=authentication");
		   	expectedURLList.add("http://automationpractice.com/index.php?controller=authentication");
	

		   	elementName = "Sitemap-YourAccountSectionLinks_link";
	//	   	resultStatus = gm_assertionAndResultReporting(actualURLList.toString(), expectedURLList.toString(), elementName, logger);
		   	System.out.println("Out of validateYourAccountLinks Method");
	}
  	
    
 	//"********Validation of validatePagesSectionLinks********");
  	@Test (priority = 5)
   	public  void validatePagesSectionLinks() throws Exception{
   		System.out.println("In validatePagesSectionLinks Method");
   		
 		List <WebElement> pageSectionLinksCollection = sitemapPageObj.Pages_SitemapPage_lnk;
 		   	System.out.println("Total PagesSection Links = "+pageSectionLinksCollection.size());
 		   	ArrayList<String> actualURLList = new ArrayList<String>();
 		   	ArrayList<String> expectedURLList = new ArrayList<String>();
 		   	for(int i=0; i<pageSectionLinksCollection.size(); i++){
 		   		System.out.println("1");
 		   		pageSectionLinksCollection =  sitemapPageObj.Pages_SitemapPage_lnk;
 		   		WebElement pageSectionLinkEle = pageSectionLinksCollection.get(i);
 		     	System.out.println("2");
 		   		String elementName = pageSectionLinkEle.getText();
 		   		Comment = "Links validation -->> Page section -- Sitemap page";
 		 //  		String actualURL = gm_getActualURL(pageSectionLinkEle, elementName, logger, Comment);
 		 //  		System.out.println(actualURL);
 		 //  		actualURLList.add(actualURL);
 		   		driverObj.navigate().back();
 	   	}
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_cms_category=1&controller=cms");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_cms=1&controller=cms");
		   	expectedURLList.add("http://automationpractice.com/index.php?id_cms=2&controller=cms");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_cms=3&controller=cms");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_cms=4&controller=cms");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_cms=5&controller=cms");
 		   	expectedURLList.add("http://automationpractice.com/index.php?controller=contact");
 	
 		   	elementName = "Sitemap-PageSectionLinks_link";
 	//	   	resultStatus = gm_assertionAndResultReporting(actualURLList.toString(), expectedURLList.toString(), elementName, logger);
		   	System.out.println("Out of validatePagesSectionLinks Method");
 	}
  	
 	//"********Validation of validateproductBlockImageLinks********");
  	@Test (priority = 6)
   	public  void validateproductBlockImageLinks_SM() throws Exception{
   		System.out.println("In validateproductBlockImageLinks_SM Method");
   		
 		List <WebElement> productBlockImageLinkCollection = sitemapPageObj.TopSellers_ProductsBlock_SitemapPage_Imglnk;
 		   	System.out.println("Total productBlockImageLink = "+productBlockImageLinkCollection.size());
 		   	ArrayList<String> actualURLList = new ArrayList<String>();
 		   	ArrayList<String> expectedURLList = new ArrayList<String>();
 		   	for(int i=0; i<productBlockImageLinkCollection.size(); i++){
 		   		System.out.println("1");
 		   		productBlockImageLinkCollection =  sitemapPageObj.TopSellers_ProductsBlock_SitemapPage_Imglnk;
 		   		WebElement productBlockImageLinkEle = productBlockImageLinkCollection.get(i);
 		     	System.out.println("2");
 		   		String elementName = productBlockImageLinkEle.getText();
 		   		Comment = "ProductImageLinks validation -->> TopSellers section -- Sitemap page";
 		//   		String actualURL = gm_getActualURL(productBlockImageLinkEle, elementName, logger, Comment);
 		  // 		System.out.println(actualURL);
 		 //  		actualURLList.add(actualURL);
 		   		driverObj.navigate().back();
 	   	}
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=7&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=1&controller=product");
		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=2&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=5&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=3&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=6&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=4&controller=product");
 	
 		   	elementName = "Sitemap-productBlockImageLinks_link";
 	//	   	resultStatus = gm_assertionAndResultReporting(actualURLList.toString(), expectedURLList.toString(), elementName, logger);
 		   	System.out.println("Out of validateproductBlockImageLinks_SM Method");
 	}
  	
	//"********Validation of validateproductBlockNameLinks********");
  	@Test (priority = 6)
   	public  void validateproductBlockNameLinks_SM() throws Exception{
   		System.out.println("In validateproductBlockNameLinks_SM Method");
   		
 		List <WebElement> productBlockNameLinkCollection = sitemapPageObj.TopSellers_ProductsBlocks_NameLinks_SitemapPage_lnk;
 		   	System.out.println("Total ProductBlockNameLinks = "+productBlockNameLinkCollection.size());
 		   	ArrayList<String> actualURLList = new ArrayList<String>();
 		   	ArrayList<String> expectedURLList = new ArrayList<String>();
 		   	for(int i=0; i<productBlockNameLinkCollection.size(); i++){
 		   		System.out.println("1");
 		   		productBlockNameLinkCollection =  sitemapPageObj.TopSellers_ProductsBlocks_NameLinks_SitemapPage_lnk;
 		   		WebElement productBlockNameLinkEle = productBlockNameLinkCollection.get(i);
 		     	System.out.println("2");
 		   		String elementName = productBlockNameLinkEle.getText();
 		   		Comment = "ProductNameLinks validation -->> TopSellers section -- Sitemap page";
 		//   		String actualURL = gm_getActualURL(productBlockNameLinkEle, elementName, logger, Comment);
 		 //  		System.out.println(actualURL);
 		 //  		actualURLList.add(actualURL);
 		   		driverObj.navigate().back();
 	   	}
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=7&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=1&controller=product");
		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=2&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=5&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=3&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=6&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=4&controller=product");
 	
 		   	elementName = "Sitemap-productBlockNameLinks_link";
 	//	   	resultStatus = gm_assertionAndResultReporting(actualURLList.toString(), expectedURLList.toString(), elementName, logger);
 		   	System.out.println("Out of validateproductBlockNameLinks_SM Method");
 	}
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  //"********Validation of validateCategoories SectionLinks********");
   	public  void validateCategoriesSectionLinks() throws Exception{
   		
   		
   	}
   	
   	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
}
