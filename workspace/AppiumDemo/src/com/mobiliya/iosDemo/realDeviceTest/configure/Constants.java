package com.mobiliya.iosDemo.realDeviceTest.configure;

public class Constants {

	// Excel report file path
	public static final String REPORT_FILEPATH = System.getProperty("user.dir") + "/Reports/report.xls";
	public static final String REPORT_FILENAME = "report.xls";

	// Screenshots directory path
	public static final String SCREENSHOTS_DIR_PATH = System.getProperty("user.dir") + "/Screenshots/";

	// Implicit / Explicit Waits
	public static final int IMPLICIT_WAIT_TIMEOUT_IN_SECS = 60;
	public static final int EXPLICIT_WAIT_TIMEOUT_IN_SECS = 120;
	public static final int EXPLICIT_WAIT_POLLING_TIME_IN_MILLISECS = 500;

	// Appium Service / Server
	public static final String APPIUM_NODE_PATH = "/Applications/Appium.app/Contents/Resources/node/bin/node";
	public static final String APPIUM_SERVICE_PATH = "/Applications/Appium.app/Contents/Resources/node_modules/appium/build/lib/main.js";
	public static final String APPIUM_SERVICE_URL = "http://0.0.0.0:4723/wd/hub";
	public static final String APPIUM_SERVER_IP_ADDR = "0.0.0.0";
	public static final String APPIUM_SERVER_PORT = "4723";
	public static final String IOS_WEBKIT_DEBUG_PROXY_SERVICE_PATH = "/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/ios-webkit-debug-proxy-launcher.js";

	// Device Capabilities
	public static final String PLATFORM_NAME = "iOS";
	public static final String PLATFORM_VERSION = "9.3.4";
	public static final String PLATFORM = "Mac";
	public static final boolean FULL_RESET = true;
	public static  String DEVICE_NAME = null;
	public static  String DEVICE_UDID = null;
	public static final String[] DEVICE_NAMEs = {"AgreeYaHP-09", "Mayank's iPhone"};
	public static final String[] DEVICE_UDIDS = {"c4c9cb86f9444c53a06925863fb43bff4ac81a2c","1dae97c7b2a2203799e620d2197a6165f6e65f10"};

	// GitHub App Capabilities
	public static final String GITHUB_BUNDLE_ID = "net.agreeyamobility.Test-App";
	public static final String GITHUB_APP_PATH = System.getProperty("user.dir") + "/Apps/GitHub.ipa";

	// Ortholine App Capabilities
	public static final String ORTHOLINE_BUNDLE_ID = "net.agreeyamobility.Test-App";
	public static final String ORTHOLINE_APP_PATH = System.getProperty("user.dir") + "/Apps/Ortholine.ipa";

	// Edvelop App Capabilities
	public static final String EDVELOP_BUNDLE_ID = "net.agreeyamobility.Test-App";
	public static final String EDVELOP_APP_PATH = (System.getProperty("user.dir") + "/Apps/EdvelopDock.ipa");
	public static final boolean EDVELOP_AUTO_ACCEPT_ALERTS = true;
	public static final String EDVELOP_WAIT_FOR_APP_SCRIPT = "$.delay(5000); true;";

	// Email Settings
	public static final String EMAIL_TO = "chetan.lokhande@mobiliya.com";
	public static final String EMAIL_FROM = "mobiliya1234@gmail.com";
	public static final String EMAIL_USERNAME = "mobiliya1234";
	public static final String EMAIL_PASSWORD = "mobiliya123";
	public static final String EMAIL_HOST = "smtp.gmail.com";
	public static final String EMAIL_PORT = "465";
	public static final boolean EMAIL_SMTP_AUTH = true;
	
	//Test Email Settings
	public static final String TestAccountEmail = "kanika.jaypee@gmail.com";
	public static final String TestAccountPassword = "AgreeYa@123";

	// Test pass /fail results
	public static final String RESULT_TEST_PASS = "Pass";
	public static final String RESULT_TEST_FAIL = "Fail";
	
	

}
