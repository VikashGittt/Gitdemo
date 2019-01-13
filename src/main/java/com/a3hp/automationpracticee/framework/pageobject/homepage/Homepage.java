package com.a3hp.automationpracticee.framework.pageobject.homepage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;
import com.a3hp.automationpracticee.framework.pageobject.createaccountandlogin.SignInPage;
import com.a3hp.automationpracticee.framework.pageobject.dresses.CasualDressesPage;
import com.a3hp.automationpracticee.framework.pageobject.dresses.DressesPage;
import com.a3hp.automationpracticee.framework.pageobject.dresses.EveningDressesPage;
import com.a3hp.automationpracticee.framework.pageobject.dresses.PrintedChiffonDress_SDPage;
import com.a3hp.automationpracticee.framework.pageobject.dresses.PrintedDressCDPage;
import com.a3hp.automationpracticee.framework.pageobject.dresses.PrintedDressEDPage;
import com.a3hp.automationpracticee.framework.pageobject.dresses.PrintedSummerDress1_SDPage;
import com.a3hp.automationpracticee.framework.pageobject.dresses.PrintedSummerDress2_SDPage;
import com.a3hp.automationpracticee.framework.pageobject.dresses.SummerDressesPage;
import com.a3hp.automationpracticee.framework.pageobject.information.AboutUsPage;
import com.a3hp.automationpracticee.framework.pageobject.information.BestSellersPage;
import com.a3hp.automationpracticee.framework.pageobject.information.ContactUsPage;
import com.a3hp.automationpracticee.framework.pageobject.information.NewProductsPage;
import com.a3hp.automationpracticee.framework.pageobject.information.PriceDropPage;
import com.a3hp.automationpracticee.framework.pageobject.information.SitemapPage;
import com.a3hp.automationpracticee.framework.pageobject.information.StoresPage;
import com.a3hp.automationpracticee.framework.pageobject.information.TermsAndConditionsPage;
import com.a3hp.automationpracticee.framework.pageobject.search.SearchResultPage;
import com.a3hp.automationpracticee.framework.pageobject.tops.BlousePage;
import com.a3hp.automationpracticee.framework.pageobject.tops.BlousesPage;
import com.a3hp.automationpracticee.framework.pageobject.tops.FadedShortSleeveTshirtsPage;
import com.a3hp.automationpracticee.framework.pageobject.tops.TopsPage;
import com.a3hp.automationpracticee.framework.pageobject.tops.TshirtsPage;
import com.a3hp.automationpracticee.framework.pageobject.tops.WomenPage;

public class Homepage extends UI_GenericMethods1 {
		
		//SerachField
	  @FindBy(id = "search_query_top") 
	  public static WebElement Search_TB;
	  
		//SerachButton
	  //@FindBy(xpath = "//button[@class = 'btn btn-default button-search']") 
	  @FindBy(name = "submit_search") 
	  public static WebElement Search_Btn;
	  	  
	   //Logo
	  //@FindBy(xpath = "//div[@id = 'header_logo']/a")
	  @FindBy(id = "header_logo")
	  public static WebElement Logo_link;
		 
	   //Header DiscountBar - Done
	  @FindBy(xpath = "//div[@class = 'row']/a")
	  public static WebElement Header_DiscountBar;
	
	   //Header SignIn Link - Done
	  @FindBy(xpath = "//div[@class = 'header_user_info']/a")
	  public static WebElement SignIn_link;
	  
	   //Header ContactUs Link
	  @FindBy(id = "contact-link")
	  public static WebElement ContactUs_link;
	  
	  //Women_Footerlink - Done
	  @FindBy(xpath = "//li[@class='last']//a[contains(text(), 'Women')]")
	  public static WebElement Women_Footerlink;
	  
	  //Footer_Information section linkCollection
	  @FindBy(xpath = "//section[@id = 'block_various_links_footer']//li/a")
	  public static List<WebElement> InformationLinkCollection_Footerlinks;
	  
	  //Footer_Myaccount section linkCollection
	  @FindBy(xpath = "//ul[@class='bullet']/li/a")
	  public static List<WebElement> MyaccountLinkCollection_Footerlinks;
	  
