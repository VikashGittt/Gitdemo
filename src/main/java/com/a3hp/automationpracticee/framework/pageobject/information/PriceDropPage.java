package com.a3hp.automationpracticee.framework.pageobject.information;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;
import com.google.common.base.Function;



public class PriceDropPage extends UI_GenericMethods1{
	//1. TopSeller
	//2. Sort By dropdown
	//3. View Grid/List
	//4. Product List
	
	
	//PageTitle_PriceDropPage_txt
	@FindBy(xpath = "//div[@id = 'center_column']/h1")
	public static WebElement  PageTitle_PriceDropPage_txt;
	
	//PageTitle_PriceDropPage_txt
	@FindBy(xpath = "//span[@class='navigation_page']")
	public static WebElement  Breadcrumb_PriceDropPage_txt;
	
	//Sort By Dropdown
	//div[@id = 'uniform-selectProductSort']
	@FindBy(id = "uniform-selectProductSort")
	public static WebElement  SortBy_PriceDropPage_DD;
	
	
	//Total Product count Text
	@FindBy(xpath = "//div[contains(@class,'top-pagination-content')]")
	public static WebElement  TotalProductCount_PriceDropPage_txt;
	
	
	//GridIcon
	@FindBy(id = "grid")
	public static WebElement  GridIcon_PriceDropPage_icon;
	
	
	//ListIcon
	@FindBy(xpath = "list")
	public static WebElement  ListIcon_PriceDropPage_icon;
	
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
	
	
	
	
	
	
	
	
	
	//ManufactureBlkTitleLnk__ManufacturesBlock
	
	@FindBy(xpath = "//div[@id = 'manufacturers_block_left']/p/a")
	public static WebElement  ManufactureBlkTitle_Lnk;
	
	//FashionManufacturer_Lnk__ManufacturesBlock
	@FindBy(xpath = "//div[@id = 'manufacturers_block_left']//li//a")
	public static WebElement  FashionManufacturer_Lnk;
 
	//AllMaFashionManufacturer_DD
	@FindBy(xpath = "//div[@id='manufacturers_block_left']//select[@class='form-control']")
	public static WebElement  AllMaFashionManufacturer_DD;
		
	//SpecialBlkTitleLnk__SpecialsBlock
	@FindBy(xpath = "//div[@id = 'special_block_right']/p/a")
	public static WebElement  SpecialBlkTitle_Lnk; 
	
	//AllspecialsBtn__SpecialsBlock
	@FindBy(xpath = "//a[@title = 'All specials']")
	public static WebElement  Allspecials_Btn; 
		
	//OurStoresBlkTitleLnk__OurStoresBlock
	@FindBy(xpath = "//div[@id = 'stores_block_left']/p/a")
	public static WebElement  OurStoresBlkTitle_Lnk; 
	
	//DiscoverOurStoresBtn__OurStores Block
	@FindBy(xpath = "//div/a[@title = 'Our stores']")
	public static WebElement  DiscoverOurStores_Btn; 
 	
	//SuppliersBlkTitleLnk__SupplierBlock
	@FindBy(xpath = "//div[@id = 'suppliers_block_left']/p/a")
	public static WebElement  SuppliersBlkTitle_Lnk; 
		
	//FashionSupplierLnk__SupplierBlock
	@FindBy(xpath = "//div[@id = 'suppliers_block_left']/div/a")
	public static WebElement  FashionSupplier_Lnk;

	//AllSuppliers_Lnk__SupplierBlock
	@FindBy(xpath = "//div[@id='suppliers_block_left']//select[@class='form-control']")
	public static WebElement  AllSuppliers_DD;

	
	
	
	
	
	
	
	
	
	
	public String getActualURL(final WebElement element) throws IOException, InterruptedException{
		System.out.println("In getActualURL Method");
		if(element.isDisplayed()==true){		
			System.out.println(element.isDisplayed());
			element.click();
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driverObj);
			wait.withTimeout(30, TimeUnit.SECONDS);
			wait.pollingEvery(5, TimeUnit.SECONDS);
			wait.ignoring(NoSuchElementException.class);
			Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driverObj) {
					return element; 
				}
			};
			wait.until(function);
		}
		String actualUrl = driverObj.getCurrentUrl();
		return actualUrl;
	}

	
























}
