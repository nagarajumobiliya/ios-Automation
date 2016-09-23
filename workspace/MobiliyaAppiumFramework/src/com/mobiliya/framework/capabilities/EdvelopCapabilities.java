package com.mobiliya.framework.capabilities;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.mobiliya.framework.configure.BaseClass;
import com.mobiliya.framework.configure.Constants;

public class EdvelopCapabilities extends BaseClass {
	public static void setEdvelopAppCapabilities() {
		try {
			caps = new DesiredCapabilities();
			DeviceCapabilities.setDeviceCapabilities();
			caps.setCapability("waitForAppScript", Constants.EDVELOP_WAIT_FOR_APP_SCRIPT);
			caps.setCapability("autoAcceptAlerts", Constants.EDVELOP_AUTO_ACCEPT_ALERTS);
			caps.setCapability("app", Constants.EDVELOP_APP_PATH);
			caps.setCapability("bundleId", Constants.EDVELOP_BUNDLE_ID);
			APP_LOGS.info("EdvelopApp capabilities specified.");
		} catch (Exception e) {
			APP_LOGS.error("Unable to specify app capabilities: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
