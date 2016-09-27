package com.mobiliya.common.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mobiliya.edvelop.test.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MicrosoftWebViewLogInPage extends BaseTest {
	public MicrosoftWebViewLogInPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(xpath = "//input[@id='i0116']")
	public WebElement tbox_email_or_phone;

	@FindBy(xpath = "//input[@id='i0118']")
	public WebElement tbox_password;

	@FindBy(xpath = "//input[@id='idSIButton9']")
	public WebElement btn_sign_in;

	@FindBy(xpath = "//input[@id='idBtn_Accept']")
	public WebElement btn_access_yes;

	public void enterEmailInToTextbox(String email) {
		try {
			tbox_email_or_phone.sendKeys(email);
		} catch (Exception e) {
			APP_LOGS.error("Unable to enter text:" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void enterPasswordInToTextbox(String password) {
		try {
			tbox_password.sendKeys(password);
		} catch (Exception e) {
			APP_LOGS.error("Unable to enter text:" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickSignInButton() {
		try {
			btn_sign_in.click();
		} catch (Exception e) {
			APP_LOGS.error("Unable to click:" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickAccessYesButton() {
		try {
			btn_access_yes.click();
		} catch (Exception e) {
			APP_LOGS.error("Unable to click:" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void performMicrosoftLogIn(String email, String password) {
		try {
			wait.until(ExpectedConditions.visibilityOf(tbox_email_or_phone));
			enterEmailInToTextbox(email);
			enterPasswordInToTextbox(password);
			clickSignInButton();
			wait.until(ExpectedConditions.elementToBeClickable(btn_access_yes));
			clickAccessYesButton();
			APP_LOGS.debug("Log in with Microsoft sucessful.");
		} catch (Exception e) {
			APP_LOGS.error("Unable to perform Microsoft log in: " + e.getMessage());
			e.printStackTrace();
		}
	}
}