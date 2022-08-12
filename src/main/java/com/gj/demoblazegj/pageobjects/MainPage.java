package com.gj.demoblazegj.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	public WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "login2")
	WebElement loginLink;

	@FindBy(id = "signin2")
	WebElement signupLink;

	@FindBy(id = "logout2")
	WebElement logoutLink;

	@FindBy(xpath = "//div[@id='signInModal']")
	WebElement signUpModalParentDiv;

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getSignupLink() {
		return signupLink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getSignUpModalParentDiv() {
		return signUpModalParentDiv;
	}

	public boolean isSignUpModalDisplayed() {
		return getSignUpModalParentDiv().getAttribute("class").contains("show") ? true : false;
	}

	public boolean isLoginLinkDisplayed() {
		return getLoginLink().getAttribute("style").contains("display: none") ? false : true;
	}

	public boolean isLogoutLinkDisplayed() {
		return getLogoutLink().getAttribute("style").contains("display: none") ? false : true;
	}

	public void gotoSignUp() {
		getSignupLink().click();
	}

	public void gotoLogin() {
		getLoginLink().click();
	}
	
	public void logout() {
		getLogoutLink().click();
	}

}
