package com.a3hp.automationpracticee.framework.genericclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.a3hp.automationpracticee.framework.pageobject.homepage.Homepage;




//This method not to be used


public class UI_GenericMethods_mini{
	
	protected static WebDriver driverObj;
	protected Homepage homeObj;

	
	/****************************************
	 * Launch Browser & URL
	 ****************************************************/

	/******************** Launch Browser **************************/

		public void gm_LaunchBrowser(String browserName){
			
		if (browserName.equalsIgnoreCase("CH") == true) {
			System.getProperty("webdriver.chrome.driver", "Please put Path here");
			driverObj = new ChromeDriver();
	
			// Launch Firefox browser
		} else if (browserName.equalsIgnoreCase("FF") == true) {
			System.getProperty("webdriver.gecko.driver", "Please put Path here");
			driverObj = new FirefoxDriver();		
		} else {
			System.out.println("Please enter correct browser name");
		}	
		 driverObj.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 driverObj.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		 driverObj.manage().window().maximize();

	}

	/******************** Open Site **************************/
	public static void gm_OpenURL(String URL) {
		driverObj.get(URL);
	}

	public Homepage gm_OpenApp(String BrowserName, String URL){
		System.out.println("In gm_OpenAp Method");
		gm_LaunchBrowser(BrowserName);
		try { //Just to wait for few seconds before and after URL launch
			Thread.sleep(10000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		gm_OpenURL(URL);  //URL Launched
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
		System.out.println("URL done");
		System.out.println("Now Homepage is in display");
		homeObj = PageFactory.initElements(driverObj, Homepage.class);
		return homeObj;
	}
}
