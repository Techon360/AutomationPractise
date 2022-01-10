package com.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.actiondriver.Act;
import com.selenium.base.BaseClass;

public class PaymentPage  extends BaseClass {
	
	public PaymentPage ()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//a[@title='Pay by bank wire']")) public WebElement bankWire;
	
	@FindBy(xpath=("//a[@title='Pay by check.']")) public WebElement cheque;
	
	
	
	
	public OrderSummaryPage clickOnPaymentMethod()
	{
		Act.click(bankWire);
		return new OrderSummaryPage();
	}

	


}
