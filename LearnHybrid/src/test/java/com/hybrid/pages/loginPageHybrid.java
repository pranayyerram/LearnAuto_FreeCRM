package com.hybrid.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class loginPageHybrid {
WebDriver driver;
	
	//WebElement uname1 = driver.findElement(By.xpath("//input[@name='username']"));
	//WebElement pass1 = driver.findElement(By.xpath("//input[@name='password']"));
	//WebElement LoginBtn = driver.findElement(By.xpath("//input[@class='btn btn-small']"));
	public loginPageHybrid(WebDriver ldriver) {
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(how=How.NAME, using= "username") WebElement uname1;
	
	@FindBy(how=How.NAME, using="password") WebElement pass1;
	@FindBy(how=How.XPATH, using="//*[@id=\"loginForm\"]/div/div/input") WebElement LoginBtn;
	
	public void LoginToApp(String usernameApp, String passwordApp) {
		uname1.sendKeys(usernameApp);
		pass1.sendKeys(passwordApp);
		LoginBtn.click();
	}
}
