package com.mobiliya.common.pageObjects;

import java.util.Set;

import com.mobiliya.framework.configure.BaseClass;

public class KeywordsCommon extends BaseClass {
	public static void contextSwitchNativeToWeb() {
		try {
			Thread.sleep(2000);
			@SuppressWarnings({ "unchecked" })
			Set<String> contextNames = driver.getContextHandles();
			for (String contextName : contextNames) {
				if (contextName.contains("WEBVIEW")) {
					driver.context(contextName);
					APP_LOGS.info("Switched to the context: "+contextName);
				}
			}
		} catch (Exception e) {
			APP_LOGS.error("Unable to switch context: "+e.getMessage());
			e.printStackTrace();
		}
	}

	public static void contextSwitchWebToNative() {
		try {
			driver.context("NATIVE_APP");
			APP_LOGS.info("Switched to the context: NATIVE_APP");
		} catch (Exception e) {
			APP_LOGS.error("Unable to switch context: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
