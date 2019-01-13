package com.a3hp.automationpracticee.framework.helperclasses;

/**
 * 
 * @author Bhanu Pratap Singh
 * https://www.udemy.com/seleniumbybhanu/
 * https://www.youtube.com/user/MrBhanupratap29/playlists
 *
 */
public class ConstantsHelper_v1{
	


	public final static String userName = "testdunkin5@gmail.com";
	public final static String password = "Qwertyui1";	
	public final static int explicitWait = 30;
	public final static int impliciteWait = 200;
	public final static int pageLoadTimeout = 400;
	public final static String BrowserName = "Chrome";
	public final static String URL = "http://automationpractice.com/index.php";
	
	public static String getUsername() {
		return userName;
		
	}
	public static String getPassword() {
		return password;
	}
	public static int getpageLoadTimeout() {
		return impliciteWait;
	}
	public static int getExplicitwait() {
		return explicitWait;
	}	
	public static int getImplicitewait() {
		return pageLoadTimeout;
	}
	
	public static String getBrowser() {
		return BrowserName;
	}
	public static String getURL() {
		return URL;
	}
}