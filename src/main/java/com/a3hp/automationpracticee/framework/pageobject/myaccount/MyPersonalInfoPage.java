package com.a3hp.automationpracticee.framework.pageobject.myaccount;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;

public class MyPersonalInfoPage extends UI_GenericMethods1{
	//MyPersonalInfoPage_PageHeading_Txt
	@FindBy(xpath = "//div[@id='center_column']/h1")
	public static WebElement MyPersonalInfoPage_PageHeading_Txt;
		
		
		
		
	//MyPersonalInfoPage_backToYourAccount_btnn
	@FindBy(xpath = "//div[@id='center_column']//li[1]/a")
	public static WebElement MyPersonalInfoPage_backToYourAccount_btn;

	//Home Button
	@FindBy(xpath = "//div[@id='center_column']//li[2]/a")
	public static WebElement MyPersonalInfoPage_Home_btn;
}
