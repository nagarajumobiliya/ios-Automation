package com.mobiliya.edvelop.pageObjects;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.mobiliya.framework.configure.BaseClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class KidsListPage extends BaseClass {
	public KidsListPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]")
	public MobileElement static_text_get_started;
	
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
	public MobileElement btn_continue;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell")
	public List<MobileElement> list_Kids;

	public void clickContinueButton() {
		btn_continue.click();
	}
	
	public String getTextGetStartedStaticText(){
		return static_text_get_started.getAttribute("name");
	}

	public void selectKidFromList(String kidName){
		for (MobileElement eleKid : list_Kids) {
			String kn;
			if((kn=eleKid.getAttribute("name"))==kidName){
				System.out.println("*****************"+kn+"**********");
			}
		}
	}
}
