package com.mobiliya.androidDemo.test;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;



public class AppTest {
	
	Process p;
	String nodePath = "C:/Program Files (x86)/Appium/node.exe";
	String appiumJSPath = "C:/Program Files (x86)/Appium/node_modules/appium/bin/appium.js";
	String cmd = nodePath + " " + appiumJSPath;
	
	public static void main(String[] args) throws Exception {
		
		AppTest a= new AppTest();
		//a.appiumStart();
		//ExcelUtils.setExcelFile("E:\\projects\\Test\\src\\com\\mobiliya\\android\\testdata\\testreport.xlsx", "Sheet1");
		String Datapath =System.getProperty("user.dir");
		
		File exlFile = new File(Datapath+"/AndroidReport.xls");
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(exlFile);
        WritableSheet writableSheet = writableWorkbook.createSheet("Sheet1", 0);
		System.out.println("launching camera app");
		Camera.cameraLauncher();
		System.out.println("launched camera");
		Label l1= new Label(0, 0, "Camera App");
	    Label l2= new Label(1, 0, "Camera Launched successfully");
	    writableSheet.addCell(l1);
        writableSheet.addCell(l2);
		
		System.out.println("launching Gmail app");
		Gmail.gmailLauncher();
		System.out.println("launched Gmail");	
		Label l3= new Label(0, 1, "Gmail");
        Label l4= new Label(1, 1, "Gmail Launched successfully");
        writableSheet.addCell(l3);
        writableSheet.addCell(l4);
        
		System.out.println("launching Calculator app");
		Calculator.calcLauncher();
		System.out.println("launched Calculator");	
		writableSheet.addCell(new Label(0,2,"Calculator"));
		writableSheet.addCell(new Label(1,2,"Calculator launched successfully"));
		
		writableWorkbook.write();
		Desktop.getDesktop().open(new File(Datapath+"/AndroidReport.xls"));
		writableWorkbook.close();
		
	}
	
	public void appiumStart() throws IOException, InterruptedException {
		  
		  CommandLine command = new CommandLine("cmd");
		  command.addArgument("/c");
		  command.addArgument(nodePath);
		  command.addArgument(appiumJSPath);
		  command.addArgument("--address");
		  command.addArgument("127.0.0.1");
		  command.addArgument("--port");
		  command.addArgument("4723");
		  command.addArgument("--no-reset");
		  command.addArgument("--log");
		  command.addArgument("D://appiumLogs.txt");
		  DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		  DefaultExecutor executor = new DefaultExecutor();
		  executor.setExitValue(1);
		  executor.execute(command, resultHandler);
		  Thread.sleep(15000);
		 }
	
	public  void appiumStop() throws IOException {
		  CommandLine command = new CommandLine("cmd");
		  command.addArgument("/c");
		  command.addArgument("taskkill");
		  command.addArgument("/F");
		  command.addArgument("/IM");
		  command.addArgument("node.exe");
		  DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		  DefaultExecutor executor = new DefaultExecutor();
		  executor.setExitValue(1);
		  executor.execute(command, resultHandler);
		 }

}
