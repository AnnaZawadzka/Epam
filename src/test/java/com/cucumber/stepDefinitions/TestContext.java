package com.cucumber.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestContext {

	private WebDriver driver;

	@Before
	public void setupBrowser() {
		System.setProperty("webdriver.chrome.driver", "seleniumUtils/chromedriver.exe");
		driver = new ChromeDriver();
		
	}

	@After
	public void tearDownBrowser() {
		driver.quit();
	}
	
	@After
	public void tearDown() throws Exception 	{
		driver.manage().deleteAllCookies();
	}


	public WebDriver getDriver() {
		return this.driver;
	}
	}
