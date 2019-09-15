package com.telerikacademy.testframework;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.logging.log4j.Logger;

public class UserActions {
	public static final Logger logger = Utils.LOG;
	final WebDriver driver;

	public UserActions() {
		this.driver = Utils.getWebDriver();
	}

	public static void loadBrowser() {
		Utils.getWebDriver().get(Utils.getConfigPropertyByKey("base.url"));
	}

	public static void quitDriver(){
		Utils.tearDownWebDriver();
	}

	public void clickElement(String key){
		logger.info("Clicking on element " + key);
		WebElement element =driver.findElement(By.xpath(Utils.getUIMappingByKey(key)));
		element.click();
	}

	public void typeValueInField(String value, String field){
		WebElement element = driver.findElement(By.xpath(Utils.getUIMappingByKey(field)));
		element.sendKeys(value);
	}

	//############# WAITS #########

	public void waitForElementVisible(String locator, int seconds){
		WebElement element= driver.findElement(By.xpath(Utils.getUIMappingByKey(locator)));
		WebDriverWait wait= new WebDriverWait(driver,seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	//############# ASSERTS #########

	public void assertElementPresent(String locator){
		Assert.assertNotNull(driver.findElement(By.xpath(Utils.getUIMappingByKey(locator))));
	}
}
