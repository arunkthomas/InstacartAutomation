package com.instacart.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.instacart.driver.Driver;
import com.instacart.reports.ExtentLogger;
import com.instacart.reports.ExtentReport;

public class Listeners implements ITestListener, ISuiteListener {
	

	public void onStart(ISuite suite) {
		ExtentReport.iniReports();
		
	}

	public void onFinish(ISuite suite) {
		ExtentReport.flushReports();
	}

	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName()); 
		
		
	}

	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + " is passed",true);
		
	}

	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName()+ " is failed",true);
		ExtentLogger.fail(result.getThrowable().toString());
	
	}

	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+ " is skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		//Not used for now
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		//Not used for now
	}

	public void onStart(ITestContext context) {
		//Not used for now
	}

	public void onFinish(ITestContext context) {
		//Not used for now
	}

	
}
