package com.a3hp.automationpracticee.framework.pageobject.createaccountandlogin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;
import com.a3hp.automationpracticee.framework.pageobject.myaccount.MyAccountPage;

 

public class RegistrationPage extends UI_GenericMethods1{
	
	public RegistrationPage(){
		System.out.println("1");
    	TestDataPath1="TestData/RegistrationPage/RegistrationPage.xlsx";
    	TDSheetName1="Registration_Page";
    	System.out.println("2");
    }
	//PageTitle
	@FindBy(xpath = "//div[@id = 'center_column']//h1")
	public static WebElement CreateAccountPageTitle_Txt;
	
	//PBreadcrumb Text
	@FindBy(xpath = "//span[@class='navigation_page']")
	public static WebElement CreateAccount_Breadcrumb_Txt;
	
	//PageSubtitle
	@FindBy(xpath = "//h3[contains(text(),'Your personal information')]")
	public static WebElement PersonalInfoTitle_Txt;
	
	//Mr. RadioButton
	@FindBy(id = "id_gender1")
	public static WebElement Mr_RB;
	
	//Mrs. RadioButton
	@FindBy(id = "id_gender2")
	public static WebElement Mrs_RB;
	
	//Radio Button Collection
	//div[@class='clearfix']//div[@class='radio-inline'][1]//div
	@FindBy(xpath = "//div[@class='clearfix']//div[@class='radio-inline'][1]//div")
	public static WebElement Gender_RB;
	
	
	
	//CustomerFirstName_Textbox
	 @FindBy(id = "customer_firstname")
	 public static WebElement FirstName_TB;
	 
	//CustomerLastName_Textbox
	 @FindBy(id = "customer_lastname")
	 public static WebElement LastName_TB;
	 
	 //Email_Textbox
	 @FindBy(id = "email")
	 public static WebElement Email_TB;
	 
	 //Password_Textbox
	 @FindBy(id = "passwd")
	 public static WebElement Password_TB;
	 
	//Days_DOB_Dropdown
	 @FindBy(id = "days")
	 public static WebElement DOBDays_DD;
	 
	//Months_DOB_Dropdown
	 @FindBy(id = "months")
	 public static WebElement DOBMonths_DD;
	 
	 //Years_DOB_Dropdown
	 @FindBy(id = "years")
	 public static WebElement DOBYears_DD;
	 
	 //Newsleter_Checkbox
	 @FindBy(id = "newsletter")
	 public static WebElement Newsletter_CB;
	 
	//OfferOptin_CB
	 @FindBy(id = "optin")
	 public static WebElement OfferOptin_CB;
	 
	 //AddressSectionTitle_Txt
	 @FindBy(xpath = "//form[@id = 'account-creation_form']/div[2]/h3")
	 public static WebElement AddressSectionTitle_Txt;
	 
	 //Address_FirstName_TB
	 @FindBy(id = "firstname")
	 public static WebElement FirstNameAdrs_TB;
	 
	//Address_LastName_TB
	 @FindBy(id = "lastname")
	 public static WebElement LastNameAdrs_TB;
	 
	 //Address_Company_TB
	 @FindBy(id = "company")
	 public static WebElement CompanyAdrs_TB;
	 
	 //Address1_Textbox
	 @FindBy(id = "address1")
	 public static WebElement Address1Adrs_TB;
	 
	 //Address2_Textbox
	 @FindBy(id = "address2")
	 public static WebElement Address2Adrs_TB;
	 
	 //Address2_Textbox
	 @FindBy(id = "city")
	 public static WebElement CityAdrs_TB;
		 
	 //State_DD
	 @FindBy(id = "id_state")
	 public static WebElement StateAdrs_DD;
	 
	 //ZipCode_TB
	 @FindBy(id = "postcode")
	 public static WebElement ZipCodeAdrs_TB;
		 
	 //CountryAdrs_DD
	 @FindBy(id = "id_country")
	 public static WebElement CountryAdrs_DD;
	 
	 //Additional information_TB
	 @FindBy(id = "other")
	 public static WebElement Additionalinfo_TB;
	 	 
	 //Homephone_TB
	 @FindBy(id = "phone")
	 public static WebElement HomephoneAdrs_TB;
	 
	 //MobilePhone_TB
	 @FindBy(id = "phone_mobile")
	 public static WebElement MobilePhoneAdrs_TB;
	 
	 //AddressAlias_TB
	 @FindBy(id = "alias")
	 public static WebElement AddressAliasAdrs_TB;
	 
	 //RegisterButton_Btn
	 @FindBy(id = "submitAccount")
	 public static WebElement RegisterButton_Btn;
	 
	 //Email_Errormessage
	 @FindBy(xpath = "//div[@class='alert alert-danger']//li")
	 public static WebElement Email_EM;
	  
