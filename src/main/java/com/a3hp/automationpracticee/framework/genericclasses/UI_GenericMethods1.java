package com.a3hp.automationpracticee.framework.genericclasses;

//1.1: OldgetbrowserMethod + ObjectRepositoryFile
//1.2: OldgetbrowserMethod + Constant
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.exec.OS;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.a3hp.automationpracticee.framework.enums.BrowserTypeHelper_v1;
import com.a3hp.automationpracticee.framework.enums.OSNameHelper_v1;
import com.a3hp.automationpracticee.framework.helperclasses.ConstantsHelper_v1;
import com.a3hp.automationpracticee.framework.helperclasses.ResourceHelper_v1;
import com.a3hp.automationpracticee.framework.pageobject.homepage.Homepage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
 



public class UI_GenericMethods1 extends XL_GenericMethods {
	public static final String ConfigFilePath = "config/config.properties";
	public static WebDriver driverObj, driverObj1;
	public static Properties ConfigObject;
	protected Homepage homeObj;
	public ArrayList<String> imagePathList;	
	protected static EdgeOptions edgeOptions;	
	protected static FirefoxOptions ffOptions;
	String OSName;
	//protected static WebDriver ffDriver; 	[To Be Deleted]
	//String locatorType1; 					[To Be Deleted]
	//String value1;	 					[To Be Deleted]
	//static String ele_xpathh; 			[To Be Deleted]
	//static String ele_idd; 				[To Be Deleted]
	//static String ele_Name; 				[To Be Deleted]
	//static String ele_className; 			[To Be Deleted]
	//static String name; 					[To Be Deleted]
	//static String ele_linkText; 			[To Be Deleted]	
	
	
	//////////////////////////////////// Log Configuration//////////////////////////////////////////
	public void gm_ConfigureLog4J() throws IOException {

		Properties p = new Properties();
		String log4jPath = gm_GetConfigValue("log4JPropPath");
		p.load(new FileInputStream(log4jPath));
		PropertyConfigurator.configure(p);
	}

	public void gm_WriteToLog(String Msg, String LogType) throws IOException {
		DOMConfigurator.configure("log4j.xml");
		Logger logger = Logger.getLogger(this.getClass().getName());// UI_GenericMethods1.class.getName());
		if (LogType.equalsIgnoreCase("I")) {
			logger.info(Msg);
		} else if (LogType.equalsIgnoreCase("D")) {
			logger.debug(Msg);
		} else if (LogType.equalsIgnoreCase("E")) {
			logger.error(Msg);
		} else if (LogType.equalsIgnoreCase("W")) {
			logger.warn(Msg);
		}

	}

	public void gm_WriteToLog(String Msg, String LogType, String ClassName) throws IOException {
		ConfigObject = new Properties();
		FileInputStream fis = new FileInputStream(ConfigFilePath);
		ConfigObject.load(fis);
	}

	public void gm_LoadCOnfigFile() throws IOException {
		ConfigObject = new Properties();
		FileInputStream fis = new FileInputStream(ConfigFilePath);
		ConfigObject.load(fis);
		
	}

	public String gm_GetConfigValue(String propName) throws IOException {
		if (ConfigObject == null) {
			gm_LoadCOnfigFile();
		}
		String PropValue = ConfigObject.getProperty(propName);
		return PropValue;
	}

	/******************** Wait Visibility **************************/
	public void gm_WaitVIsibility(WebElement we, int timeOut_Sec) {
		System.out.println("In gm_WaitVIsibility method");
		WebDriverWait wtObj = new WebDriverWait(driverObj, timeOut_Sec);
		System.out.println("Check for expected Condition");
		wtObj.until(ExpectedConditions.visibilityOf(we));

	}

	/******************** Wait forURL **************************/
	public void gm_WaitforURLDisplay(String URL, int timeOut_Sec) {
		System.out.println("In gm_WaitforURLDisplay method");
		WebDriverWait wtObj = new WebDriverWait(driverObj, timeOut_Sec);
		System.out.println("Check for expected Condition");
		wtObj.until(ExpectedConditions.urlToBe(URL));

	}

	/******************** Wait Clickable **************************/
	public void gm_WaitClickable(WebElement we, int timeOut_Sec) {
		WebDriverWait wtObj = new WebDriverWait(driverObj, timeOut_Sec);
		wtObj.until(ExpectedConditions.elementToBeClickable(we));

	}

