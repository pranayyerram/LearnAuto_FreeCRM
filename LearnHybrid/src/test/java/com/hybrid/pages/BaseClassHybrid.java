package com.hybrid.pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.hybrid.utilities.ConfigDataProvider;
import com.hybrid.utilities.ExcelDataProvider;
import com.hybrid.utilities.Helper;
import com.hybrid.utilities.browserActionsHybrid;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.*;


public class BaseClassHybrid {
	public WebDriver driver;
	public ExcelDataProvider excel1;
	public loginPageHybrid objLoginPageHybrid;
	public ConfigDataProvider con;
	public ExtentReports report;
	public ExtentTest logger;
	public ExtentHtmlReporter extent;
	
	@BeforeSuite
	public void setUpSuite() {
		con=new ConfigDataProvider();
		excel1=new ExcelDataProvider();
		objLoginPageHybrid = new loginPageHybrid(driver);
		
		extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/report "+Helper.getCurrentDate()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeClass
	public void setup() {
		Reporter.log("Trying to start browser", false);
	//System.setProperty("webdriver.chrome.driver", "C://Users//Pranay//Downloads//chromedriver_win32//chromedriver(104).exe");
	//driver = new ChromeDriver();
	driver = browserActionsHybrid.startApplication(driver,con.getBrowser(),con.getUrl());
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Reporter.log("Application is started and running...");
	//driver.get("https://classic.freecrm.com/index.html");
	}
	
	@AfterClass
	public void teardown() {
		
		browserActionsHybrid.closeApplication(driver);
		Reporter.log("Closing Application");
	}
	
	@AfterMethod
	public void screenshotCap(ITestResult result) throws IOException {
		if (result.getStatus()==ITestResult.FAILURE);
		{
			Helper.captureScreenshot(driver);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		if(result.getStatus()==ITestResult.SUCCESS); {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
	}
	
}
