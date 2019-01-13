package com.a3hp.automationpracticee.framework.pageobject.shoppingcartandcheckout;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {

	@FindBy(id = "cart_title")
	public static WebElement CheckoutPageTitle_txt;
	
	@FindBy(id = "summary_products_quantity")
	public static WebElement productCounter_txt;
	
	@FindBy(id = "order_step")
	public static WebElement checkoutSteps_txt;
	
	@FindBy(xpath = "//tr//p/a")
	public static List <WebElement> cartProduct_linktext;
	
	@FindBy(xpath = "//tr//small[2]")
	public static List <WebElement> cartProductAttribute_txt;
	
	//@FindBy(xpath = "//tr[contains(@id, 'product_price')]")
	@FindBy(xpath = "//tr//td[@class ='cart_unit']") 
	public static List <WebElement> cartProductUnitCost_txt;
	
	@FindBy(xpath = "//tr//td[contains(@class, 'cart_quantity')]") 
	public static List <WebElement> cartProductQuantity_txt;
	
	@FindBy(xpath = "//tr//td[contains(@class, 'cart_delete')]//a") 
	public static List <WebElement> cartProductDelete_Icon;	
	
	@FindBy(xpath = "//td[@id = 'total_product']") 
	public static WebElement cartTotalProductCost_txt;	
	
	@FindBy(xpath = "//td[@id= 'total_shipping']") 
	public static WebElement cartTotalShippingCost_txt;
	
	@FindBy(xpath = "//td[@id= 'total_price_without_tax']") 
	public static WebElement cartTotalPriceWithoutTax_txt;
	
	@FindBy(xpath = "//td[@id= 'total_tax']") 
	public static WebElement cartTotalTax_txt;
	
	@FindBy(xpath = "//span[@id= 'total_price']") 
	public static WebElement cartGrossTotal_txt;
	
	@FindBy(xpath = "//ul[contains(@class, 'first_item')]//h3") 
	public static WebElement deliveryAddressSectionTitle_txt;
	
	@FindBy(xpath = "//ul[contains(@class, 'first_item')]/li/span") 
	public static List <WebElement> deliveryAddressDetail_txt;
	
	@FindBy(xpath = "//ul[contains(@class, 'last_item')]//h3") 
	public static WebElement invoiceAddressSectionTitle_txt;
	
	@FindBy(xpath = "//ul[contains(@class, 'last_item')]/li/span") 
	public static List <WebElement> invoiceAddressDetail_txt;
	
	@FindBy(xpath = "//a[@title='Continue shopping']") 
	public static WebElement ContinueShopping_Linktxt;
	
	@FindBy(xpath = "//p/a[@title = 'Proceed to checkout']") 
	public static WebElement proceedToCheckout_Linktxt;
	
	@FindBy(xpath = "//input[@type = 'checkbox']") 
	public static WebElement termsandconditions_CB;
	
	@FindBy(xpath = "//p[@class = 'checkbox']//a") 
	public static WebElement termsandconditions_Link;
	
	
	
	
	
	
	
	
	
	

}
