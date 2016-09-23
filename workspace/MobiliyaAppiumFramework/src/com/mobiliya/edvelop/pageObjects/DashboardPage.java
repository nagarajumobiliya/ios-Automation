package com.mobiliya.edvelop.pageObjects;

import org.openqa.selenium.support.PageFactory;

import com.mobiliya.framework.configure.BaseClass;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DashboardPage extends BaseClass{
	public DashboardPage(){
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	
}
