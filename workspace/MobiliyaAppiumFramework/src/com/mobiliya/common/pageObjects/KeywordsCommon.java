package com.mobiliya.common.pageObjects;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mobiliya.framework.configure.BaseClass;

public class KeywordsCommon extends BaseClass {
	public static void contextSwitchNativeToWeb() {
		@SuppressWarnings({ "unchecked" })
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName);
			if (contextName.contains("WEBVIEW")) {
				driver.context(contextName);
			}
		}
	}

	public static void contextSwitchWebToNative() {
		driver.context("NATIVE_APP");
	}
	
	public static void waitUntil(WebElement element){
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
