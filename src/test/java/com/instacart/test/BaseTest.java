package com.instacart.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.instacart.driver.Driver;

public class BaseTest {
	

	@BeforeMethod
	public void setUp() {
		Driver.iniDriver();
	}

	
	@AfterMethod
	public void tearDown() {
		Driver.quitDriver();
	}

 

}
