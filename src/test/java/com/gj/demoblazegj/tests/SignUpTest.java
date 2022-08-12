package com.gj.demoblazegj.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gj.demoblazegj.Base;
import com.gj.demoblazegj.pageobjects.MainPage;
import com.gj.demoblazegj.pageobjects.SignupPage;

public class SignUpTest extends Base {

	public WebDriver driver;
	WebDriverWait wait;
	MainPage mainPage;
	SignupPage signupPage;
	String newUsername = "";

	@BeforeTest
	public void setup() throws IOException {
		driver = initializeDriver();
		driver.get(props.getProperty("url"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mainPage = new MainPage(driver);
		signupPage = new SignupPage(driver);
	}

	@BeforeMethod
	public void refreshPage() {
		driver.navigate().refresh();
		mainPage.gotoSignUp();
	}

	@Test
	public void signupNewUser() {
		newUsername = generateUsername();
		signupPage.signup(newUsername, "test123");
		wait.until(ExpectedConditions.alertIsPresent());
		Alert jsAlert = driver.switchTo().alert();
		Assert.assertEquals(jsAlert.getText(), "Sign up successful.");
		jsAlert.accept();
	}

	@Test
	public void signupExistingUser() {
		signupPage.signup("hai123", "test123");
		wait.until(ExpectedConditions.alertIsPresent());
		Alert jsAlert = driver.switchTo().alert();
		Assert.assertEquals(jsAlert.getText(), "This user already exist.");
		jsAlert.accept();
	}

	@Test
	public void passwordRequired() {
		newUsername = generateUsername();
		signupPage.signup(newUsername, "");
		wait.until(ExpectedConditions.alertIsPresent());
		Alert jsAlert = driver.switchTo().alert();
		Assert.assertEquals(jsAlert.getText(), "Please fill out Username and Password.");
		jsAlert.accept();
	}

	@Test
	public void closeButtonCancelsSignUp() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(signupPage.getSigninModalLabel()));
		signupPage.closeSigninModal_closeButton();
		wait.until(ExpectedConditions.invisibilityOf(signupPage.getSigninModalLabel()));
		Assert.assertFalse(mainPage.isSignUpModalDisplayed());
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

	public String generateUsername() {
		UUID randomUUID = UUID.randomUUID();
		return randomUUID.toString().substring(0, 6);
	}

}