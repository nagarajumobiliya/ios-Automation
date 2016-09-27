package com.mobiliya.edvelop.pageObjects;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mobiliya.framework.configure.BaseClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindAll;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSFindBys;

public class KidsListPage extends BaseClass {
	public KidsListPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]")
	public MobileElement static_text_get_started;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
	public MobileElement btn_continue;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell")
	public List<MobileElement> list_Kids ;
    
	public void clickContinueButton() {
		try {
			btn_continue.click();
		} catch (Exception e) {
			APP_LOGS.error("Unable to click: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public String getTextGetStartedStaticText() {
		try {
			String text;
			//wait.until(ExpectedConditions.visibilityOf(static_text_get_started));
			//text=static_text_get_started.getAttribute("name");
			//if(text.equals(null)||(text.equals(""))){
				text=static_text_get_started.getText();
				return text;
			//}
		} catch (Exception e) {
			APP_LOGS.error("Unable to read text: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

//	public void selectKidFromList(String kidName) {
//		for (MobileElement eleKid : list_Kids) {
////			System.out.println(eleKid.getAttribute("Name"));
//			System.out.println(eleKid.getAttribute("name"));
//			//eleKid.
//			System.out.println(eleKid.findElement(By.xpath("/UIAStaticText[1]")).getText());
//			//System.out.println(eleKid.findElementByXPath("UIAStaticText[1]").getText());
//			//System.out.println(eleKid.getAttribute("UIAStaticText[1]"));
//			String kidsName = "Raju";
//		    //String kidsName = driver.findElement(By.xpath(eleKid + "/UIAStaticText[1]")).getText();
//			if (kidsName.equals(kidName)) {
//				continue;
//			} else {
//				eleKid.click();
//			}
//		}
//	}
	
	public void selectKidFromList(String kidName) {
		try {
//			wait.until(ExpectedConditions.visibilityOfAllElements(list_Kids));
			for (MobileElement eleKid : list_Kids) {
				System.out.println(eleKid.getAttribute("name"));
				if ((eleKid.getAttribute("name")).equals(kidName)) {
					continue;
				} else {
					eleKid.click();
				}
			}
		} catch (Exception e) {
			APP_LOGS.error("Unable to select: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
