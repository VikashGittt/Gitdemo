package com.a3hp.automationpracticee.framework.pageobject.createaccountandlogin;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;
import com.a3hp.automationpracticee.framework.helper.TestBase.TestBasee;
import com.a3hp.automationpracticee.framework.pageobject.myaccount.MyAccountPage;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class ForgotPasswordPage extends TestBasee{
	
	// public ForgotPasswordPage(WebDriver driverObj) {
	//	super(driverObj);
		
//}


	@FindBy(xpath = "//div[@class = 'box']/h1")
	 public static WebElement ForGotPassword_PgTtl;

	 @FindBy(id = "email")
	 public static WebElement ForgotPassword_EmailAddress_TB;
	 
	 @FindBy(xpath = "//form[@id = 'form_forgotpassword']//button")
	 public static WebElement retrievePassword_Btn;
	 
	 @FindBy(xpath = "//a[@title = 'Back to Login']")
	 public static WebElement BackToLogin_Btn;
	 
	 @FindBy(xpath = "//p[contains(@class, 'alert-success')]")
	 public static WebElement forgotPwdConfirmationMesg_txt;
	
		public ForgotPasswordPage(){
			System.out.println("1");
	    	TestDataPath1="TestData/ForgotPasswordPage/ForgotPasswordPage.xlsx";
	    	TDSheetName1="Login_Page";
	    	System.out.println("2");
	    }
	 public String validateForgotPassword(String rownum) throws IOException{
		System.out.println("In validateForgotPassword method");	
		 xl_GetTestData1(rownum);
			gm_XLInput(ForgotPassword_EmailAddress_TB, "Email_tbx", "Email_tbox", 30);			
			System.out.println("^^^^^^^^^^^^^^^^^");
			HashMap<String, Object> testData_HM = new HashMap<String, Object>();
			System.out.println("%%%%%%%%%%%%%%%%%%");
			//String emailvalue = testData_HM.get("Email_tbx").toString();
			String emailValue1 = ForgotPassword_EmailAddress_TB.getAttribute("value");
			System.out.println("emailValue1: "+emailValue1);
			String emailValue2 = ForgotPassword_EmailAddress_TB.getAttribute("innerHTML");
			System.out.println("emailValue2: "+emailValue2);
			System.out.println("*******************");
			if(retrievePassword_Btn.isDisplayed()==false){
				System.out.println("In If block of validateForgotPassword");
				gm_WaitVIsibility(retrievePassword_Btn, 25);
				System.out.println("Out of validateForgotPasswordblock method");
			}else{
				System.out.println("element.isDisplayed() --> "+retrievePassword_Btn.isDisplayed());
			}
			retrievePassword_Btn.click();
	    	//ForgotPasswordPage  forgotpasswordPageObj=PageFactory.initElements(driverObj, ForgotPasswordPage.class);
			return emailValue1; 
		}
}
