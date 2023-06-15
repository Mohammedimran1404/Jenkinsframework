package com.GoogleService.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.GoogleService.Utils.LogUtility;

public class SignInFunctionality {
	LogUtility logutility =new LogUtility();
	public WebDriver driver;
	public SignInFunctionality(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[text()='Sign in']")private WebElement signinbutton;
	@FindBy(xpath = "//input[@id='identifierId']")private WebElement usernamefield;
	@FindBy(xpath = "//span[text()='Next']")private WebElement nextbutton;
	@FindBy(xpath = "//input[@name='password']")private WebElement passwordfield;
	@FindBy(xpath = "//span[text()='Next']")private WebElement passnextbutton;
	
	public void clickOnSignBtn() {
		signinbutton.click();
		logutility.info("Sign in button is Clicked");
	}
	public void validatingLoginPage() {
		if("Sign in - Google Accounts".equals(driver.getTitle())) {
			Assert.assertTrue(true);
			logutility.info("LoginPage is displayed and passed");
		}
		else {
			Assert.assertTrue(false);
			logutility.info("LoginPage is not displayed and failed");

		}
	}
	public void userNameField(String unfield) {
		usernamefield.sendKeys(unfield);
		logutility.info("User name is entered in field");
	}
	public void nextButton() {
		nextbutton.click();
		logutility.info("Next button is clicked");
	}
	public void passwordField(String psfield) {
		passwordfield.sendKeys(psfield);
		logutility.info("Password is entered in field");
	}
	public void passNextButton() {
		passnextbutton.click();
		logutility.info("Password button is clicked");
	}
	public void validatingGoogleHomePage() {
		if("Google".equals(driver.getTitle())) {
			Assert.assertTrue(true);
			logutility.info("Google page is displayed and passed");

		}
		else {
			Assert.assertTrue(false);
			logutility.info("Google page is not displayed and failed");

		}
	}

}
