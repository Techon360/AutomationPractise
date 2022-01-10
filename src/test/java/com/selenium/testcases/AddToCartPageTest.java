package com.selenium.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.base.BaseClass;
import com.selenium.pageobjects.AddToCartPage;
import com.selenium.pageobjects.HomePage;
import com.selenium.pageobjects.IndexPage; 
import com.selenium.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass{
	
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocartpage;
	
	@Test
	public void addToCartTest()
	{
		extenttest=extentreports.createTest("addToCartTest");
		indexpage=new IndexPage();
		searchresultpage=indexpage.searchProduct();
		addtocartpage=searchresultpage.clickOnProduct();
		addtocartpage.enterQuantity();
		addtocartpage.selectSize();
		addtocartpage.clickAddToCartButton();
		boolean result=addtocartpage.validateAddToCartMessage();
		Assert.assertTrue(result);
		
	}

}
