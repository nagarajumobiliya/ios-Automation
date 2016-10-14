package com.mobiliya.edvelop.test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.mobiliya.edvelop.pageObjects.DashboardPage;

import io.appium.java_client.MobileElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class TestMainMenu extends BaseTest{

	DashboardPage page = null;
	@BeforeClass
	public void getPartentWindow() {
		page = new DashboardPage();
		//wait.until(ExpectedConditions.elementToBeClickable(page.btn_parent));
		//page.btn_parent.click();
	}
  @Test
  public void testTimeLineITems() {
	 String [] actual = page.getTimeLineItems();
	 String [] expected = {"All","Notice", "Homework", "Gallery", "Event"};
     Assert.assertEquals(actual, expected);
  }
  
  @Test
  public void testAllEventsDisplayed() {
	  page.clickAllMenuButton();
	  try {
		Thread.sleep(500);
		List<MobileElement> displayedAllEvents = page.getDisplayedEvents();
		int count = displayedAllEvents.size();
		Assert.assertNotEquals(count, 0);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  @Test
  public void testGalleryEventsDisplayed() {
	  page.clickGalleryMenuButton();
	  try {
		Thread.sleep(500);
 		List<MobileElement> displayedGalleryEvents = page.getDisplayedEvents();
		int count = displayedGalleryEvents.size();
		String expected = "Gallery";
		for(int i = 1; i <= count; i++) {
		MobileElement image = (MobileElement)driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell["+i+"]//UIAStaticText[1]"));
		if(image.isDisplayed()) {
		image.click();
		} else {
			break;
		}
		Thread.sleep(500);
		List<MobileElement> images = driver.findElements(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell"));
		for(int j = 1; j<= images.size(); j++){
			MobileElement imageDispayed = (MobileElement) driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIACollectionView[1]/UIACollectionCell["+j+"]"));
			if (imageDispayed.getAttribute("name").equals("ic download")) {
				imageDispayed.click();
				wait.until(ExpectedConditions.attributeContains(imageDispayed, "name", "ic play"));
				Assert.assertEquals(imageDispayed.getAttribute("name"), "ic play");
			}else if(imageDispayed.getAttribute("name").equals("ic play")) {
				Assert.assertEquals(imageDispayed.getAttribute("name"), "ic play");
			}else {
			imageDispayed.click();
			Thread.sleep(200);
			page.btn_back.click();
			}
		}
	    MobileElement gallery = (MobileElement) driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]"));
	    Assert.assertEquals(gallery.getText(), expected);
	    page.btn_back.click();
			
			//Assert.assertTrue(displayedGalleryEvents[i].toLowerCase().contains(expected));
		}
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
  }
  
  
  @Test
  public void testNoticeEventsDisplayed() {
	  page.clickNoticeMenuButton();
	  try {
		Thread.sleep(500);
		List<MobileElement> displayedNoticeEvents = page.getDisplayedEvents();
		String expected = "Notice";
		int count = displayedNoticeEvents.size();
		for(int i = 1; i <= count; i++) {
			MobileElement image = (MobileElement)driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell["+i+"]"));
			if(image.isDisplayed()) {
			image.click();
			} else {
				break;
			}
			Thread.sleep(500);
		    MobileElement notice = (MobileElement) driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]"));
		    Assert.assertEquals(notice.getText(), expected);
		    page.btn_back.click();
		}
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
  }
  
  @Test
  public void testHomeWorkEventsDisplayed() {
	  page.clickHomeWorkMenuButton();
	  try {
		Thread.sleep(500);
		List<MobileElement> displayedHomeEvents = page.getDisplayedEvents();
		String expected = "Homework Diary";
		int count = displayedHomeEvents.size();
		for(int i=1; i<= count ; i++) {
		MobileElement image = (MobileElement)driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell["+i+"]"));
		if(image.isDisplayed()) {
			image.click();
		}else {
		break;
		}
		Thread.sleep(500);
	    MobileElement notice = (MobileElement) driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]"));
	    Assert.assertEquals(notice.getText(), expected);
	    page.btn_back.click();
			//Assert.assertTrue(displayedHomeEvents[i].toLowerCase().contains(expected));
		}
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
  
  @Test
  public void testEventEventsDisplayed() {
	  page.clickEventMenuButton();
	  try {
		Thread.sleep(500);
	    List<MobileElement> displayedEventEvents = page.getDisplayedEvents();
	    String expected = "Events";
		int count = displayedEventEvents.size();
		for(int i=1; i<= count ; i++) {
		MobileElement image = (MobileElement)driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell["+i+"]"));
		if(image.isDisplayed()) {
			image.click();
		}else {
			break;
		}
		Thread.sleep(500);
	    MobileElement notice = (MobileElement) driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]"));
	    Assert.assertEquals(notice.getText(), expected);
	    page.btn_back.click();
	    }
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
  }
  
}
