package com.mobiliya.framework.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.mobiliya.framework.configure.BaseClass;
import com.mobiliya.framework.utilities.ScreenshotUtility;

public class TestListener extends BaseClass implements ITestListener{

	@Override
	public void onFinish(ITestContext finish) {
		APP_LOGS.info("Test Finished :"+finish.getName());
	}

	@Override
	public void onStart(ITestContext started) {
		APP_LOGS.info("Test Started : "+started.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult perFail) {
		APP_LOGS.info("Test failed but within success percentage  : "+perFail.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult failed) {
		String methodName=failed.getName().toString().trim();
		APP_LOGS.info("Test case failed : "+methodName);
		ScreenshotUtility.takeScreenshot(methodName);	
	}

	@Override
	public void onTestSkipped(ITestResult skipped) {
		APP_LOGS.info("Test case skipped : "+skipped.getName());
		
	}

	@Override
	public void onTestStart(ITestResult started) {
		APP_LOGS.info("Test case execution started : "+started.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult passed) {
		APP_LOGS.info("Test case passed : "+passed.getName());
		
	}

}