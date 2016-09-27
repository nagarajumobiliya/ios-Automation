package com.mobiliya.framework.configure;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageTimeouts extends BaseClass {
	
	public static void initializeImplicitWait() {
		try {
			driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIMEOUT_IN_SECS, TimeUnit.SECONDS);
			APP_LOGS.info("Implicit wait initialized.");
		} catch (Exception e) {
			APP_LOGS.error("Unable to initialize explicit wait: "+e.getMessage());
			e.printStackTrace();
		}
	}

	public static void initializeExplicitWait() {
		try {
			wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIMEOUT_IN_SECS);
			wait.withTimeout(Constants.EXPLICIT_WAIT_TIMEOUT_IN_SECS, TimeUnit.SECONDS)
					.pollingEvery(Constants.EXPLICIT_WAIT_POLLING_TIME_IN_MILLISECS, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
			APP_LOGS.info("Explicit wait initialized.");
		} catch (Exception e) {
			APP_LOGS.error("Unable to initialize explicit wait: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
