package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	@FindBy(xpath = "//div[.='Tasks']")
private WebElement tasklnk;
	
	@FindBy(id="logoutLink")
	private WebElement lgoutlnk;
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getTasklnk() {
		return tasklnk;
	}

	public WebElement getLgoutlnk() {
		return lgoutlnk;
	}
	

}
