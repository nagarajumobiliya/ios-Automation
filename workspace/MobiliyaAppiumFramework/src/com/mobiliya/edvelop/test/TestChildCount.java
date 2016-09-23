package com.mobiliya.edvelop.test;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mobiliya.framework.configure.BaseClass;

public class TestChildCount extends BaseClass{
 //WebDriver driver = null;
	
  @BeforeClass	
  public void beforeTest() {
	  //Utilities.testSetUp();
	//  EdvelopTest.runTest();
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]")));
	  driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[2]")).click();
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[3]")));
  }
  @Test
  public void childCountTest() {
		@SuppressWarnings("unchecked")
		List <WebElement> learners = driver.findElements(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell"));
	    System.out.println(learners.size());	
		Assert.assertEquals(learners.size(), 3);
  }
  
  @Test(priority = 1)
  public void child1NameTest() {
	  String learner = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]")).getText();
	  Assert.assertEquals(learner, "Learner");  
  }
  
  @Test(priority = 2)
  public void child1Crousetest() {
	  String learnerCouser = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[2]")).getText();
	  Assert.assertEquals(learnerCouser, "Mechanical Engineering");
  }
  
  @AfterClass
  public void afterTest() {
	  driver.quit();
  }
}
