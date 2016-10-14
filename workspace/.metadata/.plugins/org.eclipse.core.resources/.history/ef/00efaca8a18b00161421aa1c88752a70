package com.mobiliya.edvelop.pageObjects;

import org.openqa.selenium.support.PageFactory;

import com.mobiliya.framework.configure.BaseClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
	public MobileElement btn_sign_in_with_facebook;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")
	public MobileElement btn_sign_in_with_google;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[3]")
	public MobileElement btn_sign_in_with_microsoft;

	public void clickSignInWithFacebookButton() {
		btn_sign_in_with_facebook.click();
	}

	public void clickSignInWithGoogleButton() {
		btn_sign_in_with_google.click();
	}

	public void clickSignInWithMicrosoftButton() {
		btn_sign_in_with_microsoft.click();
	}

}
