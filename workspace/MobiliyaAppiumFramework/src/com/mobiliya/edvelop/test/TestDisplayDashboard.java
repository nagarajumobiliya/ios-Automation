package com.mobiliya.edvelop.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mobiliya.edvelop.pageObjects.DashboardPage;
import com.mobiliya.edvelop.pageObjects.KidsListPage;

public class TestDisplayDashboard extends BaseTest{
@Test
public void testDisplayDashboardAfterValidLogin(){
	KidsListPage kidsListPage=new KidsListPage();
	DashboardPage dashboardPage=new DashboardPage();
	kidsListPage.selectKidFromList("Amal Ahmed");
	kidsListPage.clickContinueButton();
//	String actual="";
//	String expected="";
//	Assert.assertEquals(actual, expected);
}
}
