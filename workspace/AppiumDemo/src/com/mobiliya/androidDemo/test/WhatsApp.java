package com.mobiliya.androidDemo.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WhatsApp {
	
	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "5.1.1");
		capabilities.setCapability("deviceName", "88d11767");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.whatsapp");
		capabilities.setCapability("appActivity", "com.whatsapp.HomeActivity");
		
		System.out.println("capabilities set properly");
		
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("app launched successfully");
		
		driver.findElement(By.id("com.whatsapp:id/contact_row_container")).click();
		
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Camera']")).click();
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\android\\screenshots\\whatsapp\\camera.png"));
	     
		System.out.println("image captured");
		
		
		//driver.quit();
		
		
	}


}
