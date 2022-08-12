package com.gj.demoblazegj.tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gj.demoblazegj.Base;
import com.gj.demoblazegj.pageobjects.LoginPage;
import com.gj.demoblazegj.pageobjects.MainPage;

public class InvalidLoginTest extends Base {

	public WebDriver driver;
	WebDriverWait wait;
	LoginPage loginPage;
	MainPage mainPage;

	@BeforeTest
	public void setup() throws IOException {
		driver = initializeDriver();
		driver.get(props.getProperty("url"));
		mainPage = new MainPage(driver);
		loginPage = new LoginPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		mainPage.gotoLogin();
	}

	@Test(priority = 1)
	public void invalidUserLogin() {
		loginPage.login("hai122", "hai122");
		wait.until(ExpectedConditions.alertIsPresent());
		Alert jsAlert = driver.switchTo().alert();
		AssertJUnit.assertEquals(jsAlert.getText(), "User does not exist.");
		jsAlert.accept();
		loginPage.closeLoginModal_closeButton();
	}

	@Test(priority = 2)
	public void logoutOptionShouldNotDisplay() {
		Assert.assertEquals(false, mainPage.isLogoutLinkDisplayed());
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
