package com.mobiliya.framework.configure;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.io.File;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.Random;

public class AppiumServerService extends BaseClass {

	public static void startServer() {

		CommandLine command = new CommandLine(Constants.APPIUM_NODE_PATH);
		// CommandLine command = new CommandLine(Constants.APPIUM_SERVICE_PATH);
		command.addArgument(Constants.APPIUM_SERVICE_PATH, false);
		command.addArgument("--address", false);
		command.addArgument(Constants.APPIUM_SERVER_IP_ADDR);
		command.addArgument("--port", false);
		command.addArgument(currentAppiumPort);
		command.addArgument("--native-instruments-lib");
		command.addArgument("--full-reset", false);
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(command, resultHandler);
			Thread.sleep(30000);
			// System.out.println("Appium server started.");
			APP_LOGS.info("Appium server started.");
		} catch (IOException e) {
			APP_LOGS.error("Unable to perform IO: " + e.getMessage());
			e.printStackTrace();
		} catch (InterruptedException e) {
			APP_LOGS.error("Thread interrupted: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void startServer2() {
		try {
			appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort()
					.usingDriverExecutable(new File(Constants.APPIUM_NODE_PATH))
					.withAppiumJS(new File(Constants.APPIUM_SERVICE_PATH)));
			appiumService.start();
			appiumServiceUrl=appiumService.getUrl().toString();
			APP_LOGS.info("Appium server started.");
		} catch (AppiumServerHasNotBeenStartedLocallyException e) {
			APP_LOGS.error("Unable to start Appium service : " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void stopServer() {
		String[] command = { "/usr/bin/killall", "-9", "node" };
		ProcessBuilder probuilder = new ProcessBuilder(command);
		try {
			probuilder.start();
			// System.out.println("Appium server stopped.");
			APP_LOGS.info("Appium server stopped.");
		} catch (IOException e) {
			APP_LOGS.error("Unable to perform IO: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void stopServer2() {
		try {
			appiumService.stop();
			APP_LOGS.info("Appium server stopped.");
		} catch (Exception e) {
			APP_LOGS.error("Unable to stop Appium server: "+e.getMessage());
			e.printStackTrace();
		}
	}

	public static void setAppiumPort() {
		int port = generateRandomNumber();
		if (isPortAvailable(port)) {
			currentAppiumPort = String.valueOf(port);
		} else {
			setAppiumPort();
		}
	}

	private static int generateRandomNumber() {
		Random r = new Random();
		int result = r.nextInt(Constants.MAX_PORT_NUMBER - Constants.MIN_PORT_NUMBER) + Constants.MIN_PORT_NUMBER;
		return result;
	}

	private static boolean isPortAvailable(int port) {
		if (port < Constants.MIN_PORT_NUMBER || port > Constants.MAX_PORT_NUMBER) {
			throw new IllegalArgumentException("Invalid start port: " + port);
		}

		ServerSocket ss = null;
		DatagramSocket ds = null;
		try {
			ss = new ServerSocket(port);
			ss.setReuseAddress(true);
			ds = new DatagramSocket(port);
			ds.setReuseAddress(true);
			return true;
		} catch (IOException e) {
		} finally {
			if (ds != null) {
				ds.close();
			}

			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					APP_LOGS.error("Unable to perform IO: " + e.getMessage());
					e.printStackTrace();
				}
			}
		}

		return false;
	}
}

/*
 * public static void startServer2() { String [] command={
 * "/bin/sh","/Applications/Appium.app/Contents/Resources/node_modules/appium/build/lib/main.js --address 0.0.0.0  --port 4723 --native-instruments-lib --pre-launch --full-reset"
 * }; //String[] command = {
 * "/bin/sh","osascript -e 'tell application \"Terminal\" to do script \"/Applications/Appium.app/Contents/Resources/node_modules/appium/build/lib/main.js --address 0.0.0.0  --port 4723 --native-instruments-lib --pre-launch --full-reset\"'"
 * }; ProcessBuilder probuilder1 = new ProcessBuilder(command); try {
 * probuilder1.start(); Thread.sleep(30000);
 * System.out.println("Appium server started."); } catch (IOException e) {
 * e.printStackTrace(); } catch (InterruptedException e) { e.printStackTrace();
 * } }
 * 
 * public static void startServer3() { //String result = null; String []
 * command={
 * "/bin/sh","/Applications/Appium.app/Contents/Resources/node_modules/appium/build/lib/main.js --address 0.0.0.0  --port 4723 --native-instruments-lib --pre-launch --full-reset"
 * };
 * 
 * Runtime r = Runtime.getRuntime(); try { Process p = r.exec(command);
 * BufferedReader in = new BufferedReader(new
 * InputStreamReader(p.getInputStream())); String inputLine; while ((inputLine =
 * in.readLine()) != null) { System.out.println(inputLine); // result +=
 * inputLine; } in.close();
 * 
 * } catch (IOException e) { e.printStackTrace(); } }
 */
