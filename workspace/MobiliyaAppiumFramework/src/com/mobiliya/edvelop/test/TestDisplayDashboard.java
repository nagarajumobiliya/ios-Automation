package com.mobiliya.edvelop.test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mobiliya.edvelop.AppConstants;
import com.mobiliya.edvelop.pageObjects.DashboardPage;
import com.mobiliya.edvelop.pageObjects.KidsListPage;

public class TestDisplayDashboard extends BaseTest {

	@BeforeMethod
	public void navigateToDashboard() {
		// LoginPage loginPage = new LoginPage();
		// GoogleWebViewSignInPage googleSignInPage = new
		// GoogleWebViewSignInPage();
		KidsListPage kidsListPage = new KidsListPage();

		// loginPage.clickSignInWithGoogleButton();
		// googleSignInPage.performGmailSignIn(AppConstants.GOOGLE_LOGIN_EMAIL_ID,
		// AppConstants.GOOGLE_LOGIN_PASSWORD);
		wait.until(ExpectedConditions.elementToBeClickable(kidsListPage.static_text_get_started));
		kidsListPage.selectMultipleKidsfromList(AppConstants.CHILD_LIST);
		kidsListPage.clickContinueButton();
	}

	@Test
	public void testClassName() {
		DashboardPage dashboardPage = new DashboardPage();
		wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.btn_parent));
		String[] actual=dashboardPage.getClassNameList();
		String[] expected=AppConstants.CHILDWISE_CLASS_NAMES;
		//dashboardPage.clickParentButton();
		Assert.assertEquals(actual, expected);
	}
	
//	@Test
//	public void testChildName() {
//		DashboardPage dashboardPage = new DashboardPage();
//		wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.btn_parent));
//		String[] actual=dashboardPage.getChildNameList();
//		String[] expected=AppConstants.CHILD_LIST;
//		dashboardPage.clickParentButton();
//		Assert.assertEquals(actual, expected);
//	}
}
