package com.GoogleService.Baseclass;

import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import com.GoogleService.Utils.ConstantUtility;
import com.GoogleService.Utils.ExcellUtility;
import com.GoogleService.Utils.LogUtility;
import com.GoogleService.Utils.PropertyFileUtility;
import com.GoogleService.Utils.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	 PropertyFileUtility propertyFileUtility= new PropertyFileUtility();
	 WebDriverUtility webdriverutility= new WebDriverUtility();
	 LogUtility logutility =new LogUtility();
	 String baseUrl=propertyFileUtility.getApplicationUrl();
	

	public static  WebDriver driver;
	@Parameters("Browser")
	@BeforeClass
	public void setUp(String Browser) {
		if(Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			logutility.info("Chrome Browser is started successfully");
			webdriverutility.maximizeWindow(driver);
			logutility.info("Window is maximize");
			driver.get(baseUrl);
			logutility.info("Url is Launch");
		}
		else if(Browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			logutility.info("Edge Browser is started successfully");
			webdriverutility.maximizeWindow(driver);
			logutility.info("Window is maximize");
			driver.get(baseUrl);
			logutility.info("Url is Launch");
		}
		else if(Browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			logutility.info("Firefox Browser is started successfully");
			webdriverutility.maximizeWindow(driver);
			logutility.info("Window is maximize");
			driver.get(baseUrl);
			logutility.info("Url is Launch");
			
		}
		else if(Browser.equalsIgnoreCase("Safari")) {
			WebDriverManager.safaridriver().setup();
			driver= new SafariDriver();
			logutility.info("Safari Browser is started successfully");
			webdriverutility.maximizeWindow(driver);
			logutility.info("Window is maximize");
			driver.get(baseUrl);
			logutility.info("Url is Launch");
			
		}
		else {
			System.out.println("invalid browser please enter a valid browser");
			logutility.info("Invalid Browser");
		}
		  
	}
	public  String getBrowserName() {
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = caps.getBrowserName();
      
        return browserName;
    }
	
	public  String getBrowserVersion() {
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        String browserVersion = caps.getBrowserVersion();
      
        return browserVersion;
    }
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		logutility.info("Browser quit successfully");
	}
	@DataProvider(name="data")
	public String [][] googleSearchData() throws IOException{
		String path=ConstantUtility.excellfilepath;
		 ExcellUtility excellutility = new ExcellUtility(path);
		 int totalrows=excellutility.getRowCount("AdvancedSearch");
		 int totalcols=excellutility.getColumnCount("AdvancedSearch", 1);
		 String getdata[][]=new String[totalrows][totalcols];
		 for(int r=1;r<=totalrows;r++) {
		 for(int c=0;c<totalcols;c++) {
		 getdata[r-1][c]=excellutility.getCellData("AdvancedSearch", r, c);
		 }
		 
		 }

		return getdata;
		
	}
	 
	
}
