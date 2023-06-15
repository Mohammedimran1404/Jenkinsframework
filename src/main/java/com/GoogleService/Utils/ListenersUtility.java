package com.GoogleService.Utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.GoogleService.Baseclass.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ListenersUtility  implements ITestListener {
	JavaUtility javautility = new JavaUtility();
	WebDriverUtility webdriverutility = new WebDriverUtility();
	LogUtility logutility = new LogUtility();
	
	BaseClass baseclass= new BaseClass();
	PropertyFileUtility propertyFileUtility= new PropertyFileUtility();
	String baseUrl=propertyFileUtility.getApplicationUrl();
	
	ExtentSparkReporter sparkreporter;
	ExtentReports reports;
	ExtentTest test;
	
	

	public void onTestStart(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		test=reports.createTest(methodname);
		logutility.info(methodname+" Test case started");	
	}
	public void onTestSuccess(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		test.log(Status.PASS, MarkupHelper.createLabel(methodname, ExtentColor.GREEN));
		test.log(Status.INFO, methodname+  " Passed");
		logutility.pass(methodname+ " Test case executed successfully");
	}


	public void onTestFailure(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		test.log(Status.FAIL, MarkupHelper.createLabel(methodname, ExtentColor.RED));
		logutility.fail(methodname+" Test case failed");
		
		String screenShotName = methodname+"-"+javautility.getSystemdate();
		test.log(Status.INFO, methodname+ " Failed");
		test.log(Status.FAIL, result.getThrowable());
		try {
			String path = webdriverutility.takeScreenShot(BaseClass.driver, screenShotName);
			
			test.addScreenCaptureFromPath(path); 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP, MarkupHelper.createLabel(methodname, ExtentColor.ORANGE));
		logutility.fail(methodname +" Test case failed");
	}


	public void onStart(ITestContext context) {
		
		String repname = "Test-Report-" + new JavaUtility().getSystemdate() + ".html";
		logutility.info(repname + " Report generating started");

		sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/ExtentsReports/" + repname);
		sparkreporter.config().setDocumentTitle("GoogleService reports");
		sparkreporter.config().setReportName("Test Case ");
		sparkreporter.config().setTheme(Theme.STANDARD);

		reports = new ExtentReports();
		reports.attachReporter(sparkreporter);
		reports.setSystemInfo("URl", baseUrl);
		reports.setSystemInfo("OPERATING SYSTEM", System.getProperty("os.name"));
		reports.setSystemInfo("Os Version", System.getProperty("os.version"));
		reports.setSystemInfo("Java Version",System.getProperty("java.version"));	
		
	}


	public void onFinish(ITestContext context) {
		String browserName =baseclass .getBrowserName();
		String browserVersion=baseclass.getBrowserVersion();
		reports.setSystemInfo("Browser", browserName);
		reports.setSystemInfo("BrowserVersion",browserVersion );
		reports.flush();
		logutility.info("Report generated successfully");
		
		
	}
	

}
