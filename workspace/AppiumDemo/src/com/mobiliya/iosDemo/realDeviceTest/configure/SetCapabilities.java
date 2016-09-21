package com.mobiliya.iosDemo.realDeviceTest.configure;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class SetCapabilities {

	@SuppressWarnings("rawtypes")
	public static AppiumDriver driver = null;
	public static DesiredCapabilities caps = null;
	public static WritableWorkbook writableWorkbook = null;
	public static WritableSheet writableSheet = null;
	public static Label label = null;
	public static int excelRow = 0;
	public static WebDriverWait wait = null;

	public static void initializeExplicitWait() {
		try {
			wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIMEOUT_IN_SECS);
			wait.withTimeout(Constants.EXPLICIT_WAIT_TIMEOUT_IN_SECS, TimeUnit.SECONDS)
					.pollingEvery(Constants.EXPLICIT_WAIT_POLLING_TIME_IN_MILLISECS, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
			System.out.println("Wait initialized.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setDeviceCapabilities() {
		String []connectedDevice = Utilities.getForUid();
		try {
			Constants.DEVICE_NAME = connectedDevice[0];
			Constants.DEVICE_UDID = connectedDevice[1];
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Constants.PLATFORM_NAME);
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, Constants.PLATFORM_VERSION);
			//caps.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.SAFARI);
			//caps.setCapability(MobileCapabilityType.PLATFORM, Constants.PLATFORM);
			caps.setCapability(MobileCapabilityType.FULL_RESET, Constants.FULL_RESET);
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, connectedDevice[0]);
			caps.setCapability(MobileCapabilityType.UDID, connectedDevice[1]);
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 15000);
			System.out.println("Device capabilities Specified.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setGitHubAppCapabilities() {
		try {
			caps = new DesiredCapabilities();
			SetCapabilities.setDeviceCapabilities();
			
			caps.setCapability("app", Constants.GITHUB_APP_PATH);
			caps.setCapability("bundleId", Constants.GITHUB_BUNDLE_ID);
			System.out.println("GitHubApp capabilities specified.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setOrtholineAppCapabilities() {
		try {
			caps = new DesiredCapabilities();
			SetCapabilities.setDeviceCapabilities();
			
			caps.setCapability("app", Constants.ORTHOLINE_APP_PATH);
			caps.setCapability("bundleId", Constants.ORTHOLINE_BUNDLE_ID);
			System.out.println("OrtholineApp capabilities specified.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setEdvelopAppCapabilities() {
		try {
			caps = new DesiredCapabilities();
			SetCapabilities.setDeviceCapabilities();
			caps.setCapability("waitForAppScript", Constants.EDVELOP_WAIT_FOR_APP_SCRIPT);
			caps.setCapability("autoAcceptAlerts", Constants.EDVELOP_AUTO_ACCEPT_ALERTS);
			
			caps.setCapability("app", Constants.EDVELOP_APP_PATH);
			caps.setCapability("bundleId", Constants.EDVELOP_BUNDLE_ID);
			System.out.println("EdvelopApp capabilities specified.");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void setSafariLauncherCapabilities() {
		try {
			caps = new DesiredCapabilities();
			SetCapabilities.setDeviceCapabilities();
			caps.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.SAFARI);
			System.out.println("SafariLauncher capabilities specified.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	public static void setDriver() {

		try {
			try {
				driver = new IOSDriver(new URL(Constants.APPIUM_SERVICE_URL), caps);
				System.out.println("Connected to Appium Server.");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIMEOUT_IN_SECS, TimeUnit.SECONDS);
			SetCapabilities.initializeExplicitWait();
			System.out.println("Driver setup completed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
