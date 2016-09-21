package com.mobiliya.iosDemo.realDeviceTest.test;

import org.openqa.selenium.By;

import com.mobiliya.iosDemo.realDeviceTest.configure.Constants;
import com.mobiliya.iosDemo.realDeviceTest.configure.SetCapabilities;
import com.mobiliya.iosDemo.realDeviceTest.configure.Utilities;

public class GitHubAppTest extends SetCapabilities {
	
	public static void runTest(){
		SetCapabilities.setGitHubAppCapabilities();
		SetCapabilities.setDriver();
		try {
			SumTest();
			//alertTest();
			Utilities.writeResultToExcel("GitHub App Test", Constants.RESULT_TEST_PASS);
			driver.quit();
		} catch (Exception e) {
			Utilities.writeResultToExcel("GitHub App Test", Constants.RESULT_TEST_FAIL);
			e.printStackTrace();
		}
	}

	public static void SumTest(){

		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")).sendKeys("10");
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[2]")).sendKeys("10");
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")).click();
		System.out.println("Calculation completed.");
		Utilities.takeScreenshot();
	}

	public static void alertTest(){
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")).click();
		driver.switchTo().alert().accept();
		System.out.println("Alert handling completed.");
		Utilities.takeScreenshot();
		
	}
}
