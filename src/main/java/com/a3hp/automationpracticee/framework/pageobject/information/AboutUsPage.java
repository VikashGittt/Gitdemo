package com.a3hp.automationpracticee.framework.pageobject.information;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;

public class AboutUsPage extends UI_GenericMethods1 {
	
	
	//AboutUsPageTitle
	@FindBy(xpath = "//div[@id = 'center_column']//h1")
	public static WebElement AboutUsPageTitle_Txt;
	
	//BreadCrumb_AboutUsPage
	@FindBy(xpath = "//span[@class = 'navigation_page']")
	public static WebElement BreadCrumb_AboutUs_txt;
		
 
	

	
	
}