	  //////////////////////////***********************************//////////////////////////////////////
	  //Specials_Footerlink
	  @FindBy(xpath = "//a[@title = 'Specials']")
	  public static WebElement Specials_Footerlink;
	
	  //Newproducts_Footerlink
	  @FindBy(xpath = "//a[@title = 'New products']")
	  public static WebElement Newproducts_Footerlink;
	  
	  //Bestsellers_Footerlink - Done
	  //Try this @FindBy(xpath = "//a[contains(.,'Best sellers')]")
	  @FindBy(xpath = "//a[@title = 'Best sellers']")
	  public static WebElement Bestsellers_Footerlink;
	
	  //Ourstores_Footerlink - Done
	  @FindBy(xpath = "//a[@title = 'Our stores']")
	  public static WebElement Ourstores_Footerlink;
	
	  //Contactus_Footerlink - done - Done
	  @FindBy(xpath = "//a[@title = 'Contact us']")
	  public static WebElement Contactus_Footerlink;
	  
	  //TermsandConditions_Footerlink - Done
	  @FindBy(xpath = "//a[@title = 'Terms and conditions of use']")
	  public static WebElement TermsandConditions_Footerlink;
	  
	  //Aboutus_Footerlink - Done
	  @FindBy(xpath = "//a[@title = 'About us']")
	  public static WebElement Aboutus_Footerlink;
	  
	  //Sitemap_Footerlink - Done
	  @FindBy(xpath = "//a[@title = 'Sitemap']")
	  public static WebElement Sitemap_Footerlink;
	  
 
	  @FindBy(xpath = "//a[@title = 'My orders']")
	  public static WebElement MyOrders_Footerlink;
	  
	  @FindBy(xpath = "//a[@title = 'My credit slips']")
	  public static WebElement MyCreditSlips_Footerlink;
	  
	  @FindBy(xpath = "//a[@title = 'My addresses']")
	  public static WebElement MyAddresses_Footerlink;
	  
	  @FindBy(xpath = "//a[@title = 'Manage my personal information']")
	  public static WebElement MyPersonalInfo_Footerlink;
	  //////////////////////////**********************************//////////////////////////////////////
	  
	  
	  @FindBy(id="newsletter-input")
	  public static WebElement Newsletter_TB;
	  
	  @FindBy(name  = "submitNewsletter")
	  public static WebElement Newsletter_Btn;
	  
	  @FindBy(xpath  = "//section[@id = 'social_block']//li")
	  public static List<WebElement> SocialBlocks_extlnk;
	  
	  
	  
	  //Homepage-TopPromoImages1&2 - Done
	  ////div[@id = 'htmlcontent_top']//li/a/img[@class= 'item-img']
	  @FindBy(xpath = "//div[@id = 'htmlcontent_top']//li/a")
	  public static List<WebElement> TopPromoImageBlocks_imglnk;
	  
	  

	  //Homepage-5BottomPromoImages - Done
	  ////div[@id = 'htmlcontent_top']//li/a/img[@class= 'item-img']
	  @FindBy(xpath = "//div[@id = 'htmlcontent_home']//li/a")
	  public static List<WebElement> BottomPromoImageBlocks_imglnk;
	  
	  
  
	  //Homepage-Tab1 & 2
	  @FindBy(xpath = "//ul[@id='home-page-tabs']/li")
	  public static List<WebElement> TabsCollection;
	  
	  
	
	  
	  //Product Block ImageLink Collection
	  @FindBy(xpath = "//ul[@id='homefeatured']/li//a[@class='product_img_link']")
	  public static List <WebElement> productBlocksImageLinkCollection_imglnk;
	  
	  //Product Block NameLink Collection
	  @FindBy(xpath = "//ul[@id='homefeatured']/li//h5/a")
	  public static List <WebElement> productBlockNameLinkCollection_lnk;
	  
	  //Product Block More ButtonCollection
	  @FindBy(xpath = "//ul[@id='homefeatured']/li//a[@title='View']")
	  public static List <WebElement> ProductBlockMoreButtonCollection_btn;
	  
	  
	  
	  
	  // Shopping Cart link
	  @FindBy(xpath = "//div[@class= 'shopping_cart']/a")
	  public static WebElement Cart_link;
	  
