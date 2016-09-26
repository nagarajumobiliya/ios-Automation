package com.mobiliya.common.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mobiliya.edvelop.pageObjects.IntroScreensPage;
import com.mobiliya.framework.configure.BaseClass;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GoogleWebViewSignInPage extends BaseClass {
	public GoogleWebViewSignInPage(){
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(xpath = "//input[@id ='Email']")
	private WebElement tbox_enter_your_email;

	@FindBy(xpath = "//input[@id ='next']")
	private WebElement btn_next;

	@FindBy(xpath = "//input[@id = 'Passwd']")
	private WebElement tbox_enter_your_password;

	@FindBy(xpath = "//input[@id = 'signIn']")
	private WebElement btn_sign_in;

	@FindBy(xpath = "//button[@id ='submit_approve_access']")
	private WebElement btn_allow;

	private void enterEmailIntoTextbox(String email) {
		tbox_enter_your_email.sendKeys(email);
	}

	private void clickNextButton() {
		btn_next.click();
	}

	private void enterPasswordIntoTextbox(String password) {
		tbox_enter_your_password.sendKeys(password);
	}

	private void clickSignInButton() {
		btn_sign_in.click();
	}

	private void clickAllowAccessButton() {
		btn_allow.click();
	}

	public void performGmailSignIn(String email, String password) {
		wait.until(ExpectedConditions.visibilityOf(tbox_enter_your_email));
		enterEmailIntoTextbox(email);
		clickNextButton();
		wait.until(ExpectedConditions.visibilityOf(tbox_enter_your_password));
		enterPasswordIntoTextbox(password);
		clickSignInButton();
		wait.until(ExpectedConditions.visibilityOf(btn_allow));
		clickAllowAccessButton();
	}

}
