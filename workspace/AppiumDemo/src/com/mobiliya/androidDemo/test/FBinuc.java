package com.mobiliya.androidDemo.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;

public class FBinuc {

	public static WebDriver driver;
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("BrowserName", "Android");
		caps.setCapability("deviceName", "88d11767");
		caps.setCapability("Version", "5.1.1");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.android.chrome.Chrome");
		System.out.println("capabilities set properly");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		System.out.println("app launched successfully");
		
		/*WebElement e=driver.findElement(By.xpath("//android.widget.EditText[@index='0'and @text='data:,']"));
		e.sendKeys("www.facebook.com");*/
		driver.quit();
		
	}

}
