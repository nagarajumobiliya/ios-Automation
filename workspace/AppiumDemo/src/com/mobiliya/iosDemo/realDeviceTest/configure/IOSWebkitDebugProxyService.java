package com.mobiliya.iosDemo.realDeviceTest.configure;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

public class IOSWebkitDebugProxyService {
	public static void startIOSWebkitDebugProxyService(String DeviceUid) {

		// CommandLine iOSProxyCommand = new CommandLine("/bin/sh -c");
		// iOSProxyCommand.addArgument(Constants.APPIUM_NODE_PATH);
		CommandLine iOSProxyCommand = new CommandLine(Constants.APPIUM_NODE_PATH);

		// CommandLine iOSProxyCommand = new
		// CommandLine(Constants.IOS_WEBKIT_DEBUG_PROXY_SERVICE_PATH);
		iOSProxyCommand.addArgument(Constants.IOS_WEBKIT_DEBUG_PROXY_SERVICE_PATH);
	    iOSProxyCommand.addArgument("-c");
		iOSProxyCommand.addArgument(DeviceUid + ":27753");
	//	iOSProxyCommand.addArgument("-d");

		DefaultExecuteResultHandler iOSProxyresultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor iOSProxyexecutor = new DefaultExecutor();
		iOSProxyexecutor.setExitValue(1);
		try {
			iOSProxyexecutor.execute(iOSProxyCommand, iOSProxyresultHandler);
			iOSProxyCommand.toString();
			Thread.sleep(10000);
			System.out.println("iOS Proxy started.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void startIOSWebkitDebugProxyService2(String deviceUId) {
		String[] commandStartProxy ={"/bin/sh","ios_webkit_debug_proxy -c" + deviceUId + ":27753"};
		//String[] commandStartProxy = {"/bin/sh","osascript -e 'tell application \"Terminal\" to do script \"ios_webkit_debug_proxy -c 1dae97c7b2a2203799e620d2197a6165f6e65f10:27753\"'"};
		ProcessBuilder processStartProxy = new ProcessBuilder(commandStartProxy);
		try {	
			processStartProxy.start();
			Thread.sleep(10000);
			System.out.println("iOS Proxy started.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void stopIOSWebkitDebugProxyService() {
		String[] commandProxy = { "/usr/bin/killall", "-9", "ios_webkit_debug_proxy" };
		ProcessBuilder probuilder = new ProcessBuilder(commandProxy);
		try {
			probuilder.start();
			System.out.println("iOS Webkit proxy stopped.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
