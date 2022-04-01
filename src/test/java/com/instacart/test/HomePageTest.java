package com.instacart.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.instacart.pages.HomePage;
import com.instacart.utils.ExcelUtils;

public class HomePageTest extends BaseTest {
	
	private HomePageTest() {
		
	}
	

	@Test
	public void verifyStoreName() { 
		HomePage.clickShowall();
		ArrayList<String> actualStoreList = HomePage.getStoreList();
		List<Map<String, String>> list = ExcelUtils.getData("ExpectedData");
		List <String> expectedStoreList = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			expectedStoreList.add(list.get(i).get("ExpectedData1"));
		}
		for (String element:actualStoreList) {
			Assert.assertTrue(expectedStoreList.contains(element),element + " not present in expectedlist");
		}

	}

	@Test
	public void verifyAddress() {
		String actual=null;
		
		if(HomePage.getAddress().isDisplayed()) {
			HomePage.getAddress().click();
			HomePage.clickCurrentLocation();
			actual = HomePage.getCurrentAddress();
			
		}

		else {
			HomePage.clickGreatTorontoArea();
			HomePage.clickCurrentLocationPop();
			Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
			actual= HomePage.getCurrentAddressPop();

		}
		List<Map<String, String>> list = ExcelUtils.getData("ExpectedData");
		String expected= list.get(0).get("ExpectedData2");
		Assert.assertEquals(actual, expected, "expected current address doesnot match the actual" );

	}
	

}
