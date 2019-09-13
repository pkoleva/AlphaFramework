package com.telerikacademy.testframework;

import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Utils {

	private static Properties uiMappings =  PropertiesManager.PropertiesManagerEnum.INSTANCE.getUiMappings();
	private static Properties configProperties =  PropertiesManager.PropertiesManagerEnum.INSTANCE.getConfigProperties();

	public static WebDriver getWebDriver() {
		return CustomWebDriverManager.CustomWebDriverManagerEnum.INSTANCE.getDriver();
	}

	public static void tearDownWebDriver() {
		CustomWebDriverManager.CustomWebDriverManagerEnum.INSTANCE.quitDriver();
	}

	public static String getUIMappingByKey(String key) {
		String value = uiMappings.getProperty(key);
		return value != null ? value : key;
	}

	public static Properties getConfigProperties() {
		return PropertiesManager.PropertiesManagerEnum.INSTANCE.getConfigProperties();
	}

	public static String getConfigPropertyByKey(String key){
		return configProperties.getProperty(key);
	}

}
