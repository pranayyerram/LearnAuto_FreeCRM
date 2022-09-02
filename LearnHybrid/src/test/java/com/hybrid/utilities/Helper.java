package com.hybrid.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver) {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String ScreenshotPath=System.getProperty("user.dir")+ "/Screenshots/TestResult_" + getCurrentDate() +".png";
		try {
			FileHandler.copy(src, new File("./Screenshots/TestResult_"+ getCurrentDate() +".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ScreenshotPath;
		
	}
	public static String getCurrentDate() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
		Date curDate= new Date();
		return customFormat.format(curDate);
	}
}
