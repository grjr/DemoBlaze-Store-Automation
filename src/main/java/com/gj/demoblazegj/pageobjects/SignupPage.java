package com.gj.demoblazegj.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

	public WebDriver driver;

	public SignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "signInModalLabel")
	WebElement signinModalLabel;

	@FindBy(id = "sign-username")
	WebElement signinUsername;

	@FindBy(id = "sign-password")
	WebElement signinPassword;

	@FindBy(xpath = "//button[text()='Sign up']")
	WebElement signUpButton;

	@FindBy(xpath = "//div[@id='signInModal']//button[contains(text(), 'Close')]")
	WebElement signinCloseButton;

	@FindBy(xpath = "")
	WebElement signinCloseIcon;

	public WebElement getSigninModalLabel() {
		return signinModalLabel;
	}
	
	public WebElement getSigninUsername() {
		return signinUsername;
	}

	public WebElement getSigninPassword() {
		return signinPassword;
	}

	public WebElement getSignUpButton() {
		return signUpButton;
	}

	public WebElement getSigninCloseButton() {
		return signinCloseButton;
	}

	public WebElement getSigninCloseIcon() {
		return signinCloseIcon;
	}

	public void signup(String username, String pwd) {
		getSigninUsername().sendKeys(username);
		getSigninPassword().sendKeys(pwd);
		getSignUpButton().click();
	}

	public void closeSigninModal_closeButton() {
		getSigninCloseButton().click();
	}

	public void closeSigninModal_closeIcon() {
		getSigninCloseIcon().click();
	}

}
