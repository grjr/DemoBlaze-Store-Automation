package com.gj.demoblazegj.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "logInModalLabel")
	WebElement loginModalLabel;

	@FindBy(id = "loginusername")
	WebElement loginUsername;

	@FindBy(id = "loginpassword")
	WebElement loginPassword;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginButton;

	@FindBy(xpath = "//div[@id='logInModal']//button[text()='Close']")
	WebElement loginCloseButton;

	@FindBy(xpath = "")
	WebElement loginCloseIcon;

	public WebElement getLoginUsername() {
		return loginUsername;
	}

	public WebElement getLoginPassword() {
		return loginPassword;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getLoginCloseButton() {
		return loginCloseButton;
	}

	public WebElement getLoginCloseIcon() {
		return loginCloseIcon;
	}

	public void login(String username, String pwd) {
		getLoginUsername().clear();
		getLoginUsername().sendKeys(username);
		getLoginPassword().clear();
		getLoginPassword().sendKeys(pwd);
		getLoginButton().click();
	}

	public void closeLoginModal_closeButton() {
		getLoginCloseButton().click();
	}

	public void closeLoginModal_closeIcon() {
		getLoginCloseIcon().click();
	}

}
