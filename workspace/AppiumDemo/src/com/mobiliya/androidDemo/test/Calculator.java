package com.mobiliya.androidDemo.test;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.UIDefaults;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import java.lang.Object;

public class Calculator {
	
	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException {
		
		Calculator.calcLauncher();
				
	}
	
	public static void calcLauncher()throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "5.0.2");
		capabilities.setCapability("deviceName", "0a670d30");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		System.out.println("capabilities set properly");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);
		System.out.println("app launched successfully");
		
		WebElement two = driver.findElementById("com.android.calculator2:id/digit_4");
		two.click();
		System.out.println("element two is clicked");
		WebElement plus = driver.findElementById("com.android.calculator2:id/op_add");
		plus.click();
		System.out.println("element + is clicked");
		
		WebElement four = driver.findElementById("com.android.calculator2:id/digit_4");
		four.click();
		System.out.println("element 4 is clicked");
		
		WebElement equalTo = driver.findElementById("com.android.calculator2:id/eq");
		equalTo.click();
		System.out.println("element = is clicked");
		int a=driver.findElementsById("android:id/navigationBarBackground").size();
		System.out.println(a);
		driver.pressKeyCode(AndroidKeyCode.BACK);
 		//driver.pressKeyCode(92);
		driver.closeApp();
		System.out.println("app is closed");
				
	}
	
	

}

