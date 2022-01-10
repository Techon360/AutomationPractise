package com.selenium.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.actiondriver.Act;
import com.selenium.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {
	
	public OrderConfirmationPage ()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//strong[text()='Your order on My Store is complete.']")) public WebElement confirmMessage;
	
	
	
	
	
	public boolean validateConfirmMessage()
	{
		return Act.isElementDisplayed(confirmMessage);
		
		
	}


}