	  //Homepoage Carousel List
	  @FindBy(xpath = "//ul[@id='homeslider']/li/a")
	  public static List <WebElement> homesliderCollection_carousel;
	  
	  ////////////////////////////******************************////////////////////////////////////
	  //Homepage-Slider1 - Done
	  @FindBy(xpath = "//li[@class = 'homeslider-container']/a[@title='sample-1']")
	  public static WebElement homeslider1;
	  
	  //Homepage-Slider2  
	  @FindBy(xpath = "//li[@class = 'homeslider-container']/a[@title='sample-2']")
	  public static WebElement homeslider2;
	  
	  //Homepage-Slider3
	  @FindBy(xpath = "//li[@class = 'homeslider-container']/a[@title='sample-3']")
	  public static WebElement homeslider3;
	  /////////////////////////***********************************///////////////////////////////////////
	 
	  public Homepage(WebDriver driverObj){
		  this.driverObj = driverObj;
		  System.out.println("1");
			TestDataPath1="TestData/Homepage/HomePage.xlsx";
	    	TDSheetName1="Home_Page";
	    	System.out.println("2");
	  }
	 
	
/*	public Homepage navigateToHomepage(){
		System.out.println("In navigateToHomepage");	
		driverObj.navigate().to("http://automationpractice.com/index.php");
		homeObj = PageFactory.initElements(driverObj, Homepage.class);
		return homeObj;
	}  */
	 public SignInPage navigateToSignInPage(){
		 System.out.println("In navigateToSignInPage");	
		 driverObj.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
		 SignInPage signInPageObj = PageFactory.initElements(driverObj, SignInPage.class);
		  return signInPageObj;
	 }
	  
