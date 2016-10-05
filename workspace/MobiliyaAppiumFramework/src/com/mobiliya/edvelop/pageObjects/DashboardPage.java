 package com.mobiliya.edvelop.pageObjects;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.flow.ExceptionHandlingFlowContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mobiliya.framework.configure.BaseClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSFindBys;

public class DashboardPage extends BaseClass{
	public DashboardPage(){
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]")
	public MobileElement btn_parent;
	
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]")
	public MobileElement itemCategory_staticText;
	
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[2]/UIACollectionCell")
	public List <MobileElement> timeLineItems;
	
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell")
	public List <MobileElement> EventsDispalyed;
	
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")
	public MobileElement btn_sign_out;
	
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[2]/UIACollectionCell[1]")
	public MobileElement btn_menu_all;
	
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[2]/UIACollectionCell[2]")
	public MobileElement btn_menu_notice;
	
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[2]/UIACollectionCell[3]")
	public MobileElement btn_menu_homework;
	
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[2]/UIACollectionCell[4]")
	public MobileElement btn_menu_gallery;
	
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[2]/UIACollectionCell[5]")
	public MobileElement btn_menu_event;
	
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIACollectionView")
	public List<MobileElement> list_images;
	
	
	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]")
	public MobileElement btn_back;
	
	@iOSFindBy(xpath = " //UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
	public MobileElement btn_done;
	
	@iOSFindBy(xpath = " //UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAButton[1]")
	public MobileElement btn_icon;
	
	public void clickParentButton(){
		btn_parent.click();
	}
	
	public void clickAllMenuButton() {
		btn_menu_all.click();
	}
	
	
	public void clickNoticeMenuButton() {
		btn_menu_notice.click();
	}
	
	public void clickHomeWorkMenuButton() {
		btn_menu_homework.click();
	}
	
	public void clickGalleryMenuButton() {
		btn_menu_gallery.click();
	}
	
	public void clickEventMenuButton() {
		btn_menu_event.click();
	}
	
	
	public void clickSignOutButton() {
		btn_sign_out.click();
	}
	 
	public String getitemCategoryText() {
		return itemCategory_staticText.getText();
	}
	
	public String[] getTimeLineItems() {
		String [] timeline = new String[timeLineItems.size()];
		try {
			int i =0;
			for (MobileElement Item : timeLineItems) {
				timeline[i] = Item.getAttribute("name");
				i++;
			}
		} catch (Exception e) {
			APP_LOGS.error("Unable to select: " + e.getMessage());
			e.printStackTrace();
		}
		return timeline;
	}
	
	public List<MobileElement> getImageList(int glarry) {
		List <MobileElement>  ele = driver.findElementsByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell["+glarry+"]/UIAButton");
		return ele;
	}
	
	public void clickOnImage(MobileElement image) {
		image.click();
	}
	
	
	public List<MobileElement> getDisplayedEvents() {
		String[] displayedEvents = new String[EventsDispalyed.size()];
//        try {
//        	int i =0;
//        	for (MobileElement event : EventsDispalyed) {
//        		displayedEvents[i] = event.getAttribute("name");
//        		i++;
//        	}
//        } catch (Exception e) {
//        	APP_LOGS.error("Unable to select: " + e.getMessage());
//			e.printStackTrace();
//        }
		return EventsDispalyed;
	}
}
