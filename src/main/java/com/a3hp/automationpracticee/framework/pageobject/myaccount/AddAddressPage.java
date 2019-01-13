package com.a3hp.automationpracticee.framework.pageobject.myaccount;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;

public class AddAddressPage extends UI_GenericMethods1{
	
	// AddAddressTitle_Txt
	@FindBy(xpath = "//div[@id='center_column']//h1")
	public static WebElement AddAddress_PageHeading_Txt;
	
	
	
	
	// AddAddressTitle_Txt
	@FindBy(xpath = "//span[@class='navigation_page']")
	public static WebElement AddAddress_Breadcrumb_Txt;
	
	// FirstName_TB
	@FindBy(id = "firstname")
	public static WebElement AddAddress_FirstName_TB;

	// LastName_TB
	@FindBy(id = "lastname")
	public static WebElement AddAddress_LastName_TB;

	// Company_TB
	@FindBy(id = "company")
	public static WebElement AddAddress_Company_TB;
 
	// Address_TB
	@FindBy(id = "address1")
	public static WebElement AddAddress_Address_TB;
	
	// Address (Line 2)_TB
	@FindBy(id = "address2")
	public static WebElement AddAddress_AddressLine2_TB;
	
	// City_TB
	@FindBy(id = "city")
	public static WebElement AddAddress_City_TB;
	
	//State_DD
	@FindBy(id = "id_state")
	public static WebElement AddAddress_State_DD;
		
	// AddAddress_ZipPostalCode_TB
	@FindBy(id = "postcode")
	public static WebElement AddAddress_ZipPostalCode_TB;
	
	//Country_DD
	@FindBy(id = "id_country")
	public static WebElement AddAddress_Country_DD;
	
	//Homephone_TB
	@FindBy(id = "phone")
	public static WebElement AddAddress_Homephone_TB;
	
	//Mobilephone_TB
	@FindBy(id = "phone_mobile")
	public static WebElement AddAddress_Mobilephone_TB;
	
	//Additionalinformation_TB
	@FindBy(id = "other")
	public static WebElement AddAddress_additionalInformation_MB;
	
	//AddressAlias_TB
	@FindBy(id = "alias")
	public static WebElement AddAddress_addressAlias_TB;
	
	//AddAddress_saveButton_btn
	@FindBy(id = "submitAddress")
	public static WebElement AddAddress_saveButton_btn;
	
	//Back To Your addresses Button
	@FindBy(xpath = "//div[@id='center_column']//li[1]/a")
	public static WebElement AddAddress_backToYourAddress_btn;
	
	public AddAddressPage() {
		System.out.println("1");
    	TestDataPath1="TestData/AddAddressPage/AddAddressPage.xlsx";
    	TDSheetName1="AddAddress_Page";
    	System.out.println("2");
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
