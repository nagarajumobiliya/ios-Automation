package com.mobiliya.androidDemo.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Gmail {
	
	public static AndroidDriver driver;

	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Gmail.gmailLauncher();
				
	}
	
	public static void gmailLauncher()throws IOException, InterruptedException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("BrowserName", "Android");
		caps.setCapability("deviceName", "0a670d30");
		caps.setCapability("Version", "5.0.2");
		caps.setCapability("platformName", "Android");
		
		caps.setCapability("appPackage", "com.google.android.gm");
		caps.setCapability("appActivity", ".ConversationListActivityGmail");
		System.out.println("capabilities set properly");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4725/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("app launched successfully");
		
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
	     // WebDriverWait wait= new WebDriverWait(driver, 50);
	     //WebElement e= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("android.widget.EditText[@content-desc='Enter your email ']")));
	      Thread.sleep(2000);
	      
	      driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Email or phone number 'or @content-desc='Enter your email ']")).sendKeys(""
	     		+ "nitin.hambir@gmail.com");
	     Thread.sleep(2000);
	     // driver.navigate().back();
	     driver.findElement(By.xpath("//android.widget.Button[@content-desc='NEXT']")).click();
	     Thread.sleep(2000);
	     /*By webView = By.className("android.webkit.WebView");
	     WebDriverWait wait = new WebDriverWait(driver,300);
	     wait.until(ExpectedConditions.visibilityOfElementLocated(webView));*/
	     scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(scrFile, new File("E:\\android\\screenshots\\gmail\\Gmailscreenshot4.png"));
	     System.out.println("fourth screenshot printed");
	     
	     Set<String> availableContexts1 = ((AppiumDriver) driver).getContextHandles();
	     System.out.println("Total No of Context Found Before reaching WebView = "+ availableContexts1.size());
	     System.out.println("Context Name is "+ availableContexts1);
	     
	     driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Password ']")).sendKeys("assg3814");
	     driver.findElement(By.xpath("//android.widget.Button[@content-desc='NEXT']")).click();
	     
	     scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(scrFile, new File("E:\\android\\screenshots\\gmail\\Gmailscreenshot5.png"));
	     System.out.println("fifth screenshot printed");
	     Thread.sleep(2000);
	     
	     driver.findElement(By.xpath("//android.widget.Button[@content-desc='ACCEPT']")).click();
	     scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(scrFile, new File("E:\\android\\screenshots\\gmail\\Gmailscreenshot6.png"));
	     System.out.println("sixth screenshot printed");
	     Thread.sleep(10000);
	     
	     driver.findElement(By.id("com.google.android.gms:id/suw_navbar_next")).click();
	     scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(scrFile, new File("E:\\android\\screenshots\\gmail\\Gmailscreenshot7.png"));
	     System.out.println("seventh screenshot printed");
	     Thread.sleep(10000);	
	     
	     driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'action_done') and @text='Take me to Gmail']")).click();
	     scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(scrFile, new File("E:\\android\\screenshots\\gmail\\Gmailscreenshot8.png"));
	     System.out.println("eigth screenshot printed");
	     Thread.sleep(10000);
	     
	     scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(scrFile, new File("E:\\android\\screenshots\\gmail\\Gmailscreenshot9.png"));
	     System.out.println("ninth screenshot printed");
	     driver.pressKeyCode(AndroidKeyCode.BACK);

	     driver.quit();
	}

}
