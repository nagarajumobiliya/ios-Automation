package com.mobiliya.androidDemo.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import jxl.Workbook;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Camera {
	
	public static AndroidDriver driver;
	public static void main(String[] args) throws RowsExceededException, WriteException, IOException, InterruptedException {
		
		Camera.cameraLauncher();

				
	}
	
	public static void cameraLauncher()throws IOException, RowsExceededException, WriteException, InterruptedException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "5.0.2");
		capabilities.setCapability("deviceName", "0a670d30");
		capabilities.setCapability("platformName", "Android");
		/*capabilities.setCapability("appPackage", "com.oneplus.camera");
		capabilities.setCapability("appActivity", "com.oneplus.camera.OPCameraActivity");*/
		
		capabilities.setCapability("appPackage", "com.google.android.GoogleCamera");
		capabilities.setCapability("appActivity", "com.android.camera.CameraLauncher");
		
		System.out.println("capabilities set properly for Camera");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		System.out.println("Camera app launched successfully");
		
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Shutter']")).click();
		
		Dimension size= driver.manage().window().getSize();
		int startx=(int)(size.width*0.70);
		int endx=(int)(size.width*0.20);
		int starty=(int)(size.height/2);
		((AndroidDriver)driver).swipe(startx, starty, endx, starty, 3000);
		Thread.sleep(2000);
		System.out.println("image captured for Camera app");
		//driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();		
		driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.quit();
		System.out.println("app is closed");
	}
	
	


}
