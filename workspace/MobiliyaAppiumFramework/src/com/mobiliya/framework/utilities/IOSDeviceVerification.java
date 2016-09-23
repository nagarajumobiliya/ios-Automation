package com.mobiliya.framework.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import com.mobiliya.framework.configure.Constants;
import com.mobiliya.framework.configure.BaseClass;

public class IOSDeviceVerification extends BaseClass {

	public static void verifyConnectedIDevice() {
		try {
			Process pro = Runtime.getRuntime().exec("instruments -s devices");
			InputStream processStdOutput = pro.getInputStream();
			Reader r = new InputStreamReader(processStdOutput);
			BufferedReader br = new BufferedReader(r);
			String uid = null;
			for (int i = 0; i <= 2; i++) {
				uid = br.readLine();
			}
			String uids[] = Constants.REGISTERED_DEVICES_UDIDS;
			for (int i = 0; i < uids.length; i++) {
				if (uid.contains(uids[i])) {
					String[] uidSplit = uid.split(" ");
					connectedDeviceUDID = uids[i];
					connectedDeviceName = uidSplit[0];
					APP_LOGS.info("Device is connected and ready to use.");
					// break;
				}
			}
			if (connectedDeviceUDID == null) {
				APP_LOGS.debug("Device not connected / Device connected is not registered!");
				APP_LOGS.info("Unable to perform automation! Exiting...");
				System.exit(0);
			}

		} catch (IOException e) {
			APP_LOGS.error("Unable to verify device: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
