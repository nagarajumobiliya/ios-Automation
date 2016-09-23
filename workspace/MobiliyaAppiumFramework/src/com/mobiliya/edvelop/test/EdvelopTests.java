package com.mobiliya.edvelop.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mobiliya.common.pageObjects.GoogleWebViewSignInPage;
import com.mobiliya.common.pageObjects.KeywordsCommon;
import com.mobiliya.edvelop.AppConstants;
import com.mobiliya.edvelop.pageObjects.BackToLoginPage;
import com.mobiliya.edvelop.pageObjects.DashboardPage;
import com.mobiliya.edvelop.pageObjects.IntroScreensPage;
import com.mobiliya.edvelop.pageObjects.KidsListPage;
import com.mobiliya.edvelop.pageObjects.LoginPage;
import com.mobiliya.framework.configure.Constants;
import com.mobiliya.framework.utilities.ExcelUtility;

public class EdvelopTests {

	@Test(priority = 1)
	public void testDisplayIntroScreensOnFirstLaunch() {
		IntroScreensPage introPage = new IntroScreensPage();
		introPage.SwipeIntroImages();
		String actual = introPage.getTextGetStartedButton();
		String expected = AppConstants.INTRO_PAGE_EXPECTED_GET_STATRED_BTN_TEXT;
		Assert.assertEquals(actual, expected);
	}

	@Test(dependsOnMethods = { "testDisplayIntroScreensOnFirstLaunch" }, dataProvider = "testDataInvalidLogin")
	public void testInvalidLoginWithGoogle(String username, String password) {
		IntroScreensPage introPage = new IntroScreensPage();
		LoginPage loginPage = new LoginPage();
		KidsListPage kidsListPage = new KidsListPage();
		BackToLoginPage backToLoginPage = new BackToLoginPage();
		GoogleWebViewSignInPage signInPage = new GoogleWebViewSignInPage();
		introPage.clickGetStartedButton();
		loginPage.clickSignInWithGoogleButton();
		KeywordsCommon.contextSwitchNativeToWeb();
		signInPage.performGmailSignIn(username, password);
		KeywordsCommon.contextSwitchWebToNative();
		KeywordsCommon.waitUntil(kidsListPage.static_text_get_started);
		String actual = backToLoginPage.getTextErrMsgInvalidLogin();
		String expected = AppConstants.BACK_TO_LOGIN_PAGE_EXPECTED_INVALID_LOGIN_ERR_MSG;
		Assert.assertEquals(actual, expected);
	}

	@Test(dependsOnMethods = { "testInvalidLoginWithGoogle" }, dataProvider = "testDataValidLogin")
	public void testValidLoginWithGoogle(String username, String password) {
		IntroScreensPage introPage = new IntroScreensPage();
		LoginPage loginPage = new LoginPage();
		KidsListPage kidsListPage = new KidsListPage();
		GoogleWebViewSignInPage signInPage = new GoogleWebViewSignInPage();
		BackToLoginPage backToLoginPage = new BackToLoginPage();
		//introPage.clickGetStartedButton();
		backToLoginPage.clickBackToLoginButton();
		loginPage.clickSignInWithGoogleButton();
		KeywordsCommon.contextSwitchNativeToWeb();
		signInPage.performGmailSignIn(username, password);
		KeywordsCommon.contextSwitchWebToNative();
		KeywordsCommon.waitUntil(kidsListPage.static_text_get_started);
		String actual = kidsListPage.getTextGetStartedStaticText();
		String expected = AppConstants.KIDS_LIST_PAGE_EXPECTED_STATIC_TEXT;
		Assert.assertEquals(actual, expected);
	}

	@Test(dependsOnMethods = { "testValidLoginWithGoogle" })
	public void testDisplayDashboard() {
		KidsListPage kidsListPage = new KidsListPage();
		DashboardPage dashboardPage = new DashboardPage();

	}

	@Test
	public void testValidLoginWithGoogleAfterLoginFail() {

	}

	@DataProvider(name = "testDataValidLogin")
	public Object[][] testDataValidLogin() {
		String[][] data = new String[1][2];
		ExcelUtility.setExcelFile(System.getProperty("user.dir") + AppConstants.TEST_DATA_FILE_PATH,
				AppConstants.VALID_LOGIN_TEST_DATA_SHEET_NAME);
		data[0][0] = ExcelUtility.getCellData(1, 0);
		data[0][1] = ExcelUtility.getCellData(1, 1);
		return data;
	}

	@DataProvider(name = "testDataInvalidLogin")
	public Object[][] testDataInvalidLogin() {
		// String[][] data = null;
		ExcelUtility.setExcelFile(System.getProperty("user.dir") + AppConstants.TEST_DATA_FILE_PATH,
				AppConstants.INVALID_LOGIN_TEST_DATA_SHEET_NAME);
		int rowCount = ExcelUtility.getRowsCount();
		// System.out.println("Row Count: "+ rowCount);
		String[][] data = new String[rowCount][];
		int colCount;
		for (int row = 1; row < rowCount; row++) {
			colCount = ExcelUtility.getColumnsCount(row);
			data = new String[rowCount][colCount];
			for (int col = 0; col < colCount; col++) {
				data[row - 1][col] = ExcelUtility.getCellData(row, col);
				System.out.println(data[row - 1][col]);
			}
		}
		return data;
	}

}