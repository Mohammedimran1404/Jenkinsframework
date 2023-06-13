package com.GoogleService.PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.GoogleService.Utils.WebDriverUtility;

public class AdvancedSearchOption {
	 WebDriverUtility webdriverutility= new WebDriverUtility();

		public WebDriver driver;
		public AdvancedSearchOption(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//div[text()='Settings']") WebElement settings;
		
		@FindBy(linkText = "Advanced search")WebElement advancedsearch;
		
		@FindBy(xpath = "//input[@id='xX4UFf']")WebElement allthesewords;
		
		@FindBy(xpath = "//input[@id='CwYCWc']")WebElement thisexactwords;
	
		@FindBy(xpath = "//input[@id='mSoczb']")WebElement anyofthiswords;
		
		@FindBy(xpath = "//input[@id='mSoczb']/following::input[1]")WebElement noneofthesewords;
		
		@FindBy(xpath = "//input[@id='LK5akc']")WebElement numberrangingfrom;
		
		@FindBy(xpath ="//input[@name='as_nhi']")WebElement numberrangingto;
		
		@FindBy(xpath="//div[@id='lr_button']")WebElement language;
		@FindBy(xpath = "//li[@id=':d']/child::div")WebElement clickonparticularlanguage;
		
		@FindBy(xpath="//div[@id='cr_button']")WebElement region;
		@FindBy(xpath="//li[@id=':44']/child::div")WebElement particularregion;
		
		@FindBy(xpath = "//div[@id='as_qdr_button']")WebElement lastupdate;
		@FindBy(xpath = "//li[@id=':80']/child::div")WebElement particularlastupdate;
		
		@FindBy(xpath = "//input[@id='NqEkZd']")WebElement siteordomain;
		
		@FindBy(xpath="//div[@id='as_occt_button']")WebElement termsappearing;
		@FindBy(xpath="//li[@id=':85']/child::div")WebElement particulartermsappearing;
		
		@FindBy(xpath = "//div[@id='as_rights_button']")WebElement usagerights;
		@FindBy(xpath = "//li[@id=':8d']/child::div")WebElement particularusagerights;
		
		@FindBy(xpath="//div[@id='as_rights_button']/following::div[5]/child::input[2]")WebElement advancedsearchbtn;
		
		
		public void clickOnSettings() {
			settings.click();
		}
		public void clickOnAdvancedSearch() {
			advancedsearch.click();
		}
		public void validatingAdvancedSearchPage() {
			if("Google Advanced Search".equals(driver.getTitle())) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
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
		}
		public void clickOnadvancedSearchButton() {
			advancedsearchbtn.click();
		}
		public void validatingSearchResult() {
			if(("Kai-ros Kai OR OR OR ros \"Kai\" -none site:https://www.google.com 1..20 - Google Search").equals(driver.getTitle())) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);

			}
			}
		}
		
		
		
		
	

