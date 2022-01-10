package com.selenium.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.base.BaseClass;
import com.selenium.pageobjects.HomePage;
import com.selenium.pageobjects.IndexPage;
import com.selenium.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass{
	
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	
	@Test
	public void loginTest()
	{
		extenttest=extentreports.createTest("loginTest");
		indexpage=new IndexPage();
		loginpage=indexpage.clickOnSignIn();
		homepage=loginpage.loginUser();
		boolean result=homepage.validatWishList();
		boolean result1=homepage.validatOrderHistory();
		Assert.assertTrue(result && result1);
	}

}
