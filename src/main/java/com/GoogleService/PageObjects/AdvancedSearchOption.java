package com.GoogleService.PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.GoogleService.Utils.LogUtility;
import com.GoogleService.Utils.WebDriverUtility;

public class AdvancedSearchOption {
	 WebDriverUtility webdriverutility= new WebDriverUtility();
	 LogUtility logutility = new LogUtility();

		public WebDriver driver;
		public AdvancedSearchOption(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//div[text()='Settings']")private WebElement settings;
		
		@FindBy(linkText = "Advanced search") private WebElement advancedsearch;
		
		@FindBy(xpath = "//input[@id='xX4UFf']")private WebElement allthesewords;
		
		@FindBy(xpath = "//input[@id='CwYCWc']")private WebElement thisexactwords;
	
		@FindBy(xpath = "//input[@id='mSoczb']")private WebElement anyofthiswords;
		
		@FindBy(xpath = "//input[@id='mSoczb']/following::input[1]")private WebElement noneofthesewords;
		
		@FindBy(xpath = "//input[@id='LK5akc']")private WebElement numberrangingfrom;
		
		@FindBy(xpath ="//input[@name='as_nhi']")private WebElement numberrangingto;
		
		@FindBy(xpath="//div[@id='lr_button']")WebElement language;
		@FindBy(xpath = "//li[@id=':d']/child::div")WebElement clickonparticularlanguage;
		
		@FindBy(xpath="//div[@id='cr_button']")private WebElement region;
		@FindBy(xpath="//li[@id=':44']/child::div")private WebElement particularregion;
		
		@FindBy(xpath = "//div[@id='as_qdr_button']")private WebElement lastupdate;
		@FindBy(xpath = "//li[@id=':80']/child::div")private WebElement particularlastupdate;
		
		@FindBy(xpath = "//input[@id='NqEkZd']")private WebElement siteordomain;
		
		@FindBy(xpath="//div[@id='as_occt_button']")private WebElement termsappearing;
		@FindBy(xpath="//li[@id=':85']/child::div")private WebElement particulartermsappearing;
		
		@FindBy(xpath = "//div[@id='as_rights_button']")private WebElement usagerights;
		@FindBy(xpath = "//li[@id=':8d']/child::div")private WebElement particularusagerights;
		
		@FindBy(xpath="//div[@id='as_rights_button']/following::div[5]/child::input[2]")private WebElement advancedsearchbtn;
		
		
		public void clickOnSettings() {
			settings.click();
			logutility.info("Settings is Clicked");
		}
		public void clickOnAdvancedSearch() {
			advancedsearch.click();
			logutility.info("AdvancedSearch is Clicked");
		}
		public void validatingAdvancedSearchPage() {
			if("Google Advanced Search".equals(driver.getTitle())) {
				Assert.assertTrue(true);
				logutility.info("Advanced search page is displayed and passed");
			}
			else {
				Assert.assertTrue(false);
				logutility.info("Advanced search page is not displayed and failed");
			}
		}
		public void searchCriteria(String allwords,String exactwords,String thiswords,String nonewords,String numberrange,String numberto,String site) {
			allthesewords.sendKeys(allwords);
			thisexactwords.sendKeys(exactwords);
			anyofthiswords.sendKeys(thiswords);
			noneofthesewords.sendKeys(nonewords);
			numberrangingfrom.sendKeys(numberrange);
			numberrangingto.sendKeys(numberto);
			webdriverutility.scrollAction(driver);
			language.click();
			clickonparticularlanguage.click();
			region.click();
			particularregion.click();
			lastupdate.click();
			particularlastupdate.click();
			siteordomain.sendKeys(site);
			termsappearing.click();
			particulartermsappearing.click();
			usagerights.click();
			particularusagerights.click();
			logutility.info("Search creteria is entered");
		}
		public void clickOnadvancedSearchButton() {
			advancedsearchbtn.click();
			logutility.info("Advanced search button is Clicked");
		}
		public void validatingSearchResult() {
			if(("Kairos Kai OR OR OR ros \"Kaiross\" -none site:https://www.google.com 1..20 - Google Search").equals(driver.getTitle())) {
				Assert.assertTrue(true);
				logutility.info("Search result is displayed and passed");
			}
			else {
				Assert.assertTrue(false);
				logutility.info("Search result is not displayed and failed");

			}
			}
		}
		
		
		
		
	


