package com.GoogleService.Testcases;

import org.testng.annotations.Test;


import com.GoogleService.Baseclass.BaseClass;
import com.GoogleService.PageObjects.SignInFunctionality;

public class TC_SignInFunctionality extends BaseClass{
	@Test
	public void signInFunctionalityTest() {
	SignInFunctionality sif = new SignInFunctionality(driver);
	sif.clickOnSignBtn();
	sif.validatingLoginPage();
	sif.userNameField("imran957398@gmail.com");
	sif.nextButton();
	sif.passwordField("XXXXXXXX");
	sif.passNextButton();
	sif.validatingGoogleHomePage();
	
	}

}
