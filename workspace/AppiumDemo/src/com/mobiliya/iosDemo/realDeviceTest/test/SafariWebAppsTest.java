package com.mobiliya.iosDemo.realDeviceTest.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mobiliya.iosDemo.realDeviceTest.configure.Constants;
import com.mobiliya.iosDemo.realDeviceTest.configure.SetCapabilities;
import com.mobiliya.iosDemo.realDeviceTest.configure.Utilities;

public class SafariWebAppsTest extends SetCapabilities {

	public static void runTest() {
		SetCapabilities.setSafariLauncherCapabilities();
		SetCapabilities.setDriver();
		try {
			facebookLoginTest();
			Utilities.writeResultToExcel("Facebook WebApp Test", Constants.RESULT_TEST_PASS);
			driver.quit();
		} catch (Exception e) {
			Utilities.writeResultToExcel("Facebook WebApp Test", Constants.RESULT_TEST_FAIL);
			e.printStackTrace();
		}

	}

	public static void facebookLoginTest() {

		driver.get("https://www.facebook.com/");
		System.out.println("Page opened with Title: " + driver.getTitle());

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='_56bg _4u9z _5ruq']")));

		driver.findElement(By.xpath("//input[@class='_56bg _4u9z _5ruq']")).sendKeys("mobiliya1234@gmail.com");
		driver.findElement(By.xpath("//input[@class='_56bg _4u9z _27z2']")).sendKeys("mobiliya123");
		driver.findElement(By.xpath("//button[@class='_54k8 _56bs _56b_ _56bw _56bu']")).click();

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//a[@data-sigil='menu-link icon blocking-touchable']")));
		driver.findElement(By.xpath("//a[@data-sigil='menu-link icon blocking-touchable']")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-sigil='logout']")));
		driver.findElement(By.xpath("//a[@data-sigil='logout']")).click();
		Utilities.takeScreenshot();
	}
}
