package com.a3hp.automationpracticee.framework.pageobject.myaccount;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;

public class MyAddressesPage extends UI_GenericMethods1{
	//MyAddresses_PageTitle_Txt
	@FindBy(xpath = "//div[@id='center_column']/h1")
	public static WebElement MyAddresses_PageHeading_Txt;
		
		
		
		
		
	//MyAddresses_PageTitle_Txt
	@FindBy(xpath = "//a[@title = 'Update']")
	public static WebElement MyAddresses_UpdateButton_Btn;
		
	//MyAddresses_PageTitle_Txt
	@FindBy(xpath = "//a[@title = 'Delete']")
	public static WebElement MyAddresses_DeleteButton_Btn;
		
	//MyAddresses_PageTitle_Txt
	@FindBy(xpath = "//a[@title = 'Add an address']")
	public static WebElement MyAddresses_AddAnAddress_Btn;	
		
	//MyAddresses_AddressTitle_Txt
	@FindBy(xpath = "//h3[contains(text(), 'AtlantaAddress1')]")
	public static WebElement MyAddresses_AddressTitle_Txt;
	
	//MyAddresses_AddressTitleCollection_Txt
	@FindBy(xpath = "//div//ul//h3")
	public static WebElement MyAddresses_AddressTitleCollection_Txt;	
		
	//Back To Your Account Button
	@FindBy(xpath = "//div[@id='center_column']//li[1]/a")
	public static WebElement MyAddresses_backToYourAccount_btn;

	//Home Button
	@FindBy(xpath = "//div[@id='center_column']//li[2]/a")
	public static WebElement MyAddresses_Home_btn;
		
	 public AddAddressPage navigateToAddAddressPage(){
		 driverObj.navigate().to("http://automationpractice.com/index.php?controller=address");
		 AddAddressPage addAddressPageObj = PageFactory.initElements(driverObj, AddAddressPage.class);
		  return addAddressPageObj;
	 }	
		
		
		
		
		
		
		
		
		
		
}
