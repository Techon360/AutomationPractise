package com.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.actiondriver.Act;
import com.selenium.base.BaseClass;

public class ShippingPage extends BaseClass {
	
	
	public ShippingPage ()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//button[@name='processCarrier']/span[contains(text(),'Proceed to checkout')]")) public WebElement proceedToCheckout;
	
	@FindBy(xpath=("//input[@id='cgv']")) public WebElement checkBoxTerms;
	
	
	
	
	public void checkTerms()
	{
		Act.click(checkBoxTerms);	
	}

	
	public PaymentPage clickOnProceedToCheckout()
	{
		Act.click(proceedToCheckout);	
		return new PaymentPage();
	}

}
