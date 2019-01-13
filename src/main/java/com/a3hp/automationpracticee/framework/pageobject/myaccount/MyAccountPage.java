package com.a3hp.automationpracticee.framework.pageobject.myaccount;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;
import com.a3hp.automationpracticee.framework.pageobject.tops.WomenPage;

public class MyAccountPage extends UI_GenericMethods1{
	
	//MyAccountPageTitle_Txt
	@FindBy(xpath = "//div[@id = 'center_column']/h1")
	public static WebElement MyAccount_PageHeading_Txt;




	//MyAccount_Breadcrumb_txt
	@FindBy(xpath = "//span[@class = 'navigation_page']")
	public static WebElement MyAccount_Breadcrumb_txt;
	
	//MyAccounts_ModuleLinksCollection_lnk
	@FindBy(xpath = "//div[@id = 'center_column']//a[contains(@href, 'http://automationpractice.com/index.php?')]")
	public static List <WebElement> MyAccount_ModuleLinksCollection_lnk;
	
	//MyAccounts_HomeButton
	@FindBy(xpath = "	//a[@title='Home']")
	public static WebElement MyAccount_HomeButton_Btn;
	
	 public MyOrdersPage navigateToMyOrderHistoryPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?controller=history");
		 MyOrdersPage myOrdersPageObj = PageFactory.initElements(driverObj, MyOrdersPage.class);
		  return myOrdersPageObj;
	 }
	 
	 public MyCreditSlipsPage navigateToMyCreditSlipPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?controller=order-slip");
		 MyCreditSlipsPage myCreditSlipsPageObj = PageFactory.initElements(driverObj, MyCreditSlipsPage.class);
		  return myCreditSlipsPageObj;
	 }
	 
	 public MyAddressesPage navigateToMyAddressesPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?controller=addresses");
		 MyAddressesPage myAddressesPageObj = PageFactory.initElements(driverObj, MyAddressesPage.class);
		 return myAddressesPageObj;
	 }
	 
	 public MyPersonalInfoPage navigateToMyPersonalInformationPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?controller=identity");
		 MyPersonalInfoPage myPersonalInfoPageObj = PageFactory.initElements(driverObj, MyPersonalInfoPage.class);
		 return myPersonalInfoPageObj;
	 }
	 
	 public MyWishlistPage navigateToMyWishlistPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist");
		 MyWishlistPage myWishlistPageObj = PageFactory.initElements(driverObj, MyWishlistPage.class);
		  return myWishlistPageObj;
	 }
	
	
	
}






