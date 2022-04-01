package com.instacart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.instacart.driver.DriverManager;
import com.instacart.reports.ExtentLogger;

public final class HomePage {
	
	private static By buttonShowall = By.xpath("//button[text()='Show all']");
	private static By buttonStoreList = By.xpath("//p[@class='css-3w8d2s']");
	private static By textboxCurrentAddress = By.xpath("//input[@name='homepage-address-input']");
	private static By buttonCurrentLocation = By.xpath("//button[@data-testid='address-results-use-current-location']");
	private static By linkGreaterTorontoArea =By.xpath("//span[text()='Greater Toronto Area']");
	private static By buttonPopCurrentLocation = By.xpath("//button[@class='css-47mte7']");
	private static By textboxPopCurrentaddress = By.xpath("//input[@aria-labelledby='addressInputError']");
	
	

	public static void clickShowall() {
		DriverManager.getDriver().findElement(buttonShowall).click();
		ExtentLogger.pass("Show all button clicked");
	}
	
	public static ArrayList<String> getStoreList() {
		List<WebElement> storeList= DriverManager.getDriver().findElements(buttonStoreList); 
		ArrayList<String> storeListName = new ArrayList<String>(); 
		for(WebElement element:storeList) {
			storeListName.add(element.getText());
			
		} 
		ExtentLogger.pass("Store list name collected");
		return storeListName;
		
	}
	public static WebElement getAddress() {
		return DriverManager.getDriver().findElement(textboxCurrentAddress);
		
	}
	public static void clickCurrentLocation() {
		DriverManager.getDriver().findElement(buttonCurrentLocation).click();
		ExtentLogger.pass("Current Location clicked");
	}
	public static String getCurrentAddress() {
		ExtentLogger.pass("Current address taken from textfield");
		return DriverManager.getDriver().findElement(textboxCurrentAddress).getAttribute("value");
		
	}
	public static void clickGreatTorontoArea() {
		DriverManager.getDriver().findElement(linkGreaterTorontoArea).click();
		ExtentLogger.pass("GreaterTorontoArea clicked");
	}
	public static void clickCurrentLocationPop() {
		DriverManager.getDriver().findElement(buttonPopCurrentLocation).click();
		ExtentLogger.pass("Current Location clicked");
	}
	public static String getCurrentAddressPop() {
		ExtentLogger.pass("Current address taken from textfield");
		return DriverManager.getDriver().findElement(textboxPopCurrentaddress).getAttribute("value");
	}
}
