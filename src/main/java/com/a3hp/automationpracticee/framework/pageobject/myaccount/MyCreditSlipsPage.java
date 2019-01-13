package com.a3hp.automationpracticee.framework.pageobject.myaccount;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;

public class MyCreditSlipsPage extends UI_GenericMethods1{

	//MyCreditSlipsHeading_Txt
	@FindBy(xpath = "//div[@id='center_column']/h1")
	public static WebElement MyCreditSlips_PageHeading_Txt;
	
	
	
	
	//Back To Your Account Button
	@FindBy(xpath = "//div[@id='center_column']//li[1]/a")
	public static WebElement MyCreditSlips_backToYourAccount_btn;

	//Back To Your Account Button
	@FindBy(xpath = "//div[@id='center_column']//li[2]/a")
	public static WebElement MyCreditSlips_Home_btn;
	
	
	
}
