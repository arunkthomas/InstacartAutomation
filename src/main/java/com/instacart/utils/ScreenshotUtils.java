package com.instacart.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.instacart.driver.DriverManager;

public final class ScreenshotUtils {
	
	private ScreenshotUtils() {
		
	}
	
	public static String getBase64Image() {
		TakesScreenshot screenShot= (TakesScreenshot)DriverManager.getDriver();
		return screenShot.getScreenshotAs(OutputType.BASE64);
	}

}
