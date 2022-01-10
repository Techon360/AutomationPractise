package com.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.actiondriver.Act;
import com.selenium.base.BaseClass;

public class AddressPage extends BaseClass {
	
	public AddressPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//span[text()='Proceed to checkout']")) public WebElement proceedToCheckout;
	
	
	
	
	
	
	public ShippingPage clickOnProceedToCheckout()
	{
		Act.click(proceedToCheckout);	
		return new ShippingPage();
	}
	

}
