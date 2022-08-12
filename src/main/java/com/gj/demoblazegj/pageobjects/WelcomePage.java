package com.gj.demoblazegj.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

	public WebDriver driver;

	public WelcomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "nameofuser")
	WebElement welcomeUserLabel;

	public WebElement getWelcomeUserLabel() {
		return welcomeUserLabel;
	}

}
