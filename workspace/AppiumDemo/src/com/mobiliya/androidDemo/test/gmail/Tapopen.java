package com.mobiliya.androidDemo.test.gmail;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.Connection;

public class Tapopen {

	public static AndroidDriver driver;

	public static void main(String[] args) throws IOException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "5.0.2");
		capabilities.setCapability("deviceName", "0a670d30");
		capabilities.setCapability("platformName", "Android");
		System.out.println("capabilities set properly for Camera");
		capabilities.setCapability("appPackage", "com.android.settings");
		capabilities.setCapability("appActivity", "com.android.settings.Settings");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Camera app launched successfully");
		driver.setConnection(Connection.WIFI);
		Connection c= driver.getConnection();
		String Datapath =System.getProperty("user.dir");
		System.out.println(Datapath);
		
		driver.findElementById("com.android.settings:id/category_content");
		int s=driver.findElementsById("com.android.settings:id/category_content").size();
		System.out.println("success 1 "+ s);
		WebElement ele = (WebElement) driver.findElementsById("com.android.settings:id/category_content").get(0);
		//driver.findElementByXPath("//android.view.View[contains(@resource-id,'dashboard_container')]"
		//		+ "/android.widget.LinearLayout[contains(@resource-id,'category')]");
		
		//WebElement e= (MobileElement) ele.findElements(By.className("android.widget.FrameLayout"));
		System.out.println("success 2");
		Desktop.getDesktop().open(new File(Datapath+"/report.xls"));

		
			}
}
