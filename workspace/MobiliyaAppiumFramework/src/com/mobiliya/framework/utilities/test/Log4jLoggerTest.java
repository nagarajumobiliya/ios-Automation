package com.mobiliya.framework.utilities.test;

import com.mobiliya.framework.configure.BaseClass;

public class Log4jLoggerTest extends BaseClass {
	public static void main(String[] args) {
		try {
			//System.out.println(System.getProperty("user.dir"));
			//loadProperties();
			APP_LOGS.info("Hello Log4j!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
