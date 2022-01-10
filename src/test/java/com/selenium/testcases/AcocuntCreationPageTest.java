package com.selenium.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.actiondriver.Act;
import com.selenium.base.BaseClass;
import com.selenium.pageobjects.AccountCreationPage;
import com.selenium.pageobjects.HomePage;
import com.selenium.pageobjects.IndexPage;
import com.selenium.pageobjects.LoginPage;

public class AcocuntCreationPageTest extends BaseClass {
	
	IndexPage indexpage;
	LoginPage loginpage;
	AccountCreationPage accountpreationpage;
	
	@Test
	public void verifyAcountCreationPage()
	{
		extenttest=extentreports.createTest("verifyAcountCreationPage");
		indexpage=new IndexPage();
		System.out.println(Act.randomEmailId());
		loginpage=indexpage.clickOnSignIn();
		accountpreationpage=loginpage.createNewAccount();
		boolean result=accountpreationpage.validateAcountCreatPage();
		System.out.println(Act.randomEmailId());
		Assert.assertTrue(result);
	}

}
