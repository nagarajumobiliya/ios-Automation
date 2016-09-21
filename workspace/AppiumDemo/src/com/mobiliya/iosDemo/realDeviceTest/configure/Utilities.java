package com.mobiliya.iosDemo.realDeviceTest.configure;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Utilities extends SetCapabilities {

	public static void testSetUp() {
		try {
			Utilities.setExcelFile();
			//IOSWebkitDebugProxyService.startIOSWebkitDebugProxyService2();
			//AppiumServer.startServer2();
			System.out.println("Setup Completed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void TestTearDown() {
		try {
			Utilities.closeExcel();
//			driver.quit();
//			AppiumServer.stopServer();
//			IOSWebkitDebugProxyService.stopIOSWebkitDebugProxyService();
			try {
				Desktop.getDesktop().open(new File(Constants.REPORT_FILEPATH));
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Testing complete.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String[] getForUid() {
		    String connectedName = null;
		    String connectedUid = null;
		    String[] devicesValues = new String[2];
			try {
				Process pro = Runtime.getRuntime().exec("instruments -s devices");
				InputStream processStdOutput = pro.getInputStream();
				 Reader r = new InputStreamReader(processStdOutput);
			     BufferedReader br = new BufferedReader(r);
			     String uid = null;
			     for(int i = 0; i<= 2; i++) {
			    	  uid = br.readLine();
			     }
			     String uids[] = Constants.DEVICE_UDIDS;
			     for(int i = 0; i< uids.length; i++) {
			    	 if(uid.contains(uids[i])) {
			    		  String[] uidSplit = uid.split(" ");
			    		  connectedUid = uids[i];
			    		  connectedName = uidSplit[0];
			    		  devicesValues[0] = connectedName;
			    		  devicesValues[1] = connectedUid;
			    		  String [] cmd = {"././iosProxy.sh", connectedUid};
			    		 // IOSWebkitDebugProxyService.startIOSWebkitDebugProxyService2(connectedUid);
			    		  Runtime.getRuntime().exec(cmd);
			    		 break;
			    	 }
			     }
			     if (connectedUid == null) {
			    	 System.out.println("connect device uid and Name are not added in constants array");
			    	 driver.quit();
			     }
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			// Runtime.getRuntime().exec(command);
			return devicesValues;
	}

	public static String getCurrentTime() {
		try {
			Date date = new Date();
			Timestamp timestamp = new Timestamp(date.getTime());
			return timestamp.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void takeScreenshot() {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile,
					new File(Constants.SCREENSHOTS_DIR_PATH + "screenshot" + Utilities.getCurrentTime() + ".jpg"));
			System.out.println("Screenshot taken.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void setExcelFile() {
		try {
			File reportFile = new File(Constants.REPORT_FILEPATH);
			try {
				writableWorkbook = Workbook.createWorkbook(reportFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			writableSheet = writableWorkbook.createSheet("Sheet1", 0);
			excelRow = 0;
			System.out.println("Excel sheet setup completed and file is open.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeResultToExcel(String app, String result) {
		try {
			label = new Label(0, excelRow, app);
			try {
				writableSheet.addCell(label);
			} catch (RowsExceededException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
			label = new Label(1, excelRow, result);
			try {
				writableSheet.addCell(label);
			} catch (RowsExceededException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
			excelRow++;
			System.out.println("Written to excel sucessfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeExcel() {
		try {
			try {
				writableWorkbook.write();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				writableWorkbook.close();
			} catch (WriteException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Excel file closed.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
