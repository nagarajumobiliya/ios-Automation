package com.mobiliya.androidDemo.test;

import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class Dragdropswipeandscroll {
 
	public static AndroidDriver driver;
	@BeforeTest
	  public void beforeTest() throws MalformedURLException {
		 File classpathRoot = new File(System.getProperty("user.dir"));
		  
		  File appDir = new File(classpathRoot, "/Apps");
		  
		  File app = new File(appDir, "com.mobeta.android.demodslv-0.5.0-3_APKdot.com.apk");  
		              
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  
		  capabilities.setCapability("deviceName", "0a670d30");

		  capabilities.setCapability("browserName", "Android");

		  capabilities.setCapability("platformVersion", "5.0.2");

		  capabilities.setCapability("platformName", "Android");
		  
		  capabilities.setCapability("app", app.getAbsolutePath());

		  capabilities.setCapability("appPackage", "com.mobeta.android.demodslv");

		  capabilities.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");

		  
		  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 }

	  
	
	@Test
  public void dragDrop() throws IOException, InterruptedException {
		
		System.out.println("app installed and launched");
		driver.findElementByName("Basic usage playground").click();

		WebElement ele1 = (WebElement) driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle").get(2);
		WebElement ele2 = (WebElement) driver.findElementsById("com.mobeta.android.demodslv:id/drag_handle").get(5);
		
		TouchAction action = new TouchAction((MobileDriver) driver);
		action.longPress(ele1).moveTo(ele2).release().perform();  
		System.out.println("Element has been droped at destination successfully.");
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile, new File("E:\\android\\screenshots\\draganddropdemo\\screenshot1.png"));
	    System.out.println("drag and drop completed");
	    
	    driver.scrollTo("Mark Turner");
	    driver.findElement(By.name("Mark Turner")).click();
	    scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile, new File("E:\\android\\screenshots\\draganddropdemo\\screenshot2.png"));
	    System.out.println("scroll operation completed");
	    
	    Dimension size= driver.manage().window().getSize();
	    int startx= (int)size.width/2;
	    int starty=(int)(size.height*0.80);
	    int endy =(int)(size.height*0.20);
	    
	    driver.swipe(startx, endy, startx, starty, 3000);
	    Thread.sleep(3000);
	    scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile, new File("E:\\android\\screenshots\\draganddropdemo\\screenshot3.png"));
	    System.out.println("top to down swipe completed");
	    
	    
	}

  @AfterTest
  public void afterTest() {
  }

}
