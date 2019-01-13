package com.a3hp.automationpracticee.framework.pageobject.information;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BestSellersPage {
 
	
	
	
	
	//PageTitle_BestSellersPage_txt
	@FindBy(xpath = "//div[@id = 'center_column']/h1")
	public static WebElement  PageTitle_BestSellersPage_txt;
	
	//Breadcrumb_BestSellersPage_txt
	@FindBy(xpath = "//span[@class='navigation_page']")
	public static WebElement  Breadcrumb_BestSellersPage_txt;
	
	//Sort By Dropdown
	//div[@id = 'uniform-selectProductSort']
	@FindBy(id = "uniform-selectProductSort")
	public static WebElement  SortBy_BestSellersPage_DD;
	
	
	//Total Product count Text
	@FindBy(xpath = "//div[contains(@class,'top-pagination-content')]")
	public static WebElement  TotalProductCount_BestSellersPage_txt;
	
	
	//GridIcon
	@FindBy(id = "grid")
	public static WebElement  GridIcon_BestSellersPage_icon;
	
	
	//ListIcon
	@FindBy(xpath = "list")
	public static WebElement  ListIcon_BestSellersPage_icon;
	
	//Product Block ImageLink Collection
	@FindBy(xpath = "//ul[contains(@class,'product_list')]/li//a[@class='product_img_link']")
	public static List <WebElement> productBlocksImageLinkCollection_imglnk;
	  
	//Product Block NameLink Collection
	@FindBy(xpath = "//ul[contains(@class,'product_list')]/li//h5/a")
	public static List <WebElement> productBlock_NameLinkCollection_lnk;
	  
	//Product Block More ButtonCollection
	@FindBy(xpath = "//ul[contains(@class,'product_list')]/li//a[@title='View']")
	public static List <WebElement> ProductBlock_MoreButtonCollection_btn;
	  
	//Product Block Add To Cart ButtonCollection
	@FindBy(xpath = "//ul[contains(@class,'product_list')]/li//a[@title='Add to cart']")
	public static List <WebElement> ProductBlock_AddToCartButtonCollection_btn;
		
	//Product Block Add_To_Wishlist ButtonCollection
	@FindBy(xpath = "//ul[contains(@class,'product_list')]/li//a[contains(text(), 'Add to Wishlist')]")
	public static List <WebElement> ProductBlock_AddToWishlistLinksCollection_link;
	
	//Product Block Add To Compare ButtonCollection
	@FindBy(xpath = "//ul[contains(@class,'product_list')]/li//a[contains(text(), 'Add to Compare')]")
	public static List <WebElement> ProductBlock_AddToCompareLinksCollection_link;
	
	
	
	
	
 
}
