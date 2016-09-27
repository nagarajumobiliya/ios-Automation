package com.mobiliya.framework.configure;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {

	public static Logger APP_LOGS;
	@SuppressWarnings("rawtypes")
	public static AppiumDriver driver = null;
	public static AppiumDriverLocalService appiumService=null;
	public static String appiumServiceUrl="http://0.0.0.0:4723/wd/hub";
	public static WebDriverWait wait = null;
	public static DesiredCapabilities caps = null;
	public static String connectedDeviceName = null;
	public static String connectedDeviceUDID = null;
	public static String currentAppiumPort = null;
	
	static {
		try {
			String path = System.getProperty("user.dir") + "/src/com/mobiliya/framework/configure/";
			PropertyConfigurator.configure(path + "Log4j.properties");
			APP_LOGS = Logger.getLogger(BaseClass.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}