package com.mobiliya.framework.configure;


	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.util.zip.ZipEntry;
	import java.util.zip.ZipOutputStream;
	
	public class ComprassDirectory extends BaseClass{
	  public static void zipoutputFloder() throws Exception {
		File file = new File(" ~/Downloads/test-output.zip");
		if(file.delete()) {
			System.out.println("test-output.zip deleted");
		}else {
			System.out.println("test-output.zip unfound");
		}
	    zipFolder("/Users/deepti/Documents/ios-Automation/workspace/ios-Automation/workspace/MobiliyaAppiumFramework/test-output", " ~/Downloads/test-output.zip");
	  }

	 public  static void zipFolder(String srcFolder, String destZipFile) throws Exception {
	    ZipOutputStream zip = null;
	    FileOutputStream fileWriter = null;

	    fileWriter = new FileOutputStream(destZipFile);
	    zip = new ZipOutputStream(fileWriter);

	    addFolderToZip("", srcFolder, zip);
	    zip.flush();
	    zip.close();
	  }

	  public static void addFileToZip(String path, String srcFile, ZipOutputStream zip)
	      throws Exception {

	    File folder = new File(srcFile);
	    if (folder.isDirectory()) {
	      addFolderToZip(path, srcFile, zip);
	    } else {
	      byte[] buf = new byte[1024];
	      int len;
	      FileInputStream in = new FileInputStream(srcFile);
	      zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
	      while ((len = in.read(buf)) > 0) {
	        zip.write(buf, 0, len);
	      }
	    }
	  }

	  public static void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
	      throws Exception {
	    File folder = new File(srcFolder);

	    for (String fileName : folder.list()) {
	      if (path.equals("")) {
	        addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
	      } else {
	        addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
	      }
	    }
	  }
	}

