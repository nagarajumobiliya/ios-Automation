package com.mobiliya.edvelop.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.mobiliya.edvelop.AppConstants;
import com.mobiliya.edvelop.pageObjects.DashboardPage;
import com.mobiliya.edvelop.pageObjects.KidsListPage;

public class TestDisplayDashboard extends BaseTest{
@Test
public void testDisplayDashboardAfterValidLogin(){
	KidsListPage kidsListPage=new KidsListPage();
	String[] expected = AppConstants.CHILD_LIST;
	String [] actual = kidsListPage.getChildrenList();
	kidsListPage.clickContinueButton();
	Assert.assertEquals(actual, expected);
}
}
