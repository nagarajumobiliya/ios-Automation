package com.mobiliya.framework.utilities.test;

import com.mobiliya.framework.capabilities.DeviceCapabilities;

public class AndroidGetDeviceTest {
public static void main(String[] args) {
	System.out.println(DeviceCapabilities.getAndroidDeviceName());
	System.out.println(System.getenv("PATH"));
}
}