	 public ContactUsPage navigateToContactUsPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?controller=contact");
		  ContactUsPage contactPageObj = PageFactory.initElements(driverObj, ContactUsPage.class);
		  return contactPageObj;
	 }
	  
	 public WomenPage navigateToWomenPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?id_category=3&controller=category");
		 WomenPage womenPageObj = PageFactory.initElements(driverObj, WomenPage.class);
		  return womenPageObj;
	 }
	 public TopsPage navigateToTopsPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?id_category=4&controller=category");
		 TopsPage topsPageObj = PageFactory.initElements(driverObj, TopsPage.class);
		  return topsPageObj;
	 }  
	 
	 public TshirtsPage navigateToTshirtsPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?id_category=5&controller=category");
		 TshirtsPage tshirtsPageObj = PageFactory.initElements(driverObj, TshirtsPage.class);
		  return tshirtsPageObj;
	 }  
	 
	 public FadedShortSleeveTshirtsPage navigateToFadedShortSleeveTshirtsPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?id_product=1&controller=product");
		 FadedShortSleeveTshirtsPage fadedShortSleeveTshirtsPageObj = PageFactory.initElements(driverObj, FadedShortSleeveTshirtsPage.class);
		  return fadedShortSleeveTshirtsPageObj;
	 }  
	 
	 public BlousesPage navigateToBlousesPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?id_category=7&controller=category");
		 BlousesPage blousesPageObj = PageFactory.initElements(driverObj, BlousesPage.class);
		  return blousesPageObj;
	 }  
 
	 public BlousePage navigateToBlousePage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?id_product=2&controller=product");
		 BlousePage blousePageObj = PageFactory.initElements(driverObj, BlousePage.class);
		  return blousePageObj;
	 }  
	 public DressesPage navigateToDressesPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?id_category=8&controller=category");
		 DressesPage dressesPageObj = PageFactory.initElements(driverObj, DressesPage.class);
		  return dressesPageObj;
	 } 
	 public CasualDressesPage navigateToCasualDressesPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?id_category=9&controller=category");
		 CasualDressesPage casualDressesPageObj = PageFactory.initElements(driverObj, CasualDressesPage.class);
		  return casualDressesPageObj;
	 } 
	 public PrintedDressCDPage navigateToPrintedDressCDPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?id_product=3&controller=product");
		 PrintedDressCDPage printedDressPageCDObj = PageFactory.initElements(driverObj, PrintedDressCDPage.class);
		  return printedDressPageCDObj;
	 } 
	 public EveningDressesPage navigateToEveningDressesPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?id_category=10&controller=category");
		 EveningDressesPage eveningDressesPageObj = PageFactory.initElements(driverObj, EveningDressesPage.class);
		  return eveningDressesPageObj;
	 } 
	 public PrintedDressEDPage navigateToPrintedDressEDPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?id_product=4&controller=product");
		 PrintedDressEDPage printedDressPageEDObj = PageFactory.initElements(driverObj, PrintedDressEDPage.class);
		 return printedDressPageEDObj;
	 } 

	 public SummerDressesPage  navigateToSummerDressesPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?id_category=11&controller=category");
		 SummerDressesPage  summerDressesPageObj = PageFactory.initElements(driverObj, SummerDressesPage .class);
		  return summerDressesPageObj;
	 } 
	 public PrintedSummerDress1_SDPage navigateToPrintedSummerDress1_SDPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?id_product=5&controller=product");
		 PrintedSummerDress1_SDPage printedSummerDress1_SDPageObj = PageFactory.initElements(driverObj, PrintedSummerDress1_SDPage.class);
		  return printedSummerDress1_SDPageObj;
	 } 
	 public PrintedSummerDress2_SDPage navigateToPrintedSummerDress2_SDPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?id_product=6&controller=product");
		 PrintedSummerDress2_SDPage printedSummerDress2_SDPageObj = PageFactory.initElements(driverObj, PrintedSummerDress2_SDPage.class);
		  return printedSummerDress2_SDPageObj;
	 } 
	 public PrintedChiffonDress_SDPage navigateToprintedChiffonDress_SDPageObj(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?id_product=7&controller=product");
		 PrintedChiffonDress_SDPage printedChiffonDress_SDPageObj = PageFactory.initElements(driverObj, PrintedChiffonDress_SDPage.class);
		 return printedChiffonDress_SDPageObj;
	 } 
	 
	 public PriceDropPage navigateTopriceDropPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?controller=prices-drop");
		 PriceDropPage priceDropPageObj = PageFactory.initElements(driverObj, PriceDropPage.class);
		 return priceDropPageObj;
	 } 
	 public NewProductsPage navigateToNewProductsPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?controller=new-products");
		 NewProductsPage newProductsPageObj = PageFactory.initElements(driverObj, NewProductsPage.class);
		 return newProductsPageObj;
	 } 
	 public BestSellersPage navigateToBestSellersPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?controller=best-sales");
		 BestSellersPage bestSellersPageObj = PageFactory.initElements(driverObj, BestSellersPage.class);
		 return bestSellersPageObj;
	 } 
	 public StoresPage navigateToStoresPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?controller=stores");
		 StoresPage storesPageObj = PageFactory.initElements(driverObj, StoresPage.class);
		 return storesPageObj;
	 } 
	 public TermsAndConditionsPage navigateToTermsAndConditionsPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?id_cms=3&controller=cms");
		 TermsAndConditionsPage termsAndConditionsPageObj = PageFactory.initElements(driverObj, TermsAndConditionsPage.class);
		 return termsAndConditionsPageObj;
	 } 
	 public AboutUsPage navigateToAboutUsPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?id_cms=4&controller=cms");
		 AboutUsPage aboutUsPageObj = PageFactory.initElements(driverObj, AboutUsPage.class);
		 return aboutUsPageObj;
	 } 
	 public SitemapPage navigateToSitemapPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?controller=sitemap");
		 SitemapPage sitemapPageObj = PageFactory.initElements(driverObj, SitemapPage.class);
		 return sitemapPageObj;
	 } 
	public SearchResultPage validateSearchField(String rownum) throws IOException{
		System.out.println("In validateSearchField");
		xl_GetTestData1(rownum);
		System.out.println("HH1");
		gm_XLInput(Search_TB, "Search_tbx", "Search_tbox", 30);
		System.out.println("HH2");
		Search_Btn.click();
		System.out.println("HH3");
	   	//NavObject=PageFactory.initElements(driverObj, Navigation.class);
		SearchResultPage searchResultPgObj = PageFactory.initElements(driverObj, SearchResultPage.class);
		System.out.println("H4");
		return searchResultPgObj; 
	}

}
