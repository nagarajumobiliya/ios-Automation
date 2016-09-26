package com.mobiliya.edvelop.test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mobiliya.edvelop.AppConstants;
import com.mobiliya.edvelop.pageObjects.IntroScreensPage;

public class TestDisplayIntroScreens extends BaseTest {
	@Test
	public void testDisplayIntroScreensOnFirstLaunch() {
		IntroScreensPage introPage = new IntroScreensPage();
		introPage.SwipeIntroImages();
		wait.until(ExpectedConditions.visibilityOf(introPage.btn_get_started));
		String actual = introPage.getTextGetStartedButton();
		String expected = AppConstants.INTRO_PAGE_EXPECTED_GET_STATRED_BTN_TEXT;
		Assert.assertEquals(actual, expected);
	}
}