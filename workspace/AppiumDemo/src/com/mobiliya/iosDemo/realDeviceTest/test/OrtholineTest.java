package com.mobiliya.iosDemo.realDeviceTest.test;

import java.io.IOException;
import org.openqa.selenium.By;

import com.mobiliya.iosDemo.realDeviceTest.configure.SetCapabilities;

import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchableElement;

public class OrtholineTest extends SetCapabilities {

	public static void swipeTest() throws InterruptedException, IOException {

		
		TouchableElement element1 = (TouchableElement) driver
				.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]"));

		for (int i = 0; i < 3; i++) {
			element1.swipe(SwipeElementDirection.LEFT, 100);
		}

		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")).click();
		Thread.sleep(5000);
	}
}
