package com.mobiliya.framework.utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.mobiliya.framework.configure.Constants;
import com.mobiliya.framework.configure.BaseClass;

public class ScreenshotUtility extends BaseClass {
	public static void takeScreenshot(String methodName) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(
					Constants.SCREENSHOTS_DIR_PATH + "Screenshot_" + methodName + "_" + getCurrentTime() + ".jpg"));
			APP_LOGS.info("Screenshot taken.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getCurrentTime() {
		try {
			Date date = new Date();
			Timestamp timestamp = new Timestamp(date.getTime());
			return timestamp.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
