package com.mobiliya.framework.capabilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.openqa.selenium.remote.BrowserType;
import com.mobiliya.framework.configure.Constants;
import com.mobiliya.framework.configure.BaseClass;

import io.appium.java_client.remote.MobileCapabilityType;

public class DeviceCapabilities extends BaseClass {

	public static void setDeviceCapabilities() {
		try {
			if (Constants.PLATFORM_NAME.equalsIgnoreCase("iOS")) {
				caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
				// caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,
				// Constants.PLATFORM_VERSION);
				//caps.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.SAFARI);
				caps.setCapability(MobileCapabilityType.DEVICE_NAME, connectedDeviceName);
				caps.setCapability(MobileCapabilityType.UDID, connectedDeviceUDID);
			} else {
				caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				// caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,
				// Constants.PLATFORM_VERSION);
				caps.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.ANDROID);
				caps.setCapability(MobileCapabilityType.DEVICE_NAME, getAndroidDeviceName());
			}

			caps.setCapability(MobileCapabilityType.FULL_RESET, Constants.FULL_RESET);
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 15000);
			APP_LOGS.info("Device capabilities Specified.");
		} catch (Exception e) {
			APP_LOGS.error("Unable to specify device capabilities: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static String getAndroidDeviceName() {
		try {
			String[] command = { "/bin/bash", "--login", "adb", "devices" };
			// StringBuilder cmdReturn = new StringBuilder();
			ProcessBuilder processBuilder = new ProcessBuilder(command);
			Process process = processBuilder.start();

			InputStream processStdOutput = process.getInputStream();
			Reader r = new InputStreamReader(processStdOutput);
			BufferedReader br = new BufferedReader(r);
			String connectedAndroidDevice = null;
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains("device")) {
					String splitLine[] = line.split(" ");
					connectedAndroidDevice = splitLine[0];
					break;
				} else {
					APP_LOGS.info("No device / unsupported device!");
				}
			}
			return connectedAndroidDevice;
		} catch (IOException e) {
			APP_LOGS.info("Unable to get device information: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
}