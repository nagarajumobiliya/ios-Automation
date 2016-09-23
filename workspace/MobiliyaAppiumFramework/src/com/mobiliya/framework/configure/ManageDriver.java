package com.mobiliya.framework.configure;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.ios.IOSDriver;

public class ManageDriver extends BaseClass {

	@SuppressWarnings("rawtypes")
	public static void setDriver() {

		try {
			URL url = null;
			try {
				url = new URL(appiumServiceUrl);
			} catch (MalformedURLException e) {
				APP_LOGS.error("Invalid URL specification: " + e.getMessage());
				e.printStackTrace();
			}
			driver = new IOSDriver(url, caps);
			APP_LOGS.info("Connected to Appium Server.");

			ManageTimeouts.initializeImplicitWait();
			ManageTimeouts.initializeExplicitWait();
			APP_LOGS.info("Driver setup completed.");
		} catch (Exception e) {
			APP_LOGS.error("Unable to setup driver: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