	 	public WebElement validateRegistrationPage(String rowNumber) throws IOException, InterruptedException{
			//try {
				System.out.println("In validateRegistrationPage method ");
				xl_GetTestData1(rowNumber);
				gm_XLInput(Mr_RB, "Mr_RB", "Mr_RButton", 30);
				gm_XLInput(Mrs_RB, "Mrs_RB", "Mrs_RButton", 30);
				Thread.sleep(5000);
				gm_XLInput(FirstName_TB, "FirstName_tbx", "FirstName_tbox", 30);
				Thread.sleep(1000);
				System.out.println("1@");
				gm_XLInput(LastName_TB, "LastName_tbx", "LastName_tbox", 30);
				Thread.sleep(1000);System.out.println("1");
				gm_XLInput(Email_TB, "Email_tbx", "Email_tbox", 30);
				Thread.sleep(1000);System.out.println("11");
				gm_XLInput(Password_TB, "Password_tbx", "Password_tbox", 30);
				Thread.sleep(1000);System.out.println("111");
				gm_XLInput(DOBDays_DD, "DOB_DD", "DOB_DDwn", 30);
				Thread.sleep(1000);System.out.println("11111");
				gm_XLInput(DOBMonths_DD, "DOB_MM", "DOB_MMdwn", 30);
				//Thread.sleep(1000);System.out.println("111111");
				//gm_XLInput(DOBYears_DD, "DOB_YYYY", "DOB_YYYYdwn", 30);
				Thread.sleep(1000);System.out.println("1111111");
				gm_XLInput(Newsletter_CB, "Newsletter_CB", "Newsletter_CBox", 30);
				Thread.sleep(1000);System.out.println("11111111");
				gm_XLInput(OfferOptin_CB, "OfferOptin_CB", "OfferOptin_CBox", 30); 
				Thread.sleep(1000);System.out.println("1a");
				gm_XLInput(FirstNameAdrs_TB, "AdrsFirstName_Tbx", "AdrsFirstName_Tbox", 30);
				Thread.sleep(1000);System.out.println("1b");
				gm_XLInput(LastNameAdrs_TB, "AdrsLastName_Tbx", "AdrsLastName_Tbox", 30); 
				Thread.sleep(1000);System.out.println("1c");
				gm_XLInput(CompanyAdrs_TB, "AdrsCompanyName_Tbx", "AdrsCompanyName_Tbox", 30);
				Thread.sleep(1000);System.out.println("1d");
				gm_XLInput(Address1Adrs_TB, "Address1_Tbx", "Address1_Tbox", 30); 
				Thread.sleep(1000);System.out.println("1e");
				gm_XLInput(Address2Adrs_TB, "Address2_Tbx", "Address2_Tbox", 30);
				Thread.sleep(1000);System.out.println("1f");
				gm_XLInput(CityAdrs_TB, "City_Tbx", "City_Tbox", 30); 
				Thread.sleep(1000);System.out.println("1g");
				gm_XLInput(StateAdrs_DD, "State_DD", "State_Tbox", 30);
				Thread.sleep(1000);System.out.println("1h");
				gm_XLInput(ZipCodeAdrs_TB, "Zip/Postal Code_Tbx", "Zip/Postal Code_Tbox", 30);
				Thread.sleep(5000);System.out.println("1i");
				gm_XLInput(CountryAdrs_DD, "Country_DD", "Country_Ddwn", 30);
				Thread.sleep(5000);System.out.println("1j");
				gm_XLInput(Additionalinfo_TB, "Additional_information_Tbx", "Additional_information_Tbox", 30);
				Thread.sleep(5000);System.out.println("1k");
				gm_XLInput(HomephoneAdrs_TB, "Home_phone_Tbx", "Home_phone_Tbox", 30); 
				Thread.sleep(5000);System.out.println("1l");
				gm_XLInput(MobilePhoneAdrs_TB, "Mobile_phone_Tbx", "Mobile_phone_Tbox", 30);
				Thread.sleep(5000);System.out.println("1m");
				gm_XLInput(AddressAliasAdrs_TB, "AddressAlias_Tbx", "AddressAlias_Tbox", 30); 
				Thread.sleep(5000);System.out.println("1n");
				RegisterButton_Btn.click();
				Thread.sleep(5000);
				MyAccountPage  myAccoyuntPageObj=PageFactory.initElements(driverObj, MyAccountPage.class);
				Thread.sleep(5000);
				WebElement myAccountPageTitle = myAccoyuntPageObj.MyAccount_PageHeading_Txt;
				Thread.sleep(5000);
				gm_WaitVIsibility(myAccountPageTitle, 100);
				Thread.sleep(5000);
				return myAccountPageTitle;
			//	gm_ValidateText(we, ElementName, exp);
			//	gm_TakeSnapshot(driverObj, "Reports/Images/Passed/"+ElementName+"_+"+fn_GetTimeStamp()+".png");
			//} catch (Exception e) {
	 		//	e.printStackTrace();
	 		//	System.out.println(e.getMessage());
			//} 
		//}
		
			}
		
		
}





















