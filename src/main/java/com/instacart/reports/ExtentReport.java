package com.instacart.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.instacart.constants.FrameworkConstants;
import com.instacart.utils.PropertyUtils;

public final class ExtentReport {
	
	private ExtentReport() {}
	
	private static ExtentReports extent;
	public static ExtentTest test;
	
	public static void iniReports() {
		if (Objects.isNull(extent)) {
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getReportFilePath());
			extent = new ExtentReports();
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Test Report");
			spark.config().setReportName("Results");
		}
		
	}
	
	public static void flushReports() {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
	}
	
	public static void createTest(String testcasename) {
		test = extent.createTest(testcasename);
		ExtentManager.setExtentTest(test); 
		
	}
}
