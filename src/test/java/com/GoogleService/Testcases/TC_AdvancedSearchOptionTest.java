package com.GoogleService.Testcases;


import org.testng.annotations.Test;

import com.GoogleService.Baseclass.BaseClass;
import com.GoogleService.PageObjects.AdvancedSearchOption;



public class TC_AdvancedSearchOptionTest extends BaseClass{
	
      @Test(dataProvider = "data",dataProviderClass=BaseClass.class)
      public void googleHomePageTest(String allthesewords,String thisexactwords,String anyofthiswords, String noneofthiswords, String from, String to,String site) {
    	  AdvancedSearchOption aso=new AdvancedSearchOption(driver);
    	  aso.clickOnSettings();
    	  aso.clickOnAdvancedSearch();
    	  aso.validatingAdvancedSearchPage();
    	  aso.searchCriteria(allthesewords,thisexactwords,anyofthiswords,noneofthiswords,from,to,site);
    	  aso.clickOnadvancedSearchButton();
    	  aso.validatingSearchResult();
      }

}
