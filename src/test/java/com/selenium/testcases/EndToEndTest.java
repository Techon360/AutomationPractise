package com.selenium.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.base.BaseClass;
import com.selenium.pageobjects.AddToCartPage;
import com.selenium.pageobjects.AddressPage;
import com.selenium.pageobjects.IndexPage;
import com.selenium.pageobjects.LoginPage;
import com.selenium.pageobjects.OrderConfirmationPage;
import com.selenium.pageobjects.OrderPage;
import com.selenium.pageobjects.OrderSummaryPage;
import com.selenium.pageobjects.PaymentPage;
import com.selenium.pageobjects.SearchResultPage;
import com.selenium.pageobjects.ShippingPage;

public class EndToEndTest extends BaseClass{
	
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocartpage;
	OrderPage orderpage;
	LoginPage loginpage;
	AddressPage addresspage;
	ShippingPage shippingpage;
	PaymentPage payementapage;
	OrderSummaryPage ordersummarypage;
	OrderConfirmationPage ordersummaryconfirmation;
	
	@Test
	public void endToEndTest()
	{
		extenttest=extentreports.createTest("endToEndTest");
		indexpage=new IndexPage();
		logger.info("Enter product and click search button");
		searchresultpage=indexpage.searchProduct();
		logger.info("Click on product");
		addtocartpage=searchresultpage.clickOnProduct();
		logger.info("Enter Quantity");
		addtocartpage.enterQuantity();
		logger.info("select size");
		addtocartpage.selectSize();
		logger.info("Click on add to cart button");
		addtocartpage.clickAddToCartButton();
		logger.info("Click on check out button");
		orderpage=addtocartpage.clickOnCheckOutButton();
		logger.info("Click on proceed to check out button");
		loginpage=orderpage.clickOnProceedToCheckOut();
		logger.info("Enter user credential for address page");
		addresspage=loginpage.loginUser1();
		logger.info("Click on proceed to check out button");
		shippingpage=addresspage.clickOnProceedToCheckout();
		logger.info("Accept terms and condition");
		shippingpage.checkTerms();
		logger.info("Click on proceed to check out button");
		payementapage=shippingpage.clickOnProceedToCheckout();
		logger.info("select payment method");
		ordersummarypage=payementapage.clickOnPaymentMethod();
		logger.info("clicl on confirm order button");
		ordersummaryconfirmation=ordersummarypage.clickOnConfirmOrderButton();
		boolean result=ordersummaryconfirmation.validateConfirmMessage();
		logger.info("verify confirm order message");
		Assert.assertTrue(result);
		logger.info("confirm order message is verified");
	}

}
