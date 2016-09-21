package tcom.mobiliya.iosDemo.realDeviceTest.testNgFiles;

import java.io.IOException;
import java.util.List;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mobiliya.iosDemo.realDeviceTest.configure.Constants;
import com.mobiliya.iosDemo.realDeviceTest.configure.SetCapabilities;
import com.mobiliya.iosDemo.realDeviceTest.configure.Utilities;
import com.mobiliya.iosDemo.realDeviceTest.test.EdvelopTest;

public class testChildCount extends SetCapabilities{
 //WebDriver driver = null;
	
  @BeforeClass	
  public void beforeTest() {
	  Utilities.testSetUp();
	  EdvelopTest.runTest();
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]")));
	  driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]")).click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[3]")));
	  Utilities.writeResultToExcel(Constants.DEVICE_NAME, Constants.DEVICE_UDID);
  }
  @Test
  public void childCountTest() {
		@SuppressWarnings("unchecked")
		List <WebElement> learners = driver.findElements(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell"));
	    System.out.println(learners.size());
		  if(!learners.isEmpty()){
			  Utilities.writeResultToExcel("Edvelop App ChildCount Test", "Pass");
			  Assert.assertNotNull(learners);		  
		  }else {
			  Assert.assertNotNull(learners);
			  Utilities.writeResultToExcel("Edvelop App ChildCount Test", "Fail");
		  }
  }
  
  @Test(priority = 1)
  public void child1NameTest() {
	  String learner = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]")).getText();
	  if(!learner.isEmpty()){
		  Utilities.writeResultToExcel("Edvelop App ChildName Test", "Pass");
		  Assert.assertNotNull(learner);		  
	  }else {
		  Assert.assertNotNull(learner);
		  Utilities.writeResultToExcel("Edvelop App ChildName Test", "Fail");
	  }
	    
	  
  }
  
  @Test(priority = 2)
  public void child1Crousetest() {
	  String learnerCouser = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[2]")).getText();
	  if(!learnerCouser.isEmpty()){
		  Utilities.writeResultToExcel("Edvelop App ChildCouser Test", "Pass");
		  Assert.assertNotNull(learnerCouser);		  
	  }else {
		  Assert.assertNotNull(learnerCouser);
		  Utilities.writeResultToExcel("Edvelop App ChildCouser Test", "Fail");
	  }
	    
  }
  
  @org.testng.annotations.AfterClass
  public void afterTest() throws IOException {
	  Utilities.TestTearDown();
	  Runtime.getRuntime().exec("killall Terminal");
	  driver.quit();
	  
  }
}
