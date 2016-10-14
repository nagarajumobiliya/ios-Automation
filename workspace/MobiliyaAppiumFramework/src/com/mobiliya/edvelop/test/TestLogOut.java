package com.mobiliya.edvelop.test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mobiliya.common.pageObjects.GoogleWebViewSignInPage;
import com.mobiliya.edvelop.AppConstants;
import com.mobiliya.edvelop.pageObjects.DashboardPage;
import com.mobiliya.edvelop.pageObjects.KidsListPage;
import com.mobiliya.edvelop.pageObjects.LoginPage;
import com.mobiliya.framework.configure.IOSWebkitDebugProxyService;

public class TestLogOut extends BaseTest {
//	@BeforeMethod
//	public void navigateToDashboard() {
//		LoginPage loginPage = new LoginPage();
//		GoogleWebViewSignInPage googleSignInPage = new GoogleWebViewSignInPage();
//		KidsListPage kidsListPage = new KidsListPage();
//		IOSWebkitDebugProxyService.startIOSWebkitDebugProxyService();
//		loginPage.clickSignInWithGoogleButton();
//		googleSignInPage.performGmailSignIn(AppConstants.GOOGLE_LOGIN_EMAIL_ID,
//		AppConstants.GOOGLE_LOGIN_PASSWORD);
//		wait.until(ExpectedConditions.elementToBeClickable(kidsListPage.static_text_get_started));
//		kidsListPage.selectMultipleKidsfromList(AppConstants.CHILD_LIST);
//		kidsListPage.clickContinueButton();
//	}

	@Test
	public void testLogOut() {
		DashboardPage dashboardPage = new DashboardPage();
		LoginPage loginPage = new LoginPage();
		wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.btn_parent));
		dashboardPage.clickParentButton();
		dashboardPage.clickSignOutButton();
		String actual = loginPage.get_static_text_please_login_msg();
		String expected = AppConstants.LOGIN_PAGE_EXPECTED_STATIC_TEXT_MSG;
		Assert.assertEquals(actual, expected+"hi");
	}
}