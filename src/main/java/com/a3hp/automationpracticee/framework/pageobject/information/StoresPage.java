package com.a3hp.automationpracticee.framework.pageobject.information;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;
import com.a3hp.automationpracticee.framework.pageobject.myaccount.MyAccountPage;



public class StoresPage extends UI_GenericMethods1{
	
	
		
	public  StoresPage(){
		System.out.println("1");
		TestDataPath1="TestData/Stores/StoresPage.xlsx";
    	TDSheetName1="Stores_Page";
    	System.out.println("2");	
		
	
	}
	
	//PageTitle_OurStores_txt
	@FindBy(xpath = "//div[@id = 'center_column']/h1")
	public static WebElement  PageTitle_OurStores_txt;
	
	//Breadcrumb_OurStores_txt
	@FindBy(xpath = "//span[@class='navigation_page']")
	public static WebElement  Breadcrumb_OurStores_txt;
		
	//Your Location Field
	@FindBy(id = "addressInput")
	public static WebElement yourLocation_TB;
	
	//Radius_Dropdown
	@FindBy(id = "radiusSelect")
	public static WebElement radius_DD;
	
	
	//Search_Button
	@FindBy(xpath = "//button[@name = 'search_locations']")
	public static WebElement Search_Btn;
	
	//LocationDropdown
	@FindBy(id = "locationSelect")
	public static WebElement LocationDropdown_DD;
	

	
	//"********Validation of StoresSearch Functionality********");
	public StoresPage validateStoresSearchFunctionality(String rownum) throws IOException{
		xl_GetTestData1(rownum);
		gm_XLInput(yourLocation_TB, "YourLocation_tbx", "YourLocation_tbox", 30);
    	gm_XLInput(radius_DD, "Radius_DD", "Radius_DDwn", 30);
    	Search_Btn.click();
    	StoresPage storesPageObj = PageFactory.initElements(driverObj, StoresPage.class);
		return storesPageObj; 
	}
	
	
	
	
}
