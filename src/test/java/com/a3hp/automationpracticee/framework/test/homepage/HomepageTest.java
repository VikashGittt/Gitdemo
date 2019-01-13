package com.a3hp.automationpracticee.framework.test.homepage;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.a3hp.automationpracticee.framework.helper.TestBase.TestBasee;
import com.a3hp.automationpracticee.framework.pageobject.createaccountandlogin.SignInPage;
import com.a3hp.automationpracticee.framework.pageobject.homepage.Homepage;
import com.a3hp.automationpracticee.framework.pageobject.search.SearchResultPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.log4j.LogManager;
//import org.apache.log4j.getLogger();
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


	public class HomepageTest extends TestBasee {		 

		@BeforeMethod(alwaysRun = true)
		@Parameters({ "Browser", "URL", "OSName"/**/})
	    public void getBrowser(String Browser, String URL, String OSName) throws Exception{
			System.out.println("HomepageeTest Get Browser");				
	    	System.out.println("Launch "+URL+" on "+Browser+" on "+OSName);    	
	    	homeObj = gm_OpenApp(Browser, URL, OSName); 
	    	System.out.println("Homepage is in display");    	
		}
		@AfterMethod (alwaysRun = true)
		public void publishReport_HP() throws InterruptedException, IOException, InvalidFormatException{
			System.out.println("@AfterMethod publishReport_HP");
			/*String resultStatus = null;
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
				} */
				
			/* else if(result.getStatus()==ITestResult.SUCCESS){
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
			System.out.println("closing now_HP");
			driverObj.quit();
		
		}
		
		   	
		   	
		   	
	    
	    
	    
		 
	//"********Validation of SignIn Link********");
	@Test(priority=0, groups = {"Homepage_func", "Homepage_smoke", "smoke", "func", "High"}/*, dependsOnMethods = { "validateGetSavingNowButton_HP" }*/)	
	public  void validateHeaderSignInLink_HP() throws Exception{
		
		System.out.println("In validateHeaderSignInLink Method_HP"); 
		elementName = "SignInLink";
		expectedResult = "http://automationpractice.com/index.php?controller=authentication&back=my-account";						  
		Comment = "validateHeaderSignInLink";
		actualResult = gm_getActualURL(Homepage.SignIn_link, elementName, extentTestLogger, Comment);
		System.out.println("Going to assert");
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of validateHeaderSignInLink method_HP");
	}		
   
	//"********Validation of GetSavingNow Button********");
	@Test (priority = 1, groups = {"Homepage_func", "Homepage_smoke", "smoke", "func", "High"}/*, dependsOnMethods = { "validateSearchField_HP" }*/)
	public  void validateGetSavingNowButton_HP() throws Exception{
		
		System.out.println("In validateGetSavingNowButton Method_HP");
		elementName = "GETSAVINGSNOWButton";
		actualResult = gm_getActualURL(Homepage.Header_DiscountBar, elementName, extentTestLogger, Comment);
		Comment = "validateGetSavingNowButton"; 
		expectedResult = "http://automationpractice.com/index.php";
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of validateGetSavingNowButton method_HP");
	}	
   
	@Test (priority = 2, groups = {"Homepage_func", "Homepage_smoke", "smoke", "func", "High"}/*, dependsOnMethods = { "validateHomepageSlider1_HP" }*/)
	//"********Validation of SearchBox********");
	public  void validateSearchField_HP() throws Exception{
		System.out.println("In validateSearchField Method_HP");
		SearchResultPage SearchResultPageObj = homeObj.validateSearchField("1");
		elementName = "FadedShortSleeveTshirts_lnktxt";
		Comment = "validateSearchField";
		actualResult = gm_getActualText(SearchResultPage.FadedShortSleeveTshirts_lnktxt, elementName, extentTestLogger, Comment);
	
		expectedResult = "Faded Short Sleeve T-shirts";
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of validateSearchField method_HP");
	}
	
		
  @Test (priority = 3, enabled = true, groups = {"Homepage_func", "Homepage_smoke", "smoke", "func", "High"}/*, dependsOnMethods = { "validateHomepageSlider2_HP" }*/)
	//"********Validation of Slider1********");    --------------->> Apply ArrayList for all sliders and compare ArrayList
	public  void validateHomepageSlider1_HP() throws Exception{
		System.out.println("In validateHomepageSlider1 Method_HP"); 
		elementName = "Homepage Slider1";
		Comment = "validateHomepageSlider1";
		actualResult = gm_getActualURL(Homepage.homeslider1, elementName, extentTestLogger, Comment);
		expectedResult = "https://www.prestashop.com/en?utm_source=v16_homeslider";
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of validateHomepageSlider1 method_HP");
		
	}	
   
   
	@Test (priority = 4, groups = {"Homepage_func", "smoke", "func", "High"}/*, dependsOnMethods = { "validateHomepageSlider3_HP" }*/)
	//"********Validation of Slider2********");
	public  void validateHomepageSlider2_HP() throws Exception{
		System.out.println("In validateHomepageSlider2 Method_HP"); 
		elementName = "Homepage_Slider2";
		Comment = "validateHomepageSlider2";
		actualResult = gm_getActualURL(Homepage.homeslider2, elementName, extentTestLogger, Comment);
		expectedResult = "https://www.prestashop.com/en?utm_source=v16_homeslider";
		System.out.println(actualResult);
		System.out.println(expectedResult);
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of Validation of Slider2 method_HP");
	}	
   
	@Test (priority = 5, enabled = true, groups = {"Homepage_func", "smoke", "func", "Medium"}/*, dependsOnMethods = { "validateHomepageCarouselBlocks_HP" }*/)
	//"********Validation of Slider3********");
	public  void validateHomepageSlider3_HP() throws Exception{
		System.out.println("In validateHomepageSlider3 Method_HP"); 
		elementName = "Homepage_Slider3";
		Comment = "validateHomepageSlider3";
		actualResult = gm_getActualURL(Homepage.homeslider3, elementName, extentTestLogger, Comment);
		expectedResult = "https://www.prestashop.com/en?utm_source=v16_homeslider";
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of Validation of Slider3 method_HP");
	}	
   
   
	//"********Validation of CarouselBlocks********");--> Not working--failing to click
	@Test (priority = 6, groups = {"Homepage_func", "smoke", "func", "Medium"})  
	public  void validateHomepageCarouselBlocks_HP() throws Exception{
		System.out.println("In validateHomepageCarouselBlocks Method_HP"); 
	  	List <WebElement> carouselPromoBlockCollecton = Homepage.homesliderCollection_carousel;
		   	System.out.println("Total slides = "+carouselPromoBlockCollecton.size());
		   	ArrayList<String> actualURLList = new ArrayList<String>();
		   	ArrayList<String> expectedURLList = new ArrayList<String>();
		   	for(int i=0; i<carouselPromoBlockCollecton.size(); i++){
		   		System.out.println("1");
		   		carouselPromoBlockCollecton = Homepage.homesliderCollection_carousel;
		   		WebElement carouselBlockEle = carouselPromoBlockCollecton.get(i);
		     	System.out.println("2");
		   		String elementName = carouselBlockEle.getAttribute("title");
		   		Comment = "validateHomepageCarouselBlocks";
		   		String actualURL = gm_getActualURL(carouselBlockEle, elementName, extentTestLogger, Comment);
		   		System.out.println(actualURL);
		   		actualURLList.add(actualURL);
		   		driverObj.navigate().back();
	   	}
		   	expectedURLList.add("https://www.prestashop.com/en?utm_source=v16_homeslider");
		   	expectedURLList.add("https://www.prestashop.com/en?utm_source=v16_homeslider");
		   	expectedURLList.add("https://www.prestashop.com/en?utm_source=v16_homeslider");
		   	expectedURLList.add("https://www.prestashop.com/en?utm_source=v16_homeslider");
		   	expectedURLList.add("https://www.prestashop.com/en?utm_source=v16_homeslider");
		   	elementName = "InsightBlockImageFunctionality";
		   	actualResult = actualURLList.toString();
		   	expectedResult = expectedURLList.toString();
		  	System.out.println(actualResult);
		   	System.out.println(expectedResult);
		   	Assert.assertEquals(actualResult, expectedResult);
		   	System.out.println("Out of validateHomepageCarouselBlocks Method_HP");
	}
   
	//"********Validation of productBlockMoreButton*******");//
  	//@Test (priority = 7, groups = {"Homepage_func", "func", "smoke", "Medium"})
	public  void validateproductBlock_MoreButton_HP() throws Exception{
		System.out.println("In validateproductBlock_MoreButton Method_HP ");
		List <WebElement> productBlockMoreButtonCollection = homeObj.ProductBlockMoreButtonCollection_btn;
		   	System.out.println("Total ProductBlockNameLinks = "+ productBlockMoreButtonCollection.size());
		   	ArrayList<String> actualURLList = new ArrayList<String>();
		   	ArrayList<String> expectedURLList = new ArrayList<String>();
		   	for(int i=0; i<productBlockMoreButtonCollection.size(); i++){
		   		System.out.println("1");
		   		productBlockMoreButtonCollection =  homeObj.ProductBlockMoreButtonCollection_btn;
		   		WebElement productBlockMoreButtonEle = productBlockMoreButtonCollection.get(i);
		     	System.out.println("2");
		   		String elementName = productBlockMoreButtonEle.getText();
		   		Comment = "ProductNameLinks validation Homepage[PopularSection]";
		   		String actualURL = gm_getActualURL(productBlockMoreButtonEle, elementName, extentTestLogger, Comment);
		   		System.out.println(actualURL);
		   		actualURLList.add(actualURL);
		   		driverObj.navigate().back();
	   	}
		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=1&controller=product");
		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=2&controller=product");
		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=3&controller=product");
		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=4&controller=product");
		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=5&controller=product");
		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=6&controller=product");
		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=7&controller=product");
		   	elementName = "Homepage-productBlockMoreButton_Btn";
		   	actualResult = actualURLList.toString();
		   	expectedResult = expectedURLList.toString();
		  	System.out.println(actualResult);
		   	System.out.println(expectedResult);
		   	Assert.assertEquals(actualResult, expectedResult);
		   	System.out.println("Out of validateproductBlock_MoreButton Method_HP ");
	}
	
   
	
	
	
	
	
	//"********Validation of TopPromoBlocks********");
	//@Test (priority = 8, groups = {"Homepage_func", "smoke", "func", "Medium"})
	public  void validateHomepageTopPromoBlocks_HP() throws Exception{
		System.out.println("In validateHomepageTopPromoBlocks Method_HP"); 
	  	List <WebElement> topPromoBlockCollecton = Homepage.TopPromoImageBlocks_imglnk;
	  	System.out.println(topPromoBlockCollecton.size());
		   	ArrayList<String> actualURLList = new ArrayList<String>();
		   	ArrayList<String> expectedURLList = new ArrayList<String>();
		   	for(int i=0; i<topPromoBlockCollecton.size(); i++){
		   		System.out.println("1");
		   		topPromoBlockCollecton = Homepage.TopPromoImageBlocks_imglnk;
		   		WebElement topPromoBlockEle = topPromoBlockCollecton.get(i);
		     	System.out.println("2");
		     	i=i+1;
		   		String elementName = "TopPromoImageBlockNo."+i;
		   		i=i-1;
		   		Comment = "validateHomepageTopPromoBlocks";
		   		String actualResult = gm_getActualURL(topPromoBlockEle, elementName, extentTestLogger, Comment);
		   		System.out.println(actualResult);
		   		actualURLList.add(actualResult);		   		
		   		driverObj.navigate().back();
	   	}
		   	expectedURLList.add("https://www.prestashop.com/en");
		   	expectedURLList.add("https://www.prestashop.com/en");		   	
		    elementName = "TopPromoImageBlocksFunctionality";
		   	actualResult = actualURLList.toString();
		   	expectedResult = expectedURLList.toString();
		  	System.out.println(actualResult);
		   	System.out.println(expectedResult);
		   	Assert.assertEquals(actualResult, expectedResult);
		   	System.out.println("Out of validateHomepageTopPromoBlocks Method_HP");
		
	}
	//@Test (priority = 9, groups = {"Homepage_func", "Homepage_smoke", "smoke", "func", "High"})
	//"********Validation of Logo********");
	public  void validateLogoIcon_HP() throws Exception{
		System.out.println("In validateLogoIcon Method_HP");
		elementName = "Homepage_Logo";
		Comment = "validateLogoIcon";
		actualResult = gm_getActualURL(Homepage.Logo_link, elementName, extentTestLogger, Comment);
		expectedResult = "http://automationpractice.com/index.php";
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of validateLogoIcon method_HP");
	}
	//Validation of Bottom Promo Block
	//@Test (priority = 10, groups = {"Homepage_func", "func", "smoke", "Medium"})
	public  void validateHomepageBottomPromoBlocks_HP() throws Exception{
		
		System.out.println("In validateHomepageBottomPromoBlocks Method_HP");
	  	List <WebElement> bottomPromoBlockCollecton = Homepage.BottomPromoImageBlocks_imglnk;
	  	System.out.println("Total bottomPromoBlocks = "+bottomPromoBlockCollecton.size());
		   	ArrayList<String> actualURLList = new ArrayList<String>();
		   	ArrayList<String> expectedURLList = new ArrayList<String>();
		   	for(int i=0; i<bottomPromoBlockCollecton.size(); i++){
		   		System.out.println("1");
		   		bottomPromoBlockCollecton = Homepage.BottomPromoImageBlocks_imglnk;
		   		WebElement bottomPromoBlockEle = bottomPromoBlockCollecton.get(i);
		     	System.out.println("2");
		   		String elementName = "BottomPromoImageBlockNo."+(i+1);
		   		Comment = "Validate Homepage Bottom Promo Blocks";
		   		String actualURL = gm_getActualURL(bottomPromoBlockEle, elementName, extentTestLogger, Comment);
		   		actualURLList.add(actualURL);
		   		//Need to use windo handle here
		   		driverObj.navigate().back();
	   	}
		   	
		   	expectedURLList.add("https://www.prestashop.com/en");
		   	expectedURLList.add("https://www.prestashop.com/en");
		  	expectedURLList.add("https://www.prestashop.com/en");
		   	expectedURLList.add("https://www.prestashop.com/en");
		  	expectedURLList.add("https://www.prestashop.com/en");
		   	
		   	//elementName = "5_BottomPromoImageBlocksFunctionality";	
		   	actualResult = actualURLList.toString();
		   	expectedResult = expectedURLList.toString();
		   	System.out.println(actualResult);
		   	System.out.println(expectedResult);
		   	Assert.assertEquals(actualResult, expectedResult);
		   	System.out.println("Out of validateHomepageBottomPromoBlocks Method_HP");
		
	}
   
	//"********Validation of Tabs********"); Not working
	//@Test (priority = 11, groups = {"Homepage_func", "func", "Medium", "smoke"}) 
	public  void validateHomepageTabs_HP() throws Exception{
		System.out.println("In validateHomepageTabs Method_HP"); /**/
			List <WebElement> tabCollecton = Homepage.TabsCollection;
		  	System.out.println(tabCollecton.size());
			ArrayList<String> actualStatusList = new ArrayList<String>();
		   	ArrayList<String> expectedStatusList = new ArrayList<String>();
		   	for(int i=0; i<tabCollecton.size(); i++){
		   		WebElement tabEle	= tabCollecton.get(i);
		   		String elementName = tabEle.getText();
		   		Comment = "validateHomepageTabs";
		   		String actualResult = gm_getActualStatus(tabEle, elementName, extentTestLogger, Comment);
		   		System.out.println("After click, actual clickable status of Tab: "+tabEle+" is "+actualResult);
		   		actualStatusList.add(actualResult);
		   	}	
		   		expectedStatusList.add("true");
		   		elementName = "HomepageTabs";
		   	   	actualResult = actualStatusList.toString();
			   	expectedResult = expectedStatusList.toString();		   	
			   	Assert.assertEquals(actualResult, expectedResult);
		   		System.out.println("Out Of validateHomepageTabs Method_HP");
	}
	
	
	//"********Validation of ContactUs Footerlink********");
	//@Test (priority = 12, groups = {"Homepage_func", "func", "smoke", "Medium"})
	public  void validateContactUsFooterlink_HP() throws Exception{
		System.out.println("In validateContactUsFooterlink Method_HP");
		elementName = "ContactUs_FooterLink";
		expectedResult = "http://automationpractice.com/index.php?controller=contact";
		Comment = "validateContactUsFooterlink";
		actualResult = gm_getActualURL(Homepage.Contactus_Footerlink, elementName, extentTestLogger, Comment);
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of validateContactUsFooterlink method_HP");
	}

	
	//"********//Specials_Footerlink********");
	//@Test (priority = 13, groups = {"Homepage_func", "func", "Medium", "smoke"})
	public  void validateSpecials_Footerlink_HP() throws Exception{
		System.out.println("In validateSpecials_Footerlink Method_HP"); 
		elementName = "Specials_Footerlink";
		expectedResult = "http://automationpractice.com/index.php?controller=prices-drop";
		Comment = "validateSpecials_Footerlink";
		actualResult = gm_getActualURL(Homepage.Specials_Footerlink, elementName, extentTestLogger, Comment);
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of validateSpecials_Footerlink method_HP");
	}
	
	//"********Newproducts_Footerlink********");
	//@Test (priority = 14, groups = {"Homepage_func", "func", "Medium", "smoke"})
	public  void validateNewproducts_Footerlink_HP() throws Exception{
		System.out.println("In validateNewproducts_Footerlink Method_HP");  
		elementName = "Newproducts_Footerlink";
		expectedResult = "http://automationpractice.com/index.php?controller=new-products";
		Comment = "validateNewproducts_Footerlink";
		actualResult = gm_getActualURL(Homepage.Newproducts_Footerlink, elementName, extentTestLogger, Comment);
		Assert.assertEquals(actualResult, expectedResult);
	 	System.out.println("Out  of validateNewproducts_Footerlink method_HP");
		
	}
		
	//"********Validation of Bestsellers_Footerlink********");
	//@Test (priority = 15, groups = {"Homepage_func", "func", "Medium", "smoke"})
	public  void validateBestsellers_Footerlink_HP() throws Exception{
		System.out.println("In validateBestsellers_Footerlink Method_HP"); 
		elementName = "Bestsellers_Footerlink";
		expectedResult = "http://automationpractice.com/index.php?controller=best-sales";
		Comment = "validateBestsellers_Footerlink";
		actualResult = gm_getActualURL(Homepage.Bestsellers_Footerlink, elementName, extentTestLogger, Comment);
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of validateBestsellers_Footerlink method_HP");
		
	}
		
	//"********Validation of Ourstores_Footerlink********");
	//@Test (priority = 16, enabled = false,  groups = {"Homepage_func",  "func", "Medium", "smoke"})
	public  void validateOurstores_Footerlink_HP() throws Exception{
		System.out.println("In validateOurstores_Footerlink Method_HP"); 
		elementName = "Ourstores_Footerlink";
		expectedResult = "http://automationpractice.com/index.php?controller=stores";
		Comment = "validateOurstores_Footerlink";
		actualResult = gm_getActualURL(Homepage.Ourstores_Footerlink, elementName, extentTestLogger, Comment);
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of validateOurstores_Footerlink method_HP");
	}
	
	
	
	
	//"********Validation of TermsandConditions_Footerlink********");
	//@Test (priority = 17, groups = {"Homepage_func",  "func", "Medium"})
	public  void validateTermsandConditions_Footerlink_HP() throws Exception{
		
		System.out.println("In validateTermsandConditions_Footerlink Method_HP");
		elementName = "TermsandConditions Footerlink";
		expectedResult = "http://automationpractice.com/index.php?id_cms=3&controller=cms";
		Comment = "validateTermsandConditions_Footerlink";
		actualResult = gm_getActualURL(Homepage.TermsandConditions_Footerlink, elementName, extentTestLogger, Comment);
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of validateTermsandConditions_Footerlink method_HP");
	}
		
		
	//"********Validation of Aboutus_Footerlink********");
	//@Test (priority = 18, groups = {"Homepage_func", "func", "Medium"})
	public  void validateAboutus_Footerlink_HP() throws Exception{
		
		System.out.println("In validateAboutus_Footerlink Method_HP"); 
		elementName = "AboutusFooterlink";
		expectedResult = "http://automationpractice.com/index.php?id_cms=4&controller=cms";
		Comment = "validateAboutus_Footerlink";
		actualResult = gm_getActualURL(Homepage.Aboutus_Footerlink, elementName, extentTestLogger, Comment);
		Assert.assertEquals(actualResult, expectedResult);
	 	System.out.println("Out  of validateAboutus_Footerlink method_HP");
	}
		
		
		
 
	
	//"********Validation of Sitemap_Footerlink********");
	//@Test (priority = 19, groups = {"Homepage_func", "func", "Medium", "smoke"})
	public  void validateSitemap_Footerlink_HP() throws Exception{
		
		System.out.println("In validateSitemap_Footerlink Method_HP");			
		elementName = "Sitemap_Footerlink";
		expectedResult = "http://automationpractice.com/index.php?controller=sitemap";
		Comment = "validateSitemap_Footerlink";
		actualResult = gm_getActualURL(Homepage.Sitemap_Footerlink, elementName, extentTestLogger, Comment);
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of validateSitemap_Footerlink method_HP");
	}
	
	//"********Validation of Women_Footerlink********");
	//@Test (priority = 20, enabled = true, groups = {"Homepage_func", "func", "Medium", "smoke"}) 
	public  void validateWomen_Footerlink_HP() throws Exception{
		System.out.println("In validateWomen_Footerlink Method_HP");
		elementName = "Women_Footerlink";
		expectedResult = "http://automationpractice.com/index.php?id_category=3&controller=category";
		Comment = "validateWomen_Footerlink";
		actualResult = gm_getActualURL(Homepage.Women_Footerlink, elementName, extentTestLogger, Comment);
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("Out  of validateWomen_Footerlink method_HP");
		
	}	
		
	 
	 
	 
	 
	//"********Validation of productBlockImageLinks********");
  	//@Test (priority = 21, groups = {"Homepage_func", "smoke", "func", "Medium"})
   	public  void validateproductBlockImageLinks_HP() throws Exception{
   		System.out.println("In validateproductBlockImageLinks Method_HP");	   		
   		List <WebElement> productBlockImageLinkCollection = homeObj.productBlocksImageLinkCollection_imglnk;
 		   	System.out.println("Total productBlockImageLink = "+productBlockImageLinkCollection.size());
 		   	ArrayList<String> actualURLList = new ArrayList<String>();
 		   	ArrayList<String> expectedURLList = new ArrayList<String>();
 		   	for(int i=0; i<productBlockImageLinkCollection.size(); i++){
 		   		
 		   			String imagLinkName = homeObj.productBlockNameLinkCollection_lnk.get(i).getText(); 		   		
	 		   		System.out.println("1");
	 		   		productBlockImageLinkCollection =  homeObj.productBlocksImageLinkCollection_imglnk;
	 		   		WebElement productBlockImageLinkEle = productBlockImageLinkCollection.get(i);
	 		     	System.out.println("2");
	 		   		String elementName = imagLinkName+"_imglnk";
	 		   		System.out.println("elementName ==> "+ elementName);
	 		   		Comment = "ProductImageLinks validation --> Homepage[PopularSection]";
	 		   		String actualURL = gm_getActualURL(productBlockImageLinkEle, elementName, extentTestLogger, Comment);
	 		   		actualURLList.add(actualURL);
	 		   		driverObj.navigate().back();
 		   		
 		   	}
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=1&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=2&controller=product");
		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=3&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=4&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=5&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=6&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=7&controller=product");
 	
 		   	elementName = "Homepage-productBlockImageLinks_link"; 		   
	   	   	actualResult = actualURLList.toString();
		   	expectedResult = expectedURLList.toString();
		   	System.out.println(actualResult+"\n");
		   	System.out.println(expectedResult+"\n");
		   	Assert.assertEquals(actualResult, expectedResult);
 		   	System.out.println("Out of validateproductBlockImageLinks Method_HP ");
 	}
  //"********Validation of productBlockNameLinks********");
  	//@Test (priority = 22, groups = {"Homepage_func", "smoke", "func", "Medium"})
   	public  void validateproductBlockNameLinks_HP() throws Exception{
   		System.out.println("In validateproductBlockNameLinks Method_HP ");
   		List <WebElement> productBlockNameLinkCollection = homeObj.productBlockNameLinkCollection_lnk;
 		   	System.out.println("Total ProductBlockNameLinks = "+productBlockNameLinkCollection.size());
 		   	ArrayList<String> actualURLList = new ArrayList<String>();
 		   	ArrayList<String> expectedURLList = new ArrayList<String>();
 		   	for(int i=0; i<productBlockNameLinkCollection.size(); i++){
 		   		System.out.println("1");
 		   		productBlockNameLinkCollection =  homeObj.productBlockNameLinkCollection_lnk;
 		   		WebElement productBlockNameLinkEle = productBlockNameLinkCollection.get(i);
 		     	System.out.println("2");
 		   		String elementName = productBlockNameLinkEle.getText();
 		   		Comment = "ProductNameLinks validation Homepage[PopularSection]";
 		   		String actualResult = gm_getActualURL(productBlockNameLinkEle, elementName, extentTestLogger, Comment);
 		   		System.out.println(actualResult);
 		   		actualURLList.add(actualResult);
 		   		driverObj.navigate().back();
 	   	}
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=1&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=2&controller=product");
		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=3&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=4&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=5&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=6&controller=product");
 		   	expectedURLList.add("http://automationpractice.com/index.php?id_product=7&controller=product");
 	
 		   	elementName = "Homepage-productBlockNameLinks_link";
 		   	actualResult = actualURLList.toString();
		   	expectedResult = expectedURLList.toString();
		   	Assert.assertEquals(actualResult, expectedResult);
 		   	System.out.println("Out of validateproductBlockNameLinksMethod_HP ");
 	}
  	

  	//@Test (priority = 23, groups = {"Homepage_txt", "txt", "Low"})
	public  void validateproductBlock_productName_HP() throws Exception{
		System.out.println("In validateproductBlock_productName_HP Method_HP "); 
		System.out.println("Out of validateproductBlock_productName_HP Method_HP ");
	
  	}
   //@Test (priority = 24, groups = {"Homepage_txt", "txt", "Low"})
   public  void validateproductBlock_FooterLinkName_HP() throws Exception{
	   System.out.println("In validateproductBlock_FooterLinkName_HP Method_HP "); 
	   System.out.println("Out of validateproductBlock_FooterLinkName_HP Method_HP ");
	
   }
   
	//////////*******************Validation Of Product Blocks**********************************/////////////
	
	
	
	
	
	
	
	//"********Validation of Links under My Account section of Footer********");
 
	
	
	//"********Validation of Women_Footerlink********");
	
	
	
	
	//"********Validation of Women_Footerlink********");
	
	
	
	
	//"********Validation of Women_Footerlink********");
	
	
	
	
	//"********Validation of Women_Footerlink********");
	
	
	
	
	//"********Validation of Women_Footerlink********");
	
	
	
	
	//"********Validation of Women_Footerlink********");
	
	
	
	
}
