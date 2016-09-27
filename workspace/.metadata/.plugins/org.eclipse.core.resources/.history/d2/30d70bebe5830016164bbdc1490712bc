package com.mobiliya.edvelop.test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mobiliya.common.pageObjects.GoogleWebViewSignInPage;
import com.mobiliya.common.pageObjects.KeywordsCommon;
import com.mobiliya.common.pageObjects.MicrosoftWebViewLogInPage;
import com.mobiliya.edvelop.AppConstants;
import com.mobiliya.edvelop.pageObjects.IntroScreensPage;
import com.mobiliya.edvelop.pageObjects.KidsListPage;
import com.mobiliya.edvelop.pageObjects.LoginPage;
import com.mobiliya.framework.utilities.ExcelUtility;

public class TestValidLoginWithMicrosoft extends BaseTest {
	@Test
	public void testValidLoginWithMicrosoft() {
		IntroScreensPage introPage = new IntroScreensPage();
		LoginPage loginPage = new LoginPage();
		KidsListPage kidsListPage = new KidsListPage();
		MicrosoftWebViewLogInPage msLoginPage=new MicrosoftWebViewLogInPage();
		introPage.clickGetStartedButton();
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.btn_sign_in_with_microsoft));
		loginPage.clickSignInWithMicrosoftButton();
		KeywordsCommon.contextSwitchNativeToWeb();
		msLoginPage.performMicrosoftLogIn(AppConstants.MICROSOFT_LOGIN_EMAIL_ID, AppConstants.MICROSOFT_LOGIN_PASSWORD);
		KeywordsCommon.contextSwitchWebToNative();
		wait.until(ExpectedConditions.elementToBeClickable(kidsListPage.static_text_get_started));
		String actual = kidsListPage.getTextGetStartedStaticText();
		String expected = AppConstants.KIDS_LIST_PAGE_EXPECTED_STATIC_TEXT;
		Assert.assertEquals(actual, expected);
	}
}
