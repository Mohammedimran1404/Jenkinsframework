package com.GoogleService.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {
	ConstantUtility constantutility = new ConstantUtility();
	FileInputStream fis;
	Properties pro;
	public PropertyFileUtility() {
		File f=new File(constantutility.getPropertyFilePath());
		try {
			fis= new FileInputStream(f);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	public String getApplicationUrl() {
		String url=pro.getProperty("Url");
		return url;
	}
}
