package com.mobiliya.edvelop.test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mobiliya.common.pageObjects.GoogleWebViewSignInPage;
import com.mobiliya.common.pageObjects.KeywordsCommon;
import com.mobiliya.edvelop.AppConstants;
import com.mobiliya.edvelop.pageObjects.IntroScreensPage;
import com.mobiliya.edvelop.pageObjects.KidsListPage;
import com.mobiliya.edvelop.pageObjects.LoginPage;
import com.mobiliya.framework.utilities.ExcelUtility;

public class TestValidLoginWithGoogle extends BaseTest {
	//@Test(dataProvider = "testDataValidLogin")
	@Test
	public void testValidLoginWithGoogle() {
		IntroScreensPage introPage = new IntroScreensPage();
		LoginPage loginPage = new LoginPage();
		KidsListPage kidsListPage = new KidsListPage();
		GoogleWebViewSignInPage signInPage = new GoogleWebViewSignInPage();
		introPage.clickGetStartedButton();
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.btn_sign_in_with_google));
		loginPage.clickSignInWithGoogleButton();
		KeywordsCommon.contextSwitchNativeToWeb();
		signInPage.performGmailSignIn(AppConstants.GOOGLE_LOGIN_EMAIL_ID, AppConstants.GOOGLE_LOGIN_PASSWORD);
		KeywordsCommon.contextSwitchWebToNative();
		wait.until(ExpectedConditions.elementToBeClickable(kidsListPage.static_text_get_started));
		String actual = kidsListPage.getTextGetStartedStaticText();
		String expected = AppConstants.KIDS_LIST_PAGE_EXPECTED_STATIC_TEXT;
		//Assert.assertEquals(actual, expected);
	}

//	@DataProvider(name = "testDataValidLogin")
//	public Object[][] testDataValidLogin() {
//		ExcelUtility.setExcelFile(System.getProperty("user.dir") + AppConstants.TEST_DATA_FILE_PATH,
//				AppConstants.VALID_LOGIN_TEST_DATA_SHEET_NAME);
//		int rowCount = ExcelUtility.getRowsCount();
//		String[][] data = new String[rowCount][];
//		int colCount;
//		for (int row = 1; row <= rowCount; row++) {
//			colCount = ExcelUtility.getColumnsCount(row);
//			data = new String[rowCount][colCount];
//			for (int col = 0; col < colCount; col++) {
//				data[row - 1][col] = ExcelUtility.getCellData(row, col);
//			}
//		}
//		return data;
//	}
}
