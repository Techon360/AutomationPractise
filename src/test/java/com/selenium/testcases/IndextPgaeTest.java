package com.selenium.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.actiondriver.Act;
import com.selenium.base.BaseClass;
import com.selenium.pageobjects.IndexPage;

public class IndextPgaeTest extends BaseClass {
	IndexPage indexpage;
	
	@Test
	public void verifyLogo()
	{
		extenttest=extentreports.createTest("verifyLogo");
		logger.info("1st test case");
	    indexpage=new IndexPage();
	    boolean result=indexpage.validatLogo();
	    Assert.assertTrue(result);
	}
	
	@Test
	public void verifyTitle()
	{
		extenttest=extentreports.createTest("verifyTitle");
		logger.info("2nd test case");
		String actual=indexpage.myStoreTitle();
	    Assert.assertEquals(actual, "My S23tore");
	}

}
