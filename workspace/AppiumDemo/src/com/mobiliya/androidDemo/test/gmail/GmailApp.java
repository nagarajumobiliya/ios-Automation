package com.mobiliya.androidDemo.test.gmail;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

public class GmailApp {
	
	public static WebDriver driver;

  @Test
  public void signup() throws IOException, InterruptedException {
	  
	  driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'welcome_tour_skip')]"));
	  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(scrFile, new File("E:\\android\\screenshots\\gmail\\Gmailscreenshot1.png"));
      System.out.println("first screenshot printed");
		
      
      driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'welcome_tour_skip')]")).click();
      scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(scrFile, new File("E:\\android\\screenshots\\gmail\\Gmailscreenshot2.png"));
      System.out.println("second screenshot printed");
      
      driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'setup_addresses_add_another')]")).click();
      scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(scrFile, new File("E:\\android\\screenshots\\gmail\\Gmailscreenshot3.png"));
      System.out.println("Third screenshot printed");
      
      driver.findElement(By.id("android:id/button1")).click();
      Thread.sleep(2000);
	  driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Enter your email ']")).sendKeys(""
	     		+ "nitin.hambir@gmail.com");
	  
	  driver.findElement(By.xpath("//android.widget.Button[@content-desk='NEXT']")).click();
	  scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(scrFile, new File("E:\\android\\screenshots\\gmail\\Gmailscreenshot4.png"));
	  System.out.println("fourth screenshot printed");


  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  
	  	DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("BrowserName", "Android");
		caps.setCapability("deviceName", "0a670d30");
		caps.setCapability("Version", "5.0.2");
		caps.setCapability("platformName", "Android");
		
		caps.setCapability("appPackage", "com.google.android.gm");
		caps.setCapability("appActivity", ".ConversationListActivityGmail");
		System.out.println("capabilities set properly");
		
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("app launched successfully");
  }

  @AfterClass
  public void afterClass() {
     driver.quit();
     

  }

}
