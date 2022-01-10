package com.selenium.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.base.BaseClass;
import com.selenium.pageobjects.AddToCartPage;
import com.selenium.pageobjects.IndexPage;
import com.selenium.pageobjects.OrderPage;
import com.selenium.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocartpage;
	OrderPage orderpage;
	
	@Test
	public void verifyTotalPrice()
	{
		extenttest=extentreports.createTest("verifyTotalPrice");
		indexpage=new IndexPage();
		searchresultpage=indexpage.searchProduct();
		addtocartpage=searchresultpage.clickOnProduct();
		addtocartpage.enterQuantity();
		addtocartpage.selectSize();
		addtocartpage.clickAddToCartButton();
		orderpage=addtocartpage.clickOnCheckOutButton();
		double unitrate=orderpage.getUnitPrice();
		double totalrate=orderpage.getTotalPrice();
		double totalExpected=(unitrate*2)+2;
		Assert.assertEquals(totalExpected, totalrate);
		
	}


}
