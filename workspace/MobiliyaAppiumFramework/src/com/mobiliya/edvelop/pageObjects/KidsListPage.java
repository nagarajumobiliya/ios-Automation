package com.mobiliya.edvelop.pageObjects;
import java.util.List;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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


	
	public String[] getChildrenList() {
		String [] childNames = new String[list_Kids.size()];
		wait.until(ExpectedConditions.elementToBeClickable(btn_continue));
		try {
			int i =0;
			for (MobileElement eleKid : list_Kids) {
				childNames[i] = eleKid.getAttribute("name");
				i++;
			}
		} catch (Exception e) {
			APP_LOGS.error("Unable to select: " + e.getMessage());
			e.printStackTrace();
		}
		return childNames;
	}
}
