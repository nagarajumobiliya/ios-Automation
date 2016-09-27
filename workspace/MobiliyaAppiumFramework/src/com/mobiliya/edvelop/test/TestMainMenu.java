package com.mobiliya.edvelop.test;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mobiliya.edvelop.pageObjects.DashboardPage;
import org.testng.Assert;

public class TestMainMenu extends BaseTest{
	Map <String,String> childandClassName = null;
	@BeforeMethod
	public void getPartentWindow() {
		DashboardPage page = new DashboardPage();
		  page.clickParentButton();
		  childandClassName= page.getChildAndClassName();
	}
  @Test
  public void childName() {
	  Assert.assertTrue(childandClassName.containsKey("User1"));
  }
  
}