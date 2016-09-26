package com.mobiliya.edvelop.test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mobiliya.common.pageObjects.GoogleWebViewSignInPage;
import com.mobiliya.common.pageObjects.KeywordsCommon;
import com.mobiliya.edvelop.AppConstants;
import com.mobiliya.edvelop.pageObjects.BackToLoginPage;
import com.mobiliya.edvelop.pageObjects.IntroScreensPage;
import com.mobiliya.edvelop.pageObjects.LoginPage;
import com.mobiliya.framework.utilities.ExcelUtility;

public class TestInvalidLoginWithGoogle extends BaseTest {
	@Test(dataProvider = "testDataInvalidLogin")
	public void testInvalidLoginWithGoogle(String username, String password) {
		IntroScreensPage introPage = new IntroScreensPage();
		LoginPage loginPage = new LoginPage();
		BackToLoginPage backToLoginPage = new BackToLoginPage();
		GoogleWebViewSignInPage signInPage = new GoogleWebViewSignInPage();
		introPage.clickGetStartedButton();
		loginPage.clickSignInWithGoogleButton();
		KeywordsCommon.contextSwitchNativeToWeb();
		signInPage.performGmailSignIn(username, password);
		KeywordsCommon.contextSwitchWebToNative();
		wait.until(ExpectedConditions.visibilityOf(backToLoginPage.static_text_err_msg));
		String actual = backToLoginPage.getTextErrMsgInvalidLogin();
		String expected = AppConstants.BACK_TO_LOGIN_PAGE_EXPECTED_INVALID_LOGIN_ERR_MSG;
		Assert.assertEquals(actual, expected);
	}

	@DataProvider(name = "testDataInvalidLogin")
	public Object[][] testDataInvalidLogin() {
		ExcelUtility.setExcelFile(System.getProperty("user.dir") + AppConstants.TEST_DATA_FILE_PATH,
				AppConstants.INVALID_LOGIN_TEST_DATA_SHEET_NAME);
		int rowCount = ExcelUtility.getRowsCount();
		String[][] data = new String[rowCount][];
		int colCount;
		for (int row = 1; row <= rowCount; row++) {
			colCount = ExcelUtility.getColumnsCount(row);
			data = new String[rowCount][colCount];
			for (int col = 0; col < colCount; col++) {
				data[row - 1][col] = ExcelUtility.getCellData(row, col);
			}
		}
		return data;
	}
}
