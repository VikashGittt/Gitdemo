package com.a3hp.automationpracticee.framework.pageobject.search;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage {

	@FindBy(xpath = "//h5//a[@title = 'Faded Short Sleeve T-shirts']")
	public static WebElement FadedShortSleeveTshirts_lnktxt;
	
	
	
	
	
	@FindBy(xpath = "//span[contains(.,'Faded Short Sleeve T-shirts')]")
	public static WebElement SearchKeyWord_txt;
	
}
