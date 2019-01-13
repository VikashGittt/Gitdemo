package com.a3hp.automationpracticee.framework.pageobject.myaccount;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;

	public class MyWishlistPage extends UI_GenericMethods1{
		//MyWishlist_PageHeading_Txt
		@FindBy(xpath = "//div[@id='mywishlist']/h1")
		public static WebElement MyWishlist_PageHeading_Txt;
			
			
			
			
		
		//MyAccountPageHeading_Txt
		@FindBy(xpath = "//div[@id='mywishlist']//h3")
		public static WebElement MyWishlist_NewWishlistSectionHeading_txt;
		
		//MyWishlist_NameField_TB
		@FindBy(id = "name")
		public static WebElement MyWishlist_NameField_TB;
		
		//MyWishlist_Save_Btn
		@FindBy(id = "submitWishlist")
		public static WebElement MyWishlist_Save_Btn;
		
		//MyWishlist_AddedNameCollection
		@FindBy(xpath = "//tr/td[1]")
		public static WebElement MyWishlist_WishListNameCollection_txt;
		
		//MyWishlist_DeleteWishlistCollection
		@FindBy(xpath = "//tr/td[6]")
		public static WebElement MyWishlist_WishListDeleteIconCollection_Icon;
			
		//Back To Your Account Button
		@FindBy(xpath = "//div[@id='mywishlist']//li[1]/a")
		public static WebElement MyWishlist_backToYourAccount_btn;
	
		//Back To Your Account Button
		@FindBy(xpath = "//div[@id='mywishlist']//li[2]/a")
		public static WebElement MyWishlist_Home_btn;
}
