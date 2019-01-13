package com.a3hp.automationpracticee.framework.pageobject.information;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;
import com.google.common.base.Function;


public class NewProductsPage extends UI_GenericMethods1{
	//Page Heading
	@FindBy(xpath = "//div[@id = 'center_column']/h1")
	public static WebElement pageTitle_NewProductPage_txt;
	
	//Page Breadcrumb
	@FindBy(xpath = "//span[@class ='navigation_page']")
	public static WebElement breadcrumb_NewProductPage_txt;
	
	//All Best Seller Button
	//parent -- id="best-sellers_block_right"
	@FindBy(xpath = "//a[@title = 'All best sellers']")
	public static WebElement AllBestSeller_btn;
	
	//Information Section Heading link
	@FindBy(xpath = "//section[@id = 'informations_block_left_1']/p/a")
	public static WebElement InfomationSection_HeadingLink_lnk;
	
	//Information Section Link Collection
	@FindBy(xpath = "//section[@id = 'informations_block_left_1']//li/a")
	public static WebElement InfomationSection_linkCollection_lnk;
	
	//Catgories Section-Women Link [need to check whether below mentioned common xpath can be used as colln or not
	////div[@id = 'categories_block_left']//a
	@FindBy(xpath = "//div[@id = 'categories_block_left']//a[contains(text(), 'Women')]")
	public static WebElement CatogriesSection_Women_lnk;
	
	//Catgories Section-Tops Link 
	@FindBy(xpath = "//div[@id = 'categories_block_left']//a[contains(text(), 'Tops')]")
	public static WebElement CatogriesSection_Tops_lnk;
	
	//Catgories Section-Casual Dresses Link
	@FindBy(xpath = "//div[@id = 'categories_block_left']//a[contains(text(), 'T-shirts')]")
	public static WebElement CatogriesSection_TShirts_lnk;
	
	//Catgories Section-Casual Dresses Link
	@FindBy(xpath = "//div[@id = 'categories_block_left']//a[contains(text(), 'Blouses')]")
	public static WebElement CatogriesSection_Blouses_lnk;
	
	//Catgories Section-Casual Dresses Link
  	@FindBy(xpath = "//div[@id = 'categories_block_left']//a[contains(text(), 'Dresses')]")
	public static WebElement CatogriesSection_Dresses_lnk;
	
	//Catgories Section-Casual Dresses Link
	@FindBy(xpath = "//div[@id = 'categories_block_left']//a[contains(text(), 'Casual Dresses')]")
	public static WebElement CatogriesSection_CasualDresses_lnk;
	
	//Catgories Section-Evening Dresses Link
	@FindBy(xpath = "//div[@id = 'categories_block_left']//a[contains(text(), 'Evening Dresses')]")
	public static WebElement CatogriesSection_EveningDresses_lnk;
	
	//Catgories Section-Summer Dresses Link
	@FindBy(xpath = "//div[@id = 'categories_block_left']//a[contains(text(), 'Summer Dresses')]")
	public static WebElement CatogriesSection_SummerDresses_lnk;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
