package com.gj.demoblazegj.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gj.demoblazegj.Base;
import com.gj.demoblazegj.pageobjects.LoginPage;
import com.gj.demoblazegj.pageobjects.MainPage;
import com.gj.demoblazegj.pageobjects.WelcomePage;

public class ValidLoginTest extends Base {

	public WebDriver driver;
	WebDriverWait wait;
	LoginPage loginPage;
	WelcomePage welcomePage;
	MainPage mainPage;

	@BeforeTest
	public void setup() throws IOException {
		driver = initializeDriver();
		driver.get(props.getProperty("url"));
		mainPage = new MainPage(driver);
		welcomePage = new WelcomePage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		loginPage = new LoginPage(driver);
		mainPage.gotoLogin();
	}

	@Test(priority = 1)
	public void validUserLogin() {
		loginPage.login("hai123", "hai123");
		wait.until(ExpectedConditions.visibilityOf(welcomePage.getWelcomeUserLabel()));
		Assert.assertEquals(welcomePage.getWelcomeUserLabel().getText(), "Welcome hai123");
	}

	@Test(priority = 2)
	public void loginOptionShouldNotDisplay() {
		Assert.assertEquals(false, mainPage.isLoginLinkDisplayed());
	}
	
	@Test(priority = 3)
	public void logoutOptionShouldDisplay() {
		Assert.assertEquals(true, mainPage.isLogoutLinkDisplayed());
	}
	
	@Test(priority = 4)
	public void logout() {
		mainPage.logout();
		Assert.assertEquals(true, mainPage.isLoginLinkDisplayed());
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
