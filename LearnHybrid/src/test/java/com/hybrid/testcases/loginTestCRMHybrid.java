package com.hybrid.testcases;

import java.util.concurrent.TimeUnit;
import com.hybrid.utilities.ConfigDataProvider;
import com.hybrid.utilities.ExcelDataProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.*;
import com.hybrid.pages.loginPageHybrid;
import com.hybrid.utilities.browserActionsHybrid;
import com.hybrid.pages.BaseClassHybrid;
public class loginTestCRMHybrid extends BaseClassHybrid{
	
	
	
	@Test
	public void loginApp() {
		
		logger=report.createTest("Login to CRM");
		
		loginPageHybrid x=PageFactory.initElements(driver, loginPageHybrid.class);
		logger.info("Application Starting");
		
		x.LoginToApp(excel1.getStringData("Sheet1", 0, 0), excel1.getStringData("Sheet1", 0, 1));
		logger.pass("Logged in");
	}
	
}

//loginPageHybrid x=PageFactory.initElements(driver, loginPageHybrid.class);
//x.LoginToApp("pranayyerram", "Bunny@1556");

//loginPageHybrid x = new loginPageHybrid();
//loginPageHybrid y = PageFactory.initElements(driver, loginPageHybrid.class);