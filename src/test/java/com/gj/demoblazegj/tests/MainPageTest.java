 package com.gj.demoblazegj.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gj.demoblazegj.Base;

public class MainPageTest extends Base {

	public WebDriver driver;

	@BeforeTest
	public void launch() throws IOException {
		driver = initializeDriver();
		driver.get(props.getProperty("url"));
	}

	@Test
	public void validateTitle() {
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "STORE");
	}

	@AfterTest
	public void quit() {
		driver.quit();
	}

}
