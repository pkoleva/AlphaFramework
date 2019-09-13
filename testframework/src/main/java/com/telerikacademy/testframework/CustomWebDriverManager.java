package com.telerikacademy.testframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.FirefoxDriverManager;


public class CustomWebDriverManager {
	public enum CustomWebDriverManagerEnum {
		INSTANCE;
		private WebDriver driver = setupBrowser();

		private WebDriver setupBrowser(){
			FirefoxDriverManager.getInstance().setup();
			WebDriver firefoxDriver = new FirefoxDriver();
			firefoxDriver.manage().window().maximize();
			return firefoxDriver;
		}

		public void quitDriver() {
			if (driver != null) {
				driver.quit();
			}
		}

		public WebDriver getDriver() {
			return driver;
		}


	}
}
