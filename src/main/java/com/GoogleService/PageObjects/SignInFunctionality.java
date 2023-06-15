package com.GoogleService.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignInFunctionality {
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
	}
	public void validatingLoginPage() {
		if("Sign in - Google Accounts".equals(driver.getTitle())) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);

		}
	}
	public void userNameField(String unfield) {
		usernamefield.sendKeys(unfield);
	}
	public void nextButton() {
		nextbutton.click();
	}
	public void passwordField(String psfield) {
		passwordfield.sendKeys(psfield);
	}
	public void passNextButton() {
		passnextbutton.click();
	}
	public void validatingGoogleHomePage() {
		if("Google".equals(driver.getTitle())) {
			Assert.assertTrue(true);

		}
		else {
			Assert.assertTrue(false);

		}
	}

}
