package com.selenium.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.base.BaseClass;
import com.selenium.pageobjects.HomePage;
import com.selenium.pageobjects.IndexPage;
import com.selenium.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
	
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	
	
	@Test
	public void productAvailabilityTest()
	{
		extenttest=extentreports.createTest("productAvailabilityTest");
		indexpage=new IndexPage();
		searchresultpage=indexpage.searchProduct();
		boolean result=searchresultpage.isProductAvailable();
		Assert.assertTrue(result);
		
	}

}
