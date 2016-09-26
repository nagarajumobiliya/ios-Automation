package com.mobiliya.framework.configure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

public class IOSWebkitDebugProxyService extends BaseClass {
	public static void startIOSWebkitDebugProxyService() {

		stopIOSWebkitDebugProxyService();
		// CommandLine iOSProxyCommand = new CommandLine("/bin/sh -c");
		// iOSProxyCommand.addArgument(Constants.APPIUM_NODE_PATH);
		CommandLine iOSProxyCommand = new CommandLine(Constants.APPIUM_NODE_PATH);

		// CommandLine iOSProxyCommand = new
		// CommandLine(Constants.IOS_WEBKIT_DEBUG_PROXY_SERVICE_PATH);
		iOSProxyCommand.addArgument(Constants.IOS_WEBKIT_DEBUG_PROXY_SERVICE_PATH);
		iOSProxyCommand.addArgument("-c");
		iOSProxyCommand.addArgument(connectedDeviceUDID + ":27753");
		// iOSProxyCommand.addArgument("-d");

		DefaultExecuteResultHandler iOSProxyresultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor iOSProxyexecutor = new DefaultExecutor();
		iOSProxyexecutor.setExitValue(1);
		try {
			iOSProxyexecutor.execute(iOSProxyCommand, iOSProxyresultHandler);
			iOSProxyCommand.toString();
			Thread.sleep(10000);
			// System.out.println("iOS Proxy started.");
			APP_LOGS.info("IOS webkit debug proxy service started.");
		} catch (IOException e) {
			APP_LOGS.error("Unable to perform IO: " + e.getMessage());
			e.printStackTrace();
		} catch (InterruptedException e) {
			APP_LOGS.error("Thread interrupted: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void stopIOSWebkitDebugProxyService() {
		String[] commandProxy = { "/usr/bin/killall", "-9", "ios_webkit_debug_proxy" };
		ProcessBuilder probuilder = new ProcessBuilder(commandProxy);
		try {
			probuilder.start();
			// System.out.println("iOS Webkit proxy stopped.");
			APP_LOGS.info("IOS webkit debug proxy service stopped.");
		} catch (IOException e) {
			APP_LOGS.error("Unable to perform IO: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// public static void startIOSWebkitDebugProxyService2() {
	// String[] commandStartProxy ={"/bin/sh","ios_webkit_debug_proxy -c
	// 1dae97c7b2a2203799e620d2197a6165f6e65f10:27753"};
	//// String[] commandStartProxy = {"/bin/sh","osascript -e 'tell application
	// \"Terminal\" to do script \"ios_webkit_debug_proxy -c
	// 1dae97c7b2a2203799e620d2197a6165f6e65f10:27753\"'"};
	// ProcessBuilder processStartProxy = new ProcessBuilder(commandStartProxy);
	// try {
	// processStartProxy.start();
	// Thread.sleep(10000);
	// System.out.println("iOS Proxy started.");
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	//

	public static void startIOSWebkitDebugProxyService3() {
		// String result = null;
		String[] commandStartProxy = { "/usr/local/bin/ios_webkit_debug_proxy", "-u", connectedDeviceUDID, ":27753" };
		Runtime r = Runtime.getRuntime();
		try {
			Process p = r.exec(commandStartProxy);
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
				// result += inputLine;
			}
			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
