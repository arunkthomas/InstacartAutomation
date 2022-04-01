package com.instacart.constants;

public final class FrameworkConstants {
	
	private FrameworkConstants() {
		
	}
	
	private static final String CHROMEDRIVERPATH = "./chromedriver.exe";
	private static final String REPORTFILEPATH = "./reports\\index.html";
	private static final String EXCELFILEPATH = "./src\\test\\java\\resources\\TestData.xlsx";
	private static final String PROPERTYFILEPATH = "./src\\test\\java\\resources\\Config.Properties";
	
	public static String getPropertyFilePath() {
		return PROPERTYFILEPATH;
	}

	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
	}
	
	public static String getReportFilePath() {
		return REPORTFILEPATH;
	}
	
	public static String getExcelFilePath() {
		return EXCELFILEPATH;
	}

}
