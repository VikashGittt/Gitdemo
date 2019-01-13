package com.a3hp.automationpracticee.framework.pageobject.information;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;
import com.a3hp.automationpracticee.framework.pageobject.myaccount.MyAccountPage;

public class ContactUsPage extends UI_GenericMethods1 {
	
	
	
	public ContactUsPage(){
		System.out.println("1");
		TestDataPath1="TestData/ContactUsPage/ContactUsPage.xlsx";
    	TDSheetName1="ContactUs_Page";
    	System.out.println("2");
    }
	
	//ContactUsPageHeading
	@FindBy(xpath = "//div[@id = 'center_column']/h1")
	public static WebElement PageHeading_ContactUsPage_Txt;
	
	//ContactUsPageBreadcrumb
	@FindBy(xpath = "//span[@class='navigation_page']")
	public static WebElement breadCrumb_ContactUsPage_Txt;
	
	//SubjectHeadingDropdown
	@FindBy(id = "id_contact")
	public static WebElement SubjectHeading_DD;
	
	
	//Email Address TextBox
	@FindBy(id = "email")
	public static WebElement EmailAddress_TB;
	
	//Order reference TextBox
	@FindBy(id = "id_order")
	public static WebElement OrderReference_TB;
	
	//Attach File TextBox
	@FindBy(id = "fileUpload")
	public static WebElement fileUpload_TB;
	
	//Attach File TextBox
	@FindBy(xpath = "//span[@class = 'action']")
	public static WebElement fileUpload_Btn;
	
	//Message Box
	@FindBy(id = "message")
	public static WebElement MessageBox_MB;
	
	//Send Button
	@FindBy(id = "submitMessage")
	public static WebElement SendBtn_Btn;
	
	//Home Button
	
	@FindBy(xpath = "//ul[contains(@class, 'footer_links')]//a")
	public static WebElement HomeBtn_Btn;
	
	
	//ContactUsConfirmationMessage
	@FindBy(xpath = "//div[@id='center_column']/p")
	public static WebElement ContactUsConfirmationMessage_txt;
	
	public ContactUsPage validateContactUsProcess(String rownum) throws IOException{
		xl_GetTestData1(rownum);
		gm_XLInput(SubjectHeading_DD, "SubjectHeading_DD", "Subject Heading_DDwn", 30);
    	gm_XLInput(EmailAddress_TB, "Emailaddress_Tbx", "Emailaddress_Tbx", 30);
    	gm_XLInput(OrderReference_TB, "Orderreference_Tbx", "Orderreference_Tbox", 30);
    	//Upload field - To code using AutoIt
    	gm_XLInput(MessageBox_MB, "MessageBox_Mbx", "MessageBox_Mbox", 30);
    	SendBtn_Btn.click();
    	ContactUsPage contactUsPageObj=PageFactory.initElements(driverObj, ContactUsPage.class);
		return contactUsPageObj;
    	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
