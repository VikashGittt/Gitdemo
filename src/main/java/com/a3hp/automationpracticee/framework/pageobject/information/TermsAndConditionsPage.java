package com.a3hp.automationpracticee.framework.pageobject.information;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;

public class TermsAndConditionsPage extends UI_GenericMethods1 {

	
	
	
	
	 @FindBy(xpath = "//div[@id = 'center_column']//h1")
	 public static WebElement TermsAndConditionsPageTitle_txt;
	
	//BreadCrumb_T&CPage
	@FindBy(xpath = "//span[@class = 'navigation_page']")
	public static WebElement BreadCrumb_TermsAndConditions_txt;
	
	 
		
	
	
}
