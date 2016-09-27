package com.mobiliya.edvelop.pageObjects;

import org.openqa.selenium.support.PageFactory;

import com.mobiliya.framework.configure.BaseClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class BackToLoginPage extends BaseClass {
	public BackToLoginPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]")
	public MobileElement static_text_err_msg;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
	public MobileElement btn_back_to_login;

	public String getTextErrMsgInvalidLogin() {
		try {
			return static_text_err_msg.getAttribute("name");
		} catch (Exception e) {
			APP_LOGS.error("Unable to get text: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public void clickBackToLoginButton() {
		try {
			btn_back_to_login.click();
		} catch (Exception e) {
			APP_LOGS.error("Unable to click:" + e.getMessage());
			e.printStackTrace();
		}
	}
}
