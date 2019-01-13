package com.a3hp.automationpracticee.framework.pageobject.information;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;


public class SitemapPage extends UI_GenericMethods1 {
	@FindBy(xpath = "//div[@id='center_column']")
	public static WebElement SitemapPageTitle_Txt;
	
	
	
	//BreadCrumb_SitemapPage
	@FindBy(xpath = "//span[@class = 'navigation_page']")
	public static WebElement BreadCrumb_SitemapPage_txt;
	
	//OurOffers Link Collection
	@FindBy(xpath = "//div[@id= 'sitemap_content']/div[1]//li/a")
	public static List<WebElement> OurOffersLinks_SitemapPage_lnk;
	
	//YOUR ACCOUNT Link Collection
	@FindBy(xpath = "//div[@id= 'sitemap_content']/div[2]//li/a")
	public static List<WebElement> YourAccountLinks_SitemapPage_lnk;
	
	//Categories Link Collection
	@FindBy(xpath = "//div[@id = 'listpage_content']/div[1]//a")
	public static List<WebElement> Categories_SitemapPage_lnk;
	
	//PAGES Link Collection
	@FindBy(xpath = "//div[@id = 'listpage_content']/div[2]//li/a")
	public static List<WebElement> Pages_SitemapPage_lnk;
	
	//TopSellers ProductsBlock ImLink Collection
	@FindBy(xpath = "//div[@id='best-sellers_block_right']//li/a")
	public static List<WebElement> TopSellers_ProductsBlock_SitemapPage_Imglnk;
	
	//TopSellers ProductsBlock NameLink Collection
	@FindBy(xpath = "	//div[@id='best-sellers_block_right']//li//h5/a")
	public static List<WebElement> TopSellers_ProductsBlocks_NameLinks_SitemapPage_lnk;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
