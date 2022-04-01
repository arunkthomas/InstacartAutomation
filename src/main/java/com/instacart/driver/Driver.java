package com.instacart.driver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import com.instacart.constants.FrameworkConstants;
import com.instacart.utils.PropertyUtils;

public final class Driver {
	
	private Driver () {
		
	}
	
	public static void iniDriver() {
		if (Objects.isNull(DriverManager.getDriver())) {
			System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
			DriverManager.setDriver(new ChromeDriver());
			DriverManager.getDriver().manage().deleteAllCookies();
			DriverManager.getDriver().get(PropertyUtils.getValue("url"));
			DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}
	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unloadDriver();
		}
	}

}
