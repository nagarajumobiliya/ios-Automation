package com.mobiliya.androidDemo.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Contact {
	
	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "5.1.1");
		capabilities.setCapability("deviceName", "88d11767");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.android.contacts");
		capabilities.setCapability("appActivity", ".activities.PeopleActivity");
		
		System.out.println("capabilities set properly");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("app launched successfully");
		
		//WebElement s = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'menu_search')]"));
		//s.click();
		//driver.findElement(By.xpath("//android.widget.EditText[contains(@reource-id,'search_view')]")).sendKeys("pritam");
		//System.out.println("element two is clicked");
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);

		driver.pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
		
		driver.quit();
		
		
	}
	


}
