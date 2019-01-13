package com.a3hp.automationpracticee.framework.pageobject.createaccountandlogin;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.a3hp.automationpracticee.framework.genericclasses.UI_GenericMethods1;
import com.a3hp.automationpracticee.framework.helper.TestBase.TestBasee;
import com.a3hp.automationpracticee.framework.pageobject.myaccount.MyAccountPage;

 
public class SignInPage extends TestBasee{
	
	 @FindBy(xpath = "//div[@class='breadcrumb clearfix']/a")
	 public static WebElement HomeIcon_Brdcrmb;
	
	 ///////////////////Registration/////////////////
	 @FindBy(xpath = "//span[@class='navigation_page']")
	 public static WebElement Brdcrmb_SignIn_Txt;
	
	 @FindBy(xpath = "//h3[contains(text(), 'Create an account')]")
	 public static WebElement SectionHeading_CreateAccount_txt;
	 
	 @FindBy(id  = "email_create")
	 public static WebElement Reg_Emailaddress_TB;
	
	 @FindBy(id  = "SubmitCreate")
	 public static WebElement CreateAccount_Btn;
	
	 ////////////////////////////Sign In///////////////////////*
	
	 @FindBy(xpath = "//div[@id = 'center_column']/h1")
	 public static WebElement PageHeading_SignIn_txt;
	 
	 @FindBy(xpath = "//h3[contains(text(), 'Already registered?')]")
	 public static WebElement SectionHeading_SignIn_txt;
	 
	 @FindBy(id  = "email")
	 public static WebElement SignIn_Email_TB;
	 
	 @FindBy(id  = "passwd")
	 public static WebElement SignIn_Password_TB;
	
	 @FindBy(id = "SubmitLogin")
	 public static WebElement SignIn_Btn;
	 
	 @FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	 public static WebElement ForgotPassword_Lnk;
	 
	 @FindBy(xpath = "//div[@id = 'center_column']/h1")
	 public static WebElement MyAccountHeading_Lnk;
	
		public SignInPage(WebDriver driverObj){
			this.driverObj = driverObj;
			System.out.println("1");
			TestDataPath1="TestData/LoginPage/LoginPage.xlsx";
	    	TDSheetName1="Login_Page";
	    	System.out.println("2");
	    	 
	    	 
	    }
		
		public ForgotPasswordPage navigateToForgotPasswordPage(){
			  driverObj.navigate().to("http://automationpractice.com/index.php?controller=password");
			  ForgotPasswordPage forgotPasswordPageObj = PageFactory.initElements(driverObj, ForgotPasswordPage.class);
			  return forgotPasswordPageObj;
		}
		  
		public MyAccountPage validateLogin(String rownum) throws IOException{
			System.out.println("In Validatelogin method");
			xl_GetTestData1(rownum);
			gm_XLInput(SignIn_Email_TB, "SignIn_Email_tbx", "SignIn_Email_tbox", 30);
	    	gm_XLInput(SignIn_Password_TB, "SignIn_Password_tbx", "SignIn_Password_tbox", 30);
	    	SignIn_Btn.click();
	    	MyAccountPage  myAccoyuntPageObj=PageFactory.initElements(driverObj, MyAccountPage.class);
			return myAccoyuntPageObj; 
		}
	
		public RegistrationPage validateCreateAccountBtn(String rownum) throws IOException, InterruptedException{
			System.out.println("In validateCreateAccountBtn Method");
			xl_GetTestData1(rownum);
			gm_XLInput(Reg_Emailaddress_TB, "Reg_Email_tbx", "Reg_TBox", 30);
	      	CreateAccount_Btn.click();
	      	//Thread.sleep(30000);
	      
			
	    	//NavObject=PageFactory.initElements(driverObj, Navigation.class);
	    	RegistrationPage  registrationPageObj=PageFactory.initElements(driverObj, RegistrationPage.class);
			return registrationPageObj; 
		}
		public void validate_ForgotPasswordLink() throws IOException{
			ForgotPassword_Lnk.click();
			String actualURL = driverObj.getCurrentUrl();
	    	 
		}

}
