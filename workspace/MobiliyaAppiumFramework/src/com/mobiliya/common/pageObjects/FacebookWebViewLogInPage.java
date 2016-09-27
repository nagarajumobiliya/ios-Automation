package com.mobiliya.common.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mobiliya.edvelop.test.BaseTest;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FacebookWebViewLogInPage extends BaseTest {
	public FacebookWebViewLogInPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(xpath = "//input[@class='_56bg _4u9z _5ruq']")
	public WebElement tbox_email_address;

	@FindBy(xpath = "//input[@class='_56bg _4u9z _27z2']")
	public WebElement tbox_facebook_password;

	@FindBy(xpath = "//button[@class='_54k8 _56bs _56b_ _56bw _56bu']")
	public WebElement btn_log_in;

	@FindBy(xpath = "//button[@class='_54k8 _56bs _5o-- _j93 _56bw _56bu']")
	public WebElement btn_confirm_ok;

	public void enterEmailInToTextbox(String email) {
		try {
			tbox_email_address.sendKeys(email);
		} catch (Exception e) {
			APP_LOGS.error("Unable to enter text:" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void enterPasswordInToTextbox(String password) {
		try {
			tbox_facebook_password.sendKeys(password);
		} catch (Exception e) {
			APP_LOGS.error("Unable to enter text:" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickLogInButton() {
		try {
			btn_log_in.click();
		} catch (Exception e) {
			APP_LOGS.error("Unable to click:" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void clickConfirmOkButton() {
		try {
			btn_confirm_ok.click();
		} catch (Exception e) {
			APP_LOGS.error("Unable to click:" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void performFacebookLogIn(String email, String password) {
		try {
			wait.until(ExpectedConditions.visibilityOf(tbox_email_address));
			enterEmailInToTextbox(email);
			enterPasswordInToTextbox(password);
			clickLogInButton();
			wait.until(ExpectedConditions.elementToBeClickable(btn_confirm_ok));
			clickConfirmOkButton();
			APP_LOGS.debug("Log in with Facebook sucessful.");
		} catch (Exception e) {
			APP_LOGS.error("Unable to perform facebook log in: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
