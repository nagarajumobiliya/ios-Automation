package com.mobiliya.iosDemo.realDeviceTest.test;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mobiliya.iosDemo.realDeviceTest.configure.Constants;
import com.mobiliya.iosDemo.realDeviceTest.configure.SetCapabilities;
import com.mobiliya.iosDemo.realDeviceTest.configure.Utilities;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchableElement;

public class EdvelopTest extends SetCapabilities {

	public static void runTest() {
		SetCapabilities.setEdvelopAppCapabilities();
		SetCapabilities.setDriver();
		try {
			gmailParentLogIn();
			//Utilities.writeResultToExcel("Edvelop App Test", Constants.RESULT_TEST_PASS);
			//driver.quit();
		} catch (Exception e) {
			//Utilities.writeResultToExcel("Edvelop App Test", Constants.RESULT_TEST_FAIL);
			e.printStackTrace();
		}
	}
	
	public static void SwipeScreens() {
		TouchableElement elementSplashScreen = (TouchableElement) driver
				.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAImage[1]"));

		for (int i = 0; i < 2; i++) {
			elementSplashScreen.swipe(SwipeElementDirection.LEFT, 100);
		}	
	}

//	public static void LoginTest() {
//
//		// wait.until(ExpectedConditions.alertIsPresent());
//		// driver.switchTo().alert().dismiss();
//		//driver.context("NATIVE_APP");
//
//		SwipeScreens();
//		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")).click();
//
//		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")).click();
//
//		@SuppressWarnings({ "unchecked" })
//		Set<String> contextNames = driver.getContextHandles();
//		for (String contextName : contextNames) {
//			System.out.println(contextName);
//			if (contextName.contains("WEBVIEW")) {
//				driver.context(contextName);
//			}
//		}
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='_56bg _4u9z _5ruq']")));
//		driver.findElement(By.xpath("//input[@class='_56bg _4u9z _5ruq']")).sendKeys("kanika.jaypee@gmail.com");
//		driver.findElement(By.xpath("//input[@class='_56bg _4u9z _27z2']")).sendKeys("AgreeYa@123");
//		driver.findElement(By.xpath("//button[@class='_54k8 _56bs _56b_ _56bw _56bu']")).click();
//		driver.findElement(By.xpath("//button[@class='_54k8 _56bs _5o-- _j93 _56bw _56bu']")).click();
//
//		driver.context("NATIVE_APP");
//		wait.until(ExpectedConditions.presenceOfElementLocated(
//				By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")));
//		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")).click();
//		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]")).click();
//		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]")).click();
//
//		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")).click();
//
//		wait.until(ExpectedConditions.presenceOfElementLocated(
//				By.xpath("// UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]")));
//		driver.findElement(By.xpath("// UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]")).click();
//		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")).click();
//		
//	}
	
	public static void gmailParentLogIn() {
		SwipeScreens();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")).click();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")).click();
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName);
			if (contextName.contains("WEBVIEW")) {
				driver.context(contextName);
			}
		}
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id ='Email']")));
		driver.findElement(By.xpath("//input[@id ='Email']")).sendKeys(Constants.TestAccountEmail);
		driver.findElement(By.xpath("//input[@id ='next']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id = 'Passwd']")));
		driver.findElement(By.xpath("//input[@id = 'Passwd']")).sendKeys(Constants.TestAccountPassword);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id = 'signIn']")));
		driver.findElement(By.xpath("//input[@id = 'signIn']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id ='submit_approve_access']")));
		driver.findElement(By.xpath("//button[@id ='submit_approve_access']")).click();
		driver.context("NATIVE_APP");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")));
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")).click();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")).click();
		
	}
}
