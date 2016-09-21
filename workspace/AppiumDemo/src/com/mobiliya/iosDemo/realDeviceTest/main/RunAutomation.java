package com.mobiliya.iosDemo.realDeviceTest.main;

import com.mobiliya.iosDemo.realDeviceTest.configure.SetCapabilities;
import com.mobiliya.iosDemo.realDeviceTest.configure.Utilities;
import com.mobiliya.iosDemo.realDeviceTest.test.EdvelopTest;
import com.mobiliya.iosDemo.realDeviceTest.test.GitHubAppTest;
import com.mobiliya.iosDemo.realDeviceTest.test.SafariWebAppsTest;

public class RunAutomation extends SetCapabilities{

	public static void main(String[] args) {
		
		try {
			//Utilities.testSetUp();
			EdvelopTest.runTest();
			//GitHubAppTest.runTest();
			//SafariWebAppsTest.runTest();
			//Utilities.TestTearDown();
			//EmailReport.sendMail();
			System.out.println("All tests executed sucessfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
