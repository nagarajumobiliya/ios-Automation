package com.mobiliya.iosDemo.realDeviceTest.configure;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import java.io.IOException;

public class AppiumServer {
	public static AppiumDriverLocalService service = null;

	public static void startServer() {

		CommandLine command = new CommandLine(Constants.APPIUM_NODE_PATH);
		// CommandLine command = new CommandLine(Constants.APPIUM_SERVICE_PATH);
		command.addArgument(Constants.APPIUM_SERVICE_PATH, false);
		command.addArgument("--address", false);
		command.addArgument(Constants.APPIUM_SERVER_IP_ADDR);
		command.addArgument("--port", false);
		command.addArgument(Constants.APPIUM_SERVER_PORT);
		command.addArgument("--native-instruments-lib");
		command.addArgument("--full-reset", false);
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(command, resultHandler);
			Thread.sleep(30000);
			System.out.println("Appium server started.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void startServer2() {
		String [] command={"/bin/sh","/Applications/Appium.app/Contents/Resources/node_modules/appium/build/lib/main.js --address 0.0.0.0  --port 4723 --native-instruments-lib --pre-launch --full-reset"};
		//String[] command = { "/bin/sh","osascript -e 'tell application \"Terminal\" to do script \"/Applications/Appium.app/Contents/Resources/node_modules/appium/build/lib/main.js --address 0.0.0.0  --port 4723 --native-instruments-lib --pre-launch --full-reset\"'"};
		ProcessBuilder probuilder1 = new ProcessBuilder(command);
		try {
			probuilder1.start();
			Thread.sleep(30000);
			System.out.println("Appium server started.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void stopServer() {
		String[] command = { "/usr/bin/killall", "-9", "node" };
		ProcessBuilder probuilder = new ProcessBuilder(command);
		try {
			probuilder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Runtime.getRuntime().exec(command);
		System.out.println("Appium server stopped.");
	}

	public static void stopServer2() {
		service.stop();
	}

}
