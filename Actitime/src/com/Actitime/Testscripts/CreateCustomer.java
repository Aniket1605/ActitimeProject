package com.Actitime.Testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.Baseclass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.pom.Homepage;
import com.Actitime.pom.TaskPage;

public class CreateCustomer extends Baseclass{
	FileLibrary flib=new FileLibrary();
@Test
public void createCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
	Homepage hp=new Homepage(driver);
	hp.getTasklnk().click();
	
	TaskPage tp=new TaskPage(driver);
	String custname = flib.readDataFromExcelFile("Sheet1",4, 1);
	String description = flib.readDataFromExcelFile("Sheet1", 1, 2);
	tp.completetask(custname, description);
	String expected=custname;
	System.out.println(expected);
	 String actualdata = driver.findElement(By.xpath("//div[@title='"+custname+"']")).getText();
	SoftAssert s=new SoftAssert();
	s.assertEquals(expected, actualdata);
	Reporter.log("assertion pass",true);
	s.assertAll();
	
			
	
}


}