	/******************** Check Clickable Status **************************/
	public boolean gm_isClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driverObj, 5);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	///////////////////////// This method to be replaced by Fluent Wait
	public void gm_WaitVIsibility_Java(WebElement we, int timeOut_Sec) {
		driverObj.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		int time = 0;
		while (we.isDisplayed() == false && time >= timeOut_Sec) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			time = time + 1;
		}
		driverObj.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

									/************************************************************
									 				* Launch Browser & URL
									 ************************************************************/

									/******************** Launch Browser **************************/

	public void gm_LaunchBrowser(String browserName) throws IOException, InstantiationException, IllegalAccessException {
			
			// Launch IE11 browser
		if (browserName.equalsIgnoreCase("IE") == true) {
			driverObj = getIExplorerDriver(getIExplorerCapabilities());
			gm_WriteToLog("IE has been launched", "I");

			// Launch Chrome browser
		} else if (browserName.equalsIgnoreCase("CH") == true) {
			driverObj = getChromeDriver(getChromeCapabilities());
			gm_WriteToLog("Chrome has been launched", "I");

			// Launch Firefox browser
		} else if (browserName.equalsIgnoreCase("FF") == true) {
			driverObj = getFirefoxDriver(getFirefoxCapabilities());
			gm_WriteToLog("Firefox has been launched", "I");

			// Launch Edge Browser
		
		} else if (browserName.equalsIgnoreCase("ED") == true) {
			driverObj = getMicrosoftEdgeDriver(getMicrosoftEdgeCapabilities());
			gm_WriteToLog("MicrosoftEdge has been launched", "I");

		} else if (browserName.equalsIgnoreCase("Safari") == true) {
			System.out.println("//Need to write code here for Safari");
			gm_WriteToLog("Safari has been launched", "I");
		
		} else if (browserName.equalsIgnoreCase("Opera") == true) {
			System.out.println("//Need to write code here for Opera");
			gm_WriteToLog("Opera has been launched", "I");
		
		} else {
			System.out.println("Please enter correct browser name");
		}
		// int implicitlyWait_Value = ObjectRepo.reader.getPageLoadTimeOut();
		 int pageLoadTimeOut_Value = ConstantsHelper_v1.getpageLoadTimeout();
		 int implicitlyWait_Value = ConstantsHelper_v1.getImplicitewait();
		 driverObj.manage().timeouts().implicitlyWait(implicitlyWait_Value, TimeUnit.SECONDS);
		 driverObj.manage().timeouts().pageLoadTimeout(pageLoadTimeOut_Value, TimeUnit.SECONDS);
		 //driverObj.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 driverObj.manage().window().maximize();

	}

	/******************** Open Site **************************/
	public void gm_OpenURL(String URL) {
		driverObj.get(URL);
	}

	public Homepage gm_OpenApp(String BrowserName, String URL, String OSName)		throws IOException, InterruptedException, InstantiationException, IllegalAccessException {
		System.out.println("In gm_OpenAp Method");
		this.OSName = OSName;
		System.out.println(BrowserName+" -- "+URL);		
		gm_LaunchBrowser(BrowserName);
		System.out.println("Browsrname done");
		Thread.sleep(2000);
		gm_OpenURL(URL);
		Thread.sleep(2000);
		System.out.println("URL done");
		System.out.println("Now Homepage is in display");
		gm_WriteToLog("Homepage is in display", "I");
		homeObj = PageFactory.initElements(driverObj, Homepage.class); 
		return homeObj;
	}

	/*********************************************Desired Capability of Chrome BROWSER*********************************************/
	public ChromeOptions getChromeCapabilities() {

		ChromeOptions chOptions = new ChromeOptions();
		chOptions.addArguments("start-maximized");
		chOptions.addArguments("disable-infobars");
		chOptions.setAcceptInsecureCerts(true);
		chOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		chOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		/***Simple Technique***/
		chOptions.setCapability(CapabilityType.BROWSER_NAME, BrowserTypeHelper_v1.Chrome);//1
		chOptions.setCapability(CapabilityType.PLATFORM_NAME, OSNameHelper_v1.WINDOWS); //2
		
		
		/***Advanced Technique***/
	 /*	if (OSSName.equalsIgnoreCase("WINDOWS")||OSSName.contains("Windows")) { //3 (8steps): After grid implementation, 1&2 to be replaced by 3 
			chOptions.setCapability(CapabilityType.PLATFORM_NAME, OSName.WINDOWS);
		} else if (OSSName.contains("MAC")||OSSName.contains("Mac")) {
			chOptions.setCapability(CapabilityType.PLATFORM_NAME, OSName.MAC);
		} else if (OSSName.contains("LINUX")||OSSName.contains("Linux")) {
			chOptions.setCapability(CapabilityType.PLATFORM_NAME, OSName.LINUX);
		} else {
			System.out.println("Please specify correct OS");
		}*/
	 
		chOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		chOptions.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
		chOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
		chOptions.setCapability(CapabilityType.SUPPORTS_SQL_DATABASE, true);
		chOptions.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
		return chOptions;
		// For use with RemoteWebDriver: IMPORTANT
		/*
		 * RemoteWebDriver driver = new RemoteWebDriver( new URL("http://localhost:4444/wd/hub"), new ChromeOptions());
		 */

	}
	

	
	public WebDriver getChromeDriver(ChromeOptions chOptions) throws InstantiationException, IllegalAccessException {
		/***Simple Technique***/
		String chromeDriverPath = "MasterFiles\\Drivers\\ChromeDriver\\Chromedriver_win32_v2.38\\chromedriver.exe";
	 	System.setProperty("webdriver.chrome.driver", ResourceHelper_v1.getResourcePath(chromeDriverPath));
	 	return new ChromeDriver(chOptions);
		
		/***Advanced Technique***/
	/* 	System.out.println("OSName "+ OSSName);
			 if (OSSName.contains("WINDOWS")||OSSName.contains("Windows")) {
				System.setProperty("webdriver.chrome.driver", ResourceHelper_v1.getResourcePath(chromeDriverPath));
				return new ChromeDriver(chOptions);
			}else if (OSSName.contains("MAC")||OSSName.contains("Mac")) {
				System.setProperty("webdriver.chrome.driver", ResourceHelper_v1.getResourcePath(chromeDriverPath));
				return new ChromeDriver(chOptions);
			}else if (OSSName.contains("LINUX")||OSSName.contains("Linux")) {
				System.setProperty("webdriver.chrome.driver", ResourceHelper_v1.getResourcePath(chromeDriverPath));
				return new ChromeDriver(chOptions);
			}
			return null;   */
	}

	/*****************************************Desired Capability of Firefox BROWSER************************************/
	

	public FirefoxOptions getFirefoxCapabilities() {
		ffOptions = new FirefoxOptions();
		ProfilesIni ffprofile = new ProfilesIni();
		FirefoxProfile ffxprofile = ffprofile.getProfile("SeleniumProfile1");
		ffxprofile.setAcceptUntrustedCertificates(true);
		ffxprofile.setAssumeUntrustedCertificateIssuer(true);
		ffOptions.setCapability(FirefoxDriver.PROFILE, ffxprofile); //
		ffOptions.setCapability("marionette", true);
		ffOptions.setAcceptInsecureCerts(true);
		ffOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		ffOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ffOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		ffOptions.setCapability(CapabilityType.BROWSER_NAME, BrowserTypeHelper_v1.Firefox);
		
		/***Simple Technique***/
		//ffOptions.setCapability(CapabilityType.PLATFORM_NAME, OSNameHelper_v1.WINDOWS);
		 

		/***Advanced Technique***/
		if (OSName.contains("WINDOWS")||OSName.contains("Windows")) {
			ffOptions.setCapability(CapabilityType.PLATFORM_NAME, OSNameHelper_v1.WINDOWS);
		} else if (OSName.contains("MAC")||OSName.contains("Mac")) {
			ffOptions.setCapability(CapabilityType.PLATFORM_NAME, OSNameHelper_v1.MAC);
		} else if (OSName.contains("LINUX")||OSName.contains("Linux")) {
			ffOptions.setCapability(CapabilityType.PLATFORM_NAME, OSNameHelper_v1.LINUX);
		} else {
			System.out.println("Please specify correct OS");
		} 
		ffOptions.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
		ffOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
		ffOptions.setCapability(CapabilityType.SUPPORTS_SQL_DATABASE, true);
		ffOptions.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
		ffOptions.setCapability("marionette", true);
		return ffOptions;

	}

	public WebDriver getFirefoxDriver(FirefoxOptions ffOptions) {
		/***Simple Technique***/
		String geckoDriverPath = "MasterFiles\\Drivers\\GeckoDriver\\64Bit\\v23\\geckodriver.exe";
	  	System.setProperty("webdriver.gecko.driver", ResourceHelper_v1.getResourcePath(geckoDriverPath));
	  	return new FirefoxDriver(ffOptions);
		
		/***Advanced Technique***/
		/* 	 if (OSName.contains("WINDOWS")||OSName.contains("Windows")) {
		 		System.setProperty("webdriver.gecko.driver", ResourceHelper_v1.getResourcePath(geckoDriverPath));
		 		return new FirefoxDriver(ffOptions);
		 	} else if (OSName.contains("MAC")||OSSName.contains("Mac")) {
				System.setProperty("webdriver.gecko.driver", ResourceHelper_v1.getResourcePath(geckoDriverPath));
				return new FirefoxDriver(ffOptions);
		 	} else if (OSName.contains("LINUX")||OSSName.contains("Linux")) {
		 		System.setProperty("webdriver.gecko.driver", ResourceHelper_v1.getResourcePath(geckoDriverPath));
		 		return new FirefoxDriver(ffOptions);
		}
		return null;  */
	}

	/******************************Desired Capability of InternetExplorer****************************************/
	public InternetExplorerOptions getIExplorerCapabilities() {
		InternetExplorerOptions IEOptions = new InternetExplorerOptions();
		IEOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		IEOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		IEOptions.setCapability(CapabilityType.BROWSER_NAME, BrowserTypeHelper_v1.Iexplorer);
		
		if (OSName.contains("WINDOWS")||OSName.contains("Windows")) {
			IEOptions.setCapability(CapabilityType.PLATFORM_NAME, OSNameHelper_v1.WINDOWS);
		} else if (OSName.contains("MAC")||OSName.contains("Mac")) {
			IEOptions.setCapability(CapabilityType.PLATFORM_NAME, OSNameHelper_v1.MAC);
		} else if (OSName.contains("LINUX")||OSName.contains("Linux")) {
			IEOptions.setCapability(CapabilityType.PLATFORM_NAME, OSNameHelper_v1.LINUX);
		} else {
			System.out.println("Please specify correct OS");
		} 
	
		IEOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
		IEOptions.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		IEOptions.setCapability(CapabilityType.SUPPORTS_SQL_DATABASE, true);
		IEOptions.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
		IEOptions.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
		IEOptions.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
		IEOptions.ignoreZoomSettings();
		return IEOptions;
	}

	public WebDriver getIExplorerDriver(InternetExplorerOptions IEOptions) {
		String ieDriverServerPath = "MasterFiles\\Drivers\\IEDriverServer\\64Bit\\3.14.0\\IEDriverServer.exe";
		if (OSName.contains("WINDOWS")||OSName.contains("Windows")) {			
			System.setProperty("webdriver.ie.driver", ResourceHelper_v1.getResourcePath(ieDriverServerPath));
			return new InternetExplorerDriver(IEOptions);
		} else if (OSName.contains("MAC")||OSName.contains("Mac")) {
			System.out.println("In Else");
			System.setProperty("webdriver.ie.driver", ResourceHelper_v1.getResourcePath(ieDriverServerPath));
			return new InternetExplorerDriver(IEOptions);
		} else if (OSName.contains("LINUX")||OSName.contains("Linux")) {
			System.out.println("In Else");
			System.setProperty("webdriver.ie.driver", ResourceHelper_v1.getResourcePath(ieDriverServerPath));
			return new InternetExplorerDriver(IEOptions);
		}
		return null;
	}

	
	
	
	
	////////// *****Desired Capability of MicrosoftEdge BROWSER*****//////////
	public EdgeOptions getMicrosoftEdgeCapabilities() {
		edgeOptions = new EdgeOptions();
		edgeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		edgeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		edgeOptions.setCapability(CapabilityType.BROWSER_NAME, BrowserTypeHelper_v1.MicrosoftEdge);
		
		if (OSName.contains("WINDOWS")||OSName.contains("Windows")) {
			edgeOptions.setCapability(CapabilityType.PLATFORM_NAME, OSNameHelper_v1.WINDOWS);
		} else if (OSName.contains("MAC")||OSName.contains("Mac")) {
			edgeOptions.setCapability(CapabilityType.PLATFORM_NAME, OSNameHelper_v1.MAC);
		} else if (OSName.contains("LINUX")||OSName.contains("Linux")) {
			edgeOptions.setCapability(CapabilityType.PLATFORM_NAME, OSNameHelper_v1.LINUX);
		} else {
			System.out.println("Please specify correct OS");
		}		
		edgeOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
		edgeOptions.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		edgeOptions.setCapability(CapabilityType.SUPPORTS_SQL_DATABASE, true);
		edgeOptions.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
		edgeOptions.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
		edgeOptions.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
		return edgeOptions;
	}

	public WebDriver getMicrosoftEdgeDriver(EdgeOptions edgeOptions) {
		String microsoftWebDriverPath = "MasterFiles\\Drivers\\EdgeDriver\\MicrosoftWebDriver.exe";
		 if (OSName.contains("WINDOWS")||OSName.contains("Windows")) {			
			System.setProperty("webdriver.edge.driver",	ResourceHelper_v1.getResourcePath(microsoftWebDriverPath));
			return new EdgeDriver(edgeOptions);
		} else if (OSName.contains("MAC")||OSName.contains("Mac")) {
			System.out.println("In Else");
			System.setProperty("webdriver.edge.driver",	ResourceHelper_v1.getResourcePath(microsoftWebDriverPath));
			return new EdgeDriver(edgeOptions);
		} else if (OSName.contains("LINUX")||OSName.contains("Linux")) {
			System.out.println("In Else");
			System.setProperty("webdriver.edge.driver",	ResourceHelper_v1.getResourcePath(microsoftWebDriverPath));
			return new EdgeDriver(edgeOptions);
		}
		return null;
	}

	////////// *****Desired Capability of HTML UNIT BROWSER*****//////////

	public Capabilities getHtmlUnitDriverCapabilities() {
		DesiredCapabilities unit = DesiredCapabilities.htmlUnit();
		unit.setAcceptInsecureCerts(true);
		unit.setCapability(CapabilityType.BROWSER_NAME, BrowserTypeHelper_v1.HtmlUnitDriver);
		if (OSName.contains("WINDOWS")||OSName.contains("Windows")) {
			unit.setCapability(CapabilityType.PLATFORM_NAME, OSNameHelper_v1.WINDOWS);
		} else if (OSName.contains("MAC")||OSName.contains("Mac")) {
			unit.setCapability(CapabilityType.PLATFORM_NAME, OSNameHelper_v1.MAC);
		} else if (OSName.contains("LINUX")||OSName.contains("Linux")) {
			unit.setCapability(CapabilityType.PLATFORM_NAME, OSNameHelper_v1.LINUX);
		} else {
			System.out.println("Please specify correct OS");
		}
		unit.setJavascriptEnabled(true);
		System.out.println(unit.getBrowserName());
		unit.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		unit.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
		unit.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
		return unit;

	}

	public WebDriver getHtmlUnitDriver(Capabilities unit) {
		// unit = htmlBrowser.getHtmlUnitDriverCapabilities();

		if (OSName.contains("WINDOWS")||OSName.contains("Windows")) {
			System.out.println("In Else");
			return new HtmlUnitDriver(unit);
		}else if (OSName.contains("MAC")||OSName.contains("Mac")) {
			return new HtmlUnitDriver(unit);
		}else if (OSName.contains("LINUX")||OSName.contains("Linux")) {
			System.out.println("In Elseif");
			return new HtmlUnitDriver(unit);
		}
		return null;

	}

	/**********************************************************Input Method*************************************************************/
						/**************************************** Field******************************************/
	
	public String inputValuesTextField(WebElement element, String inputVal) {
		try {
			element.clear();
			element.sendKeys(inputVal);
			gm_WriteToLog(inputVal + "has been entered in " + element, "I");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return inputVal;
	}

	public void gm_InputValuesTextField(WebElement we, String inputValue, String WEName, int timeout_Seconds) throws IOException {
		try {
			we.clear();
			we.sendKeys(inputValue);
			gm_WriteToLog(inputValue + "has been entered in " + WEName, "I");
		} catch (NoSuchElementException ne) {
			gm_WaitVIsibility(we, timeout_Seconds);
			gm_WriteToLog("NoSuchElementException found", "I");
		} catch (ElementNotVisibleException nv) {
			gm_WriteToLog(WEName + " is not visible", "E");
			gm_WriteToLog("ElementNotVisibleException found", "I");
		} catch (StaleElementReferenceException se) {
			System.out.println(se.getMessage());			 
			gm_WriteToLog("StaleElementReferenceException found", "I");
		}

	}

	public void gm_XLInput(WebElement we, String ColumnName_Key, String WEName, int timeout_Seconds)throws IOException {
		try {
			String InputValue = (String) testData_HM.get(ColumnName_Key);
			String tagName = we.getTagName();
			String TypeName = we.getAttribute("type");
			if (tagName.equalsIgnoreCase("select")) {
				Select selectObj = new Select(we);
				int indexnum = -1;
				try { // For Date Value
					indexnum = Integer.parseInt(InputValue);
					Integer indexnum1 = new Integer(indexnum);
					System.out.println(indexnum1.toString().length());
					if (indexnum1.toString().length() != 4) {
						System.out.println("In if block of XLINPUT1");
						indexnum = -1;
					} else {
						System.out.println("In else block of XLINPUT1");
						indexnum = Integer.parseInt(InputValue);
					}
				} catch (Exception e) {

				}
				if (indexnum == -1) {
					try {
						selectObj.selectByVisibleText(InputValue);
						 gm_WriteToLog("Selection done in Dropdown - "+WEName+", By VisibleText", "I");
					} catch (Exception e) {
						selectObj.selectByValue(InputValue);
						gm_WriteToLog("Selection done in Dropdown "+WEName+", By Value", "I");
					}
				} else {
					selectObj.selectByIndex(indexnum);
					gm_WriteToLog("Selection done in Dropdown "+WEName+", By Index", "I");					 
				}
				//Need to work on the below else if code
			} else if (TypeName.equalsIgnoreCase("radio") || TypeName.equalsIgnoreCase("checkbox")) {
				System.out.println("In ElseIf of XLINPUT1-InputValue" + InputValue);
				if (TypeName.equalsIgnoreCase("radio") && (InputValue.equalsIgnoreCase("Yes"))) {
					we.click();
					System.out.println("InputValue" + InputValue);
				} else if (TypeName.equalsIgnoreCase("checkbox") && (InputValue.equalsIgnoreCase("Yes"))) {
					we.click();
				} else {

				}
			} else {
				we.clear();
				we.sendKeys(InputValue);
			}
			gm_WriteToLog(InputValue + "has been entered/selected in " + WEName, "I");
		} catch (NoSuchElementException ne) {
			gm_WaitVIsibility(we, timeout_Seconds);
			System.out.println(ne.getMessage());

		} catch (ElementNotVisibleException nv) {
			gm_WriteToLog(WEName + " is not visible", "E");
			System.out.println(nv.getMessage());
		} catch (StaleElementReferenceException se) {
			System.out.println(se.getMessage());
		}

	}

	public void selectDropdown_SelectAll(WebElement dropdwnElement) {

		Select slctDropdown = new Select(dropdwnElement);
		List<WebElement> drpdwnOptions = slctDropdown.getOptions();
		int optionCount = drpdwnOptions.size();
		try {
			for (int i = 0; i < optionCount; i++) {
				WebElement drpDwnEle = drpdwnOptions.get(i);
				System.out.println("Selected Dropdown option is: " + slctDropdown.getFirstSelectedOption().getText());
				gm_WriteToLog("Selected Dropdown option is: " + slctDropdown.getFirstSelectedOption().getText(), "E");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/******************** Take Screenshot **************************/
	public void gm_TakeSnapshot(String destFilePath) throws InterruptedException {
		System.out.println("In gm_TakeSnapshot Method");
		TakesScreenshot tss = (TakesScreenshot) driverObj;
		System.out.println("11111111");
		File srcfileobj = tss.getScreenshotAs(OutputType.FILE);
		System.out.println("222222222");
		File destFileObj = new File(destFilePath);
		System.out.println("333333333");
		try {
			FileUtils.copyFile(srcfileobj, destFileObj);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		System.out.println("Out gm_TakeSnapshot Method");

	}



	/**************************************** Validation Technique No1: Most Preferable ************************************/
				/****************************************GET ACTUAL RESULT***********************************/
	
	public ArrayList<String> gm_getActualDropdownOptions(WebElement element, String elementName, ExtentTest extentTestLogger, String Comment) throws IOException, InterruptedException {
		System.out.println("In gm_getActualDropdownOptions method");
		if (element.isDisplayed() == false) {
			System.out.println("In If block of gm_getActualDropdownOptions method");
			gm_WaitVIsibility(element, 25);
			System.out.println("Out of  If block of gm_getActualDropdownOptions method");
		} else {
			System.out.println("element.isDisplayed() --> " + element.isDisplayed());
		}
		Select selectDD = new Select(element);
		List<WebElement> actualDropdownList = selectDD.getOptions();
		ArrayList<String> actualDropdownListName = new ArrayList<String>();
		
		//Store dropdownlist in the arraylist
		for (WebElement ele : actualDropdownList) {
			actualDropdownListName.add(ele.getText());
		}
		String screenshotName = elementName;
		String ImagePath1 = "E:\\QA\\Automation_Tools\\Selenium\\WorkspaceMars1\\A3hp.com.automationprac\\TestReports\\Screenshots\\ActualResult\\"+ screenshotName + "_" + fn_GetTimeStamp() + ".png";
		String ImagePath2 = "E:\\QA\\Automation_Tools\\Selenium\\WorkspaceMars1\\A3hp.com.automationprac\\TestReports\\ExtentReport3\\Screenshots\\ActualResult\\"+ screenshotName + "_" + fn_GetTimeStamp() + ".png";
		gm_TakeSnapshot(ImagePath1);
		gm_WriteToLog("Actual result Screenshot taken and stored at" +ImagePath1, "I");
		gm_TakeSnapshot(ImagePath2);
		gm_WriteToLog("Actual Result Screenshot for Extent Report taken and stored at" +ImagePath2, "I");	
		// Add Image in extennt Report
		extentTestLogger.info("ActualResultSSBelow: "+ extentTestLogger.addScreenCaptureFromPath(ImagePath2));
		//	extentTestLogger.info("details", MediaEntityBuilder.createScreenCaptureFromPath(ImagePath2).build());  //Alternate way
		//logger.log(LogStatus.INFO, Comment, ImagePath2);(For extent Report v2)
		System.out.println("Out of gm_getActualDropdownOptions method");
		return actualDropdownListName;

	}

	public String gm_getActualStatus(WebElement element, String elementName, ExtentTest extentTestLogger, String Comment)	throws IOException, InterruptedException {
		System.out.println("In gm_getActualStatus method");
		if (element.isDisplayed() == false) {
			System.out.println("In If block of gm_getActualStatus method");
			gm_WaitVIsibility(element, 25);
			System.out.println("Out of block of gm_getActualStatus method");
		} else {
			System.out.println("element.isDisplayed() --> " + element.isDisplayed());
		}
		Boolean actualStatus = false;
		String actualElementStatus = null;
		actualStatus = gm_isClickable(element);
		actualElementStatus = actualStatus.toString();
		if (actualElementStatus.equalsIgnoreCase("True")) {
			element.click();
		}
		System.out.println("actualStatus = " + actualElementStatus);
		elementName = elementName.replaceAll(" ", "_");
		elementName = elementName.replaceAll("-", "_");
		elementName = elementName.replaceAll("\'", " ");
		elementName = elementName.replaceAll("\\'", "\\\\");
		elementName = elementName.replaceAll(" ", "");
		String screenshotName = "ActualResult_Page_for_linkorbutton--" + elementName;
		String ImagePath1 = "E:\\QA\\Automation_Tools\\Selenium\\WorkspaceMars1\\A3hp.com.automationprac\\TestReports\\Screenshots\\ActualResult\\"
				+ screenshotName + "_" + fn_GetTimeStamp() + ".png";
		gm_TakeSnapshot(ImagePath1);
		gm_WriteToLog("Actual result Screenshot taken and stored at" +ImagePath1, "I");
		
		String ImagePath2 = "E:\\QA\\Automation_Tools\\Selenium\\WorkspaceMars1\\A3hp.com.automationprac\\TestReports\\ExtentReport3\\Screenshots\\ActualResult\\"
				+ screenshotName + "_" + fn_GetTimeStamp() + ".png";
		gm_TakeSnapshot(ImagePath2);
		gm_WriteToLog("Actual Result Screenshot for Extent Report taken and stored at" +ImagePath2, "I");	
		// Add Image in extennt Report
		
		extentTestLogger.info("ActualResultSSBelow: "+ extentTestLogger.addScreenCaptureFromPath(ImagePath2));
		//	extentTestLogger.info("details", MediaEntityBuilder.createScreenCaptureFromPath(ImagePath2).build());  //Alternate way
	 	//logger.log(LogStatus.INFO, Comment, ImagePath2);(For extent Report v2)
		System.out.println("Out of gm_getActualStatus method");
		return actualElementStatus;
		
	
		 
		 
	}

	public String gm_getActualText(WebElement element, String elementName, ExtentTest extentTestLogger, String Comment)throws IOException, InterruptedException {
		System.out.println("In gm_getActualText method");
		if (element.isDisplayed() == false) {
			System.out.println("In If block of gm_getActualText method");
			gm_WaitVIsibility(element, 25);
			System.out.println("Out of block of gm_getActualText method");
		} else {
			System.out.println("element.isDisplayed() --> " + element.isDisplayed());
		}
		String actualText = element.getText();
		System.out.println("ActualText = " + actualText);
		elementName = elementName.replaceAll(" ", "_");
		elementName = elementName.replaceAll("-", "_");
		String[] arrVal = elementName.split("_");
		String lastArrItem = arrVal[arrVal.length - 1];
		System.out.println("lastArrItem: " + lastArrItem);
		String screenshotName = null;
		if (lastArrItem.equalsIgnoreCase("txt")) {
			screenshotName = elementName;
		} else {
			screenshotName = "ActualResult_Page_for_linkorbutton__" + elementName;
		}
		System.out.println("screenshotName-->>>>" + screenshotName);
		String ImagePath1 = "E:\\QA\\Automation_Tools\\Selenium\\WorkspaceMars1\\A3hp.com.automationprac\\TestReports\\Screenshots\\ActualResult\\"	+ screenshotName + "_" + fn_GetTimeStamp() + ".png";
		gm_TakeSnapshot(ImagePath1);
		gm_WriteToLog("Actual result Screenshot taken and stored at" +ImagePath1, "I");
		// Add Image in extennt Report
		String ImagePath2 = "E:\\QA\\Automation_Tools\\Selenium\\WorkspaceMars1\\A3hp.com.automationprac\\TestReports\\ExtentReport3\\Screenshots\\ActualResult\\"+ screenshotName + "_" + fn_GetTimeStamp() + ".png";
		gm_TakeSnapshot(ImagePath2);
		gm_WriteToLog("Actual Result Screenshot for Extent Report taken and stored at" +ImagePath2, "I");		
		extentTestLogger.info("ActualResultSSBelow: "+ extentTestLogger.addScreenCaptureFromPath(ImagePath2)); 		//logger.addScreenCaptureFromPath(ImagePath2);
		//	extentTestLogger.info("details", MediaEntityBuilder.createScreenCaptureFromPath(ImagePath2).build());  //Alternate way
	 	//logger.log(LogStatus.INFO, Comment, ImagePath2);(For extent Report v2)
		
		System.out.println("Out of gm_getActualText method");
		/**/	return actualText;
		
	}

	public String gm_getActualURL(WebElement element, String elementName, ExtentTest extentTestLogger, String Comment)throws IOException, InterruptedException {
		System.out.println("In getActualURL Method");
		if (element.isDisplayed() == false) {
			System.out.println("In If block of getActualURL method");
			gm_WaitVIsibility(element, 25);
			System.out.println("Out of block of getActualURL method");
			//System.out.println("element.isDisplayed() --> " + element.isDisplayed());
		} else {
			System.out.println("element.isDisplayed() --> " + element.isDisplayed());
		}
		//Actions actObj = new Actions(driverObj);
		//actObj.moveToElement(element);
		//actObj.click().build().perform();
		scrollToElemet(element);
		Thread.sleep(10000);
		try{
			element.click();
		}catch(Exception e){
			System.out.println("In Catch");
			((JavascriptExecutor)driverObj).executeScript("arguments[0].click();", element);
		}
		//gm_WaitforURLDisplay("http://www.prestashop.com/?utm_source=v16_homeslider", 100);
		
		Thread.sleep(15000);
		
		elementName = elementName.replaceAll(" ", "_");
		elementName = elementName.replaceAll("-", "_");
		elementName = elementName.replaceAll("\'", " ");
		elementName = elementName.replaceAll("\\'", "\\\\");
		elementName = elementName.replaceAll(" ", "");
		System.out.println(elementName + " -- clicked");
		gm_WriteToLog(elementName + " -- clicked", "I");
		String actualUrl = driverObj.getCurrentUrl();
		System.out.println("URL associated with link - " + elementName + " = " + actualUrl);
		String screenshotName = "ActualResult_Page_for_linkorbutton--" + elementName;
		System.out.println("ElementName is: " + elementName);
	//	logger.log(LogStatus.INFO, "URL for elementName" + elementName + " is: " + actualUrl);
		gm_WriteToLog("URL for elementName" + elementName + '"' + " is: " + actualUrl + '"', "I");
		
		//ExcelReporting-ActualResult
		String ImagePath1 = "E:\\QA\\Automation_Tools\\Selenium\\WorkspaceMars1\\A3hp.com.automationprac\\TestReports\\Screenshots\\ActualResult\\"
				+ screenshotName + "_" + fn_GetTimeStamp() + ".png";
		System.out.println(ImagePath1);
		System.out.println("ExcelReporting-ActualResult: Going to take screenshot");
		gm_TakeSnapshot(ImagePath1);
		System.out.println("ExcelReporting-ActualResult: screenshot taken");
		imagePathList = new ArrayList<String>();
		//ExtentReportion-ActualResult
		String ImagePath2 = "E:\\QA\\Automation_Tools\\Selenium\\WorkspaceMars1\\A3hp.com.automationprac\\TestReports\\ExtentReport3\\Screenshots\\ActualResult\\"+ screenshotName + "_" + fn_GetTimeStamp() + ".png";
		System.out.println(ImagePath2);
		System.out.println("ExtentReportion-ActualResult: Going to take screenshot");
		gm_TakeSnapshot(ImagePath2);
		System.out.println("ExtentReportion-ActualResult: screenshot taken");
		imagePathList.add(ImagePath2);
	
		extentTestLogger.info("ActualResultSSBelow: "+ extentTestLogger.addScreenCaptureFromPath(ImagePath2)); 			//logger.addScreenCaptureFromPath(ImagePath2)
		//	extentTestLogger.info("details", MediaEntityBuilder.createScreenCaptureFromPath(ImagePath2).build());  //Alternate way
	 	//	logger.log(LogStatus.INFO, Comment, ImagePath2);//*/
		return actualUrl;
		
	}
	
	public void scrollToElemet(WebElement element) {
		JavascriptExecutor exe = (JavascriptExecutor) driverObj;
		exe.executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
	//	Log.info(element);
	}			
	
			/***********************ASSERTION****************************/
/*	
	public String gm_assertionAndResultReporting(String actualResult, String expectedResult, String elementName, ExtentTest logger) throws IOException, InvalidFormatException, InterruptedException {
		System.out.println("In gm_assertionAndResultReporting method");
		//try {
		//	System.out.println("In Try Block");
			
			resultStatus = "PASSED";
			System.out.println("resultStatus = " + resultStatus);
			gm_WriteToLog("Test " + resultStatus, "I");
		//	return resultStatus;
		//} catch (Exception e) {
		//	System.out.println("In Catch block");
		//	resultStatus = "FAILED";
		//	e.printStackTrace();
		//	System.out.println(e.getMessage());

		//	gm_WriteToLog("Test Failed", "W");
		//} finally {
		//	System.out.println("in finally block");
		//	System.out.println("resultStatus1 =>> " + resultStatus);			
		//	if (!(resultStatus != null)) {
		//		resultStatus = "FAILED";
		//		System.out.println("resultStatus2 =>> " + resultStatus);
		//	}
		//	System.out.println(actualResult);
		//	System.out.println("resultStatus3 =>> " + resultStatus);
		//	
			return resultStatus;
			  
		}
		//System.out.println("resultStatushdj = " + resultStatus);
		
	//}*/
									/***************************************
									 * Generate Report with Screenshot
									****************************************/
	public String gm_setScreenshotPath_forExtentReporting(String elementName, String resultStatus) {
		System.out.println("In gm_setScreenshotPath_forExtentReporting");
		System.out.println(elementName + "--" + resultStatus);
		String ImagePath = 	"E:\\QA\\Automation_Tools\\Selenium\\WorkspaceMars1\\A3hp.com.automationprac\\TestReports\\ExtentReport3\\Screenshots\\"+ resultStatus + "\\" + elementName + "_" + fn_GetTimeStamp() + ".png";
		return ImagePath;
	}

	public String gm_setScreenshotPath_forCustomizedReporting(String elementName, String resultStatus) {
		System.out.println("In gm_setScreenshotPath_forCustomizedReporting");
		//String ImagePath = 	"E:\\QA\\Automation_Tools\\Selenium\\WorkspaceMars1\\A3hp.com.automationprac\\TestReports\\Screenshots\\" + elementName + "_" + fn_GetTimeStamp() + ".png";
		String ImagePath = 	"E:\\QA\\Automation_Tools\\Selenium\\WorkspaceMars1\\A3hp.com.automationprac\\TestReports\\Screenshots\\"+ resultStatus + "\\" + elementName + "_" + fn_GetTimeStamp() + ".png";
		return ImagePath;
	}

	public void gm_generateReportWithScreenshots(String actualResult, String expectedResult, String elementName, String resultStatus) throws InvalidFormatException, InterruptedException {

		System.out.println("In gm_generateReportWithScreenshots Method");
		String ImagePath = gm_setScreenshotPath_forCustomizedReporting(elementName, resultStatus);
		System.out.println(ImagePath);
		System.out.println("To Take Screenshot");
		try {
			gm_TakeSnapshot(ImagePath);	
			//captureScreenshot_NotInUse(driverObj, elementName, resultStatus);
			System.out.println("ScreenshotTaken");
			System.out.println(elementName+"***"+expectedResult+"***-"+actualResult+"***-"+resultStatus+"-"+ImagePath);
			String[] ResArray = gm_GetResultStepArray(elementName, expectedResult, actualResult, resultStatus, ImagePath);		
			xl_WriteResultToExcel(ResArray);		
			System.out.println("XL Reporting Done");
			gm_WriteToLog("Screenshot of webelement" + elementName + " is saved at " + ImagePath, "I");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("ResultStatus = " + resultStatus);
		System.out.println(" Out gm_generateReportWithScreenshots Method");
	}

	public String[] gm_GetResultStepArray(String ElementName, String exp, String ActualText, String Status,
			String SnapshotPath) {
		Throwable t = new Throwable();
		StackTraceElement[] arr_Ste = t.getStackTrace();
		for (StackTraceElement ste : arr_Ste) {
			//System.out.println(ste);
		}
		System.out.println("arr_Ste length " + arr_Ste.length);
		StackTraceElement ste0 = arr_Ste[0];
		//System.out.println("ste0: " + ste0);
		StackTraceElement ste1 = arr_Ste[1];
		//System.out.println("ste1: " + ste1);
		StackTraceElement ste2 = arr_Ste[2];
		//System.out.println("ste2: " + ste2);
		//StackTraceElement ste3 = arr_Ste[3];
		//System.out.println("ste3: " + ste3);

		// Get Method name from selected stake
		String MethodName = ste2.getMethodName();
		String metname1 = MethodName.substring(0, 1).toUpperCase();
		String metname2 = MethodName.substring(1).toLowerCase();
		//System.out.println(metname1.toString());
		//System.out.println(metname2.toString());
		MethodName = metname1.concat(metname2);

		// Get Class name from selected stake --To get Module and submodule name
		// by splitting it
		String ClassName = ste2.getClassName().toUpperCase();
		//System.out.println(ClassName.toString());
		String[] ArrClsName = ClassName.split("\\.");
		String SplitClassName = ArrClsName[ArrClsName.length - 1].toUpperCase();
		String SubModuleName = SplitClassName.substring(0, SplitClassName.length() - 4);
		//System.out.println(SubModuleName.toString());

		// Get module name
		String ModuleName = ArrClsName[ArrClsName.length - 2];
		//System.out.println(ModuleName.toString());
		String modname1 = ModuleName.substring(0, 1).toUpperCase();
		String modname2 = ModuleName.substring(1).toLowerCase();
		//System.out.println(modname1.toString());
		//System.out.println(modname2.toString());
		ModuleName = modname1.concat(modname2);

		String[] ResultArray = { ModuleName, SubModuleName, MethodName, ElementName, exp, ActualText, Status,
				SnapshotPath };

		return ResultArray;
	}

	/******************** Object Repository ***************************/

	public static void objRep() throws IOException {
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\src\\objects.properties");
		// Pass object reference objfile to load method of Properties object.
		obj.load(objfile);
	}

	static Properties prop = null;
	static Properties queryProp = null;
	private static final Logger log = Logger.getLogger(UI_GenericMethods1.class.getName());
	static {
		log.info("Loading the Properties File");
		try {
			prop = new Properties();
			prop.load(new FileInputStream(System.getProperty("user.dir") + "\\src\\objects.properties"));
		} catch (FileNotFoundException fe) {
			log.error("Exception in PropFileReader--" + fe);
		} catch (IOException io) {
			log.error("Exception in PropFileReader--" + io);
		}
	}

	public static String objRep1(String key) {
		String value = null;
		try {
			if (prop != null) {
				value = prop.getProperty(key);
			} else {
				prop = new Properties();
				prop.load(new FileInputStream(System.getProperty("user.dir") + "\\src\\objects.properties"));
				value = prop.getProperty(key);
			}
		} catch (Exception ex) {
			log.error("Exception in PropFileReader--" + ex);
		}
		return value;
	}

	/******************************************* Not In Use**********************************************************/
	/////////////////////////////// ///////////////////////////////////////////
	/*	public void gm_AssertResult_NotInUse(-, String ElementName, String expectedText)
			throws InvalidFormatException, IOException, InterruptedException {
		System.out.println("In gm_AssertResult method");
		String ActualText = we.getText();
		System.out.println("ActualText = " + ActualText);
		System.out.println("ExpectedText = " + expectedText);
		Assert.assertEquals(ActualText, expectedText);
		gm_WriteToLog("TestPassed", "I");

	}*/


	/********************
	 * Generate Report without Screenshot
	 **************************/

	/*	public String[] gm_GetResultStepArray1_NotInUse(String ElementName, String exp, String ActualText, String Status,
			String SnapshotPath) {
		Throwable t = new Throwable();
		StackTraceElement[] arr_Ste = t.getStackTrace();
		StackTraceElement ste = arr_Ste[3];
		String MethodName = ste.getMethodName().toUpperCase();
		String ClassName = ste.getClassName().toUpperCase();
		String[] ArrClsName = ClassName.split("\\.");
		String SubModuleName = ArrClsName[ArrClsName.length - 1].toUpperCase();
		String ModuleName = ArrClsName[ArrClsName.length - 2];
		String modname1 = ModuleName.substring(0).toUpperCase();
		//System.out.println("modname1: " + modname1);

		SnapshotPath = "Snapshot Not Taken for Passed Results";
		String[] ResultArray = { ModuleName, SubModuleName, MethodName, ElementName, exp, ActualText, Status,
				SnapshotPath };

		return ResultArray;
	}*/

	/*	public void gm_generateReportWithScreenshots_mvn_NotInUse(String actualResult, String expectedResult,
			String elementName) throws InvalidFormatException, IOException, InterruptedException {
		System.out.println("In gm_generateReportWithScreenshots_mvn Method");
		String ImagePath = null;
		if (actualResult.equalsIgnoreCase(expectedResult)) {
			ImagePath = "TestReport/Screenshots/Passed/" + elementName + "_" + fn_GetTimeStamp() + ".png";
			gm_TakeSnapshot(ImagePath);
			String[] ResArray = gm_GetResultStepArray(elementName, expectedResult, actualResult, "Passed", ImagePath);
			xl_WriteResultToExcel(ResArray);
		} else {
			ImagePath = "TestReport/Screenshots/Failed/" + elementName + "_" + fn_GetTimeStamp() + ".png";
			gm_TakeSnapshot(ImagePath);
			String[] ResArray = gm_GetResultStepArray(elementName, expectedResult, actualResult, "Failed", ImagePath);
			xl_WriteResultToExcel(ResArray);
		}
		gm_WriteToLog("Screenshot of webelement" + elementName + " is saved at " + ImagePath, "I");
		System.out.println(" Out gm_generateReportWithScreenshots_mvn Method");
	}*/

/*	public static String captureScreenshot_NotInUse(WebDriver driverObj, String screenshotName, String resultStatus) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driverObj;
			File source = ts.getScreenshotAs(OutputType.FILE);
			System.out.println("screenshotName = " + screenshotName);
			String dest = "E:\\QA\\Automation_Tools\\Selenium\\WorkspaceMars1\\2hp.com.hayoumethod.mavenfrwork1\\TestReport\\ExtentReport\\"
					+ resultStatus + "\\" + screenshotName + ".png";
			 
			// ImagePath="ActualResult/"+screenshotName+"_"+fn_GetTimeStamp()+".png";
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot Taken");
			return dest;
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
			return e.getMessage();
		}
	} */
	///////////////////////////////////// **VALIDATION**//////////////////////////////////////////
	////////////////////////// Validation technique1///////////////////////
	/*	public String getActualURL_M1_NotInUse(WebElement element, String elementName)
			throws IOException, InterruptedException {
		System.out.println("In getActualURL Method");
		String actualUrl = null;
		if (element.isDisplayed() == false) {
			System.out.println("In If block of getActualURL method");
			gm_WaitVIsibility(element, 25);
			System.out.println("Out If block of getActualURL method");
		} else {
			System.out.println("element.isDisplayed() --> " + element.isDisplayed());
		}
		element.click();
		System.out.println(elementName + " -- clicked");
		gm_WriteToLog(elementName + " -- clicked", "I");
		actualUrl = driverObj.getCurrentUrl();
		System.out.println("URL associated with link/button - " + elementName + " = " + actualUrl);
		String screenshotName = "ResultPage_for_link_button_" + elementName;
		String ImagePath = "TestReport/Screenshots/ActualResult/" + screenshotName + "_" + fn_GetTimeStamp() + ".png";
		gm_TakeSnapshot(ImagePath);
		driverObj.navigate().back();
		return actualUrl;
	}*/

	////////////////////////// Validation technique2: Not so
	////////////////////////// Preferable///////////////////////
	/*	public String validateNavigationUsingAssertion_NotInUse(WebElement element, String expectedURL, String elementName,
			ExtentTest logger) throws IOException, InterruptedException, InvalidFormatException {
		System.out.println("In validateNavigation Method");
		if (element.isDisplayed() == false) {
			System.out.println("In If block of getActualURL method");
			gm_WaitVIsibility(element, 25);
			System.out.println("Out of If block of getActualURL method");
		} else {
			System.out.println("element.isDisplayed() --> " + element.isDisplayed());
		}
		element.click();
		System.out.println(elementName + " -- clicked");
		gm_WriteToLog(elementName + " -- clicked", "I");
		String actualUrl = driverObj.getCurrentUrl();
		System.out.println("URL associated with link/button - " + elementName + " = " + actualUrl);
		String screenshotName = "ResultPage_for_link_button_" + elementName;
		String ImagePath = "TestReport/Screenshots/ActualResult/" + screenshotName + "_" + fn_GetTimeStamp() + ".png";
		gm_TakeSnapshot(ImagePath);
		try {
			System.out.println("In Try block of Validate nav");
			Assert.assertEquals(actualUrl, expectedURL);
			System.out.println("Assertion Done");
			String Status = "PASS";
		//	logger.log(LogStatus.PASS, "Button Functionality Passed");
			gm_WriteToLog("Test passed", "I");
		} catch (Exception e) {
			System.out.println("In catch block of assertion");
			e.printStackTrace();
			System.out.println(e.getMessage());
		//	logger.log(LogStatus.FAIL, "Button Functionality Failed");
			gm_WriteToLog("Test Failed", "W");
		} finally {
			System.out.println("in finally block");
			System.out.println(actualUrl);

		}
		System.out.println("Out  of validateNavigation method");
		System.out.println("actualUrl = " + actualUrl);
		return actualUrl;

	}*/

	// Below one is preferred
/*	public String gm_TakeSnapshot_NotInUse(WebDriver driver, WebElement ElementName)
			throws IOException, InterruptedException {
		String destFilePath = "Reports/Images/" + ElementName + "_" + fn_GetTimeStamp() + ".png";
		destFilePath = destFilePath.split("/", 2)[1];
		TakesScreenshot tss = (TakesScreenshot) driver;
		File srcfileobj = tss.getScreenshotAs(OutputType.FILE);
		Thread.sleep(300);
		File destFileObj = new File(destFilePath);
		FileUtils.copyFile(srcfileobj, destFileObj);
		gm_WriteToLog("Screenshot of webelement" + ElementName + " is saved at " + destFilePath, "I");
		return destFilePath;
	}

	/*	public void gm_Validate_NotInUse(String actualText, String expectedText, String ElementName)
			throws InvalidFormatException, IOException, InterruptedException {
		System.out.println("In gm_Validate method");
		String ImagePath = null;
		if (actualText.equalsIgnoreCase(expectedText)) {
			ImagePath = "Reports/Images/" + ElementName + "_" + fn_GetTimeStamp() + ".png";
			ImagePath = ImagePath.split("/", 2)[1];
			gm_TakeSnapshot(ImagePath);
			String[] ResArray = gm_GetResultStepArray(ElementName, expectedText, actualText, "Passed", ImagePath);
			xl_WriteResultToExcel(ResArray);
		} else {
			ImagePath = "Reports/Images/" + ElementName + "_" + fn_GetTimeStamp() + ".png";
			ImagePath = ImagePath.split("/", 2)[1];
			gm_TakeSnapshot(ImagePath);

			String[] ResArray = gm_GetResultStepArray(ElementName, expectedText, actualText, "Failed", ImagePath);
			xl_WriteResultToExcel(ResArray);
		}
	}*/

	/*	public void gm_ValidateText_mvn1_NotInUse(WebElement we, String ElementName, String expectedText)
			throws InvalidFormatException, IOException, InterruptedException {
		System.out.println("In gm_ValidateText_mvn method");
		String actualText = we.getText();
		System.out.println("ActualText = " + actualText);

		System.out.println("ExpectedText = " + expectedText);
		String status = null;
		if (actualText.equalsIgnoreCase(expectedText) == true) {
			status = "Passed";
		} else {
			status = "failed";
		}
		gm_Validate_NotInUse(actualText, expectedText, ElementName);

	}*/

/*	public void gm_Validate1_NotInUse(String actualText, String expectedText, String ElementName)
			throws InvalidFormatException, IOException, InterruptedException {
		System.out.println("In gm_Validate method");
		String ImagePath = null;
		if (actualText.equalsIgnoreCase(expectedText)) {
			ImagePath = "Reports/Images/" + ElementName + "_" + fn_GetTimeStamp() + ".png";
			ImagePath = ImagePath.split("/", 2)[1];
			gm_TakeSnapshot(ImagePath);
			String[] ResArray = gm_GetResultStepArray(ElementName, expectedText, actualText, "Passed", ImagePath);
			xl_WriteResultToExcel(ResArray);
		} else {
			ImagePath = "Reports/Images/" + ElementName + "_" + fn_GetTimeStamp() + ".png";
			ImagePath = ImagePath.split("/", 2)[1];
			gm_TakeSnapshot(ImagePath);

			String[] ResArray = gm_GetResultStepArray(ElementName, expectedText, actualText, "Failed", ImagePath);
			xl_WriteResultToExcel(ResArray);
		}
	}*/
}