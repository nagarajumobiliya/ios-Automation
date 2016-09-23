package com.mobiliya.edvelop.test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.mobiliya.framework.configure.Constants;
import com.mobiliya.framework.configure.IOSWebkitDebugProxyService;
import com.mobiliya.framework.configure.ManageDriver;
import com.mobiliya.framework.capabilities.DeviceCapabilities;
import com.mobiliya.framework.capabilities.EdvelopCapabilities;
import com.mobiliya.framework.configure.AppiumServerService;
import com.mobiliya.framework.configure.BaseClass;
import com.mobiliya.framework.utilities.ExcelUtility;
import com.mobiliya.framework.utilities.IOSDeviceVerification;

public class BaseTest extends BaseClass {

	@BeforeSuite
	public void setup() {
		try {
			if (Constants.PLATFORM_NAME.equalsIgnoreCase("iOS")) {
				IOSDeviceVerification.verifyConnectedIDevice();
				APP_LOGS.info("Device info: [Platform : iOS, Device Name: " + connectedDeviceName + ", Device UDID: "
						+ connectedDeviceUDID + "]");
			} else {
				APP_LOGS.info("Device info: [Platform : Android, Device Name: "
						+ DeviceCapabilities.getAndroidDeviceName() + "]");
			}
			ExcelUtility.setExcelFile(Constants.REPORT_FILEPATH, "Sheet1");
			IOSWebkitDebugProxyService.startIOSWebkitDebugProxyService();
			//AppiumServerService.setAppiumPort();
			//AppiumServerService.startServer2();
			EdvelopCapabilities.setEdvelopAppCapabilities();
			ManageDriver.setDriver();
			APP_LOGS.info("Setup Completed.");
		} catch (Exception e) {
			APP_LOGS.error("Unable to setup test: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void tearDown() {
		try {
			AppiumServerService.stopServer();
			IOSWebkitDebugProxyService.stopIOSWebkitDebugProxyService();
			/*try {
				Desktop.getDesktop().open(new File(Constants.REPORT_FILEPATH));
			} catch (IOException e) {
				APP_LOGS.error("Unable to perform IO: " + e.getMessage());
				e.printStackTrace();
			}*/
			APP_LOGS.info("Testing complete.");
		} catch (Exception e) {
			APP_LOGS.error("Unable to complete test: " + e.getMessage());
			e.printStackTrace();
		}
	}
}