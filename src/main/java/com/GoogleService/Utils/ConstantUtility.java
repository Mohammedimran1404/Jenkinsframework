package com.GoogleService.Utils;

public class ConstantUtility {
private	String propertyfilepath=System.getProperty("user.dir")+"/src/test/resources/config.properties";
private	String excellfilepath=System.getProperty("user.dir")+"/src/test/resources/AdvancedSearchOptions.xlsx";

public String getPropertyFilePath() {
	return propertyfilepath;
}
public String getExcellFilePath() {
	return excellfilepath;

}
}
