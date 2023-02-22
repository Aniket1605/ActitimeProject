package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.pom.Homepage;
import com.Actitime.pom.LoginPage;

public class Baseclass {
	
	FileLibrary f=new FileLibrary();
	
	public static WebDriver driver;
	@BeforeSuite
	public void databaseconnection() {
	Reporter.log("database connected",true);	
	}
	
	@AfterSuite
	public void databasedisconnection() {
		Reporter.log("database disconnected",true);
	}
	
	@BeforeClass
	public void launchBrowser() throws IOException {
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String Url = f.readDataFromPropertyFile("url");
		driver.get(Url);
		Reporter.log("browser launched successfully",true);
		
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
		Reporter.log("browser closed successfully",true);
		
	}
	
	
	
	
	
	@BeforeMethod
	public void loginToActitime() throws IOException {
		String UN = f.readDataFromPropertyFile("username");
		String PW = f.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.login(UN, PW);
		Reporter.log("logged in successfully",true);
	}
	
	@AfterMethod
	public void logoutFromActitime() throws InterruptedException {
		Homepage hp=new Homepage(driver);
		Thread.sleep(3000);
		hp.getLgoutlnk().click();
		Reporter.log("logged out successfully",true);
	}
	
	
	
	
	
	
	
	
	
	

}
