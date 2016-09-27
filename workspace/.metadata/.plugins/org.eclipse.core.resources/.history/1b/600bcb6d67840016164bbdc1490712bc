package com.mobiliya.edvelop.pageObjects;

import org.openqa.selenium.support.PageFactory;

import com.mobiliya.framework.configure.BaseClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchableElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class IntroScreensPage extends BaseClass {

	public IntroScreensPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAImage[1]")
	public TouchableElement img_intro;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
	public MobileElement btn_get_started;

	public void SwipeIntroImages() {
		for (int i = 0; i < 2; i++) {
			img_intro.swipe(SwipeElementDirection.LEFT, 100);
		}
	}

	public String getTextGetStartedButton() {
		return btn_get_started.getAttribute("name");
	}
	
	public void clickGetStartedButton() {
		btn_get_started.click();
	}
}

//
