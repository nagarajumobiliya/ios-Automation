package com.mobiliya.androidDemo.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FBinChrome {
	
	public static WebDriver driver;
	public static void main(String[] args) throws MalformedURLException {
		
		// Create object of  DesiredCapabilities class and specify android platform
		DesiredCapabilities caps=DesiredCapabilities.android();
		 
		 
		 caps.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserType.CHROME);
		 
		   caps.setCapability(MobileCapabilityType.PLATFORM,Platform.ANDROID);
		 
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");		
		caps.setCapability("deviceName", "0a670d30");
		caps.setCapability("Version", "5.0.2");
		
		caps.setCapability("appPackage", "com.chrome.beta");
		caps.setCapability("appActivity", "org.chromium.chrome.browser.ChromeTabbedActivity");
		System.out.println("capabilities set properly");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		System.out.println("app launched successfully");
		
		driver.get("http://www.facebook.com");
		System.out.println("Title "+driver.getTitle());
		
		
		driver.findElement(By.name("email")).sendKeys("nitin.hambir@gmail.com");
		 
		driver.findElement(By.name("pass")).sendKeys("12345");
		 
		driver.findElement(By.xpath("//input[@name='login']")).click();
		driver.quit();
		
	}

}
